//view/edit products database
package nour.ppts;

import java.util.ArrayList;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import javax.swing.table.DefaultTableModel;

public class ProductsWindow extends Window {

    public MainWindow parent;
    private static final String[] medicineColumns = {
        "ID", "Name", "Price (EGP)", "Stock", "Active Substance", "Dose (mg)", "Location", "Serial Number"
    };
    private static final String[] otherColumns = {
        "ID", "Name", "Price (EGP)", "Stock", "Serial Number", "Description"
    };

    ProductsWindow(MainWindow parent) {
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

        //disabling table fields editing
        jTableMedicine.setDefaultEditor(Object.class, null);
        jTableOther.setDefaultEditor(Object.class, null);

        //Loading values from Product ArrayLists into table models
        try {
            addToMedicineTable(Medicine.allMedicines);
            addToOtherTable(OtherProduct.allOtherProducts);
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), "Error!", ERROR);
        }

        jTextFieldSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextFieldSearchActionPerformed(null);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextFieldSearchActionPerformed(null);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        //MouseListerner for UpdateProductWindow
        addMouseDoubleClickListener();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jTabbedPane = new javax.swing.JTabbedPane();
        jScrollPaneMedicine = new javax.swing.JScrollPane();
        jTableMedicine = new javax.swing.JTable();
        jScrollPaneOther = new javax.swing.JScrollPane();
        jTableOther = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButtonRemoveProduct = new javax.swing.JButton();
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonAddProduct = new javax.swing.JButton();
        jButtonPrint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jTableMedicine.setAutoCreateRowSorter(true);
        jTableMedicine.setModel(medicineTableModel);
        jTableMedicine.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPaneMedicine.setViewportView(jTableMedicine);

        jTabbedPane.addTab("Medicine", jScrollPaneMedicine);

        jTableOther.setAutoCreateRowSorter(true);
        jTableOther.setModel(otherTableModel);
        jScrollPaneOther.setViewportView(jTableOther);

        jTabbedPane.addTab("Other Products", jScrollPaneOther);

        jButtonRemoveProduct.setText("Remove Product");
        jButtonRemoveProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveProductActionPerformed(evt);
            }
        });

        jTextFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchActionPerformed(evt);
            }
        });

        jButtonAddProduct.setText("Add Product");
        jButtonAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddProductActionPerformed(evt);
            }
        });

        jButtonPrint.setText("Print");
        jButtonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRemoveProduct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonAddProduct, jButtonPrint, jButtonRemoveProduct});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButtonRemoveProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAddProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldSearch)
                    .addComponent(jButtonPrint))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonAddProduct, jButtonPrint, jButtonRemoveProduct, jTextFieldSearch});

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addMouseDoubleClickListener() {
        ProductsWindow thisWindow = this;
        jTableMedicine.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                javax.swing.JTable table = (javax.swing.JTable) mouseEvent.getSource();
                java.awt.Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    for (Medicine medicine : Medicine.allMedicines) {
                        if (medicine.getId() == Integer.parseInt(jTableMedicine.getModel().getValueAt(jTableMedicine.getSelectedRow(), 0).toString())) {
                            UpdateMedicineWindow w = new UpdateMedicineWindow(thisWindow, medicine);
                            break;
                        }
                    }
                }
            }
        });
        jTableOther.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                javax.swing.JTable table = (javax.swing.JTable) mouseEvent.getSource();
                java.awt.Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    for (OtherProduct product : OtherProduct.allOtherProducts) {
                        if (product.getId() == Integer.parseInt(jTableOther.getModel().getValueAt(jTableOther.getSelectedRow(), 0).toString())) {
                            UpdateOtherProductWindow w = new UpdateOtherProductWindow(thisWindow, product);
                            break;
                        }
                    }
                }
            }
        });
    }

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
                    removeMedicine(id);
                }
                refreshMedicineTable();
            } else {
                int[] indexes = jTableOther.getSelectedRows();
                for (int index : indexes) {
                    int id = Integer.parseInt(otherTableModel.getValueAt(index, 0).toString());
                    removeOther(id);
                }
                refreshOtherTable();
            }

        } catch (SQLException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Failed to remove:" + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jButtonRemoveProductActionPerformed

    private void jButtonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintActionPerformed
        // TODO add your handling code here:
        PrintProductsListWindow w = new PrintProductsListWindow(this);
    }//GEN-LAST:event_jButtonPrintActionPerformed

    private void jTextFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchActionPerformed
        // TODO add your handling code here:
        String search = jTextFieldSearch.getText();
        if (jTabbedPane.getSelectedIndex() == 0) {
            if (!jTextFieldSearch.getText().isEmpty()) {
                DefaultTableModel newModel = initTableModel(medicineColumns);
                for (var v : medicineTableModel.getDataVector()) {
                    if (v.get(0).equals(search) || v.get(v.size() - 1).toString().contains(search) || v.get(1).toString().contains(search)) {
                        newModel.addRow(v);
                    }
                }
                jTableMedicine.setModel(newModel);
            } else {
                jTableMedicine.setModel(medicineTableModel);
            }
        }
        else {
            if (!jTextFieldSearch.getText().isEmpty()) {
                DefaultTableModel newModel = initTableModel(otherColumns);
                for (var v : otherTableModel.getDataVector()) {
                    if (v.get(0).equals(search) || v.get(v.size() - 2).toString().contains(search) || v.get(1).toString().contains(search)) {
                        newModel.addRow(v);
                    }
                }
                jTableOther.setModel(newModel);
            } else {
                jTableOther.setModel(otherTableModel);
            }
        }

    }//GEN-LAST:event_jTextFieldSearchActionPerformed

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
    public void removeMedicine(int id) throws SQLException {
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
    public void removeOther(int id) throws Exception {
        Database.remove("product", id);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddProduct;
    private javax.swing.JButton jButtonPrint;
    private javax.swing.JButton jButtonRemoveProduct;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JScrollPane jScrollPaneMedicine;
    private javax.swing.JScrollPane jScrollPaneOther;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTableMedicine;
    private javax.swing.JTable jTableOther;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel medicineTableModel;
    private DefaultTableModel otherTableModel;
}
