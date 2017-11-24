package vn.edu.poly.project_one.View_getter_setter;

import java.io.Serializable;

/**
 * Created by ASUS on 11/21/2017.
 */

public class visit_danhsachcuahang_getter_setter implements Serializable {
    public String txt_custom1;
    public String txt_custom2;
    public String btn_custom3;

    public visit_danhsachcuahang_getter_setter() {
    }

    public visit_danhsachcuahang_getter_setter(String txt_custom1, String txt_custom2, String btn_custom3) {
        this.txt_custom1 = txt_custom1;
        this.txt_custom2 = txt_custom2;
        this.btn_custom3 = btn_custom3;
    }

    public String getTxt_custom1() {
        return txt_custom1;
    }

    public void setTxt_custom1(String txt_custom1) {
        this.txt_custom1 = txt_custom1;
    }

    public String getTxt_custom2() {
        return txt_custom2;
    }

    public void setTxt_custom2(String txt_custom2) {
        this.txt_custom2 = txt_custom2;
    }

    public String getBtn_custom3() {
        return btn_custom3;
    }

    public void setBtn_custom3(String btn_custom3) {
        this.btn_custom3 = btn_custom3;
    }
}
