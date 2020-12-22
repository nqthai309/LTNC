/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import bean.Lop;
import bean.SinhVien;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.DAO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 *
 * @author thai
 */
public class LopAction extends ActionSupport{
    ResultSet rs = null;
    ResultSet rs1 = null;
    ResultSet rs2 = null;
    List<Lop> listLops = null;
    private boolean noData = false;
    Lop lop = null;
    private String maLop, tenLop, maKhoa, maHeDT, maKhoaHoc;
    String submitType,textSearch,radioButton;

    public String getRadioButton() {
        return radioButton;
    }

    public void setRadioButton(String radioButton) {
        this.radioButton = radioButton;
    }

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
    int sum;
    List<String> maKhoas = null;
    List<String> maHeDTs = null;
    List<String> maKhoaHocs = null;

    public List<String> getMaKhoas() {
        return maKhoas;
    }

    public void setMaKhoas(List<String> maKhoas) {
        this.maKhoas = maKhoas;
    }

    public List<String> getMaHeDTs() {
        return maHeDTs;
    }

    public void setMaHeDTs(List<String> maHeDTs) {
        this.maHeDTs = maHeDTs;
    }

    public List<String> getMaKhoaHocs() {
        return maKhoaHocs;
    }

    public void setMaKhoaHocs(List<String> maKhoaHocs) {
        this.maKhoaHocs = maKhoaHocs;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getMaHeDT() {
        return maHeDT;
    }

    public void setMaHeDT(String maHeDT) {
        this.maHeDT = maHeDT;
    }

    public String getMaKhoaHoc() {
        return maKhoaHoc;
    }

    public void setMaKhoaHoc(String maKhoaHoc) {
        this.maKhoaHoc = maKhoaHoc;
    }

    
    public void setListLops(List<Lop> listLops) {
        this.listLops = listLops;
    }

    public void setNoData(boolean noData) {
        this.noData = noData;
    }

    public List<Lop> getListLops() {
        return listLops;
    }

    public boolean isNoData() {
        return noData;
    }
    
    @Override
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        if(session.get("SessionLogin") != null){
            try {
                int result = DAO.InsertLop(maLop.trim(), tenLop.trim(), maKhoa.trim(), maHeDT.trim(), maKhoaHoc.trim());
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
    public String GetLop(){
        Map session = ActionContext.getContext().getSession();
        if(session.get("SessionLogin") != null){
            try {
                listLops = new ArrayList<Lop>();
                rs = DAO.GetLop();
                int i = 0;
                if(rs != null){
                    while(rs.next()){
                        i++;
                        lop = new Lop();
                        lop.setMaLop(rs.getString(1).trim());
                        lop.setTenLop(rs.getString(2).trim());
                        lop.setMaKhoa(rs.getString(3).trim());
                        lop.setMaHeDT(rs.getString(4).trim());
                        lop.setMaKhoaHoc(rs.getString(5).trim());
                    
                        listLops.add(lop);
                    }
                    sum = listLops.size();
                }
                if(i == 0)  noData = false;
                else    noData = true;
            
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "GetLop";
        }else{
            return "fail";
        }
    }
    
    public String AddLop(){
        Map session = ActionContext.getContext().getSession();
        if(session.get("SessionLogin") != null){
            try {
                maKhoas = new ArrayList<String>();
                maHeDTs = new ArrayList<String>();
                maKhoaHocs = new ArrayList<String>();
                rs = DAO.GetMaKhoa();
                int i = 0;
                if(rs != null){
                    while(rs.next()){
                        maKhoas.add(rs.getString(1));
                    }
                }
                
                rs1 = DAO.GetMaHeDT();
                if(rs1 != null){
                    while(rs1.next()){
                        maHeDTs.add(rs1.getString(1));
                    }
                }
                
                rs2 = DAO.GetMaKhoaHoc();
                if(rs2 != null){
                    while(rs2.next()){
                        maKhoaHocs.add(rs2.getString(1));
                    }
                }
                if(i == 0)  noData = false;
                else    noData = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
                return "AddLop";
            }else{
                return "fail";
            }
    }
    public String EditLop(){
        Map session = ActionContext.getContext().getSession();
        if(session.get("SessionLogin") != null){
            int i=0;
            noData = false;
            listLops = new ArrayList<>();
            lop = new Lop();
            maKhoas = new ArrayList<>();
            maHeDTs = new ArrayList<>();
            maKhoaHocs = new  ArrayList<>();
            try {
                if(submitType.equals("updatedata")){
                    rs = DAO.findLopByMaLop(maLop);
                    if(rs != null){
                        while(rs.next()){
                            i++;
                            lop.setMaLop(rs.getString(1));
                            lop.setTenLop(rs.getString(2));
                            
                            ResultSet rs2 = DAO.GetMaKhoa();
                            while(rs2.next()){
                                maKhoas.add(rs2.getString(1));
                            }
                            lop.setMaKhoa(rs.getString(3));
                            
                            ResultSet rs3 = DAO.GetMaHeDT();
                            while(rs3.next()){
                                maHeDTs.add(rs3.getString(1));
                            }
                            lop.setMaHeDT(rs.getString(4));
                            
                            ResultSet rs4 = DAO.GetMaKhoaHoc();
                            while(rs4.next()){
                                maKhoaHocs.add(rs4.getString(1));
                            }
                            lop.setMaKhoaHoc(rs.getString(5));
                            listLops.add(lop);
                        }
                    }
                }
                if(i != 0) noData = true;
                else noData = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "editLop";
        }else{
            return "fail";
        }
    }
    
    public String EditLopSubmit(){
        Map session = ActionContext.getContext().getSession();
        if(session.get("SessionLogin") != null){
            try {
                int result = DAO.UpdateLop(maLop, tenLop, maKhoa, maHeDT, maKhoaHoc);
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
    public String DeleteLop(){
        Map session = ActionContext.getContext().getSession();
        if(session.get("SessionLogin") != null){
            try {
                if(submitType.equals("deletedata")){
                    int result = DAO.DeleteLop(maLop); 
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
    public String TimKiemLop(){
        Map session = ActionContext.getContext().getSession();
        if(session.get("SessionLogin") != null){
            try {
                noData = true;
                ResultSet rs = DAO.TimKiemLop(textSearch.trim());
                listLops = new ArrayList<>();
                if(rs != null){
                    while(rs.next()){
                        lop = new Lop();
                        lop.setMaLop(rs.getString(1).trim());
                        lop.setTenLop(rs.getString(2).trim());
                        lop.setMaKhoa(rs.getString(3).trim());
                        lop.setMaHeDT(rs.getString(4).trim());
                        lop.setMaKhoaHoc(rs.getString(5).trim());
                        listLops.add(lop);
                    }
                    if(radioButton.equals("sxten"))  Collections.sort(listLops, Lop.nameCompare);
                    if(radioButton.equals("sxkhoa"))  Collections.sort(listLops, Lop.maKhoaCompare);
                    if(radioButton.equals("sxhedt")) Collections.sort(listLops, Lop.maHeDTCompare);
                    if(radioButton.equals("sxkhoahoc")) Collections.sort(listLops, Lop.maKhoaHocCompare);
                    sum = listLops.size();
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
