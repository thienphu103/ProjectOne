package vn.edu.poly.project_one.View_getter_setter;

import java.io.Serializable;

/**
 * Created by A on 11/30/2017.
 */

public class visit_1_getter_setter implements Serializable {
    private int background;
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
    private String soluong;
    private String name_cuahang;
    private String logo_cuahang;
    private String text_donhang;
    private String khach;
    private String sdt;
    private int background_2;
    private String date_thongbao;
    private String text_thongbao;

    public visit_1_getter_setter(String date_thongbao, String text_thongbao) {
        this.date_thongbao = date_thongbao;
        this.text_thongbao = text_thongbao;
    }

    public String getDate_thongbao() {
        return date_thongbao;
    }

    public void setDate_thongbao(String date_thongbao) {
        this.date_thongbao = date_thongbao;
    }

    public String getText_thongbao() {
        return text_thongbao;
    }

    public void setText_thongbao(String text_thongbao) {
        this.text_thongbao = text_thongbao;
    }

    public visit_1_getter_setter(int background, String text_donhang, String khach, String sdt, int background_2) {
        this.background = background;
        this.text_donhang = text_donhang;
        this.khach = khach;
        this.sdt = sdt;
        this.background_2 = background_2;
    }

    public int getBackground_2() {
        return background_2;
    }

    public void setBackground_2(int background_2) {
        this.background_2 = background_2;
    }

    public String getText_donhang() {
        return text_donhang;
    }

    public void setText_donhang(String text_donhang) {
        this.text_donhang = text_donhang;
    }

    public String getKhach() {
        return khach;
    }

    public void setKhach(String khach) {
        this.khach = khach;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public visit_1_getter_setter(int id_sp, String ten_sp, String gia_sp, String hinhanh_sp, String soluongconlai_sp) {
        this.id_sp=id_sp;
        this.ten_sp = ten_sp;
        this.gia_sp = gia_sp;
        this.hinhanh_sp = hinhanh_sp;
        this.soluongconlai_sp=soluongconlai_sp;
    }


    public visit_1_getter_setter(String ten_sp, String gia_sp, String soluong, String name_cuahang) {
        this.ten_sp = ten_sp;
        this.gia_sp = gia_sp;
        this.soluong = soluong;
        this.name_cuahang = name_cuahang;
    }


    public visit_1_getter_setter(String ten_sp,String soluongconlai_sp,String hinhanh_sp) {
        this.ten_sp = ten_sp;
        this.soluongconlai_sp=soluongconlai_sp;
        this.hinhanh_sp = hinhanh_sp;
    }
    public visit_1_getter_setter(String hinhanh_sp) {
        this.hinhanh_sp = hinhanh_sp;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public String getName_cuahang() {
        return name_cuahang;
    }

    public void setName_cuahang(String name_cuahang) {
        this.name_cuahang = name_cuahang;
    }

    public String getLogo_cuahang() {
        return logo_cuahang;
    }

    public void setLogo_cuahang(String logo_cuahang) {
        this.logo_cuahang = logo_cuahang;
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
