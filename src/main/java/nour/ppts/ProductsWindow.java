//jFrame window to view/edit products database
package nour.ppts;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.awt.event.*;
import java.sql.SQLException;

public class ProductsWindow extends Window {

    public MainWindow parent;
    private static String[] medicineColumns = {
        "ID", "Name", "Price (EGP)", "Stock", "Active Substance", "Dose (mg)", "Location", "Serial Number"
    };
    private static String[] otherColumns = {
        "ID", "Name", "Price (EGP)", "Stock", "Serial Number", "Description"
    };

    public ProductsWindow(MainWindow parent) {
        this.parent = parent;

        //hiding parent until productsWindow is closed
        parent.setVisible(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent windowEvent) {
                parent.setVisible(true);
            }
        });

        medicineTableModel = initTableModel(medicineColumns);
        otherTableModel = initTableModel(otherColumns);
        initComponents();

        jTableMedicine.setDefaultEditor(Object.class, null); //disabling table fields editing
        jTableOther.setDefaultEditor(Object.class, null);

        try {
            addToMedicineTable(Medicine.allMedicines);
            addToOtherTable(OtherProduct.allOtherProducts);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        this.setLocation(500, 250);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane = new javax.swing.JTabbedPane();
        jScrollPaneMedicine = new javax.swing.JScrollPane();
        jTableMedicine = new javax.swing.JTable();
        jScrollPaneOther = new javax.swing.JScrollPane();
        jTableOther = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButtonRemoveProduct = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButtonAddProduct = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jTableMedicine.setModel(medicineTableModel);
        jScrollPaneMedicine.setViewportView(jTableMedicine);

        jTabbedPane.addTab("Medicine", jScrollPaneMedicine);

        jTableOther.setModel(otherTableModel);
        jScrollPaneOther.setViewportView(jTableOther);

        jTabbedPane.addTab("Other Products", jScrollPaneOther);

        jButtonRemoveProduct.setText("Remove Product");
        jButtonRemoveProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveProductActionPerformed(evt);
            }
        });

        jTextField1.setText("Search");
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });

        jButtonAddProduct.setText("Add Product");
        jButtonAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddProductActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
                        .addComponent(jButtonRemoveProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonAddProduct, jButtonRemoveProduct, jTextField1});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButtonRemoveProduct)
                    .addComponent(jButtonAddProduct)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonAddProduct, jButtonRemoveProduct, jTextField1});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel2, jTabbedPane});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddProductActionPerformed
        // TODO add your handling code here:
        AddProductWindow w = new AddProductWindow(this);
    }//GEN-LAST:event_jButtonAddProductActionPerformed

    private void jButtonRemoveProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveProductActionPerformed
        // TODO add your handling code here:
        try {
            if (jTabbedPane.getSelectedIndex() == 0) {
                int[] indexes = jTableMedicine.getSelectedRows();
                for (int index : indexes) {
                    int id = Integer.parseInt(medicineTableModel.getValueAt(index, 0).toString());
                    removeFromMedicineTable(id);
                }
                refreshMedicineTable();
            } else {
                int[] indexes = jTableOther.getSelectedRows();
                for (int index : indexes) {
                    int id = Integer.parseInt(otherTableModel.getValueAt(index, 0).toString());
                    removeFromOtherTable(id);
                }
                refreshOtherTable();
            }

        } catch (SQLException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Failed to remove:" + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jButtonRemoveProductActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1MouseClicked

    private DefaultTableModel initTableModel(String[] columns) {
        DefaultTableModel model = new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                columns
        );
        return model;
    }

    public void refreshMedicineTable() throws SQLException {
        medicineTableModel = initTableModel(medicineColumns);
        addToMedicineTable(Medicine.allMedicines);
        jTableMedicine.setModel(medicineTableModel);
    }

    public void refreshOtherTable() throws SQLException {
        otherTableModel = initTableModel(otherColumns);
        addToOtherTable(OtherProduct.allOtherProducts);
        jTableOther.setModel(otherTableModel);
    }

    //add an ArrayList of Medicine
    private void addToMedicineTable(ArrayList<Medicine> medicines) {
        for (int i = 0; i < medicines.size(); i++) {
            String[] current = medicines.get(i).getDataArray();
            String[] temp = {current[0], current[1], current[3], current[4], current[2], current[6], current[8], current[7]};
            medicineTableModel.addRow(temp);
        }
    }

    //add one Medicine
    public void addToMedicineTable(Medicine medicine) {
        String[] current = medicine.getDataArray();
        String[] temp = {current[0], current[1], current[3], current[4], current[2], current[6], current[8], current[7]};
        medicineTableModel.addColumn(temp);
    }

    //remove one Medicine
    public void removeFromMedicineTable(int id) throws SQLException {
        Database.remove("medicine", id);
    }

    //add an ArrayList of OtherProduct
    private void addToOtherTable(ArrayList<OtherProduct> products) throws SQLException {
        for (int i = 0; i < products.size(); i++) {
            String[] current = products.get(i).getDataArray();
            String[] temp = {current[0], current[1], current[3], current[4], current[6], current[2]};
            otherTableModel.addRow(temp);
        }
    }

    //add one OtherProduct
    public void addToOtherTable(OtherProduct product) {
        String[] current = product.getDataArray();
        String[] temp = {current[0], current[1], current[3], current[4], current[6], current[2]};
        otherTableModel.addRow(temp);
    }

    //remove one OtherProduct
    public void removeFromOtherTable(int id) throws Exception {
        Database.remove("product", id);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddProduct;
    private javax.swing.JButton jButtonRemoveProduct;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPaneMedicine;
    private javax.swing.JScrollPane jScrollPaneOther;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTableMedicine;
    private javax.swing.JTable jTableOther;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    static private DefaultTableModel medicineTableModel;
    private DefaultTableModel otherTableModel;
}
