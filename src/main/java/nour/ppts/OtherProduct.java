//class for non-medicine products;
package nour.ppts;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OtherProduct extends Product {

    private String description;

    public static int numberOfAttributes = 7;
    public static ArrayList<OtherProduct> allOtherProducts = new ArrayList<>();
    public static String[] attributeNames = {"productID", "productName", "productDescription", "productPrice",
        "productStock", "productImageLocation", "productSerialNumber"};

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static int getNumberOfAttributes() {
        return numberOfAttributes;
    }

    public static void setNumberOfAttributes(int numberOfAttributes) {
        OtherProduct.numberOfAttributes = numberOfAttributes;
    }

    public static ArrayList<OtherProduct> getAllOtherProducts() {
        return allOtherProducts;
    }

    public static void setAllOtherProducts(ArrayList<OtherProduct> allOtherProducts) {
        OtherProduct.allOtherProducts = allOtherProducts;
    }

    @Override
    public void setData(ResultSet st, int index) {
        try {
            st.absolute(index);
            setId(st.getInt("productID"));
            setName(st.getString("productName"));
            setPrice(st.getDouble("productPrice"));
            setStock(st.getInt("productStock"));
            setSerialNumber(st.getInt("productSerialNumber"));
            setImageLocation(st.getString("productImageLocation"));
            setDescription(st.getString("productDescription"));
        } catch (SQLException ex) {
            System.out.println("Error!\t" + ex.getMessage());
        }
    }

    @Override
    public String[] getDataArray() {
        String[] arr = new String[numberOfAttributes];
        arr[0] = Integer.toString(getId());
        arr[1] = getName();
        arr[3] = Double.toString(getPrice());
        arr[4] = Integer.toString(getStock());
        arr[6] = Integer.toString(getSerialNumber());
        arr[2] = getDescription();
        arr[5] = getImageLocation();
        return arr;
    }

    OtherProduct(ResultSet rs, int index) {
        setData(rs, index);
    }

}
