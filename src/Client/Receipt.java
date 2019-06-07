package Client;

import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pranjal
 */
public class Receipt extends javax.swing.JFrame 
{
    public Receipt() 
    {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        receit = new javax.swing.JTabbedPane();
        Receipt = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Rct = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        netbanking = new javax.swing.JPanel();
        cardpayment = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Rct.setColumns(20);
        Rct.setRows(5);
        jScrollPane3.setViewportView(Rct);

        jButton1.setText("Print Receipt");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ReceiptLayout = new javax.swing.GroupLayout(Receipt);
        Receipt.setLayout(ReceiptLayout);
        ReceiptLayout.setHorizontalGroup(
            ReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReceiptLayout.createSequentialGroup()
                .addGroup(ReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ReceiptLayout.createSequentialGroup()
                        .addGap(548, 548, 548)
                        .addComponent(jButton1))
                    .addGroup(ReceiptLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(461, Short.MAX_VALUE))
        );
        ReceiptLayout.setVerticalGroup(
            ReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReceiptLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jButton1)
                .addContainerGap(153, Short.MAX_VALUE))
        );

        receit.addTab("Receipt", Receipt);

        javax.swing.GroupLayout netbankingLayout = new javax.swing.GroupLayout(netbanking);
        netbanking.setLayout(netbankingLayout);
        netbankingLayout.setHorizontalGroup(
            netbankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1616, Short.MAX_VALUE)
        );
        netbankingLayout.setVerticalGroup(
            netbankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 842, Short.MAX_VALUE)
        );

        receit.addTab("NetBanking", netbanking);

        javax.swing.GroupLayout cardpaymentLayout = new javax.swing.GroupLayout(cardpayment);
        cardpayment.setLayout(cardpaymentLayout);
        cardpaymentLayout.setHorizontalGroup(
            cardpaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1616, Short.MAX_VALUE)
        );
        cardpaymentLayout.setVerticalGroup(
            cardpaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 842, Short.MAX_VALUE)
        );

        receit.addTab("CardPayment", cardpayment);

        jScrollPane1.setViewportView(receit);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Rct.print();
        } catch (PrinterException ex) {
            Logger.getLogger(Receipt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Receipt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextArea Rct;
    public javax.swing.JPanel Receipt;
    public javax.swing.JPanel cardpayment;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JPanel netbanking;
    public javax.swing.JTabbedPane receit;
    // End of variables declaration//GEN-END:variables
}
