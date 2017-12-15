package vn.edu.poly.project_one.View_getter_setter;

import java.io.Serializable;

/**
 * Created by ASUS on 11/23/2017.
 */

public class visit_hangmoi_getter_setter_kieudanhsach implements Serializable {
    public String img;
    public String title;
    public String price;
    public String id;

    public visit_hangmoi_getter_setter_kieudanhsach(String img, String title, String price,String id) {
        this.img = img;
        this.title = title;
        this.price = price;
        this.id=id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
