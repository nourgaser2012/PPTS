//connection and parent class for all windows
package nour.ppts;

import java.sql.*;
import java.util.ArrayList;

public abstract class Window extends javax.swing.JFrame implements Database {

    public static Connection connection;

    static {
        System.out.println("class Window loading block called...");
        dbToArrayLists();
    }

    //overwrites the medicine and otherProducts arrayLists with all enteries from their respective tables from the database;
    protected static void dbToArrayLists() {
        System.out.println("Populating arrays now...");
        try {
            //clearing the arrays
            Medicine.allMedicines = new ArrayList<>(); 
            OtherProduct.allOtherProducts = new ArrayList<>();
            
            //ResultSets with all enteries from the database
            ResultSet medicineResult = Database.readAll("medicine");
            ResultSet otherResult = Database.readAll("otherProducts");
            
            int medicineSize = Database.getResultSetSize(medicineResult);
            int otherSize = Database.getResultSetSize(otherResult);
            
            System.out.println("Entering array population loops...");
            for (int i = 0; i < medicineSize; i++) {
                Medicine.allMedicines.add(new Medicine(medicineResult, i + 1));
            }
            for (int i = 0; i < otherSize; i++) {
                OtherProduct.allOtherProducts.add(new OtherProduct(otherResult, i + 1));
            }
            
            medicineResult.close();
            otherResult.close();
            System.out.println("Populated arrays successfully(and closed connection)...");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public final void setTheme(String themeName) {
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
