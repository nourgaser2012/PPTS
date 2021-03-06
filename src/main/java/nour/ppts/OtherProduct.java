//class for non-medicine products;
//same concept as Medicine class, for explanations check Medicine class.
package nour.ppts;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class OtherProduct extends Product {

    private String description;

    public static int numberOfAttributes = 7;
    public static ArrayList<OtherProduct> allOtherProducts = new ArrayList<>();
    public static String[] attributeNames = {"productID", "productName", "productDescription", "productPrice",
        "productStock", "productImageLocation", "productSerialNumber"};

    OtherProduct(ResultSet rs, int index) {
        setData(rs, index);
        initializeIfNotInitialized();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
            if (getImageLocation() != null) {
                setImage(new ImageIcon(getImageLocation()));
            }

        } catch (SQLException ex) {
            System.out.println("Error!\t" + ex.getMessage());
        }
    }

    @Override
    protected void initializeIfNotInitialized() {
        if (getDescription() == null) {
            setDescription("Undefined");
        }
        if (getImageLocation() == null) {
            setImageLocation("./Icons/darkBlueQuestionMark.png");
            setImage(new ImageIcon(this.getImageLocation()));
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

}
