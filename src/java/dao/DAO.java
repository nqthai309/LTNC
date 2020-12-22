/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author thai
 */
public class DAO {
    public static Connection getConnectDB(){
        Connection conn = null;
        try {
            String url = ConnectionString.url;
            String user = ConnectionString.user;
            String pass = ConnectionString.pass;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("successfully");
        } catch (Exception e) {
            System.out.println("fail");
        }
        return conn;
    }
    public static String CheckLogin(String username, String password){
        try {
            Connection conn = getConnectDB();
            Statement stm = null;
            ResultSet rs = null;
            stm = conn.createStatement();
            String sql = "SELECT username FROM Login WHERE username = '"+username+"' and password = '"+password+"'  ";
            rs = stm.executeQuery(sql);
            while(rs.next()){
                return rs.getString(1);
            }
        } catch (Exception e) {
        }
        return "error";
    }
    public static ResultSet GetSinhVien() throws SQLException{
        ResultSet rs = null;
        try {
            String sql = "Select * from SinhVien";
            PreparedStatement ps = getConnectDB().prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            if (getConnectDB() != null) {
                getConnectDB().close();
            }
        }
    }
    public static ResultSet GetDiem() throws SQLException{
        ResultSet rs = null;
        try {
            String sql = "Select * from Diem";
            PreparedStatement ps = getConnectDB().prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            if (getConnectDB() != null) {
                getConnectDB().close();
            }
        }
    }
    public static ResultSet GetLop() throws SQLException{
        ResultSet rs = null;
        try {
            String sql = "Select * from Lop";
            PreparedStatement ps = getConnectDB().prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            if (getConnectDB() != null) {
                getConnectDB().close();
            }
        }
    }
    public static ResultSet GetKhoa() throws SQLException{
        ResultSet rs = null;
        try {
            String sql = "Select * from Khoa";
            PreparedStatement ps = getConnectDB().prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            if (getConnectDB() != null) {
                getConnectDB().close();
            }
        }
    }
    public static ResultSet GetMaLop() throws SQLException {
        ResultSet rs = null;
        try {
            String sql = "Select MaLop from Lop";
            PreparedStatement ps = getConnectDB().prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            if (getConnectDB() != null) {
                getConnectDB().close();
            }
        }
    }
    public static ResultSet GetMaMH() throws SQLException {
        ResultSet rs = null;
        try {
            String sql = "Select MaMH from MonHoc";
            PreparedStatement ps = getConnectDB().prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            if (getConnectDB() != null) {
                getConnectDB().close();
            }
        }
    }
    public static ResultSet CheckMaSV(String maSV) throws SQLException{
        ResultSet rs = null;
        try {
            String sql = "Select * from SinhVien where MaSV = '"+maSV+"' ";
            PreparedStatement ps = getConnectDB().prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            if (getConnectDB() != null) {
                getConnectDB().close();
            }
        }
    }
    public static int InsertSinhVien(String maSV, String tenSinhVien, String gioiTinh,String ngaySinh, String queQuan, String maLop) throws SQLException{
        
        try {
            String sql = "INSERT SinhVien VALUES ('"+maSV+"',N'"+tenSinhVien+"',"
                    + "'"+gioiTinh+"' ,'"+ngaySinh+"','"+queQuan+"','"+maLop+"') ";
            PreparedStatement ps = getConnectDB().prepareStatement(sql);
            return ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally{
            if (getConnectDB() != null) {
                getConnectDB().close();
            }
        }
    }
    public static ResultSet findSinhVienByMaSV(String maSV){
        ResultSet rs = null;
        try {
            String sql = "Select * from SinhVien where MaSV = '"+maSV+"'";
            PreparedStatement ps = getConnectDB().prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static int UpdateSinhVien(String maSV, String tenSinhVien, String gioiTinh,String ngaySinh, String queQuan, String maLop) throws SQLException{
        int i=0;
        try {
            String sql = "update SinhVien"
                    + " set TenSV=N'"+tenSinhVien.trim()+"', GioiTinh='"+gioiTinh.trim()+"', "
                    + "NgaySinh='"+ngaySinh.trim()+"', "
                    + "QueQuan='"+queQuan.trim()+"', MaLop='"+maLop.trim()+"' "
                    + "where MaSV='"+maSV.trim()+"'";
            PreparedStatement ps = getConnectDB().prepareStatement(sql);
            i = ps.executeUpdate();
            return i;
            
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (getConnectDB() != null) {
		getConnectDB().close();
            }
        }
    }
    public static int DeleteSinhVien(String maSV){
        try {
            String sql = "delete SinhVien where MaSV = '"+maSV+"'";
            PreparedStatement ps = getConnectDB().prepareStatement(sql);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public static int InsertDiemSinhVien(String maSV, String maMH, int hocKy, int diemLan1, int diemLan2){
        try {
            String sql = "INSERT Diem VALUES ('"+maSV+"', '"+maMH+"', '"+hocKy+"', '"+diemLan1+"', '"+diemLan2+"')";
            PreparedStatement ps = getConnectDB().prepareStatement(sql);
            int i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public static ResultSet TimKiemSinhVien(String textSearch){
        ResultSet rs = null;
        try {
            String sql = "Select * from SinhVien where TenSV like N'%"+textSearch+"%' ";
            PreparedStatement ps = getConnectDB().prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static int InsertLop(String maLop, String tenLop, String maKhoa,String maHeDT, String maKhoaHoc) throws SQLException{
        
        try {
            String sql = "INSERT Lop VALUES ('"+maLop+"',N'"+tenLop+"',"
                    + "'"+maKhoa+"' ,'"+maHeDT+"','"+maKhoaHoc+"') ";
            PreparedStatement ps = getConnectDB().prepareStatement(sql);
            return ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally{
            if (getConnectDB() != null) {
                getConnectDB().close();
            }
        }
    }
}
