package nour.ppts;

import java.sql.*;

public interface Database {

    String username = "root";
    String password = "1234";
    String url = "jdbc:mysql://localhost:3306/ppts";

    static ResultSet readAll(String table) throws SQLException {
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery("SELECT * FROM " + table + ";");
        rs.first();
        return rs;
    }
    
//    ResultSet read(String selectQuery) throws SQLException;
//
//    void write(String query) throws SQLException;

    static int getResultSetSize(ResultSet rs) throws SQLException {
        rs.last();
        int size = rs.getRow();
        rs.first();
        return size;
    }

    static void openConnection(Connection conn) throws SQLException {
        System.out.println("Attmpting to start connection...");
        conn = DriverManager.getConnection(url, username, password);
        System.out.println("Connection established successfully...");
    }

    static void closeConnection(Connection conn) throws SQLException {
        conn.close();
        System.out.print("Connection closed...");
    }
}
