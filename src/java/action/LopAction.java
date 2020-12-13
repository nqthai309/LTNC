/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import bean.Lop;
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
public class LopAction extends ActionSupport{
    ResultSet rs = null;
    List<Lop> listLops = null;
    private boolean noData = false;
    Lop lop = null;

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
        try {
            listLops = new ArrayList<Lop>();
            rs = DAO.GetLop();
            int i = 0;
            if(rs != null){
                while(rs.next()){
                    i++;
                    lop = new Lop();
                    lop.setMaLop(rs.getString(1));
                    lop.setTenLop(rs.getString(2));
                    lop.setMaKhoa(rs.getString(3));
                    lop.setMaHeDT(rs.getString(4));
                    lop.setMaKhoaHoc(rs.getString(5));
                    
                    listLops.add(lop);
                }
            }
            if(i == 0)  noData = false;
            else    noData = true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "GetLop";
    }
    
}
