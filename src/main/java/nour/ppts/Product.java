//parent class for medicine and otherProducts objects

package nour.ppts;

import java.awt.Image;
import java.sql.*;

public abstract class Product {

    private int id, stock, serialNumber;
    private double price;
    private Image image;
    private String imageLocation;
    private String name;

    public int getId() {
        return id;
    }

    public int getStock() {
        return stock;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public Image getImage() {
        return image;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public String getName() {
        return name;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductImage(Image productImage) {
        this.image = productImage;
    }

    public abstract void setData(ResultSet rs, int index);

    public abstract String[] getDataArray();
}
