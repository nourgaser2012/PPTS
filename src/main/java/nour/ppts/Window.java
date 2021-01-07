package nour.ppts;

import javax.swing.Icon;

public abstract class Window extends javax.swing.JFrame {

//    static {
//        System.out.println("class Window loading block called...");
//        try {
//        Database.refreshMedicinesArrayList();
//        Database.refreshOtherProductsArrayList();
//        }
//        catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }

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
        System.out.println("Creating new window...");
        setTheme("Nimbus");
        setSize(750, 450);
//        setResizable(false);
//        java.awt.Dimension d = new java.awt.Dimension(600, 350);
//        setMinimumSize(d);
        setPreferredSize(getSize());
        setLocationRelativeTo(null);
        setTitle("PPTS");
        this.setVisible(true);
        //add any other styling or common functionality for all windows here;
    }

}
