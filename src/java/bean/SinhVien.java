/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author thai
 * 
 */
import java.util.Comparator;
        
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
    
    public static Comparator<SinhVien> nameCompare = new Comparator<SinhVien>() {
        @Override
        public int compare(SinhVien o1, SinhVien o2) {
            String[] data1 = o1.tenSinhVien.split("\\s");
            String[] data2 = o2.tenSinhVien.split("\\s");
            int value1 = data2[data2.length - 1].compareTo(data1[data1.length - 1]);
            if(value1 == 0){
                int value2 = data2[data2.length - 2].compareTo(data1[data1.length - 2]);
                return value2;
            }
            return value1;
        }
    };
    
    public static Comparator<SinhVien> sexCompare = new Comparator<SinhVien>() {
        @Override
        public int compare(SinhVien o1, SinhVien o2) {
            return o1.gioiTinh.compareTo(o2.gioiTinh);
        }
    };
    
    public static Comparator<SinhVien> gradeCompare = new Comparator<SinhVien>() {
        @Override
        public int compare(SinhVien o1, SinhVien o2) {
            return o1.maLop.compareTo(o2.maLop);
        }
    };
    
    public static Comparator<SinhVien> addressCompare = new Comparator<SinhVien>() {
        @Override
        public int compare(SinhVien o1, SinhVien o2) {
            return o1.queQuan.compareTo(o2.queQuan);
        }
    };
    
    
}
