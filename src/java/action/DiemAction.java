/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import bean.Diem;
import bean.Lop;
import bean.SinhVien;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.util.List;
import dao.DAO;
import java.util.ArrayList;
import java.util.Map;
import java.util.Collections;
/**
 *
 * @author thai
 */
public class DiemAction extends ActionSupport{
    ResultSet rs = null;
    List<Diem> listDiem = null;
    private boolean noData = false;
    Diem diem = null;
    List<String> maMocHocs = null;
    String maSV, maMH, hocKy, diemLan1, diemLan2;
    String submitType,textSearch,radioButton;
    int sum;

    public int getSum() {
        return sum;
    }

    public void setTextSearch(String textSearch) {
        this.textSearch = textSearch;
    }

    public void setRadioButton(String radioButton) {
        this.radioButton = radioButton;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
    
    public String getTextSearch() {
        return textSearch;
    }

    public String getRadioButton() {
        return radioButton;
    }

    public String getSubmitType() {
        return submitType;
    }

    public void setSubmitType(String submitType) {
        this.submitType = submitType;
    }
    

    public ResultSet getRs() {
        return rs;
    }

    public List<Diem> getListDiem() {
        return listDiem;
    }

    public boolean isNoData() {
        return noData;
    }

    public Diem getDiem() {
        return diem;
    }

    public List<String> getMaMocHocs() {
        return maMocHocs;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getMaMH() {
        return maMH;
    }

    public String getHocKy() {
        return hocKy;
    }

    public String getDiemLan1() {
        return diemLan1;
    }

    public String getDiemLan2() {
        return diemLan2;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public void setListDiem(List<Diem> listDiem) {
        this.listDiem = listDiem;
    }

    public void setNoData(boolean noData) {
        this.noData = noData;
    }

    public void setDiem(Diem diem) {
        this.diem = diem;
    }

    public void setMaMocHocs(List<String> maMocHocs) {
        this.maMocHocs = maMocHocs;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public void setHocKy(String hocKy) {
        this.hocKy = hocKy;
    }

    public void setDiemLan1(String diemLan1) {
        this.diemLan1 = diemLan1;
    }

    public void setDiemLan2(String diemLan2) {
        this.diemLan2 = diemLan2;
    }
    
    
    @Override
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        if(session.get("SessionLogin") != null){
            try {
                listDiem = new ArrayList<Diem>();
                rs = DAO.GetDiem();
                int i = 0;
                if(rs != null){
                    while(rs.next()){
                        i++;
                        diem = new Diem();
                        diem.setMaSV(rs.getString(1));
                        diem.setMaMH(rs.getString(2));
                        diem.setHocKy(rs.getInt(3));
                        diem.setDiemLan1(rs.getInt(4));
                        diem.setDiemLan2(rs.getInt(5));
                    
                        listDiem.add(diem);
                    }
                }
                if(i == 0)  noData = false;
                else    noData = true;
            
            } catch (Exception e) {
                e.printStackTrace();
            }
        
            return "GetDiem";
        }else{
            return "fail";
        }
        
    }
    public String AddDiemSinhVien(){
        Map session = ActionContext.getContext().getSession();
        if(session.get("SessionLogin") != null){
            maMocHocs = new ArrayList<String>();
        try {
            rs = DAO.GetMaMH();
            if(rs != null){
                while(rs.next()){
                    maMocHocs.add(rs.getString(1).trim());
                }
            }
        } catch (Exception e) {
        }
        return "AddDiemSinhVien";
        }else{
            return "fail";
        }
        
    }
    public String AddDiemSinhVienSubmit(){
        Map session = ActionContext.getContext().getSession();
        if(session.get("SessionLogin") != null){
            try {
            
            int result = DAO.InsertDiemSinhVien(maSV.trim(), maMH.trim(), Integer.parseInt(hocKy.trim())
                    , Integer.parseInt(diemLan1.trim()), Integer.parseInt(diemLan2.trim()));
            if(result > 0) return "complete";
            else    return "fail";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        }else{
            return "fail";
        } 
    }
    
    public String EditDiem(){
        Map session = ActionContext.getContext().getSession();
        if(session.get("SessionLogin") != null){
            int i=0;
            noData = false;
            listDiem = new ArrayList<>();
            
            try {
                if(submitType.equals("updatedata")){
                    rs = DAO.findDiemByMaSVMaMH(maSV,maMH);
                    if(rs != null){
                        while(rs.next()){
                            i++;
                            diem = new Diem();
                            diem.setMaSV(rs.getString("MaSV").trim());
                            diem.setMaMH(rs.getString("MaMH").trim());
                            diem.setHocKy(rs.getInt("HocKy"));
                            diem.setDiemLan1(rs.getInt("DiemLan1"));
                            diem.setDiemLan2(rs.getInt("DiemLan2"));
                            listDiem.add(diem);
                        }
                    }
                }
                if(i != 0) noData = true;
                else noData = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "editDiem";
        }else{
            return "fail";
        }
    }
    
    public String EditDiemSubmit(){
        Map session = ActionContext.getContext().getSession();
        if(session.get("SessionLogin") != null){
            try {
                int result = DAO.UpdateDiem(maSV.trim(), maMH.trim(), Integer.parseInt(hocKy.trim())
                    , Integer.parseInt(diemLan1.trim()), Integer.parseInt(diemLan2.trim()));
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
    
    public String DeleteDiem(){
        Map session = ActionContext.getContext().getSession();
        if(session.get("SessionLogin") != null){
            try {
                if(submitType.equals("deletedata")){
                    int result = DAO.DeleteDiem(maSV.trim(),maMH.trim()); 
                    if(result > 0) return "complete";
                    else return "fail";
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "cant delete";
            }
            return "";
        }else{
            return "fail";
            
        }
        
    }
    
     public String TimKiemDiem(){
        Map session = ActionContext.getContext().getSession();
        if(session.get("SessionLogin") != null){
            try {
                noData = true;
                ResultSet rs = DAO.TimKiemDiemByMaSV(textSearch.trim());
                listDiem = new ArrayList<>();
                if(rs != null){
                    while(rs.next()){
                        diem = new Diem();
                        diem = new Diem();
                        diem.setMaSV(rs.getString(1));
                        diem.setMaMH(rs.getString(2));
                        diem.setHocKy(rs.getInt(3));
                        diem.setDiemLan1(rs.getInt(4));
                        diem.setDiemLan2(rs.getInt(5));
                        listDiem.add(diem);
                    }
                    if(radioButton.equals("sxMaSV"))  Collections.sort(listDiem, Diem.maSVCompare);
                    if(radioButton.equals("sxMaMH"))  Collections.sort(listDiem, Diem.maMHCompare);
                    if(radioButton.equals("sxHocKy")) Collections.sort(listDiem, Diem.hocKyCompare);
                    if(radioButton.equals("sxDiemLan1")) Collections.sort(listDiem, Diem.diemLan1Compare);
                    if(radioButton.equals("sxDiemLan2")) Collections.sort(listDiem, Diem.diemLan2Compare);
                    sum = listDiem.size();
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
