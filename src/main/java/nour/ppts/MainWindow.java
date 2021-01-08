//starting window
package nour.ppts;

import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MainWindow extends Window {

    Boolean connectedToDb;
    private static final String[] iconLocations = {"./Icons/hand_with_a_pill_64px.png", "./Icons/pill_64px.png", "./Icons/receipt_64px.png"};

    public MainWindow() {
        connectedToDb = false;
        initComponents();
        String[] serverAddresses = new String[Database.servers.length];
        int index = 0;
        for (String[] server : Database.servers) {
            serverAddresses[index] = server[2].substring(13);
            index++;
        }
        comboBoxModel = new DefaultComboBoxModel(serverAddresses);
        jComboBoxServer.setModel(comboBoxModel);

        jLabelTitle.setIcon(new ImageIcon(iconLocations[0]));
        jLabelButtonProducts.setIcon(new ImageIcon(iconLocations[1]));
        jLabelButtonReceipts.setIcon(new ImageIcon(iconLocations[2]));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jPanelServerForm = new javax.swing.JPanel();
        jTextFieldUsername = new javax.swing.JTextField();
        jLabelUsername = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jComboBoxServer = new javax.swing.JComboBox<>();
        jButtonConnect = new javax.swing.JButton();
        jPasswordField = new javax.swing.JPasswordField();
        jPanelButtons = new javax.swing.JPanel();
        jPanelRecieptsButton = new javax.swing.JPanel();
        jLabelButtonReceipts = new javax.swing.JLabel();
        jPanelProductsButton = new javax.swing.JPanel();
        jLabelButtonProducts = new javax.swing.JLabel();
        jPanelTitle = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelMain.setBackground(new java.awt.Color(222, 222, 222));
        jPanelMain.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        jPanelMain.setAlignmentY(java.awt.Component.CENTER_ALIGNMENT);
        jPanelMain.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jPanelServerForm.setBackground(new java.awt.Color(222, 222, 222));

        jTextFieldUsername.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldUsername.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldUsername.setText("root");
        jTextFieldUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsernameActionPerformed(evt);
            }
        });

        jLabelUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelUsername.setForeground(new java.awt.Color(0, 0, 0));
        jLabelUsername.setText("Username");

        jLabelPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelPassword.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPassword.setText("Password");

        jComboBoxServer.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxServer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxServer.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxServer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Server 1", "Server 2", "Item 3", "Item 4" }));

        jButtonConnect.setBackground(new java.awt.Color(255, 255, 255));
        jButtonConnect.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonConnect.setForeground(new java.awt.Color(0, 0, 0));
        jButtonConnect.setText("Connect");
        jButtonConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConnectActionPerformed(evt);
            }
        });

        jPasswordField.setBackground(new java.awt.Color(255, 255, 255));
        jPasswordField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPasswordField.setForeground(new java.awt.Color(0, 0, 0));
        jPasswordField.setText("1234");

        javax.swing.GroupLayout jPanelServerFormLayout = new javax.swing.GroupLayout(jPanelServerForm);
        jPanelServerForm.setLayout(jPanelServerFormLayout);
        jPanelServerFormLayout.setHorizontalGroup(
            jPanelServerFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelServerFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelServerFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxServer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelServerFormLayout.createSequentialGroup()
                        .addComponent(jLabelUsername)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelServerFormLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanelServerFormLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabelPassword, jLabelUsername});

        jPanelServerFormLayout.setVerticalGroup(
            jPanelServerFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelServerFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelServerFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPassword)
                    .addComponent(jLabelUsername)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonConnect)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelServerFormLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabelPassword, jLabelUsername, jTextFieldUsername});

        jPanelButtons.setBackground(new java.awt.Color(222, 222, 222));

        jPanelRecieptsButton.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRecieptsButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));

        jLabelButtonReceipts.setBackground(new java.awt.Color(255, 255, 255));
        jLabelButtonReceipts.setFont(jLabelButtonReceipts.getFont().deriveFont(jLabelButtonReceipts.getFont().getStyle() | java.awt.Font.BOLD, jLabelButtonReceipts.getFont().getSize()+6));
        jLabelButtonReceipts.setForeground(new java.awt.Color(0, 0, 0));
        jLabelButtonReceipts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelButtonReceipts.setText("Generate Reciept");
        jLabelButtonReceipts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelButtonReceiptsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelButtonReceiptsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelButtonReceiptsMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelRecieptsButtonLayout = new javax.swing.GroupLayout(jPanelRecieptsButton);
        jPanelRecieptsButton.setLayout(jPanelRecieptsButtonLayout);
        jPanelRecieptsButtonLayout.setHorizontalGroup(
            jPanelRecieptsButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecieptsButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelButtonReceipts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelRecieptsButtonLayout.setVerticalGroup(
            jPanelRecieptsButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecieptsButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelButtonReceipts, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanelProductsButton.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProductsButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));

        jLabelButtonProducts.setBackground(new java.awt.Color(255, 255, 255));
        jLabelButtonProducts.setFont(jLabelButtonProducts.getFont().deriveFont(jLabelButtonProducts.getFont().getStyle() | java.awt.Font.BOLD, jLabelButtonProducts.getFont().getSize()+6));
        jLabelButtonProducts.setForeground(new java.awt.Color(0, 0, 0));
        jLabelButtonProducts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelButtonProducts.setText("View/Update Products");
        jLabelButtonProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelButtonProductsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelButtonProductsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelButtonProductsMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelProductsButtonLayout = new javax.swing.GroupLayout(jPanelProductsButton);
        jPanelProductsButton.setLayout(jPanelProductsButtonLayout);
        jPanelProductsButtonLayout.setHorizontalGroup(
            jPanelProductsButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductsButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelButtonProducts, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelProductsButtonLayout.setVerticalGroup(
            jPanelProductsButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProductsButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelButtonProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelButtonsLayout = new javax.swing.GroupLayout(jPanelButtons);
        jPanelButtons.setLayout(jPanelButtonsLayout);
        jPanelButtonsLayout.setHorizontalGroup(
            jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelRecieptsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelProductsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelButtonsLayout.setVerticalGroup(
            jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelProductsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRecieptsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelTitle.setBackground(new java.awt.Color(222, 222, 222));

        jLabelTitle.setBackground(new java.awt.Color(0, 0, 0));
        jLabelTitle.setFont(new java.awt.Font("Segoe UI", 1, 27)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("Pharmacy Product Tracking System (PPTS)");

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
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelServerForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addComponent(jPanelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanelServerForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelButtonProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonProductsMouseClicked
        // TODO add your handling code here:
        if (connectedToDb == true) {
            ProductsWindow w = new ProductsWindow(this);
        } else {
            JOptionPane.showMessageDialog(this, "Please connect to a database first.", "Not Connected", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jLabelButtonProductsMouseClicked

    private void jLabelButtonProductsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonProductsMouseEntered
        // TODO add your handling code here:
        Font f = jLabelButtonProducts.getFont();
        jLabelButtonProducts.setFont(new Font(f.getName(), f.getStyle(), f.getSize() + 3
        ));
    }//GEN-LAST:event_jLabelButtonProductsMouseEntered

    private void jLabelButtonProductsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonProductsMouseExited
        // TODO add your handling code here:
        Font f = jLabelButtonProducts.getFont();
        jLabelButtonProducts.setFont(new Font(f.getName(), f.getStyle(), f.getSize() - 3
        ));
    }//GEN-LAST:event_jLabelButtonProductsMouseExited

    private void jLabelButtonReceiptsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonReceiptsMouseClicked
        // TODO add your handling code here:
        if (connectedToDb == true) {
            ReceiptsWindow w = new ReceiptsWindow(this);
        } else {
            JOptionPane.showMessageDialog(this, "Please connect to a database first.", "Not Connected", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jLabelButtonReceiptsMouseClicked

    private void jLabelButtonReceiptsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonReceiptsMouseEntered
        // TODO add your handling code here:
        Font f = jLabelButtonReceipts.getFont();
        jLabelButtonReceipts.setFont(new Font(f.getName(), f.getStyle(), f.getSize() + 3
        ));
    }//GEN-LAST:event_jLabelButtonReceiptsMouseEntered

    private void jLabelButtonReceiptsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonReceiptsMouseExited
        // TODO add your handling code here:
        Font f = jLabelButtonReceipts.getFont();
        jLabelButtonReceipts.setFont(new Font(f.getName(), f.getStyle(), f.getSize() - 3
        ));
    }//GEN-LAST:event_jLabelButtonReceiptsMouseExited

    private void jTextFieldUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsernameActionPerformed

    private void jButtonConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConnectActionPerformed
        // TODO add your handling code here:
        String selectedServerAddress = jComboBoxServer.getSelectedItem().toString();
        if (!jTextFieldUsername.getText().isEmpty() && !String.valueOf(jPasswordField.getPassword()).isEmpty()) {
            for (String[] server : Database.servers) {
                if (server[2].contains(selectedServerAddress)) {
                    if ((server[0].equals(jTextFieldUsername.getText())) && (server[1].equals(String.valueOf(jPasswordField.getPassword())))) {
                        Database.selectServer(server);
                        try {
                            Database.refreshMedicinesArrayList();
                            Database.refreshOtherProductsArrayList();
                            Database.refreshReceiptsArrayList();
                            JOptionPane.showMessageDialog(this, "Connected to " + server[2] + " successfully.");
                            connectedToDb = true;
                        } catch (java.sql.SQLException e) {
                            JOptionPane.showMessageDialog(this, e.getMessage());
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Incorrect username or password.", "Wrong Credentials", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    continue;
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please enter the username and the password for the selected server.", "Credentials Not Found", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonConnectActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConnect;
    private javax.swing.JComboBox<String> jComboBoxServer;
    private javax.swing.JLabel jLabelButtonProducts;
    private javax.swing.JLabel jLabelButtonReceipts;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JPanel jPanelButtons;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelProductsButton;
    private javax.swing.JPanel jPanelRecieptsButton;
    private javax.swing.JPanel jPanelServerForm;
    private javax.swing.JPanel jPanelTitle;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
    private javax.swing.DefaultComboBoxModel comboBoxModel;
}
