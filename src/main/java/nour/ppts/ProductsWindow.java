//jFrame window to view/edit products database

package nour.ppts;

import javax.swing.table.DefaultTableModel;

public class ProductsWindow extends Window {

    public ProductsWindow() {
        medicineTableModel = new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "Name", "Active Substance", "Price (EGP)", "Stock", "Dose (mg)", "Serial Number", "Location"
                }
        );
        otherTableModel = new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "Name", "Price", "Stock", "Serial Number", "Description"
                }
        );
        initComponents();
        jTableMedicine.setDefaultEditor(Object.class, null);
        jTableOther.setDefaultEditor(Object.class, null);
        for (int i = 0; i < Medicine.allMedicines.size(); i++) {
            String[] current = Medicine.allMedicines.get(i).getDataArray();
            String[] temp = {current[0], current[1], current[2], current[3], current[4], current[6], current[7], current[8]};
            medicineTableModel.addRow(temp);
        }
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
                    .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButtonRemoveProduct)
                    .addComponent(jButtonAddProduct))
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddProduct;
    private javax.swing.JButton jButtonRemoveProduct;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPaneMedicine;
    private javax.swing.JScrollPane jScrollPaneOther;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTableMedicine;
    private javax.swing.JTable jTableOther;
    // End of variables declaration//GEN-END:variables
    static private DefaultTableModel medicineTableModel;
    private DefaultTableModel otherTableModel;
}
