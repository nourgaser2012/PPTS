package nour.ppts;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import static nour.ppts.Database.dateFormat;

public class GenerateReceiptWindow extends Window {

    private ReceiptsWindow parent;
    private static final String windowIconLocation = "./Icons/paid_bill_64px.png";

    public GenerateReceiptWindow(ReceiptsWindow parent) {
        this.parent = parent;

        //freezing parent until productsWindow is closed
        parent.setFocusableWindowState(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent windowEvent) {
                parent.setFocusableWindowState(true);
                parent.toFront();
            }
        });

        tableModel = new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Type", "Name", "Quantity", "Total"}
        );

        initComponents();

        //setting date chooser date to system date
        try {
            jDateChooser.setDate(Database.getCurrentDate());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Current Date Error", JOptionPane.ERROR_MESSAGE);
        }
        
        jLabelTitle.setIcon(new ImageIcon(windowIconLocation));
        this.setSize(460, 480);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jPanelAddProduct = new javax.swing.JPanel();
        jButtonAdd = new javax.swing.JButton();
        jButtonRemove = new javax.swing.JButton();
        jScrollPaneTable = new javax.swing.JScrollPane();
        jTableProductsTable = new javax.swing.JTable();
        jPanelForm = new javax.swing.JPanel();
        jLabelID = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jLabelDate = new javax.swing.JLabel();
        jLabelCustomerName = new javax.swing.JLabel();
        jTextFieldCustomerName = new javax.swing.JTextField();
        jLabelNumberOfItems = new javax.swing.JLabel();
        jTextFieldNumberOfItems = new javax.swing.JTextField();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jPanelTitle = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jPanelTotal = new javax.swing.JPanel();
        jTextFieldTotal = new javax.swing.JTextField();
        jLabelTotal = new javax.swing.JLabel();
        jPanelCancel = new javax.swing.JPanel();
        jButtonCancel = new javax.swing.JButton();
        jButtonGenerate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonRemove.setText("Remove");
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveActionPerformed(evt);
            }
        });

        jTableProductsTable.setModel(tableModel);
        jScrollPaneTable.setViewportView(jTableProductsTable);

        javax.swing.GroupLayout jPanelAddProductLayout = new javax.swing.GroupLayout(jPanelAddProduct);
        jPanelAddProduct.setLayout(jPanelAddProductLayout);
        jPanelAddProductLayout.setHorizontalGroup(
            jPanelAddProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAddProductLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneTable, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addGroup(jPanelAddProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAdd, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonRemove, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jPanelAddProductLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonAdd, jButtonRemove});

        jPanelAddProductLayout.setVerticalGroup(
            jPanelAddProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAddProductLayout.createSequentialGroup()
                .addGroup(jPanelAddProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAddProductLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPaneTable, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAddProductLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jButtonAdd)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonRemove)))
                .addContainerGap())
        );

        jPanelAddProductLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonAdd, jButtonRemove});

        jLabelID.setText("Receipt ID");

        jLabelDate.setText("Date");

        jLabelCustomerName.setText("Customer Name");

        jLabelNumberOfItems.setText("Number of Items");

        jTextFieldNumberOfItems.setEditable(false);
        jTextFieldNumberOfItems.setText("0");

        jDateChooser.setDateFormatString(Database.dateFormat);
        jDateChooser.setMaxSelectableDate(java.sql.Date.valueOf(java.time.LocalDate.now()));

        javax.swing.GroupLayout jPanelFormLayout = new javax.swing.GroupLayout(jPanelForm);
        jPanelForm.setLayout(jPanelFormLayout);
        jPanelFormLayout.setHorizontalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormLayout.createSequentialGroup()
                        .addComponent(jLabelNumberOfItems, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldNumberOfItems, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormLayout.createSequentialGroup()
                        .addComponent(jLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldID, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormLayout.createSequentialGroup()
                        .addComponent(jLabelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addComponent(jLabelCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldCustomerName)))
                .addContainerGap())
        );

        jPanelFormLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabelCustomerName, jLabelDate, jLabelID, jLabelNumberOfItems});

        jPanelFormLayout.setVerticalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelID)
                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelDate)
                    .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCustomerName)
                    .addComponent(jTextFieldCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumberOfItems)
                    .addComponent(jTextFieldNumberOfItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelFormLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabelCustomerName, jLabelDate, jLabelID, jLabelNumberOfItems, jTextFieldCustomerName, jTextFieldID, jTextFieldNumberOfItems});

        jLabelTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("Generate New Reciept");

        javax.swing.GroupLayout jPanelTitleLayout = new javax.swing.GroupLayout(jPanelTitle);
        jPanelTitle.setLayout(jPanelTitleLayout);
        jPanelTitleLayout.setHorizontalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelTitleLayout.setVerticalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jTextFieldTotal.setEditable(false);
        jTextFieldTotal.setText("0.00");

        jLabelTotal.setText("Total");

        javax.swing.GroupLayout jPanelTotalLayout = new javax.swing.GroupLayout(jPanelTotal);
        jPanelTotal.setLayout(jPanelTotalLayout);
        jPanelTotalLayout.setHorizontalGroup(
            jPanelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTotalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldTotal)
                .addContainerGap())
        );
        jPanelTotalLayout.setVerticalGroup(
            jPanelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTotalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTotal)
                    .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jButtonGenerate.setText("Generate");
        jButtonGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCancelLayout = new javax.swing.GroupLayout(jPanelCancel);
        jPanelCancel.setLayout(jPanelCancelLayout);
        jPanelCancelLayout.setHorizontalGroup(
            jPanelCancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCancelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonGenerate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancel)
                .addContainerGap())
        );

        jPanelCancelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonCancel, jButtonGenerate});

        jPanelCancelLayout.setVerticalGroup(
            jPanelCancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCancelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancel)
                    .addComponent(jButtonGenerate))
                .addContainerGap())
        );

        jPanelCancelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonCancel, jButtonGenerate});

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelAddProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addComponent(jPanelTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)))
                .addContainerGap())
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelAddProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelMainLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanelCancel, jPanelTotal});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        JTextField id = new JTextField();
        JTextField quantity = new JTextField();
        JComboBox type = new JComboBox();

        Boolean found = false;

        type.addItem("Medicine");
        type.addItem("Other Product");

        Object[] obj = {"Product ID/Serial Number", id, "Product Quantity", quantity, type};

        ImageIcon icon = new ImageIcon(".\\Icons\\receipt_64px.png");
        javax.swing.JOptionPane.showMessageDialog(this, obj, "Add Product to Receipt", JOptionPane.DEFAULT_OPTION, icon);
        if (id.getText().isEmpty() || quantity.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both the ID and the quantity.", "Empty ID or Quantity", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                Integer.parseInt(id.getText());
                Integer.parseInt(quantity.getText());

                //Adding to table if found
                //<editor-fold defaultstate="collapsed" desc="If Medicine is selected">
                if (type.getSelectedItem().toString().equals("Medicine")) {
                    for (Medicine medicine : Medicine.allMedicines) {
                        if (id.getText().equals(String.valueOf(medicine.getId())) || id.getText().equals(String.valueOf(medicine.getSerialNumber()))) {
                            found = true;
                            java.util.Vector data = new java.util.Vector<>();
                            data.add("Medicine");
                            data.add(medicine.getName());
                            data.add(quantity.getText());
                            if (!(medicine.getPrice() > 0)) {
                                try {
                                    Double price = Double.parseDouble(JOptionPane.showInputDialog("Medicine Price (" + medicine.getName() + ")"));
                                    data.add(price * Integer.parseInt(quantity.getText()));
                                } catch (NumberFormatException e) {
                                    throw e;
                                }
                            } else {
                                data.add(medicine.getPrice() * Integer.parseInt(quantity.getText()));
                            }

                            tableModel.addRow(data);
                            jTextFieldNumberOfItems.setText(String.valueOf(Integer.parseInt(String.valueOf((Integer.parseInt(jTextFieldNumberOfItems.getText()) + 1)))));
                            Double total = 0.0;
                            for (var v : tableModel.getDataVector()) {
                                total += Double.parseDouble(v.get(3).toString());
                            }
                            jTextFieldTotal.setText(String.valueOf(total));
                            break;
                        }
                    }
                    if (found == false) {
                        throw new Exception("No medicine found with that ID or serial number.");
                    }
                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="If OtherProduct is selected">
                if (type.getSelectedItem().toString().equals("Other Product")) {
                    for (OtherProduct product : OtherProduct.allOtherProducts) {
                        if (id.getText().equals(String.valueOf(product.getId())) || id.getText().equals(String.valueOf(product.getSerialNumber()))) {
                            found = true;
                            java.util.Vector data = new java.util.Vector<>();
                            data.add("Other Product");
                            data.add(product.getName());
                            data.add(quantity.getText());
                            if (!(product.getPrice() > 0)) {
                                try {
                                    Double price = Double.parseDouble(JOptionPane.showInputDialog("Product Price (" + product.getName() + ")"));
                                    data.add(price * Integer.parseInt(quantity.getText()));
                                } catch (NumberFormatException e) {
                                    throw e;
                                }
                            } else {
                                data.add(product.getPrice() * Integer.parseInt(quantity.getText()));
                            }

                            tableModel.addRow(data);
                            jTextFieldNumberOfItems.setText(String.valueOf(Integer.parseInt(jTextFieldNumberOfItems.getText() + 1)));
                            Double total = 0.0;
                            for (var v : tableModel.getDataVector()) {
                                total += Double.parseDouble(v.get(3).toString());
                            }
                            jTextFieldTotal.setText(String.valueOf(total));
                            break;
                        }
                    }
                    if (found == false) {
                        throw new Exception("No product found with that ID or serial number.");
                    }
                }
                //</editor-fold>

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "ID and quantity must be integers, and price must be a number.", "Input Error!", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRemoveActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateActionPerformed
        // TODO add your handling code here:
        try {
            //making sure that date and items tables aren't empty
            if (jTextFieldID.getText().isEmpty()) {
                throw new Exception("ID Cannot be empty.");
            }
            try {
                Integer.parseInt(jTextFieldID.getText());
            } catch (NumberFormatException e) {
                throw new Exception("ID must be an integer.");
            }
            if (jDateChooser.getDate().toString().isEmpty() || jDateChooser.getDate() == null) {
                try {
                    jDateChooser.setDate(Database.getCurrentDate());
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter the data correctly.\n" + ex.getMessage(), "Current Date Error", JOptionPane.ERROR_MESSAGE);
                }
                throw new Exception("Must add the date using the provided format.");
            }
            if (jTableProductsTable.getRowCount() == 0) {
                throw new Exception("Must add at least one product to the receipt.");
            }

            //will store the data from the textfields
            Map<String, String> values = new HashMap<>();

            values.put("tableName", "receipts");
            values.put("receiptID", String.valueOf(jTextFieldID.getText()));
            values.put("receiptNumberOfItems", jTextFieldNumberOfItems.getText());
            values.put("receiptTotal", jTextFieldTotal.getText());

            SimpleDateFormat simpleDateFormatter = new SimpleDateFormat(dateFormat);
            values.put("receiptDate", simpleDateFormatter.format(jDateChooser.getDate()));
            System.out.println(simpleDateFormatter.format(jDateChooser.getDate()));

            String items = "";
            for (int i = 0; i < jTableProductsTable.getRowCount(); i++) {
                items += String.valueOf(Integer.parseInt(tableModel.getDataVector().get(i).elementAt(2).toString()));
                items += "x";
                items += tableModel.getDataVector().get(i).elementAt(1).toString();
                items += ", ";
            }
            items = items.substring(0, items.length() - 2);
            values.put("receiptItems", items);

            if (!jTextFieldCustomerName.getText().isEmpty()) {
                values.put("receiptCustomerName", jTextFieldCustomerName.getText());
            }

            //columns string indicates which columns to send to the database (only sending non-empty values)
            String columns = "( ";
            java.util.ArrayList<String> columnsArr = new java.util.ArrayList<>();
            for (String k : values.keySet()) {
                if ("tableName".equals(k)) {
                    continue;
                }
                columns += k + ", ";
                columnsArr.add(k);
            }
            columns = columns.substring(0, columns.length() - 2);
            columns += ") ";

            //SQL query that will be excuted being sent to insert method from Database clase
            try {
                insert("INSERT INTO " + values.get("tableName") + columns + "VALUES(", values, columnsArr);
            }
            catch (SQLException e) {
                throw e;
            }
            Database.refreshReceiptsArrayList();
            parent.refreshTable();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonGenerateActionPerformed

    public void insert(String insertQuery, Map<String, String> values, java.util.ArrayList<String> columns) throws SQLException {
        for (String k : columns) {
            try {
                Double.parseDouble(values.get(k));
                insertQuery += values.get(k) + ", ";
            } catch (NumberFormatException e) {
                insertQuery += "'" + values.get(k) + "', ";
            }
            finally {
                System.out.println(values.get(k));
            }
        }
        insertQuery = insertQuery.substring(0, insertQuery.length() - 2);
        insertQuery += ");";
        System.out.println(insertQuery);
        
        Database.insert(insertQuery);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonGenerate;
    private javax.swing.JButton jButtonRemove;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabelCustomerName;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelNumberOfItems;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JPanel jPanelAddProduct;
    private javax.swing.JPanel jPanelCancel;
    private javax.swing.JPanel jPanelForm;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelTitle;
    private javax.swing.JPanel jPanelTotal;
    private javax.swing.JScrollPane jScrollPaneTable;
    private javax.swing.JTable jTableProductsTable;
    private javax.swing.JTextField jTextFieldCustomerName;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldNumberOfItems;
    private javax.swing.JTextField jTextFieldTotal;
    // End of variables declaration//GEN-END:variables
    DefaultTableModel tableModel;

}
