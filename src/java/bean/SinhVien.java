/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author thai
 */
public class SinhVien {
    private String maSV;
    private String tenSinhVien;
    private Boolean gioiTinh;
    private String ngaySinh;
    private String queQuan;
    private String maLop;

    public SinhVien(String maSV, String tenSinhVien, Boolean gioiTinh, String ngaySinh, String queQuan, String maLop) {
        this.maSV = maSV;
        this.tenSinhVien = tenSinhVien;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
        this.maLop = maLop;
    }

    public SinhVien() {
    }

    public String getMaSV() {
        return maSV;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public Boolean getGioiTinh() {
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

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public void setGioiTinh(Boolean gioiTinh) {
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
    
    
}
