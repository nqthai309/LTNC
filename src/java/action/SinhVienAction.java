/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import bean.SinhVien;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.util.List;
import dao.DAO;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author thai
 */
public class SinhVienAction extends ActionSupport{
    ResultSet rs = null;
    List<SinhVien> sinhViens = null;
    List<String> maLops = null;
    private boolean noData = false;
    SinhVien sv = null;
    private String maSV, tenSinhVien, gioiTinh, ngaySinh, queQuan, maLop;
    String submitType, textSearch;

    
    

    public String getTextSearch() {
        return textSearch;
    }

    public void setTextSearch(String textSearch) {
        this.textSearch = textSearch;
    }
    
    

    public String getSubmitType() {
        return submitType;
    }

    public void setSubmitType(String submitType) {
        this.submitType = submitType;
    }
    

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }
    

    public String getMaSV() {
        return maSV;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public String getMaLop() {
        return maLop;
    }
    
    

    public void setMaLops(List<String> maLops) {
        this.maLops = maLops;
    }

    public List<String> getMaLops() {
        return maLops;
    }
    
    
    public List<SinhVien> getSinhViens() {
        return sinhViens;
    }

    public boolean isNoData() {
        return noData;
    }

    public void setSinhViens(List<SinhVien> sinhViens) {
        this.sinhViens = sinhViens;
    }

    public void setNoData(boolean noData) {
        this.noData = noData;
    }

    @Override
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        if(session.get("SessionLogin") != null){
            try {
                int result = DAO.InsertSinhVien(maSV.trim(), tenSinhVien.trim(), gioiTinh.trim(), ngaySinh.trim(), queQuan.trim(), maLop.trim());
                if(result > 0){
                    return "complete";
                }else{
                    return "fail";
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            } 
        }else{
            return "fail";
        }
    }
    
    public String GetSinhVien(){
        Map session = ActionContext.getContext().getSession();
        
        if(session.get("SessionLogin") != null){
            try {
                sinhViens = new ArrayList<SinhVien>();
                rs = DAO.GetSinhVien();
                int i = 0;
                if(rs != null){
                    while(rs.next()){
                        i++;
                        sv = new SinhVien();
                        sv.setMaSV(rs.getString(1).trim());
                        sv.setTenSinhVien(rs.getString(2).trim());
                        sv.setGioiTinh(rs.getBoolean(3));
                        sv.setNgaySinh(rs.getString(4).trim());
                        sv.setQueQuan(rs.getString(5).trim());
                        sv.setMaLop(rs.getString(6).trim());
                    
                        sinhViens.add(sv);
                    }
                }
                if(i == 0)  noData = false;
                else    noData = true;
            
            } catch (Exception e) {
            e.printStackTrace();
        }
            return "GetSinhVien";
        }else{
//            String linkRedirect = "http://localhost:8084/Struts2_QLSV/";
            return "fail";
        }
        
    }
    
    public String AddSinhVien(){
        Map session = ActionContext.getContext().getSession();
        if(session.get("SessionLogin") != null){
            try {
                maLops = new ArrayList<String>();
                rs = DAO.GetMaLop();
                int i = 0;
                if(rs != null){
                    while(rs.next()){
                        maLops.add(rs.getString(1));
                    }
                }
                if(i == 0)  noData = false;
                else    noData = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
                return "AddSinhVien";
            }else{
                return "fail";
            }
        
    }
    public String EditSinhVien(){
        Map session = ActionContext.getContext().getSession();
        if(session.get("SessionLogin") != null){
            int i=0;
            noData = false;
            sinhViens = new ArrayList<>();
            sv = new SinhVien();
            maLops = new ArrayList<>();
            try {
                if(submitType.equals("updatedata")){
                    rs = DAO.findSinhVienByMaSV(maSV);
                    if(rs != null){
                        while(rs.next()){
                            i++;
                            sv.setMaSV(rs.getString(1));
                            sv.setTenSinhVien(rs.getString(2));
                            sv.setGioiTinh(rs.getBoolean(3));
                        
                            String[] data = rs.getString(4).split(" ");
                            String[] data2 = data[0].split("-");
                            String ns = data2[0]+"-"+data2[1]+"-"+data2[2];
                            sv.setNgaySinh(ns);
                        
                            sv.setQueQuan(rs.getString(5));
                        
                            ResultSet rs2 = DAO.GetMaLop();
                            while(rs2.next()){
                                maLops.add(rs2.getString(1));
                            }
                            sv.setMaLop(rs.getString(6));
                            sinhViens.add(sv);
                        }
                    }
                }
                if(i != 0) noData = true;
                else noData = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "editSinhVien";
        }else{
            return "fail";
        }
        
    }
    public String EditSinhVienSubmit(){
        Map session = ActionContext.getContext().getSession();
        if(session.get("SessionLogin") != null){
            try {
                int result = DAO.UpdateSinhVien(maSV, tenSinhVien, gioiTinh, ngaySinh, queQuan, maLop);
                if(result > 0) return "complete";
                else return "fail";
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }else{
            return "fail";
        }
        
    }
    public String DeleteSinhVien(){
        Map session = ActionContext.getContext().getSession();
        if(session.get("SessionLogin") != null){
            try {
                if(submitType.equals("deletedata")){
                    int result = DAO.DeleteSinhVien(maSV);
                    if(result > 0) return "complete";
                    else return "fail";
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "fail";
            }
            return "";
        }else{
            return "fail";
            
        }
        
    }
    public String TimKiemSinhVien(){
        Map session = ActionContext.getContext().getSession();
        if(session.get("SessionLogin") != null){
            try {
                noData = true;
                ResultSet rs = DAO.TimKiemSinhVien(textSearch.trim());
                sinhViens = new ArrayList<>();
                if(rs != null){
                    while(rs.next()){
                        sv = new SinhVien();
                        sv.setMaSV(rs.getString(1).trim());
                        sv.setTenSinhVien(rs.getString(2).trim());
                        sv.setGioiTinh(rs.getBoolean(3));
                        sv.setNgaySinh(rs.getString(4).trim());
                        sv.setQueQuan(rs.getString(5).trim());
                        sv.setMaLop(rs.getString(6).trim());
                        sinhViens.add(sv);
                    }
                    return "complete";
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "fail";
            }
            return "";
        }else{
            
            return "fail";
        }
        
    }
    
    
}
