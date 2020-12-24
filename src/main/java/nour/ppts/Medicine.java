//medicine objects
package nour.ppts;

import java.util.ArrayList;
import java.sql.*;

public class Medicine extends Product {

    private String location, activeSub;
    private double dose;

    public static int numberOfAttributes = 9;
    public static ArrayList<Medicine> allMedicines = new ArrayList<>();
    public static String[] attributeNames = {"medicineID", "medicineName", "medicineActiveSub", "medicinePrice",
        "medicineStock", "medicineImageLocation", "medicineDose", "medicineSerialNumber", "medicineLocation"};

    public void setLocation(String location) {
        this.location = location;
    }

    public void setActiveSub(String activeSub) {
        this.activeSub = activeSub;
    }

    public void setDose(double dose) {
        this.dose = dose;
    }

    public static void setNumberOfAttributes(int numberOfAttributes) {
        Medicine.numberOfAttributes = numberOfAttributes;
    }

    public static void setAllMedicines(ArrayList<Medicine> allMedicines) {
        Medicine.allMedicines = allMedicines;
    }

    @Override
    public void setData(ResultSet rs, int index) {
        try {
            rs.absolute(index);
            setId(rs.getInt("medicineID"));
            setName(rs.getString("medicineName"));
            setPrice(rs.getDouble("medicinePrice"));
            setStock(rs.getInt("medicineStock"));
            setSerialNumber(rs.getInt("medicineSerialNumber"));
            setLocation(rs.getString("medicineLocation"));
            setImageLocation(rs.getString("medicineImageLocation"));
            setDose(rs.getDouble("medicineDose"));
            setActiveSub(rs.getString("medicineActiveSub"));
        } catch (SQLException ex) {
            System.out.println("Error!\t" + ex.getMessage());
        }
    }

    public String getLocation() {
        return location;
    }

    public String getActiveSub() {
        return activeSub;
    }

    public double getDose() {
        return dose;
    }

    public static int getNumberOfAttributes() {
        return numberOfAttributes;
    }

    public static ArrayList<Medicine> getAllMedicines() {
        return allMedicines;
    }

    Medicine(ResultSet rs, int index) {
        setData(rs, index);
    }

    @Override
    public String[] getDataArray() {
        String[] arr = new String[numberOfAttributes];
        arr[0] = Integer.toString(getId());
        arr[1] = getName();
        arr[2] = getActiveSub();
        arr[3] = Double.toString(getPrice());
        arr[4] = Integer.toString(getStock());
        arr[5] = getImageLocation();
        arr[6] = Double.toString(getDose());
        arr[7] = Integer.toString(getSerialNumber());
        arr[8] = getLocation();
        return arr;
    }

}
