//parent parent class for medicine and otherProducts objects
//contains all common attributes between Medicine and OtherProduct

package nour.ppts;

import java.awt.Image;
import java.sql.*;

public abstract class Product {

    private int id, stock, serialNumber;
    private double price;
    private Image image;
    private String imageLocation;        //used to store the image's location on the server
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

    public abstract void setData(ResultSet rs, int index); //DATABASE RELATED! Set the product's all data using a 
    //ResultSet from the Database and the index (the number of the row which represents the product
    
    protected abstract void initializeIfNotInitialized();
   
    public abstract String[] getDataArray(); //get all the data of the product in same order as server columns as string
}
