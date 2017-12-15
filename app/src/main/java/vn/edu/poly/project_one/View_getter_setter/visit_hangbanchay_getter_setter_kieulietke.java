package vn.edu.poly.project_one.View_getter_setter;

import java.io.Serializable;

/**
 * Created by ASUS on 11/22/2017.
 */

public class visit_hangbanchay_getter_setter_kieulietke implements Serializable {

    public String img_kieulietke;
    public String txt_custom1;
    public String txt_custom2;
    public String txt_custom3;
    public String txt_id;

    public visit_hangbanchay_getter_setter_kieulietke(String img_kieulietke, String txt_custom1, String txt_custom2, String txt_custom3,String txt_id) {
        this.img_kieulietke = img_kieulietke;
        this.txt_custom1 = txt_custom1;
        this.txt_custom2 = txt_custom2;
        this.txt_custom3 = txt_custom3;
        this.txt_id=txt_id;
    }

    public visit_hangbanchay_getter_setter_kieulietke() {
    }

    public String getTxt_id() {
        return txt_id;
    }

    public void setTxt_id(String txt_id) {
        this.txt_id = txt_id;
    }

    public String getImg_kieulietke() {
        return img_kieulietke;
    }

    public void setImg_kieulietke(String img_kieulietke) {
        this.img_kieulietke = img_kieulietke;
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

    public String getTxt_custom3() {
        return txt_custom3;
    }

    public void setTxt_custom3(String txt_custom3) {
        this.txt_custom3 = txt_custom3;
    }
}
