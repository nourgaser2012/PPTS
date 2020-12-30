package nour.ppts;

import java.sql.*;
import java.util.ArrayList;

public final class Database {

    //free online server on SmarterASP.net
//    private static final String USERNAME = "a6cc0b_ppts";
//    private static final String PASSWORD = "ppts1234";
//    private static final String URL = "jdbc:mysql://mysql5044.site4now.net/db_a6cc0b_ppts";
    
    //for local server only
    private static String username = "root";
    private static String password = "1234";
    private static final String URL = "jdbc:mysql://localhost:3306/ppts";

    static ResultSet select(String query) throws SQLException {
        Connection conn = DriverManager.getConnection(URL, username, password);
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
        Connection conn = DriverManager.getConnection(URL, username, password);
        System.out.println("Connection established successfully...");
        return conn;
    }

    static void remove(String tableName, int id) throws SQLException {
        Connection conn = DriverManager.getConnection(URL, username, password);
        PreparedStatement st = conn.prepareStatement("DELETE FROM " + tableName + " WHERE " + tableName + "ID = " + id + ";");
        st.executeUpdate();
        st.close();
        Database.refreshMedicinesArrayList();
        Database.refreshOtherProductsArrayList();
    }

    static void insert(String query) throws SQLException {
        Connection conn = DriverManager.getConnection(URL, username, password);
        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        st.executeUpdate(query);
        st.close();
        conn.close();
    }

    //refrshes the ArrayList from the database: 
    //clears the ArrayList then inserts into it all entries from its respective table from the database
    static void refreshMedicinesArrayList() throws SQLException {
        System.out.println("Populating arrays now...");
        //clearing the array
        Medicine.allMedicines = new ArrayList<>();

        //ResultSets with all enteries from the database
        ResultSet rs = Database.select("SELECT * FROM medicine;");

        int rsSize = Database.getResultSetSize(rs); //number of rows fetched

        for (int i = 0; i < rsSize; i++) {
            Medicine.allMedicines.add(new Medicine(rs, i + 1));
        }

        rs.close();
        System.out.println("Medicine ArrayList refrshed successfully...");
    }

    static void refreshOtherProductsArrayList() throws SQLException {
        OtherProduct.allOtherProducts = new ArrayList<>();
        ResultSet rs = Database.select("SELECT * FROM product;");
        int rsSize = Database.getResultSetSize(rs);
        for (int i = 0; i < rsSize; i++) {
            OtherProduct.allOtherProducts.add(new OtherProduct(rs, i + 1));
        }
        rs.close();
        System.out.println("OtherProducts ArrayList refrshed successfully...");

    }

//    static void refreshRecieptsArrayList() throws SQLException {
//        Reciepts.allReciepts = new ArrayList<>();
//        ResultSet rs = Database.select("SELECT * FROM reciept");
//        int rsSize = Database.getResultSetSize(rs);
//        for (int i = 0; i < rsSize; i++) {
//            Reciept.allReciepts.add(new Reciept(rs, i + 1));
//        }
//        rs.close();
//        System.out.println("Reciepts ArrayList refrshed successfully...");
//    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Database.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Database.password = password;
    }
    
}
