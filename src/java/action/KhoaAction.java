/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import bean.Khoa;
import bean.SinhVien;
import com.opensymphony.xwork2.ActionSupport;
import dao.DAO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thai
 */
public class KhoaAction extends ActionSupport{
    ResultSet rs = null;
    List<Khoa> listKhoas = null;
    private boolean noData = false;
    Khoa khoa = null;

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
        try {
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
            if(i == 0)  noData = false;
            else    noData = true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return "GetKhoa";
    }
    
}
