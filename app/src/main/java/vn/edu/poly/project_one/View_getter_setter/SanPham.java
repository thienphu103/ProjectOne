package vn.edu.poly.project_one.View_getter_setter;

/**
 * Created by TN on 24-Nov-17.
 */

public class SanPham {
    String ten_sp;
    String gia_sp;
    String soluong_sp;
    String size_sp;
    String img_sp;

    public SanPham(String ten_sp, String gia_sp, String soluong_sp, String size_sp, String img_sp) {
        this.ten_sp = ten_sp;
        this.gia_sp = gia_sp;
        this.soluong_sp = soluong_sp;
        this.size_sp = size_sp;
        this.img_sp = img_sp;
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

    public String getSoluong_sp() {
        return soluong_sp;
    }

    public void setSoluong_sp(String soluong_sp) {
        this.soluong_sp = soluong_sp;
    }

    public String getSize_sp() {
        return size_sp;
    }

    public void setSize_sp(String size_sp) {
        this.size_sp = size_sp;
    }

    public String getImg_sp() {
        return img_sp;
    }

    public void setImg_sp(String img_sp) {
        this.img_sp = img_sp;
    }
}
