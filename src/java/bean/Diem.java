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
public class Diem {
    private String maSV;
    private String maMH;
    private int hocKy;
    private int diemLan1;
    private int diemLan2;
    
    public int getDiemLan2() {
        return diemLan2;
    }

    public void setDiemLan2(int diemLan2) {
        this.diemLan2 = diemLan2;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getMaMH() {
        return maMH;
    }

    public int getHocKy() {
        return hocKy;
    }

    public int getDiemLan1() {
        return diemLan1;
    }


    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }

    public void setDiemLan1(int diemLan1) {
        this.diemLan1 = diemLan1;
    }

     public static Comparator<Diem> maSVCompare = new Comparator<Diem>() {
        @Override
         public int compare(Diem o1, Diem o2) {
            return o1.maSV.compareTo(o2.maSV);
        }
    };
    
    public static Comparator<Diem> maMHCompare = new Comparator<Diem>() {
        @Override
        public int compare(Diem o1, Diem o2) {
            return o1.maMH.compareTo(o2.maMH);
        }
    };
    
    public static Comparator<Diem> hocKyCompare = new Comparator<Diem>() {
        @Override
        public int compare(Diem o1, Diem o2) {
            return o1.hocKy - o2.hocKy;
        }
    };
    
    public static Comparator<Diem> diemLan1Compare = new Comparator<Diem>() {
        @Override
        public int compare(Diem o1, Diem o2) {
            return o1.diemLan1 - o2.diemLan1;
        }
    };
        
    public static Comparator<Diem> diemLan2Compare = new Comparator<Diem>() {
        @Override
        public int compare(Diem o1, Diem o2) {
            return o1.diemLan2 - o2.diemLan2;
        }
    };
    
    
    
    
}
