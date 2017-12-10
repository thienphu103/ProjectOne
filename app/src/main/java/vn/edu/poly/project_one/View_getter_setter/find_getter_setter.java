package vn.edu.poly.project_one.View_getter_setter;

import java.io.Serializable;

/**
 * Created by ASUS on 11/18/2017.
 */

public class find_getter_setter implements Serializable {
    String lst_xuhuong;
    String image;
    String price;
    String soluong;
    String id;

    public find_getter_setter(String lst_xuhuong, String image, String price, String id) {
        this.lst_xuhuong = lst_xuhuong;
        this.image = image;
        this.price = price;
        this.id = id;

    }

    public find_getter_setter() {
    }

    public String getLst_xuhuong() {
        return lst_xuhuong;
    }

    public void setLst_xuhuong(String lst_xuhuong) {
        this.lst_xuhuong = lst_xuhuong;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}