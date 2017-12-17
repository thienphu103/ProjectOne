package vn.edu.poly.project_one.ControlClass;

/**
 * Created by Hong Thai
 */
public class DetailsClass {

    private String name;
    private String id;
    private String price;
    private String image;
    private String number;

    public DetailsClass(String name, String price, String id, String image, String number) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.image = image;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
