//MOHAMMED EZZ'S TASK
//this window should display the selected product (only if one product only is selected) data and allow to edit it
package nour.ppts;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UpdateOtherProductWindow extends Window {

    ProductsWindow parent;
    OtherProduct product;

    public UpdateOtherProductWindow(ProductsWindow parent, OtherProduct otherProduct) {
        this.parent = parent;
        this.product = otherProduct;

        //freezing parent until productsWindow is closed
        parent.setFocusableWindowState(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent windowEvent) {
                parent.setFocusableWindowState(true);
                parent.toFront();
            }
        });

        initComponents();
        setTextFields();
        jLabelImage.setIcon(product.getImage());
        setSize(getPreferredSize().width + 50, getPreferredSize().height + 200);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jPanelButtons = new javax.swing.JPanel();
        jButtonUpdate = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jLabelBackButton = new javax.swing.JLabel();
        jPanelTitle = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jPanelMiddle = new javax.swing.JPanel();
        jPanelForm = new javax.swing.JPanel();
        jLabelOtherPrice = new javax.swing.JLabel();
        jLabelOtherDescription = new javax.swing.JLabel();
        jLabelOtherID = new javax.swing.JLabel();
        jTextFieldOtherPrice = new javax.swing.JTextField();
        jLabelOtherSerialNumber = new javax.swing.JLabel();
        jLabelOtherName = new javax.swing.JLabel();
        jTextFieldOtherID = new javax.swing.JTextField();
        jTextFieldOtherSerialNumber = new javax.swing.JTextField();
        jLabelOtherImageLocation = new javax.swing.JLabel();
        jTextFieldOtherDescription = new javax.swing.JTextField();
        jTextFieldOtherStock = new javax.swing.JTextField();
        jLabelOtherStock = new javax.swing.JLabel();
        jTextFieldOtherImageLocation = new javax.swing.JTextField();
        jTextFieldOtherName = new javax.swing.JTextField();
        jButtonBrowse = new javax.swing.JButton();
        jPanelImage = new javax.swing.JPanel();
        jLabelImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jLabelBackButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBackButton.setIcon(new javax.swing.ImageIcon("E:\\Code\\Java Practice\\PPTS\\src\\main\\java\\nour\\Icons\\back_64px.png")); // NOI18N
        jLabelBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBackButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelButtonsLayout = new javax.swing.GroupLayout(jPanelButtons);
        jPanelButtons.setLayout(jPanelButtonsLayout);
        jPanelButtonsLayout.setHorizontalGroup(
            jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBackButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCancel)
                .addContainerGap())
        );

        jPanelButtonsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonCancel, jButtonUpdate});

        jPanelButtonsLayout.setVerticalGroup(
            jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelButtonsLayout.createSequentialGroup()
                .addGroup(jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonUpdate)
                        .addComponent(jLabelBackButton))
                    .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelButtonsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonCancel, jButtonUpdate, jLabelBackButton});

        jLabelTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("Update Product Data");

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

        jLabelOtherPrice.setText("Price");

        jLabelOtherDescription.setText("Description");

        jLabelOtherID.setText("ID");

        jLabelOtherSerialNumber.setText("SN");

        jLabelOtherName.setText("Name");

        jTextFieldOtherID.setEditable(false);

        jLabelOtherImageLocation.setText("Image");

        jLabelOtherStock.setText("Stock");

        jButtonBrowse.setText("Browse");
        jButtonBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBrowseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFormLayout = new javax.swing.GroupLayout(jPanelForm);
        jPanelForm.setLayout(jPanelFormLayout);
        jPanelFormLayout.setHorizontalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelOtherName)
                    .addComponent(jLabelOtherID)
                    .addComponent(jLabelOtherStock)
                    .addComponent(jLabelOtherPrice)
                    .addComponent(jLabelOtherImageLocation)
                    .addComponent(jLabelOtherSerialNumber)
                    .addComponent(jLabelOtherDescription))
                .addGap(57, 57, 57)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldOtherDescription, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldOtherStock, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldOtherPrice, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldOtherSerialNumber, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldOtherID, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldOtherName)
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addComponent(jTextFieldOtherImageLocation, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBrowse)))
                .addContainerGap())
        );

        jPanelFormLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabelOtherDescription, jLabelOtherID, jLabelOtherImageLocation, jLabelOtherName, jLabelOtherPrice, jLabelOtherSerialNumber, jLabelOtherStock});

        jPanelFormLayout.setVerticalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelOtherID, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldOtherID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelOtherName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldOtherName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelOtherPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldOtherPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldOtherStock, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelOtherStock, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelOtherSerialNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldOtherSerialNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldOtherImageLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelOtherImageLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBrowse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldOtherDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelOtherDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelFormLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonBrowse, jTextFieldOtherDescription, jTextFieldOtherID, jTextFieldOtherImageLocation, jTextFieldOtherName, jTextFieldOtherPrice, jTextFieldOtherSerialNumber, jTextFieldOtherStock});

        jLabelImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanelImageLayout = new javax.swing.GroupLayout(jPanelImage);
        jPanelImage.setLayout(jPanelImageLayout);
        jPanelImageLayout.setHorizontalGroup(
            jPanelImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelImageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelImage, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelImageLayout.setVerticalGroup(
            jPanelImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelImageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelImage, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelMiddleLayout = new javax.swing.GroupLayout(jPanelMiddle);
        jPanelMiddle.setLayout(jPanelMiddleLayout);
        jPanelMiddleLayout.setHorizontalGroup(
            jPanelMiddleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMiddleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelMiddleLayout.setVerticalGroup(
            jPanelMiddleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMiddleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMiddleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelMiddleLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanelForm, jPanelImage});

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelMiddle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMiddle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void setTextFields() {
        jTextFieldOtherID.setText(String.valueOf(product.getId()));
        jTextFieldOtherDescription.setText(String.valueOf(product.getDescription()));
        jTextFieldOtherImageLocation.setText(product.getImageLocation());
        jTextFieldOtherName.setText(product.getName());
        jTextFieldOtherPrice.setText(String.valueOf(product.getPrice()));
        jTextFieldOtherSerialNumber.setText(String.valueOf(product.getSerialNumber()));
        jTextFieldOtherStock.setText(String.valueOf(product.getStock()));
    }

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here:
        Map<String, String> data = new HashMap<>();

        try {
            if (jTextFieldOtherSerialNumber.getText().isEmpty()) {
                throw new NumberFormatException("Serial number cannot be empty.");
            }
            if (jTextFieldOtherName.getText().isEmpty()) {
                throw new NumberFormatException("Name cannot be empty.");
            }
            if (!String.valueOf(product.getDescription()).equals(jTextFieldOtherDescription.getText())) {
                data.put("productDescription", jTextFieldOtherDescription.getText());
            }
            if (!product.getImageLocation().equals(jTextFieldOtherImageLocation.getText())) {
                data.put("productImageLocation", jTextFieldOtherImageLocation.getText());
            }
            if (!product.getName().equals(jTextFieldOtherName.getText())) {
                data.put("productName", jTextFieldOtherName.getText());
            }
            if (!String.valueOf(product.getPrice()).equals(jTextFieldOtherPrice.getText())) {
                data.put("productPrice", jTextFieldOtherPrice.getText());
            }
            if (!String.valueOf(product.getSerialNumber()).equals(jTextFieldOtherSerialNumber.getText())) {
                data.put("productSerialNumber", jTextFieldOtherSerialNumber.getText());
            }
            if (!String.valueOf(product.getStock()).equals(jTextFieldOtherStock.getText())) {
                data.put("productStock", jTextFieldOtherStock.getText());
            }

            Database.update(Integer.parseInt(jTextFieldOtherID.getText()), "product", data);
            Database.refreshOtherProductsArrayList();
            parent.refreshOtherTable();
            System.out.println("Updated successfully.");

        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Input error, check the data you entered.\n" + "Error: " + e.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException e) {
            System.out.println("Oopsie uninitialized product value found\n" + e.getMessage());
        }

    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jLabelBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBackButtonMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabelBackButtonMouseClicked

    private void jButtonBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBrowseActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser("./");
        FileFilter imageFilter = new FileNameExtensionFilter("Images only", ImageIO.getReaderFileSuffixes());
        fc.setFileFilter(imageFilter);
        fc.setAcceptAllFileFilterUsed(false);
        fc.setApproveButtonText("Choose");
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            jTextFieldOtherImageLocation.setText(fc.getSelectedFile().getAbsolutePath());
            jLabelImage.setIcon(new ImageIcon(jTextFieldOtherImageLocation.getText()));
        }
    }//GEN-LAST:event_jButtonBrowseActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBrowse;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabelBackButton;
    private javax.swing.JLabel jLabelImage;
    private javax.swing.JLabel jLabelOtherDescription;
    private javax.swing.JLabel jLabelOtherID;
    private javax.swing.JLabel jLabelOtherImageLocation;
    private javax.swing.JLabel jLabelOtherName;
    private javax.swing.JLabel jLabelOtherPrice;
    private javax.swing.JLabel jLabelOtherSerialNumber;
    private javax.swing.JLabel jLabelOtherStock;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanelButtons;
    private javax.swing.JPanel jPanelForm;
    private javax.swing.JPanel jPanelImage;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelMiddle;
    private javax.swing.JPanel jPanelTitle;
    private javax.swing.JTextField jTextFieldOtherDescription;
    private javax.swing.JTextField jTextFieldOtherID;
    private javax.swing.JTextField jTextFieldOtherImageLocation;
    private javax.swing.JTextField jTextFieldOtherName;
    private javax.swing.JTextField jTextFieldOtherPrice;
    private javax.swing.JTextField jTextFieldOtherSerialNumber;
    private javax.swing.JTextField jTextFieldOtherStock;
    // End of variables declaration//GEN-END:variables
}
//MOHAMMED EZZ'S TASK
