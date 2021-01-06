//used to add a new product to the database
package nour.ppts;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.Map;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class AddProductWindow extends Window {

    public ProductsWindow parent;
    //used to refresh the parent's tables if updated (won't refresh if no updates happened to save processing time)
    private Boolean refreshMedicine = false;
    private Boolean refreshOther = false;

    public AddProductWindow(ProductsWindow parent) {
        this.parent = parent;
        setSize(440, 580);
        setResizable(false);
        setLocationRelativeTo(parent);

        //freezing parent until addProductWindow is closed
        parent.setFocusableWindowState(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent windowEvent) {
                parent.setFocusableWindowState(true);
                parent.toFront();
            }
        });

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanelMedicine = new javax.swing.JPanel();
        jTextFieldMedicineStock = new javax.swing.JTextField();
        jLabelMedicineImageLocation = new javax.swing.JLabel();
        jTextFieldMedicineID = new javax.swing.JTextField();
        jLabelMedicineID = new javax.swing.JLabel();
        jLabelMedicinePrice = new javax.swing.JLabel();
        jLabelMedicineDose = new javax.swing.JLabel();
        jLabelMedicineSerialNumber = new javax.swing.JLabel();
        jTextFieldMedicineImageLocation = new javax.swing.JTextField();
        jLabelMedicineStock = new javax.swing.JLabel();
        jLabelMedicineName = new javax.swing.JLabel();
        jTextFieldMedicineSerialNumber = new javax.swing.JTextField();
        jTextFieldMedicineName = new javax.swing.JTextField();
        jTextFieldMedicinePrice = new javax.swing.JTextField();
        jTextFieldMedicineDose = new javax.swing.JTextField();
        jTextFieldMedicineActiveSub = new javax.swing.JTextField();
        jLabelMedicineActiveSub = new javax.swing.JLabel();
        jTextFieldMedicineLocation = new javax.swing.JTextField();
        jLabelMedicineLocation = new javax.swing.JLabel();
        jPanelOther = new javax.swing.JPanel();
        jTextFieldOtherStock = new javax.swing.JTextField();
        jLabelOtherImageLocation = new javax.swing.JLabel();
        jTextFieldOtherID = new javax.swing.JTextField();
        jLabelOtherID = new javax.swing.JLabel();
        jLabelOtherPrice = new javax.swing.JLabel();
        jLabelOtherDescription = new javax.swing.JLabel();
        jLabelOtherSerialNumber = new javax.swing.JLabel();
        jTextFieldOtherImageLocation = new javax.swing.JTextField();
        jLabelOtherStock = new javax.swing.JLabel();
        jLabelOtherName = new javax.swing.JLabel();
        jTextFieldOtherSerialNumber = new javax.swing.JTextField();
        jTextFieldOtherName = new javax.swing.JTextField();
        jTextFieldOtherPrice = new javax.swing.JTextField();
        jTextFieldOtherDescription = new javax.swing.JTextField();
        jPanelBottom = new javax.swing.JPanel();
        jButtonAdd = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jLabelStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("Add New Product");
        jLabelTitle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTabbedPane.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelMedicineImageLocation.setText("Image");

        jLabelMedicineID.setText("ID");

        jLabelMedicinePrice.setText("Price");

        jLabelMedicineDose.setText("Dose");

        jLabelMedicineSerialNumber.setText("SN");

        jLabelMedicineStock.setText("Stock");

        jLabelMedicineName.setText("Name");

        jLabelMedicineActiveSub.setText("Active Substance");

        jLabelMedicineLocation.setText("Location");

        javax.swing.GroupLayout jPanelMedicineLayout = new javax.swing.GroupLayout(jPanelMedicine);
        jPanelMedicine.setLayout(jPanelMedicineLayout);
        jPanelMedicineLayout.setHorizontalGroup(
            jPanelMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMedicineLayout.createSequentialGroup()
                .addGroup(jPanelMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMedicineLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanelMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelMedicineName)
                            .addComponent(jLabelMedicineID)
                            .addComponent(jLabelMedicineStock)
                            .addComponent(jLabelMedicinePrice)
                            .addComponent(jLabelMedicineImageLocation)
                            .addComponent(jLabelMedicineSerialNumber)
                            .addComponent(jLabelMedicineDose)
                            .addComponent(jLabelMedicineLocation)))
                    .addGroup(jPanelMedicineLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelMedicineActiveSub, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldMedicineImageLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMedicineDose, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMedicineStock, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMedicinePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMedicineName, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMedicineSerialNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMedicineID, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMedicineActiveSub, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMedicineLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelMedicineLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabelMedicineDose, jLabelMedicineID, jLabelMedicineImageLocation, jLabelMedicineLocation, jLabelMedicineName, jLabelMedicinePrice, jLabelMedicineSerialNumber, jLabelMedicineStock});

        jPanelMedicineLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextFieldMedicineActiveSub, jTextFieldMedicineDose, jTextFieldMedicineID, jTextFieldMedicineImageLocation, jTextFieldMedicineLocation, jTextFieldMedicineName, jTextFieldMedicinePrice, jTextFieldMedicineSerialNumber, jTextFieldMedicineStock});

        jPanelMedicineLayout.setVerticalGroup(
            jPanelMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMedicineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelMedicineID, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMedicineID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanelMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldMedicineName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedicineName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanelMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelMedicinePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMedicinePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanelMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldMedicineStock, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedicineStock, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelMedicineSerialNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMedicineSerialNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldMedicineImageLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedicineImageLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldMedicineDose, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedicineDose, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldMedicineActiveSub, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedicineActiveSub, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldMedicineLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedicineLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelMedicineLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTextFieldMedicineActiveSub, jTextFieldMedicineDose, jTextFieldMedicineID, jTextFieldMedicineImageLocation, jTextFieldMedicineLocation, jTextFieldMedicineName, jTextFieldMedicinePrice, jTextFieldMedicineSerialNumber, jTextFieldMedicineStock});

        jPanelMedicineLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabelMedicineActiveSub, jLabelMedicineDose, jLabelMedicineID, jLabelMedicineImageLocation, jLabelMedicineLocation, jLabelMedicineName, jLabelMedicinePrice, jLabelMedicineSerialNumber, jLabelMedicineStock});

        jTabbedPane.addTab("Medicine", jPanelMedicine);

        jLabelOtherImageLocation.setText("Image");

        jLabelOtherID.setText("ID");

        jLabelOtherPrice.setText("Price");

        jLabelOtherDescription.setText("Description");

        jLabelOtherSerialNumber.setText("SN");

        jLabelOtherStock.setText("Stock");

        jLabelOtherName.setText("Name");

        javax.swing.GroupLayout jPanelOtherLayout = new javax.swing.GroupLayout(jPanelOther);
        jPanelOther.setLayout(jPanelOtherLayout);
        jPanelOtherLayout.setHorizontalGroup(
            jPanelOtherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOtherLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOtherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelOtherName)
                    .addComponent(jLabelOtherID)
                    .addComponent(jLabelOtherStock)
                    .addComponent(jLabelOtherPrice)
                    .addComponent(jLabelOtherImageLocation)
                    .addComponent(jLabelOtherSerialNumber)
                    .addComponent(jLabelOtherDescription, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOtherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldOtherImageLocation, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                    .addComponent(jTextFieldOtherDescription)
                    .addComponent(jTextFieldOtherStock)
                    .addComponent(jTextFieldOtherPrice)
                    .addComponent(jTextFieldOtherName)
                    .addComponent(jTextFieldOtherSerialNumber)
                    .addComponent(jTextFieldOtherID))
                .addContainerGap())
        );

        jPanelOtherLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabelOtherDescription, jLabelOtherID, jLabelOtherImageLocation, jLabelOtherName, jLabelOtherPrice, jLabelOtherSerialNumber, jLabelOtherStock});

        jPanelOtherLayout.setVerticalGroup(
            jPanelOtherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOtherLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOtherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelOtherID, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldOtherID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanelOtherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldOtherName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelOtherName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanelOtherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelOtherPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldOtherPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanelOtherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldOtherStock, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelOtherStock, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOtherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelOtherSerialNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldOtherSerialNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOtherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldOtherImageLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelOtherImageLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOtherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldOtherDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelOtherDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelOtherLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTextFieldOtherDescription, jTextFieldOtherID, jTextFieldOtherImageLocation, jTextFieldOtherName, jTextFieldOtherPrice, jTextFieldOtherSerialNumber, jTextFieldOtherStock});

        jPanelOtherLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabelOtherDescription, jLabelOtherID, jLabelOtherImageLocation, jLabelOtherName, jLabelOtherPrice, jLabelOtherSerialNumber, jLabelOtherStock});

        jTabbedPane.addTab("Other", jPanelOther);

        jPanelBottom.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Close");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jLabelStatus.setText("Error Message");

        javax.swing.GroupLayout jPanelBottomLayout = new javax.swing.GroupLayout(jPanelBottom);
        jPanelBottom.setLayout(jPanelBottomLayout);
        jPanelBottomLayout.setHorizontalGroup(
            jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBottomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCancel)
                .addContainerGap())
        );

        jPanelBottomLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonAdd, jButtonCancel, jLabelStatus});

        jPanelBottomLayout.setVerticalGroup(
            jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBottomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdd)
                    .addComponent(jButtonCancel)
                    .addComponent(jLabelStatus))
                .addContainerGap())
        );

        jPanelBottomLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonAdd, jButtonCancel, jLabelStatus});

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanelBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelMainLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabelTitle, jPanelBottom, jTabbedPane});

        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    //DATABASE RELATED!!
    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        try {
            //checking attibutes which much be non-null (must be not empty)
            if ((jTextFieldMedicineID.getText().isEmpty() && jTabbedPane.getSelectedComponent().equals(jPanelMedicine))
                    || ((jTextFieldOtherID.getText().isEmpty() && jTabbedPane.getSelectedComponent().equals(jPanelOther)))) {
                throw new Exception("ID cannot be empty.");
            }
            if ((jTextFieldMedicineName.getText().isEmpty() && jTabbedPane.getSelectedComponent().equals(jPanelMedicine))
                    || ((jTextFieldOtherName.getText().isEmpty() && jTabbedPane.getSelectedComponent().equals(jPanelOther)))) {
                throw new Exception("Name cannot be empty.");
            }
            if ((jTextFieldMedicineSerialNumber.getText().isEmpty() && jTabbedPane.getSelectedComponent().equals(jPanelMedicine))
                    || ((jTextFieldOtherSerialNumber.getText().isEmpty() && jTabbedPane.getSelectedComponent().equals(jPanelOther)))) {
                throw new Exception("SN cannot be empty.");
            }

            //will store all data entered in the textfields
            Map<String, String> values = new HashMap<>();

            //checking which panel is selected (entering into Medicine or OtherProduct)
            if (jTabbedPane.getSelectedComponent().equals(jPanelMedicine)) {

                values.put("tableName", "medicine");
                values.put("medicineID", String.valueOf(jTextFieldMedicineID.getText()));
                values.put("medicineName", jTextFieldMedicineName.getText());
                if (!jTextFieldMedicineActiveSub.getText().isEmpty()) {
                    values.put("medicineActiveSub", jTextFieldMedicineActiveSub.getText());
                }
                if (!jTextFieldMedicinePrice.getText().isEmpty()) {
                    values.put("medicinePrice", jTextFieldMedicinePrice.getText());
                }
                if (!jTextFieldMedicineStock.getText().isEmpty()) {
                    values.put("medicineStock", jTextFieldMedicineStock.getText());
                }
                if (!jTextFieldMedicineImageLocation.getText().isEmpty()) {
                    values.put("medicineImageLocation", jTextFieldMedicineImageLocation.getText());
                }
                if (!jTextFieldMedicineDose.getText().isEmpty()) {
                    values.put("medicineDose", jTextFieldMedicineDose.getText());
                }
                values.put("medicineSerialNumber", jTextFieldMedicineSerialNumber.getText());
                if (!jTextFieldMedicineLocation.getText().isEmpty()) {
                    values.put("medicineLocation", jTextFieldMedicineLocation.getText());
                }

            } else if (jTabbedPane.getSelectedComponent().equals(jPanelOther)) {

                values.put("tableName", "product");
                values.put("productID", String.valueOf(jTextFieldOtherID.getText()));
                values.put("productName", jTextFieldOtherName.getText());
                if (!jTextFieldOtherDescription.getText().isEmpty()) {
                    values.put("productDescription", jTextFieldOtherDescription.getText());
                }
                if (!jTextFieldOtherPrice.getText().isEmpty()) {
                    values.put("productPrice", jTextFieldOtherPrice.getText());
                }
                if (!jTextFieldOtherStock.getText().isEmpty()) {
                    values.put("productStock", jTextFieldOtherStock.getText());
                }
                if (!jTextFieldOtherImageLocation.getText().isEmpty()) {
                    values.put("productImageLocation", jTextFieldOtherImageLocation.getText());
                }
                values.put("productSerialNumber", jTextFieldOtherSerialNumber.getText());

            } else {
                jLabelStatus.setText("No tab seletced");
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
            insert("INSERT INTO " + values.get("tableName") + columns + "VALUES(", values, columnsArr);
            jLabelStatus.setText("Added successfully!");
            if ("medicine".equals(values.get("tableName"))) {
                Database.refreshMedicinesArrayList();
                parent.refreshMedicineTable();
            } else if ("product".equals(values.get("tableName"))) {
                Database.refreshOtherProductsArrayList();
                parent.refreshOtherTable();
            }

        } catch (NumberFormatException | SQLException e) {
            jLabelStatus.setText(e.getMessage());
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            jLabelStatus.setText(e.getMessage());
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage(), "Incomplete Data", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    //DATABASE RELATED!!
    public void insert(String insertQuery, Map<String, String> values, java.util.ArrayList<String> columns) throws SQLException {
        try {
            for (String k : columns) {
                try {
                    Double.parseDouble(values.get(k));
                    insertQuery += values.get(k) + ", ";
                } catch (NumberFormatException e) {
                    insertQuery += "'" + values.get(k) + "', ";
                }
            }
            insertQuery = insertQuery.substring(0, insertQuery.length() - 2);
            insertQuery += ");";
            System.out.println(insertQuery);
            Database.insert(insertQuery);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            jLabelStatus.setText(e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JLabel jLabelMedicineActiveSub;
    private javax.swing.JLabel jLabelMedicineDose;
    private javax.swing.JLabel jLabelMedicineID;
    private javax.swing.JLabel jLabelMedicineImageLocation;
    private javax.swing.JLabel jLabelMedicineLocation;
    private javax.swing.JLabel jLabelMedicineName;
    private javax.swing.JLabel jLabelMedicinePrice;
    private javax.swing.JLabel jLabelMedicineSerialNumber;
    private javax.swing.JLabel jLabelMedicineStock;
    private javax.swing.JLabel jLabelOtherDescription;
    private javax.swing.JLabel jLabelOtherID;
    private javax.swing.JLabel jLabelOtherImageLocation;
    private javax.swing.JLabel jLabelOtherName;
    private javax.swing.JLabel jLabelOtherPrice;
    private javax.swing.JLabel jLabelOtherSerialNumber;
    private javax.swing.JLabel jLabelOtherStock;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanelBottom;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelMedicine;
    private javax.swing.JPanel jPanelOther;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTextField jTextFieldMedicineActiveSub;
    private javax.swing.JTextField jTextFieldMedicineDose;
    private javax.swing.JTextField jTextFieldMedicineID;
    private javax.swing.JTextField jTextFieldMedicineImageLocation;
    private javax.swing.JTextField jTextFieldMedicineLocation;
    private javax.swing.JTextField jTextFieldMedicineName;
    private javax.swing.JTextField jTextFieldMedicinePrice;
    private javax.swing.JTextField jTextFieldMedicineSerialNumber;
    private javax.swing.JTextField jTextFieldMedicineStock;
    private javax.swing.JTextField jTextFieldOtherDescription;
    private javax.swing.JTextField jTextFieldOtherID;
    private javax.swing.JTextField jTextFieldOtherImageLocation;
    private javax.swing.JTextField jTextFieldOtherName;
    private javax.swing.JTextField jTextFieldOtherPrice;
    private javax.swing.JTextField jTextFieldOtherSerialNumber;
    private javax.swing.JTextField jTextFieldOtherStock;
    // End of variables declaration//GEN-END:variables
}
