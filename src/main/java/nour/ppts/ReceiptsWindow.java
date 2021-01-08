//ESLAM MAGDY'S TASK
//should have a table which reads and displays all the Receipts from the database 
//(or the AllReceipts ArrayList from the class Receipts)
//it should also have a print button which open a PrintReceiptWindow if one receipt is selected from the table
//or a PrintReceiptsListWindow is multiple receipts are selected.
//should also have a button to open a GenerateReceiptWindow, and a close button.
package nour.ppts;

import java.util.ArrayList;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class ReceiptsWindow extends Window {

    private MainWindow parent;
    private static final String[] tableColumns = {"ID", "Date", "Customer Name", "Number Of Items", "Total (EGP)", "Items"};

    public ReceiptsWindow(MainWindow parent) {

        this.parent = parent;
        //hiding parent until productsWindow is closed
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent windowEvent) {
                parent.setVisible(true);
            }
        });

        tableModel = initTableModel(tableColumns);
        initComponents();

        jTableReceipts.setDefaultEditor(Object.class, null);

        addToTable(Receipt.allReceipts);

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

        parent.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jPanelBottom = new javax.swing.JPanel();
        jButtonDelete = new javax.swing.JButton();
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonGenerateReceipt = new javax.swing.JButton();
        jButtonPrint = new javax.swing.JButton();
        jPanelMiddle = new javax.swing.JPanel();
        jTabbedPane = new javax.swing.JTabbedPane();
        jScrollPaneReciepts = new javax.swing.JScrollPane();
        jTableReceipts = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonDelete.setText("Delete Receipt");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jTextFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchActionPerformed(evt);
            }
        });

        jButtonGenerateReceipt.setText("New Reciept");
        jButtonGenerateReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerateReceiptActionPerformed(evt);
            }
        });

        jButtonPrint.setText("Print");
        jButtonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBottomLayout = new javax.swing.GroupLayout(jPanelBottom);
        jPanelBottom.setLayout(jPanelBottomLayout);
        jPanelBottomLayout.setHorizontalGroup(
            jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBottomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonGenerateReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelBottomLayout.setVerticalGroup(
            jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBottomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGenerateReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPrint))
                .addContainerGap())
        );

        jPanelBottomLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonDelete, jButtonGenerateReceipt, jButtonPrint, jTextFieldSearch});

        jTabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jTableReceipts.setAutoCreateRowSorter(true);
        jTableReceipts.setModel(tableModel);
        jTableReceipts.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPaneReciepts.setViewportView(jTableReceipts);

        jTabbedPane.addTab("Receipts", jScrollPaneReciepts);

        javax.swing.GroupLayout jPanelMiddleLayout = new javax.swing.GroupLayout(jPanelMiddle);
        jPanelMiddle.setLayout(jPanelMiddleLayout);
        jPanelMiddleLayout.setHorizontalGroup(
            jPanelMiddleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMiddleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane)
                .addContainerGap())
        );
        jPanelMiddleLayout.setVerticalGroup(
            jPanelMiddleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMiddleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelMiddle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelMiddle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private DefaultTableModel initTableModel(String[] columns) {
        DefaultTableModel model = new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                columns
        );
        return model;
    }

    public void refreshTable() throws SQLException {
        tableModel = initTableModel(tableColumns);
        addToTable(Receipt.allReceipts);
        jTableReceipts.setModel(tableModel);
    }

    //add an ArrayList of Receipt
    private void addToTable(ArrayList<Receipt> receipts) {
        for (int i = 0; i < receipts.size(); i++) {
            String[] current = receipts.get(i).getDataArray();
            String[] temp = {current[0], current[1], current[2], current[3], current[4], current[5]};
            tableModel.addRow(temp);
        }
    }

    //add one Receipt
    public void addToTable(Receipt receipt) {
        String[] current = receipt.getDataArray();
        String[] temp = {current[0], current[1], current[2], current[3], current[4], current[5]};
        tableModel.addColumn(temp);
    }

    //remove one Receipt
    public void removeReceipt(int id) throws SQLException {
        Database.remove("receipts", id);
    }

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        try {
            int[] indexes = jTableReceipts.getSelectedRows();
            for (int index : indexes) {
                int id = Integer.parseInt(tableModel.getValueAt(index, 0).toString());
                removeReceipt(id);
                refreshTable();
            }
        } catch (SQLException | ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Failed to remove:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jTextFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchActionPerformed
        // TODO add your handling code here:
        String search = jTextFieldSearch.getText();
        if (!jTextFieldSearch.getText().isEmpty()) {
            DefaultTableModel newModel = initTableModel(tableColumns);
            for (Vector v : tableModel.getDataVector()) {
                if (v.get(0).equals(search) || v.get(v.size() - 1).toString().contains(search) || v.get(1).toString().contains(search) || v.get(2).toString().contains(search)) {
                    newModel.addRow(v);
                }
            }
            jTableReceipts.setModel(newModel);
        } else {
            jTableReceipts.setModel(tableModel);
        }

    }//GEN-LAST:event_jTextFieldSearchActionPerformed

    private void jButtonGenerateReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateReceiptActionPerformed
        // TODO add your handling code here:
        GenerateReceiptWindow w = new GenerateReceiptWindow(this);
    }//GEN-LAST:event_jButtonGenerateReceiptActionPerformed

    private void jButtonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintActionPerformed
        // TODO add your handling code here:
        if (jTableReceipts.getSelectedRowCount() == 1) {
            int id = Integer.parseInt(tableModel.getValueAt(jTableReceipts.getSelectedRow(), 0).toString());
            for (Receipt receipt : Receipt.allReceipts) {
                if (receipt.getId() == id) {
                    PrintWindow w = new PrintWindow(this, receipt);
                    break;
                }
            }
        } else if (jTableReceipts.getSelectedRowCount() > 1) {
            DefaultTableModel newModel = initTableModel(tableColumns);
            int indexes[] = jTableReceipts.getSelectedRows();
            for (int index : indexes) {
                newModel.addRow(tableModel.getDataVector().get(index));
            }
            JTable newTable = new JTable(newModel);
            PrintWindow w = new PrintWindow(this, newTable);
        } else;
    }//GEN-LAST:event_jButtonPrintActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonGenerateReceipt;
    private javax.swing.JButton jButtonPrint;
    private javax.swing.JPanel jPanelBottom;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelMiddle;
    private javax.swing.JScrollPane jScrollPaneReciepts;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTableReceipts;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel tableModel;

    private void JOptionPane(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
//ESLAM MAGDY'S TASK
