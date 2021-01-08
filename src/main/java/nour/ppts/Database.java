package nour.ppts;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public final class Database {

    private static String username;
    private static String password;
    private static String url;

    private static final String[] localServer = {"root", "1234", "jdbc:mysql://localhost:3306/ppts"};
    private static final String[] smarterASPServer = {"a6cc0b_ppts", "ppts1234", "jdbc:mysql://mysql5044.site4now.net/db_a6cc0b_ppts"};
    public static String[][] servers = {localServer, smarterASPServer};

    public static String dateFormat = "yyyy-MM-dd hh:mm a";

    public static void selectServer(String[] server) {
        username = server[0];
        password = server[1];
        url = server[2];
    }

    static ResultSet select(String query) throws SQLException {
        Connection conn = DriverManager.getConnection(url, username, password);
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
        Connection conn = DriverManager.getConnection(url, username, password);
        System.out.println("Connection established successfully...");
        return conn;
    }

    static void remove(String tableName, int id) throws SQLException {
        Connection conn = DriverManager.getConnection(url, username, password);
        PreparedStatement st;
        if (tableName == "receipts") {
            st = conn.prepareStatement("DELETE FROM " + tableName + " WHERE " + "receiptID = " + id + ";");
            Database.refreshReceiptsArrayList();
        } else {
            st = conn.prepareStatement("DELETE FROM " + tableName + " WHERE " + tableName + "ID = " + id + ";");
        }
        st.executeUpdate();
        st.close();
        Database.refreshMedicinesArrayList();
        Database.refreshOtherProductsArrayList();
    }

    static void insert(String query) throws SQLException {
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        st.executeUpdate(query);
        st.close();
        conn.close();
    }

    static void update(int id, String table, java.util.Map<String, String> data) throws SQLException {
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery("SELECT * FROM " + table + " WHERE " + table + "ID=" + id + ";");
        rs.first();

        for (int i = 0; i < data.size(); i++) {
            String key = data.keySet().toArray()[i].toString();
            String value = data.get(data.keySet().toArray()[i].toString());
            switch (key) {
                case "medicineName","medicineActiveSub", "medicineImageLocation", "medicineLocation"
                        ,"productName", "productDescription", "productImageLocation" -> {
                    rs.updateString(key, value);
                }
                case "medicinePrice", "medicineDose", "productPrice", "" -> {
                    rs.updateDouble(key, Double.parseDouble(value));
                }
                case "medicineStock", "medicineSerialNumber", "productStock", "productSerialNumber" -> {
                    rs.updateInt(key, Integer.parseInt(value));
                }
            }
        }
        rs.updateRow();
        conn.close();
        st.close();
        rs.close();
    }

    //refrshes the ArrayList from the database: 
    //clears the ArrayList then inserts into it all entries from its respective table from the database
    static void refreshMedicinesArrayList() throws SQLException {
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

    static void refreshReceiptsArrayList() throws SQLException {
        Receipt.allReceipts = new ArrayList<>();
        ResultSet rs = Database.select("SELECT * FROM receipts");
        int rsSize = Database.getResultSetSize(rs);
        for (int i = 0; i < rsSize; i++) {
            Receipt.allReceipts.add(new Receipt(rs, i + 1));
        }
        rs.close();
        System.out.println("Receipts ArrayList refrshed successfully...");
    }

    public static String getCurrentDateString() throws ParseException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
        String date = java.time.LocalDateTime.now().format(dateTimeFormatter);
        return date;
    }

    public static java.util.Date getCurrentDate() throws ParseException {
        SimpleDateFormat simpleDateFormatter = new SimpleDateFormat(dateFormat);
        java.util.Date date;
        String dateString = getCurrentDateString();
        date = simpleDateFormatter.parse(dateString);
        return date;
    }
}
