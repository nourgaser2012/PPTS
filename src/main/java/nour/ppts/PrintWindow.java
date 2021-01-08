/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nour.ppts;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import static nour.ppts.Database.dateFormat;

public class PrintWindow extends Window implements Printable {

    private ProductsWindow productsWindowParent;
    private ReceiptsWindow receiptsWindowParent;

    private Medicine medicine; //if printing one medicine
    private OtherProduct product; //if printing one product
    private Receipt receipt; //if printing one receipt
    private JTable table; //if printing any table

    //one Medicine
    public PrintWindow(ProductsWindow parent, Medicine medicine) {
        this.productsWindowParent = parent;
        this.medicine = medicine;

        //hiding parent until productsWindow is closed
        productsWindowParent.setVisible(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent windowEvent) {
                productsWindowParent.setVisible(true);
            }
        });

        commonConstructorActions();
        jLabelTitle.setText("Print " + medicine.getName());

        printOne(medicine);
    }

    //one OtherProduct
    public PrintWindow(ProductsWindow parent, OtherProduct product) {
        this.productsWindowParent = parent;
        this.product = product;

        //hiding parent until productsWindow is closed
        productsWindowParent.setVisible(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent windowEvent) {
                productsWindowParent.setVisible(true);
            }
        });

        commonConstructorActions();
        jLabelTitle.setText("Print " + product.getName());

        printOne(product);
    }

    //a table from ProductsWindow
    public PrintWindow(ProductsWindow parent, JTable table) {
        this.productsWindowParent = parent;
        this.table = table;

        //hiding parent until productsWindow is closed
        productsWindowParent.setVisible(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent windowEvent) {
                productsWindowParent.setVisible(true);
            }
        });

        commonConstructorActions();
        jLabelTitle.setText("Print Multiple Products");

        printTable(table);
    }

    //one Receipt
    public PrintWindow(ReceiptsWindow parent, Receipt receipt) {
        this.receiptsWindowParent = parent;
        this.receipt = receipt;

        //hiding parent until productsWindow is closed
        receiptsWindowParent.setVisible(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent windowEvent) {
                receiptsWindowParent.setVisible(true);
            }
        });

        commonConstructorActions();
        jLabelTitle.setText("Print Receipt Number " + receipt.getId());
        printOne(receipt);
    }

    //table of receipts
    public PrintWindow(ReceiptsWindow parent, JTable table) {
        this.receiptsWindowParent = parent;
        this.table = table;

        //hiding parent until productsWindow is closed
        receiptsWindowParent.setVisible(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent windowEvent) {
                receiptsWindowParent.setVisible(true);
            }
        });

        commonConstructorActions();
        jLabelTitle.setText("Print Multiple Receipts");

        printTable(table);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jPanelButtons = new javax.swing.JPanel();
        jLabelBack = new javax.swing.JLabel();
        jButtonPrint = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jPanelTitle = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jPanelContent = new javax.swing.JPanel();
        jScrollPaneContent = new javax.swing.JScrollPane();
        jPanelInnerContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBackMouseClicked(evt);
            }
        });

        jButtonPrint.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonPrint.setText("Print");
        jButtonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintActionPerformed(evt);
            }
        });

        jButtonCancel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelButtonsLayout = new javax.swing.GroupLayout(jPanelButtons);
        jPanelButtons.setLayout(jPanelButtonsLayout);
        jPanelButtonsLayout.setHorizontalGroup(
            jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBack, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                .addComponent(jButtonPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCancel)
                .addContainerGap())
        );

        jPanelButtonsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonCancel, jButtonPrint});

        jPanelButtonsLayout.setVerticalGroup(
            jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelButtonsLayout.createSequentialGroup()
                .addGroup(jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelBack, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelButtonsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonCancel, jButtonPrint, jLabelBack});

        jLabelTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("Print X");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelInnerContent.setLayout(new java.awt.GridLayout());
        jScrollPaneContent.setViewportView(jPanelInnerContent);

        javax.swing.GroupLayout jPanelContentLayout = new javax.swing.GroupLayout(jPanelContent);
        jPanelContent.setLayout(jPanelContentLayout);
        jPanelContentLayout.setHorizontalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneContent)
                .addContainerGap())
        );
        jPanelContentLayout.setVerticalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneContent, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
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
                    .addComponent(jPanelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void commonConstructorActions() {

        initComponents();
        jLabelBack.setIcon(new ImageIcon(Window.backIconLocation));

    }

    private void jButtonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Please connect a printer.\nThis feature is not implemented yet!", "Error!", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButtonPrintActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jLabelBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBackMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabelBackMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonPrint;
    private javax.swing.JLabel jLabelBack;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanelButtons;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JPanel jPanelInnerContent;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelTitle;
    private javax.swing.JScrollPane jScrollPaneContent;
    // End of variables declaration//GEN-END:variables

    @Override
    public void printOne(Medicine medicine) {
        JLabel id = new JLabel("ID: " + Integer.toString(medicine.getId()), SwingConstants.CENTER);
        JLabel stock = new JLabel("Stock: " + Integer.toString(medicine.getStock()), SwingConstants.CENTER);
        JLabel serialNumber = new JLabel("Serial Number: " + Integer.toString(medicine.getSerialNumber()), SwingConstants.CENTER);
        JLabel name = new JLabel("Name: " + medicine.getName(), SwingConstants.CENTER);
        JLabel activeSub = new JLabel("Active Substance: " + medicine.getActiveSub(), SwingConstants.CENTER);
        JLabel location = new JLabel("Location: " + medicine.getLocation(), SwingConstants.CENTER);
        JLabel imageLocation = new JLabel("Image: " + medicine.getImageLocation(), SwingConstants.CENTER);
        JLabel dose = new JLabel("Dose: " + Double.toString(medicine.getDose()), SwingConstants.CENTER);
        JLabel price = new JLabel("Price: " + Double.toString(medicine.getPrice()), SwingConstants.CENTER);

        id.setFont(new Font("Serif", Font.BOLD, 18));
        stock.setFont(new Font("Serif", Font.BOLD, 18));
        serialNumber.setFont(new Font("Serif", Font.BOLD, 18));
        name.setFont(new Font("Serif", Font.BOLD, 18));
        activeSub.setFont(new Font("Serif", Font.BOLD, 18));
        location.setFont(new Font("Serif", Font.BOLD, 18));
        imageLocation.setFont(new Font("Serif", Font.BOLD, 18));
        dose.setFont(new Font("Serif", Font.BOLD, 18));
        price.setFont(new Font("Serif", Font.BOLD, 18));

        imageLocation.setIcon(new ImageIcon(imageLocation.getText()));

        JPanel p = new JPanel(new GridLayout(9, 1));
        JLabel[] form = new JLabel[]{id, stock, serialNumber, name, activeSub, location, imageLocation, dose, price};
        for (JLabel o : form) {
            p.add(o);
        }
        p.setBackground(Color.white);
        jPanelInnerContent.add(p);
        this.pack();

    }

    @Override
    public void printOne(OtherProduct product) {
        JLabel id = new JLabel("ID: " + Integer.toString(product.getId()), SwingConstants.CENTER);
        JLabel stock = new JLabel("Stock: " + Integer.toString(product.getStock()), SwingConstants.CENTER);
        JLabel serialNumber = new JLabel("Serial Number: " + Integer.toString(product.getSerialNumber()), SwingConstants.CENTER);
        JLabel name = new JLabel("Name: " + product.getName(), SwingConstants.CENTER);
        JLabel description = new JLabel("Description: " + product.getDescription(), SwingConstants.CENTER);
        JLabel imageLocation = new JLabel("Image: " + product.getImageLocation(), SwingConstants.CENTER);
        JLabel price = new JLabel("Price: " + Double.toString(product.getPrice()), SwingConstants.CENTER);

        id.setFont(new Font("Serif", Font.BOLD, 18));
        stock.setFont(new Font("Serif", Font.BOLD, 18));
        serialNumber.setFont(new Font("Serif", Font.BOLD, 18));
        name.setFont(new Font("Serif", Font.BOLD, 18));
        description.setFont(new Font("Serif", Font.BOLD, 18));
        imageLocation.setFont(new Font("Serif", Font.BOLD, 18));
        price.setFont(new Font("Serif", Font.BOLD, 18));

        imageLocation.setIcon(new ImageIcon(imageLocation.getText()));

        JPanel p = new JPanel(new GridLayout(9, 1));
        JLabel[] form = new JLabel[]{id, stock, serialNumber, name, imageLocation, description, price};
        for (JLabel o : form) {
            p.add(o);
        }
        p.setBackground(Color.white);
        jPanelInnerContent.add(p);
        this.pack();
    }

    @Override
    public void printOne(Receipt receipt) {
        JLabel id = new JLabel("ID: " + Integer.toString(receipt.getId()), SwingConstants.CENTER);
        JLabel numberOfItems = new JLabel("Number of items: " + Integer.toString(receipt.getNumberOfItems()), SwingConstants.CENTER);
        JLabel total = new JLabel("Total: " + Double.toString(receipt.getTotal()), SwingConstants.CENTER);
        SimpleDateFormat simpleDateFormatter = new SimpleDateFormat(dateFormat);
        JLabel date = new JLabel("Date: " + simpleDateFormatter.format(receipt.getDate()), SwingConstants.CENTER);
        JLabel customerName = new JLabel("Customer name: " + receipt.getCustomerName(), SwingConstants.CENTER);
        JLabel items = new JLabel("Items: " + receipt.getDbItemsString(), SwingConstants.CENTER);

        id.setFont(new Font("Serif", Font.BOLD, 18));
        numberOfItems.setFont(new Font("Serif", Font.BOLD, 18));
        total.setFont(new Font("Serif", Font.BOLD, 18));
        date.setFont(new Font("Serif", Font.BOLD, 18));
        customerName.setFont(new Font("Serif", Font.BOLD, 18));
        items.setFont(new Font("Serif", Font.BOLD, 18));

        JPanel p = new JPanel(new GridLayout(9, 1));
        JLabel[] form = new JLabel[]{id, date, customerName, numberOfItems, total, items};
        for (JLabel o : form) {
            p.add(o);
        }
        p.setBackground(Color.white);
        jPanelInnerContent.add(p);
        this.pack();

    }

    @Override
    public void printTable(JTable table) {
        jScrollPaneContent.getViewport().add(table);
    }
}
