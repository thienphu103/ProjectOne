package vn.edu.poly.project_one.View_getter_setter;

import java.io.Serializable;

/**
 * Created by ASUS on 11/22/2017.
 */

public class donhangcuatui_taikhoan_getter_setter implements Serializable {

    public String txt_date;
    public String txt_id;
    public String txt_price;
    public String txt_content;

    public donhangcuatui_taikhoan_getter_setter(String txt_id, String txt_price, String txt_content,String txt_date) {
        this.txt_id = txt_id;
        this.txt_price = txt_price;
        this.txt_content = txt_content;
        this.txt_date=txt_date;
    }

    public String getTxt_date() {
        return txt_date;
    }

    public void setTxt_date(String txt_date) {
        this.txt_date = txt_date;
    }

    public String getTxt_id() {
        return txt_id;
    }

    public void setTxt_id(String txt_id) {
        this.txt_id = txt_id;
    }

    public String getTxt_price() {
        return txt_price;
    }

    public void setTxt_price(String txt_price) {
        this.txt_price = txt_price;
    }

    public String getTxt_content() {
        return txt_content;
    }

    public void setTxt_content(String txt_content) {
        this.txt_content = txt_content;
    }
}
