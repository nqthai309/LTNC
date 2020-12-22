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
public class Lop {
    private String maLop;
    private String tenLop;
    private String maKhoa;
    private String maHeDT;
    private String maKhoaHoc;

    public Lop() {
    }

    public Lop(String maLop, String tenLop, String maKhoa, String maHeDT, String maKhoaHoc) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.maKhoa = maKhoa;
        this.maHeDT = maHeDT;
        this.maKhoaHoc = maKhoaHoc;
    }
    

    public String getMaLop() {
        return maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public String getMaHeDT() {
        return maHeDT;
    }

    public String getMaKhoaHoc() {
        return maKhoaHoc;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public void setMaHeDT(String maHeDT) {
        this.maHeDT = maHeDT;
    }

    public void setMaKhoaHoc(String maKhoaHoc) {
        this.maKhoaHoc = maKhoaHoc;
    }

    public static Comparator<Lop> nameCompare = new Comparator<Lop>() {
        @Override
        public int compare(Lop o1, Lop o2) {
            return o1.tenLop.compareTo(o2.tenLop);
        }
    };
    
    public static Comparator<Lop> maKhoaCompare = new Comparator<Lop>() {
        @Override
        public int compare(Lop o1, Lop o2) {
            return o1.maKhoa.compareTo(o2.maKhoa);
        }
    };
    
    public static Comparator<Lop> maHeDTCompare = new Comparator<Lop>() {
        @Override
        public int compare(Lop o1, Lop o2) {
            return o1.maHeDT.compareTo(o2.maHeDT);
        }
    };
    
    public static Comparator<Lop> maKhoaHocCompare = new Comparator<Lop>() {
        @Override
        public int compare(Lop o1, Lop o2) {
            return o1.maKhoaHoc.compareTo(o2.maKhoaHoc);
        }
    };
}
