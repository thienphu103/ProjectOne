package vn.edu.poly.project_one.View_getter_setter;

import java.io.Serializable;

/**
 * Created by ASUS on 11/28/2017.
 */

public class taikhoan_danhsachyeuthich_getter_setter implements Serializable {
    public int images;

    public taikhoan_danhsachyeuthich_getter_setter(int images) {
        this.images = images;
    }

    public taikhoan_danhsachyeuthich_getter_setter() {
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}
