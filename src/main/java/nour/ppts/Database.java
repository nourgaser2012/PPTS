package nour.ppts;

import java.sql.*;
import java.util.ArrayList;

public final class Database {

    //free online server on SmarterASP.net
//    private static final String USERNAME = "a6cc0b_ppts";
//    private static final String PASSWORD = "ppts1234";
//    private static final String URL = "jdbc:mysql://mysql5044.site4now.net/db_a6cc0b_ppts";
    //for local server only
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";
    private static final String URL = "jdbc:mysql://localhost:3306/ppts";

    static ResultSet select(String query) throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery(query);
        rs.first();
        return rs;
    }

    static int getResultSetSize(ResultSet rs) throws SQLException {
        rs.last();
        int size = rs.getRow();
        rs.first();
        return size;
    }

    static Connection openConnection() throws SQLException {
        System.out.println("Attmpting to start connection...");
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Connection established successfully...");
        return conn;
    }

    static void remove(String tableName, int id) throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        PreparedStatement st = conn.prepareStatement("DELETE FROM " + tableName + " WHERE " + tableName + "ID = " + id + ";");
        st.executeUpdate();
        st.close();
        Database.dbToArrayLists();
    }

    static void insert(String query) throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        st.executeUpdate(query);
        st.close();
        conn.close();
    }

    //overwrites the medicine and otherProducts arrayLists with all enteries from their respective tables from the database;
    static void dbToArrayLists() {
        System.out.println("Populating arrays now...");
        try {
            //clearing the arrays
            Medicine.allMedicines = new ArrayList<>();
            OtherProduct.allOtherProducts = new ArrayList<>();

            //ResultSets with all enteries from the database
            ResultSet medicineResult = Database.select("SELECT * FROM medicine;");
            ResultSet otherResult = Database.select("SELECT * FROM product;");

            int medicineSize = Database.getResultSetSize(medicineResult);
            int otherSize = Database.getResultSetSize(otherResult);

            for (int i = 0; i < medicineSize; i++) {
                Medicine.allMedicines.add(new Medicine(medicineResult, i + 1));
            }
            for (int i = 0; i < otherSize; i++) {
                OtherProduct.allOtherProducts.add(new OtherProduct(otherResult, i + 1));
            }

            medicineResult.close();
            otherResult.close();
            System.out.println("Populated arrays successfully...");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
