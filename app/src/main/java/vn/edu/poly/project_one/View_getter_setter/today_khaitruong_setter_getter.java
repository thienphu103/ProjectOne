package vn.edu.poly.project_one.View_getter_setter;

import java.io.Serializable;

/**
 * Created by ASUS on 11/23/2017.
 */

public class today_khaitruong_setter_getter implements Serializable {
    public int img_logo;
    public String custom1;
    public String custom2;
    public String custom3;

    public today_khaitruong_setter_getter(int img_logo, String custom1, String custom2, String custom3) {
        this.img_logo = img_logo;
        this.custom1 = custom1;
        this.custom2 = custom2;
        this.custom3 = custom3;
    }

    public today_khaitruong_setter_getter() {
    }

    public int getImg_logo() {
        return img_logo;
    }

    public void setImg_logo(int img_logo) {
        this.img_logo = img_logo;
    }

    public String getCustom1() {
        return custom1;
    }

    public void setCustom1(String custom1) {
        this.custom1 = custom1;
    }

    public String getCustom2() {
        return custom2;
    }

    public void setCustom2(String custom2) {
        this.custom2 = custom2;
    }

    public String getCustom3() {
        return custom3;
    }

    public void setCustom3(String custom3) {
        this.custom3 = custom3;
    }
}
