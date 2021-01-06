//MOHAMMED EZZ'S TASK
//this window should display the selected product (only if one product only is selected) data and allow to edit it
package nour.ppts;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Map;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class UpdateMedicineWindow extends Window {

    ProductsWindow parent;
    Medicine medicine;

    public UpdateMedicineWindow(ProductsWindow parent, Medicine medicine) {
        this.parent = parent;
        this.medicine = medicine;

        //freezing parent until productsWindow is closed
        parent.setFocusableWindowState(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent windowEvent) {
                parent.setFocusableWindowState(true);
            }
        });

        initComponents();
        setTextFields();
        this.setSize(500, 530);
        this.setLocationRelativeTo(null);
    }

    private void setTextFields() {
        jTextFieldMedicineID.setText(String.valueOf(medicine.getId()));
        jTextFieldMedicineActiveSub.setText(medicine.getActiveSub());
        jTextFieldMedicineDose.setText(String.valueOf(medicine.getDose()));
        jTextFieldMedicineImageLocation.setText(medicine.getImageLocation());
        jTextFieldMedicineLocation.setText(medicine.getLocation());
        jTextFieldMedicineName.setText(medicine.getName());
        jTextFieldMedicinePrice.setText(String.valueOf(medicine.getPrice()));
        jTextFieldMedicineSerialNumber.setText(String.valueOf(medicine.getSerialNumber()));
        jTextFieldMedicineStock.setText(String.valueOf(medicine.getStock()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jPanelForn = new javax.swing.JPanel();
        jTextFieldMedicineActiveSub = new javax.swing.JTextField();
        jLabelMedicinePrice = new javax.swing.JLabel();
        jLabelMedicineDose = new javax.swing.JLabel();
        jLabelMedicineLocation = new javax.swing.JLabel();
        jLabelMedicineID = new javax.swing.JLabel();
        jTextFieldMedicinePrice = new javax.swing.JTextField();
        jLabelMedicineSerialNumber = new javax.swing.JLabel();
        jLabelMedicineName = new javax.swing.JLabel();
        jTextFieldMedicineID = new javax.swing.JTextField();
        jTextFieldMedicineSerialNumber = new javax.swing.JTextField();
        jLabelMedicineImageLocation = new javax.swing.JLabel();
        jLabelMedicineActiveSub = new javax.swing.JLabel();
        jTextFieldMedicineDose = new javax.swing.JTextField();
        jTextFieldMedicineLocation = new javax.swing.JTextField();
        jTextFieldMedicineStock = new javax.swing.JTextField();
        jLabelMedicineStock = new javax.swing.JLabel();
        jTextFieldMedicineImageLocation = new javax.swing.JTextField();
        jTextFieldMedicineName = new javax.swing.JTextField();
        jPanelButtons = new javax.swing.JPanel();
        jButtonUpdate = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jPanelTitle = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelMedicinePrice.setText("Price");

        jLabelMedicineDose.setText("Dose");

        jLabelMedicineLocation.setText("Location");

        jLabelMedicineID.setText("ID");

        jLabelMedicineSerialNumber.setText("SN");

        jLabelMedicineName.setText("Name");

        jTextFieldMedicineID.setEditable(false);

        jLabelMedicineImageLocation.setText("Image");

        jLabelMedicineActiveSub.setText("Active Substance");

        jLabelMedicineStock.setText("Stock");

        javax.swing.GroupLayout jPanelFornLayout = new javax.swing.GroupLayout(jPanelForn);
        jPanelForn.setLayout(jPanelFornLayout);
        jPanelFornLayout.setHorizontalGroup(
            jPanelFornLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFornLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFornLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFornLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanelFornLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelMedicineName)
                            .addComponent(jLabelMedicineID)
                            .addComponent(jLabelMedicineStock)
                            .addComponent(jLabelMedicinePrice)
                            .addComponent(jLabelMedicineImageLocation)
                            .addComponent(jLabelMedicineSerialNumber)
                            .addComponent(jLabelMedicineDose)
                            .addComponent(jLabelMedicineLocation)))
                    .addComponent(jLabelMedicineActiveSub, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFornLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldMedicineImageLocation, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addComponent(jTextFieldMedicineDose, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addComponent(jTextFieldMedicineStock, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addComponent(jTextFieldMedicinePrice, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addComponent(jTextFieldMedicineSerialNumber, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addComponent(jTextFieldMedicineActiveSub, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addComponent(jTextFieldMedicineLocation, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addComponent(jTextFieldMedicineID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addComponent(jTextFieldMedicineName, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanelFornLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabelMedicineActiveSub, jLabelMedicineDose, jLabelMedicineID, jLabelMedicineImageLocation, jLabelMedicineLocation, jLabelMedicineName, jLabelMedicinePrice, jLabelMedicineSerialNumber, jLabelMedicineStock});

        jPanelFornLayout.setVerticalGroup(
            jPanelFornLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFornLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFornLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMedicineID, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMedicineID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanelFornLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMedicineName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMedicineName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanelFornLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelMedicinePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMedicinePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanelFornLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldMedicineStock, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedicineStock, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFornLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelMedicineSerialNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMedicineSerialNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFornLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldMedicineImageLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedicineImageLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFornLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldMedicineDose, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedicineDose, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFornLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldMedicineActiveSub, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedicineActiveSub, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFornLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldMedicineLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedicineLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelFornLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTextFieldMedicineActiveSub, jTextFieldMedicineDose, jTextFieldMedicineID, jTextFieldMedicineImageLocation, jTextFieldMedicineLocation, jTextFieldMedicineName, jTextFieldMedicinePrice, jTextFieldMedicineSerialNumber, jTextFieldMedicineStock});

        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel");

        javax.swing.GroupLayout jPanelButtonsLayout = new javax.swing.GroupLayout(jPanelButtons);
        jPanelButtons.setLayout(jPanelButtonsLayout);
        jPanelButtonsLayout.setHorizontalGroup(
            jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelButtonsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCancel)
                .addContainerGap())
        );
        jPanelButtonsLayout.setVerticalGroup(
            jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButtonCancel)
                .addComponent(jButtonUpdate))
        );

        jLabelTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("Update Medicine Data");

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
                .addComponent(jLabelTitle)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelForn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelForn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here:
        Map<String, String> data = new HashMap<>();

        try {
            if (jTextFieldMedicineSerialNumber.getText().isEmpty()) {
                throw new NumberFormatException("Serial number cannot be empty.");
            }
            if (jTextFieldMedicineName.getText().isEmpty()) {
                throw new NumberFormatException("Name cannot be empty.");
            }
            if (!medicine.getActiveSub().equals(jTextFieldMedicineActiveSub.getText())) {
                data.put("medicineActiveSub", jTextFieldMedicineActiveSub.getText());
            }
            if (!String.valueOf(medicine.getDose()).equals(jTextFieldMedicineDose.getText())) {
                data.put("medicineDose", jTextFieldMedicineDose.getText());
            }
            if (!medicine.getImageLocation().equals(jTextFieldMedicineImageLocation.getText())) {
                data.put("medicineImageLocation", jTextFieldMedicineImageLocation.getText());
            }
            if (!medicine.getLocation().equals(jTextFieldMedicineLocation.getText())) {
                data.put("medicineLocation", jTextFieldMedicineLocation.getText());
            }
            if (!medicine.getName().equals(jTextFieldMedicineName.getText())) {
                data.put("medicineName", jTextFieldMedicineName.getText());
            }
            if (!String.valueOf(medicine.getPrice()).equals(jTextFieldMedicinePrice.getText())) {
                data.put("medicinePrice", jTextFieldMedicinePrice.getText());
            }
            if (!String.valueOf(medicine.getSerialNumber()).equals(jTextFieldMedicineSerialNumber.getText())) {
                data.put("medicineSerialNumber", jTextFieldMedicineSerialNumber.getText());
            }
            if (!String.valueOf(medicine.getStock()).equals(jTextFieldMedicineStock.getText())) {
                data.put("medicineStock", jTextFieldMedicineStock.getText());
            }
            
            Database.update(Integer.parseInt(jTextFieldMedicineID.getText()), "medicine", data);
            Database.refreshMedicinesArrayList();
            parent.refreshMedicineTable();
            System.out.println("Updated successfully.");
            
        }
        catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Input error, check the data you entered.\n" + "Error: " + e.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (NullPointerException e) {
            System.out.println("Oopsie uninitialized medicine value found\n" + e.getMessage());
        }


    }//GEN-LAST:event_jButtonUpdateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabelMedicineActiveSub;
    private javax.swing.JLabel jLabelMedicineDose;
    private javax.swing.JLabel jLabelMedicineID;
    private javax.swing.JLabel jLabelMedicineImageLocation;
    private javax.swing.JLabel jLabelMedicineLocation;
    private javax.swing.JLabel jLabelMedicineName;
    private javax.swing.JLabel jLabelMedicinePrice;
    private javax.swing.JLabel jLabelMedicineSerialNumber;
    private javax.swing.JLabel jLabelMedicineStock;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanelButtons;
    private javax.swing.JPanel jPanelForn;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelTitle;
    private javax.swing.JTextField jTextFieldMedicineActiveSub;
    private javax.swing.JTextField jTextFieldMedicineDose;
    private javax.swing.JTextField jTextFieldMedicineID;
    private javax.swing.JTextField jTextFieldMedicineImageLocation;
    private javax.swing.JTextField jTextFieldMedicineLocation;
    private javax.swing.JTextField jTextFieldMedicineName;
    private javax.swing.JTextField jTextFieldMedicinePrice;
    private javax.swing.JTextField jTextFieldMedicineSerialNumber;
    private javax.swing.JTextField jTextFieldMedicineStock;
    // End of variables declaration//GEN-END:variables
}
//MOHAMMED EZZ'S TASK
