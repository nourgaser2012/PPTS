package nour.ppts;

import java.sql.*;

public interface Database {

    String username = "root";
    String password = "1234";
    String url = "jdbc:mysql://localhost:3306/ppts";

    static ResultSet readAll(String tableName) throws SQLException {
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery("SELECT * FROM " + tableName + ";");
        rs.first();
        return rs;
    }
   
    static int getResultSetSize(ResultSet rs) throws SQLException {
        rs.last();
        int size = rs.getRow();
        rs.first();
        return size;
    }

    static Connection openConnection(Connection conn) throws SQLException {
        System.out.println("Attmpting to start connection...");
        conn = DriverManager.getConnection(url, username, password);
        System.out.println("Connection established successfully...");
        return conn;
    }

    static void closeConnection(Connection conn) throws SQLException {
        conn.close();
        System.out.print("Connection closed...");
    }
    
    ResultSet read(String selectQuery) throws SQLException;

    void write(String query, java.util.Map<String, String> values) throws SQLException;
}
