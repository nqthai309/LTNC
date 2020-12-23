/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import bean.Khoa;
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
 * @author Thang
 */
public class KhoaAction extends ActionSupport{
    ResultSet rs = null;
    List<Khoa> listKhoas = null;
    private boolean noData = false;
    private boolean checkError = false;
    private boolean checkErrorDelete = false;
    Khoa khoa = null;
    String submitType, textSearch, radioButton;

    public boolean isCheckErrorDelete() {
        return checkErrorDelete;
    }

    public void setCheckErrorDelete(boolean checkErrorDelete) {
        this.checkErrorDelete = checkErrorDelete;
    }
    
    
    
    public void setCheckError(boolean checkError) {
        this.checkError = checkError;
    }

    public boolean isCheckError() {
        return checkError;
    }
    public void setRadioButton(String radioButton) {
        this.radioButton = radioButton;
    }

    public void setKhoa(Khoa khoa) {
        this.khoa = khoa;
    }

    public String getRadioButton() {
        return radioButton;
    }

    public Khoa getKhoa() {
        return khoa;
    }
    private String maKhoa, tenKhoa, diaChi, dienThoai;

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public String getSubmitType() {
        return submitType;
    }

    public String getTextSearch() {
        return textSearch;
    }
    public void setSubmitType(String submitType) {
        this.submitType = submitType;
    }

    public void setTextSearch(String textSearch) {
        this.textSearch = textSearch;
    }
    public List<Khoa> getListKhoas() {
        return listKhoas;
    }

    public boolean isNoData() {
        return noData;
    }

    public void setListKhoas(List<Khoa> listKhoas) {
        this.listKhoas = listKhoas;
    }

    public void setNoData(boolean noData) {
        this.noData = noData;
    }
    
    

       @Override
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        if(session.get("SessionLogin") != null){
            try {
            ResultSet rs = DAO.findKhoaByMaKhoa(maKhoa.trim());
            if(!(rs.next())){
                int result = DAO.InsertKhoa(maKhoa.trim(), tenKhoa.trim(), diaChi.trim(), dienThoai.trim());
                if(result > 0){
                    return "complete";
                }else{
                    return "fail";
                }   
            }else{
                checkError = true;
                return "ex";
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }  
        }else{
            return "fail";
        }

    }
  

   public String GetKhoa () throws Exception {
        Map session = ActionContext.getContext().getSession();
        if(session.get("SessionLogin") != null){
                  try{
           listKhoas = new ArrayList<Khoa>();
           rs = DAO.GetKhoa();
           int i = 0;
           if(rs != null){
               while(rs.next()){
                   i++;
                   khoa = new Khoa();
                   khoa.setMaKhoa(rs.getString(1));
                   khoa.setTenKhoa(rs.getString(2));
                   khoa.setDiaChi(rs.getString(3));
                   khoa.setDienThoai(rs.getString(4));
                   
                   listKhoas.add(khoa);
               }
           }
           if(i == 0) noData = false;
           else noData = true;
       } catch (Exception e) {
           e.printStackTrace();
       }
       return "GetKhoa"; 
        }else{
           return "fail"; 
        }

   }

    
    public String AddKhoa(){
        Map session = ActionContext.getContext().getSession();
        if(session.get("SessionLogin") != null){
           try {
            
            int i = 0;
            if(i == 0)  noData = false;
            else    noData = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "AddKhoa";
        }else{
            return "fail";
        }
    }
    
    public String EditKhoa(){
        Map session = ActionContext.getContext().getSession();
        if(session.get("SessionLogin") != null){
        int i = 0;
        noData = false;
        listKhoas = new ArrayList<>();
        khoa = new Khoa();
        try{
            if (submitType.equals("updatedata")){
                rs = DAO.findKhoaByMaKhoa(maKhoa);
                if(rs != null){
                    while(rs.next()){
                        i++;
                        khoa.setMaKhoa(rs.getString(1));
                        khoa.setTenKhoa(rs.getString(2));
                        khoa.setDiaChi(rs.getString(3));
                        khoa.setDienThoai(rs.getString(4)); 
                        listKhoas.add(khoa);
                    }
                }
            }
            if(i != 0) noData = true;
            else noData = false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "editKhoa";    
        }else {
            return "fail";
        }
       
    }
    
    public String EditKhoaSubmit(){
        Map session = ActionContext.getContext().getSession();
        if(session.get("SessionLogin") != null){
        try{
            int result = DAO.UpdateKhoa(maKhoa, tenKhoa, diaChi, dienThoai);
            if(result > 0) return "complete";
            else return "fail";
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }    
        }else{
            return "fail";
        }
    }
    
    public String DeleteKhoa(){
        Map session = ActionContext.getContext().getSession();
        if(session.get("SessionLogin") != null){
        try {
            if(submitType.equals("deletedata")){
                ResultSet rs = DAO.GetLopFromKhoaByID(maKhoa.trim());
                if(!(rs.next())){
                    int result = DAO.DeleteKhoa(maKhoa);
                    if(result > 0) return "complete";
                    else return "fail";
                }else{
                    checkErrorDelete = true;
                    return "ex";
                }
                
            }
        }catch(Exception e){
            e.printStackTrace();
            return "fail";
        }
        return "";    
        }else{
            return "fail";
        }
    }
    
    public String TimKiemKhoa(){
        Map session = ActionContext.getContext().getSession();
        if(session.get("SessionLogin") != null){
           try{
           noData = true;
           ResultSet rs = DAO.TimKiemKhoa(textSearch.trim());
           listKhoas = new ArrayList<>();
           if(rs != null){
               while(rs.next()){
                   khoa = new Khoa();
                   khoa.setMaKhoa(rs.getString(1).trim());
                   khoa.setTenKhoa(rs.getString(2).trim());
                   khoa.setDiaChi(rs.getString(3).trim());
                   khoa.setDienThoai(rs.getString(4).trim()); 
                   listKhoas.add(khoa);
               }
               if(radioButton.equals("sxmakhoa")) Collections.sort(listKhoas, Khoa.maKhoaCompare);
               if(radioButton.equals("sxtenkhoa")) Collections.sort(listKhoas, Khoa.tenKhoaCompare);
               return "complete";
           }
       }catch (Exception e){
           e.printStackTrace();
           return "fail";
       }
       return "";    
        }else{
            return "fail";
        }
    }
    
}
