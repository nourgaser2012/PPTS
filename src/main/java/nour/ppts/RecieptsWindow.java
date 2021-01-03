//ESLAM MAGDY'S TASK

//should have a table which reads and displays all the Reciepts from the database 
//(or the AllReciepts ArrayList from the class Reciepts)

//it should also have a print button which open a PrintRecieptWindow if one reciept is selected from the table
//or a PrintRecieptsListWindow is multiple reciepts are selected.

//should also have a button to open a GenerateRecieptWindow, and a close button.

package nour.ppts;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RecieptsWindow extends Window {

    private MainWindow parent;

    public RecieptsWindow(MainWindow parent) {

        this.parent = parent;
        //hiding parent until productsWindow is closed
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent windowEvent) {
                parent.setVisible(true);
            }
        });
        initComponents();
        parent.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jButtonNewReciept = new javax.swing.JButton();
        jButtonPrint = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonNewReciept.setText("New Reciept");
        jButtonNewReciept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewRecieptActionPerformed(evt);
            }
        });

        jButtonPrint.setText("Print");
        jButtonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("ESLAM MAGDY'S TASK (Delete this)");

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                .addContainerGap(203, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185))
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(jButtonNewReciept)
                .addGap(53, 53, 53)
                .addComponent(jButtonPrint)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNewReciept)
                    .addComponent(jButtonPrint))
                .addContainerGap(177, Short.MAX_VALUE))
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

    private void jButtonNewRecieptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewRecieptActionPerformed
        // TODO add your handling code here:
        GenerateRecieptWindow w = new GenerateRecieptWindow(this);
    }//GEN-LAST:event_jButtonNewRecieptActionPerformed

    private void jButtonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintActionPerformed
        // TODO add your handling code here:
        //if only one reciepts selected from the table create a PrintRecieptWindow, if multiple reciepts are selected create
        //a PrintRecieptListWindow
        int numOfSelectedReciepts = 1; //temporary until table is created
        if (numOfSelectedReciepts == 1) {
            PrintRecieptWindow w = new PrintRecieptWindow(this);
        } else if (numOfSelectedReciepts > 1) {
            PrintRecieptListWindow w = new PrintRecieptListWindow(this);
        }
        else;
    }//GEN-LAST:event_jButtonPrintActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonNewReciept;
    private javax.swing.JButton jButtonPrint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelMain;
    // End of variables declaration//GEN-END:variables
}
//ESLAM MAGDY'S TASK
