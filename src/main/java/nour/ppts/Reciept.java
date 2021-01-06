//receipt objects
//OMAR'S TASK

//this should contain all the setters and the getters for the reciept data
//it should also contain the attributes of the reciept
//should be similar to the Medicine and the OtherProduct classes (check them)

package nour.ppts;

import java.util.ArrayList;
import java.util.Date;

public class Reciept {
    private int id, numberOfItems;
    private java.util.Date issueDate;
    private ArrayList<Medicine> medicines = new ArrayList<>();
    private ArrayList<OtherProduct> otherProducts = new ArrayList<>();
    private java.util.Date date;
    private String customerName, dbItemsString;
    private float total;

    public static ArrayList<Reciept> allReciepts = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDbItemsString() {
        return dbItemsString;
    }

    public void setDbItemsString(String dbItemsString) {
        this.dbItemsString = dbItemsString;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    
    
}
//OMAR'S TASK