//medicine objects

package nour.ppts;

import java.util.ArrayList;
import java.sql.*;

public class Medicine extends Product {

    private String location, activeSub;
    private double dose;

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

    public static int numberOfAttributes = 9;
    public static ArrayList<Medicine> allMedicines = new ArrayList<>();

    public void setData(ResultSet st, int index) {
        try {
            st.absolute(index);
            setId(st.getInt("medicineID"));
            setName(st.getString("medicineName"));
            setPrice(st.getDouble("medicinePrice"));
            setStock(st.getInt("medicineStock"));
            setSerialNumber(st.getInt("medicineSerialNumber"));
            setLocation(st.getString("medicineLocation"));
            setImageLocation(st.getString("medicineImageLocation"));
            setDose(st.getDouble("medicineDose"));
            setActiveSub(st.getString("medicineActiveSub"));
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

    Medicine(ResultSet st, int index) {
        setData(st, index);
    }

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
