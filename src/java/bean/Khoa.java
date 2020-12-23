/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Comparator;

/**
 *
 * @author thai
 */
public class Khoa {
    private String maKhoa;
    private String tenKhoa;
    private String diaChi;
    private String dienThoai;

    public Khoa() {
        
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
        public Khoa(String maKhoa, String tenKhoa, String diaChi, String dienThoai) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
    }
        
    public static Comparator<Khoa> tenKhoaCompare = new Comparator<Khoa>() {
        @Override
        public int compare(Khoa o1, Khoa o2) {
            return o1.tenKhoa.compareTo(o2.tenKhoa);
        }
    };
    
    public static Comparator<Khoa> maKhoaCompare = new Comparator<Khoa>() {
        @Override
        public int compare(Khoa o1, Khoa o2) {
            return o1.maKhoa.compareTo(o2.maKhoa);
        }
    };
    
    
}
