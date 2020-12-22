//jFrame window to view/edit products database
package nour.ppts;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ProductsWindow extends Window {

    public ProductsWindow() {
        medicineTableModel = new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "Name", "Price (EGP)", "Stock", "Active Substance", "Dose (mg)", "Location", "Serial Number"
                }
        );
        otherTableModel = new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "Name", "Price (EGP)", "Stock", "Serial Number", "Description"
                }
        );
        initComponents();
        jTableMedicine.setDefaultEditor(Object.class, null); //disabling table fields editing
        jTableOther.setDefaultEditor(Object.class, null);

        updateMedicineTable(medicineTableModel, Medicine.allMedicines);
        updateOtherTable(otherTableModel, OtherProduct.allOtherProducts);

        this.setLocation(500, 250);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonRemoveProduct = new javax.swing.JButton();
        jButtonAddProduct = new javax.swing.JButton();
        jTabbedPane = new javax.swing.JTabbedPane();
        jScrollPaneMedicine = new javax.swing.JScrollPane();
        jTableMedicine = new javax.swing.JTable();
        jScrollPaneOther = new javax.swing.JScrollPane();
        jTableOther = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jButtonRemoveProduct.setText("Remove Product");
        jButtonRemoveProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveProductActionPerformed(evt);
            }
        });

        jButtonAddProduct.setText("Add Product");
        jButtonAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddProductActionPerformed(evt);
            }
        });

        jTableMedicine.setModel(medicineTableModel);
        jScrollPaneMedicine.setViewportView(jTableMedicine);

        jTabbedPane.addTab("Medicine", jScrollPaneMedicine);

        jTableOther.setModel(otherTableModel);
        jScrollPaneOther.setViewportView(jTableOther);

        jTabbedPane.addTab("Other Products", jScrollPaneOther);

        jTextField1.setText("Search");
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonRemoveProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButtonRemoveProduct)
                    .addComponent(jButtonAddProduct)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    }//GEN-LAST:event_jButtonAddProductActionPerformed

    private void jButtonRemoveProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveProductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRemoveProductActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1MouseClicked
    private void updateMedicineTable(DefaultTableModel model, ArrayList<Medicine> arr) {
        for (int i = 0; i < arr.size(); i++) {
            String[] current = arr.get(i).getDataArray();
            String[] temp = {current[0], current[1], current[3], current[4], current[2], current[6], current[8], current[7]};
            model.addRow(temp);
        }
    }

    private void updateOtherTable(DefaultTableModel model, ArrayList<OtherProduct> arr) {
        for (int i = 0; i < arr.size(); i++) {
            String[] current = arr.get(i).getDataArray();
            String[] temp = {current[0], current[1], current[3], current[4], current[6], current[2]};
            model.addRow(temp);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddProduct;
    private javax.swing.JButton jButtonRemoveProduct;
    private javax.swing.JPanel jPanel1;
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
