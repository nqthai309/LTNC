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
    public static ResultSet GetSinhVienByID(String maSV){
        ResultSet rs = null;
        try {
            String sql = "select * from SinhVien where MaSV = "+maSV;
            PreparedStatement stm = getConnectDB().prepareStatement(sql);
            rs = stm.executeQuery();
            return rs;
        } catch (Exception e) {
            return null;
        }
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
//Hiếu
    public static ResultSet findLopByMaLop(String maLop){
        ResultSet rs = null;
        try {
            String sql = "Select * from Lop where MaLop = '"+maLop+"'";
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
            String sql = "INSERT dbo.Lop VALUES  ( '"+maLop+"' ,N'"+tenLop+"' , '"+maKhoa+"' , '"+maHeDT+"' ,'"+maKhoaHoc+"')";
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
    public static ResultSet GetMaKhoa() throws SQLException {
        ResultSet rs = null;
        try {
            String sql = "Select MaKhoa from Khoa";
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
    public static ResultSet GetMaHeDT() throws SQLException {
        ResultSet rs = null;
        try {
            String sql = "Select MaHeDT from HeDT";
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
    public static ResultSet GetMaKhoaHoc() throws SQLException {
        ResultSet rs = null;
        try {
            String sql = "Select MaKhoaHoc from KhoaHoc";
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
        public static int UpdateLop(String maLop, String tenLop, String maKhoa,String maHeDT, String maKhoaHoc) throws SQLException{
        int i=0;
        try {
            String sql = "UPDATE dbo.Lop SET TenLop = N'"+tenLop+"', MaKhoa = '"+maKhoa+"', MaHeDT = '"+maHeDT+"', MaKhoaHoc = '"+maKhoaHoc+"' WHERE MaLop = '"+maLop+"'";
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

    public static int DeleteLop(String maLop){
        try {
            String sql = "delete Lop where MaLop = '"+maLop+"'";
            PreparedStatement ps = getConnectDB().prepareStatement(sql);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public static ResultSet TimKiemLop(String textSearch){
        ResultSet rs = null;
        try {
            String sql = "Select * from Lop where TenLop like N'%"+textSearch+"%' ";
            PreparedStatement ps = getConnectDB().prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
//Hiếu.!!!
    
//Tùng
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
        
        public static ResultSet findDiemByMaSVMaMH(String maSV, String maMH){
        ResultSet rs = null;
        try {
            String sql = "Select * from Diem where MaSV = '"+maSV+"' and MaMH = '"+maMH+"'";
            PreparedStatement ps = getConnectDB().prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int DeleteDiem(String maSV,String maMH){
        try {
            String sql = "Delete from Diem where MaSV = '"+maSV+"' and MaMH = '"+maMH+"'";
            PreparedStatement ps = getConnectDB().prepareStatement(sql);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public static int UpdateDiem(String maSV, String maMH, int hocKy, int diemLan1,  int diemLan2) throws SQLException{
        int i=0;
        try {
            String sql = "Update Diem SET HocKy = '"+hocKy+"', DiemLan1 = '"+diemLan1+"', DiemLan2 = '"+diemLan2+"' where MaSV = '"+maSV+"' and MaMH = '"+maMH+"'";
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
    
    public static ResultSet TimKiemDiemByMaSV(String textSearch){
        ResultSet rs = null;
        try {
            String sql = "Select * from Diem where MaSV like N'%"+textSearch+"%' ";
            PreparedStatement ps = getConnectDB().prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    //Tùng
//Thắng.!!!
        public static int InsertKhoa(String maKhoa, String tenKhoa, String diaChi, String dienThoai) throws SQLException{
        try {
            String sql = "INSERT dbo.Khoa ( MaKhoa, TenKhoa, DiaChi, DienThoai ) "
                    + "VALUES  ( '"+maKhoa+"',N'"+tenKhoa+"',N'"+diaChi+"','"+dienThoai+"')";
            PreparedStatement ps  = getConnectDB().prepareStatement(sql);
            return ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            if (getConnectDB() != null) {
                getConnectDB().close();
            }
        }
    }
    
    public static ResultSet findKhoaByMaKhoa(String maKhoa){
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM dbo.Khoa WHERE MaKhoa = '"+maKhoa+"'";
            PreparedStatement ps = getConnectDB().prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }    
    
    public static int UpdateKhoa(String maKhoa, String tenKhoa, String diaChi, String dienThoai) throws SQLException
    {
        int i = 0;
        try {
            String sql = "UPDATE Khoa SET TenKhoa = '"+tenKhoa.trim()+"', "
                         + "DiaChi = '"+diaChi.trim()+"', DienThoai = '"+dienThoai.trim()+"' \n" +
                         "WHERE MaKhoa = '"+maKhoa+"'";
            PreparedStatement ps = getConnectDB().prepareStatement(sql);
            i =  ps.executeUpdate();
            return i;
        } catch(Exception e){
            e.printStackTrace();
            return 0;
        } finally{
            if(getConnectDB() != null){
               getConnectDB().close();
            }
        }
    }
    
    public static int DeleteKhoa (String maKhoa){
        try{
            String sql = "DELETE dbo.Khoa WHERE MaKhoa = '"+maKhoa+"'";
            PreparedStatement ps = getConnectDB().prepareStatement(sql);
            return ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public static ResultSet TimKiemKhoa(String textSearch){
        ResultSet rs = null;
        try{
            String sql = "SELECT * FROM dbo.Khoa WHERE MaKhoa LIKE N'%"+textSearch+"%'";
            PreparedStatement ps = getConnectDB().prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
//Thắng.!!!
}
