package vn.edu.poly.project_one.View_getter_setter;

import java.io.Serializable;

/**
 * Created by A on 11/30/2017.
 */

public class visit_1_getter_setter implements Serializable {
    private int id_sp;
    private String ten_sp;
    private String gia_sp;
    private String mota_sp;
    private String soluongdaban_sp;
    private String soluongconlai_sp;
    private String id_shop;
    private String id_loaisp;
    private String id_danhgia_sp;
    private String hinhanh_sp;
    private String size_sp;
    private String mau_sp;
    private String han_sd_sp;

    public visit_1_getter_setter(String ten_sp, String gia_sp,String hinhanh_sp) {
        this.ten_sp = ten_sp;
        this.gia_sp = gia_sp;
        this.hinhanh_sp = hinhanh_sp;
    }

    public visit_1_getter_setter() {
    }

    public int getId_sp() {
        return id_sp;
    }

    public void setId_sp(int id_sp) {
        this.id_sp = id_sp;
    }

    public String getTen_sp() {
        return ten_sp;
    }

    public void setTen_sp(String ten_sp) {
        this.ten_sp = ten_sp;
    }

    public String getGia_sp() {
        return gia_sp;
    }

    public void setGia_sp(String gia_sp) {
        this.gia_sp = gia_sp;
    }

    public String getMota_sp() {
        return mota_sp;
    }

    public void setMota_sp(String mota_sp) {
        this.mota_sp = mota_sp;
    }

    public String getSoluongdaban_sp() {
        return soluongdaban_sp;
    }

    public void setSoluongdaban_sp(String soluongdaban_sp) {
        this.soluongdaban_sp = soluongdaban_sp;
    }

    public String getSoluongconlai_sp() {
        return soluongconlai_sp;
    }

    public void setSoluongconlai_sp(String soluongconlai_sp) {
        this.soluongconlai_sp = soluongconlai_sp;
    }

    public String getId_shop() {
        return id_shop;
    }

    public void setId_shop(String id_shop) {
        this.id_shop = id_shop;
    }

    public String getId_loaisp() {
        return id_loaisp;
    }

    public void setId_loaisp(String id_loaisp) {
        this.id_loaisp = id_loaisp;
    }

    public String getId_danhgia_sp() {
        return id_danhgia_sp;
    }

    public void setId_danhgia_sp(String id_danhgia_sp) {
        this.id_danhgia_sp = id_danhgia_sp;
    }

    public String getHinhanh_sp() {
        return hinhanh_sp;
    }

    public void setHinhanh_sp(String hinhanh_sp) {
        this.hinhanh_sp = hinhanh_sp;
    }

    public String getSize_sp() {
        return size_sp;
    }

    public void setSize_sp(String size_sp) {
        this.size_sp = size_sp;
    }

    public String getMau_sp() {
        return mau_sp;
    }

    public void setMau_sp(String mau_sp) {
        this.mau_sp = mau_sp;
    }

    public String getHan_sd_sp() {
        return han_sd_sp;
    }

    public void setHan_sd_sp(String han_sd_sp) {
        this.han_sd_sp = han_sd_sp;
    }
}
