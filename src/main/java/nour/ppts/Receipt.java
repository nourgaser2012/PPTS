package nour.ppts;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Receipt {

    private int id, numberOfItems;
    private java.util.Date date;
    private ArrayList<Medicine> medicines = new ArrayList<>();
    private ArrayList<OtherProduct> otherProducts = new ArrayList<>();
    private String[] items; // {quantity1Xid1, quantity2Xid2, ...}
    private String customerName, dbItemsString;
    private double total;

    public static final int numberOfAttributes = 6;

    public static ArrayList<Receipt> allReceipts = new ArrayList<>();

    public Receipt(ResultSet rs, int index) {
        setData(rs, index);
        initializeIfNotInitialized();
    }

    private void setData(ResultSet rs, int index) {
        try {
            rs.absolute(index);
            setId(rs.getInt("receiptID"));
            SimpleDateFormat simpleDateFormatter = new SimpleDateFormat(Database.dateFormat);
            try {
                setDate(simpleDateFormatter.parse(rs.getString("receiptDate")));
            } catch (ParseException e) {
                System.out.println("Error!\t" + e.getMessage());
            }

            setCustomerName(rs.getString("receiptCustomerName"));
            setNumberOfItems(rs.getInt("receiptNumberOfItems"));
            setTotal(rs.getDouble("receiptTotal"));
            setDbItemsString(rs.getString("receiptItems"));

        } catch (SQLException e) {
            System.out.println("Error!\t" + e.getMessage());
        }
    }

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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String[] getDataArray() {
        SimpleDateFormat simpleDateFormatter = new SimpleDateFormat(Database.dateFormat);

        String[] arr = new String[numberOfAttributes];
        arr[0] = Integer.toString(getId());
        arr[1] = simpleDateFormatter.format(getDate());
        arr[2] = getCustomerName();
        arr[3] = Integer.toString(getNumberOfItems());
        arr[4] = Double.toString(getTotal());
        arr[5] = getDbItemsString();
        return arr;
    }

    private void initializeIfNotInitialized() {
        if (getDate() == null) {
            try {
                setDate(Database.getCurrentDate());
            } catch (ParseException ex) {
                System.out.println("Parse error!\t" + ex.getMessage());
            }
        }
    }

}
