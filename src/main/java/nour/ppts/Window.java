
//connection and parent class for all windows

package nour.ppts;

import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;

public abstract class Window extends javax.swing.JFrame {

    protected static Connection connection;
    protected static String username = "root";
    protected static String password = "1234";
    protected static String url = "jdbc:mysql://localhost:3306/ppts";

    static {
        System.out.println("Loading block called...");
        updateLists();
    }

    protected static void updateLists() {
        System.out.println("Updating lists now...");
        try {
            Medicine.allMedicines = new ArrayList<>();
            connection = DriverManager.getConnection(url, username, password);
            Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet medicineResult = st.executeQuery("SELECT * FROM medicine;");
            medicineResult.last();
            int medicineSize = medicineResult.getRow();
            medicineResult.first();
            System.out.println("Entering massive population loops...");
            for (int i = 0; i < medicineSize; i++) {
                Medicine m = new Medicine(medicineResult, i + 1);
                Medicine.allMedicines.add(m);
            }
            st.close();
            medicineResult.close();
            System.out.println("Populated arrays successfully(will close result set now)...");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setTheme(String themeName) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if (themeName.equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProductsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
    }

    Window() {
        setTheme("Nimbus");
        this.setVisible(true);
        setLocation(500, 250);
        //add any other styling or common functionality for all windows here;
    }

}
