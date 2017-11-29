package vn.edu.poly.project_one.View_getter_setter;

import java.io.Serializable;

/**
 * Created by ASUS on 11/21/2017.
 */

public class visit_hangbanchay_getter_setter implements Serializable {
    public String img;
    public String title;
    public String price;

    public visit_hangbanchay_getter_setter(String img, String title, String price) {
        this.img = img;
        this.title = title;
        this.price = price;
    }

    public visit_hangbanchay_getter_setter() {
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
