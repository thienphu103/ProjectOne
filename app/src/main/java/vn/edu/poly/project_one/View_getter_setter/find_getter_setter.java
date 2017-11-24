package vn.edu.poly.project_one.View_getter_setter;

import java.io.Serializable;

/**
 * Created by ASUS on 11/18/2017.
 */

public class find_getter_setter implements Serializable {
    String lst_xuhuong;

    public find_getter_setter() {
    }

    public find_getter_setter(String lst_xuhuong) {
        this.lst_xuhuong = lst_xuhuong;
    }

    public String getLst_xuhuong() {
        return lst_xuhuong;
    }

    public void setLst_xuhuong(String lst_xuhuong) {
        this.lst_xuhuong = lst_xuhuong;
    }
}
