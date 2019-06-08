package Client;

import ClientDatabase.Database;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PaymentGateway extends javax.swing.JFrame 
{
    private static Receipt rcpt=null;
    private static Database cdb=null;
    private int port=9876;
    private String IP="127.0.0.1";
    public PaymentGateway()
    {
        initComponents();
        rcpt=new Receipt();
            try 
            {
                cdb=new Database();
            }
            catch (Exception ex) 
            {
                System.out.println("Error in Payment Gateway while making object of Client Database to  hold User records");
            }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        CD = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        TCst = new javax.swing.JTextField();
        cancel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        COD = new javax.swing.JRadioButton();
        CDP = new javax.swing.JRadioButton();
        NTB = new javax.swing.JRadioButton();
        proceed = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Address = new javax.swing.JTextArea();
        ModifyAddress = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        SaveAddress = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        CD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(CD);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 48)); // NOI18N
        jLabel1.setText("Total Cost");

        cancel.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        cancel.setText("Cancel Order");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        buttonGroup1.add(COD);
        COD.setText("Cash on Delivery");
        COD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CODActionPerformed(evt);
            }
        });

        buttonGroup1.add(CDP);
        CDP.setText("Card Payment");

        buttonGroup1.add(NTB);
        NTB.setText("Net Banking");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NTB)
                    .addComponent(CDP)
                    .addComponent(COD))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(COD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CDP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NTB)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        proceed.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        proceed.setText("Proceed");
        proceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedActionPerformed(evt);
            }
        });

        Address.setEditable(false);
        Address.setColumns(20);
        Address.setRows(5);
        Address.setText("\n\n");
        jScrollPane1.setViewportView(Address);

        ModifyAddress.setText("Modify Address");
        ModifyAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifyAddressActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        SaveAddress.setText("SaveAddress");
        SaveAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveAddressActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(TCst, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(proceed, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(95, 95, 95))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(SaveAddress)
                                .addGap(32, 32, 32))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(ModifyAddress)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(TCst, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(proceed, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(ModifyAddress)
                        .addGap(18, 18, 18)
                        .addComponent(SaveAddress)
                        .addGap(27, 27, 27))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void proceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceedActionPerformed
    if(COD.isSelected())
    {
        cdb.updateTotalPurchase(TCst.getText());
        int i;
        for(i=0;i<HomePage.CT.size();i++)
        {
            try 
            {
                cdb.addTransactionData(HomePage.CT.get(i));
            }
            catch(Exception ex)
            {
                System.out.println("Error in Payment Gateway Class in proceed button action performed");
            }
        }
     /*   Socket S=null;
        DataInputStream din=null;
        DataOutputStream dout=null;
        System.out.println("Sockets Initialise in Transactio Gatgeway CALss.");
        try 
        { 
            S=new Socket(IP,port);
            din=new DataInputStream(S.getInputStream());
            dout=new DataOutputStream(S.getOutputStream());
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        try
        {
            dout.writeUTF(SL.unm);
            dout.flush();
            dout.writeUTF(SL.passd);
            dout.flush();
            System.out.println("UserName And Password Is sent to Server from PaymentGateWay");
        }
        catch(Exception e)
        {
            System.out.println("Error in sending UserName And Password Is sent to Server from PaymentGateWay");
        }
        System.out.println("Username and passd sent to server");
        for(i=0;i<HomePage.CT.size();i++)
        {
            try 
            {
                dout.writeUTF("true");
                dout.flush();
                dout.writeInt(HomePage.CT.get(i).Day);
                dout.flush();
                dout.writeUTF(HomePage.CT.get(i).Month);
                dout.flush();
                dout.writeInt(HomePage.CT.get(i).Year);
                dout.flush();
                dout.writeUTF(HomePage.CT.get(i).Time);
                dout.flush();
                dout.writeInt(HomePage.CT.get(i).pid);
                dout.flush();
                dout.writeInt(HomePage.CT.get(i).imgbyte.length);
                dout.flush();
                System.out.println("Image length bytes is  flushed");
                dout.write(HomePage.CT.get(i).imgbyte, 0, HomePage.CT.get(i).imgbyte.length);
                dout.flush();
                dout.writeUTF(HomePage.CT.get(i).Desc);
                dout.flush();
                dout.writeUTF(HomePage.CT.get(i).MFG);
                dout.flush();
                dout.writeUTF(HomePage.CT.get(i).type);
                dout.flush();
                dout.writeInt(HomePage.CT.get(i).Quant);
                dout.flush();
                dout.writeUTF(HomePage.CT.get(i).Cost);
                dout.flush();
                dout.writeUTF(HomePage.CT.get(i).Comp);
                dout.flush();
                System.out.println("Data sent");
            }
            catch(Exception ex) 
            {
                System.out.println("Error in Payment Gateway Class in proceed button action performed");
            }
        }
        try
        {
            dout.writeUTF("false");
            dout.flush();
        }
        catch(Exception e)
        {
            System.out.println("Error In payment GateWay in cod payment style block in sending transaction history to server");
        }
        System.out.println("Complete Data Sent");*/
        cdb.deleteAllTempCart();
        HomePage.CT.clear();
        rcpt.receit.setEnabledAt(1,false);
        rcpt.receit.setEnabledAt(2,false);
        rcpt.setDefaultCloseOperation(HIDE_ON_CLOSE);
        close();
    rcpt.setVisible(true);        
}
else
if(CDP.isSelected())
{
    cdb.updateTotalPurchase(TCst.getText());
        System.out.println("Updated Total Purchase amount in totalPurchaseAmount");
        int i;
        for(i=0;i<HomePage.CT.size();i++)
        {
            try 
            {
                cdb.addTransactionData(HomePage.CT.get(i));
            }
            catch(Exception ex) 
            {
                System.out.println("Error in Payment Gateway Class in proceed button action performed");
            }
        }
     /*    Socket S=null;
        DataInputStream din=null;
        DataOutputStream dout=null;
        System.out.println("Sockets Initialise in Transactio Gatgeway CALss.");
        try 
        { 
            S=new Socket(IP,port);
            din=new DataInputStream(S.getInputStream());
            dout=new DataOutputStream(S.getOutputStream());
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        try
        {
            dout.writeUTF(SL.unm);
            dout.flush();
            dout.writeUTF(SL.passd);
            dout.flush();
            System.out.println("UserName And Password Is sent to Server from PaymentGateWay");
        }
        catch(Exception e)
        {
            System.out.println("Error in sending UserName And Password Is sent to Server from PaymentGateWay");
        }
        System.out.println("Username and passd sent to server");
        for(i=0;i<HomePage.CT.size();i++)
        {
            try 
            {
                dout.writeUTF("true");
                dout.flush();
                dout.writeInt(HomePage.CT.get(i).Day);
                dout.flush();
                dout.writeUTF(HomePage.CT.get(i).Month);
                dout.flush();
                dout.writeInt(HomePage.CT.get(i).Year);
                dout.flush();
                dout.writeUTF(HomePage.CT.get(i).Time);
                dout.flush();
                dout.writeInt(HomePage.CT.get(i).pid);
                dout.flush();
                dout.writeInt(HomePage.CT.get(i).imgbyte.length);
                dout.flush();
                System.out.println("Image length bytes is  flushed");
                dout.write(HomePage.CT.get(i).imgbyte, 0, HomePage.CT.get(i).imgbyte.length);
                dout.flush();
                dout.writeUTF(HomePage.CT.get(i).Desc);
                dout.flush();
                dout.writeUTF(HomePage.CT.get(i).MFG);
                dout.flush();
                dout.writeUTF(HomePage.CT.get(i).type);
                dout.flush();
                dout.writeInt(HomePage.CT.get(i).Quant);
                dout.flush();
                dout.writeUTF(HomePage.CT.get(i).Cost);
                dout.flush();
                dout.writeUTF(HomePage.CT.get(i).Comp);
                dout.flush();
                System.out.println("Data sent");
            }
            catch(Exception ex) 
            {
                System.out.println("Error in Payment Gateway Class in proceed button action performed");
            }
        }
        try
        {
            dout.writeUTF("false");
            dout.flush();
        }
        catch(Exception e)
        {
            System.out.println("Error In payment GateWay in cdp payment style block in sending transaction history to server");
        }
        System.out.println("Complete Data Sent");*/
        cdb.deleteAllTempCart();
        //close();
        HomePage.CT.clear();
    rcpt.receit.setEnabledAt(0,false);
    rcpt.receit.setEnabledAt(1,false);
    //Cart.PG.setVisible(false);
    close();
    rcpt.setVisible(true); 
}   
else
if(NTB.isSelected())
{
    cdb.updateTotalPurchase(TCst.getText());
        System.out.println("Updated Total Purchase amount in totalPurchaseAmount");
        int i;
        for(i=0;i<HomePage.CT.size();i++)
        {
            try 
            {
                cdb.addTransactionData(HomePage.CT.get(i));
            }
            catch(Exception ex) 
            {
                System.out.println("Error in Payment Gateway Class in proceed button action performed");
            }
        }
      /*   Socket S=null;
        DataInputStream din=null;
        DataOutputStream dout=null;
        System.out.println("Sockets Initialise in Transactio Gatgeway CALss.");
        try 
        { 
            S=new Socket(IP,port);
            din=new DataInputStream(S.getInputStream());
            dout=new DataOutputStream(S.getOutputStream());
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        try
        {
            dout.writeUTF(SL.unm);
            dout.flush();
            dout.writeUTF(SL.passd);
            dout.flush();
            System.out.println("UserName And Password Is sent to Server from PaymentGateWay");
        }
        catch(Exception e)
        {
            System.out.println("Error in sending UserName And Password Is sent to Server from PaymentGateWay");
        }
        System.out.println("Username and passd sent to server");
        for(i=0;i<HomePage.CT.size();i++)
        {
            try 
            {
                dout.writeUTF("true");
                dout.flush();
                dout.writeInt(HomePage.CT.get(i).Day);
                dout.flush();
                dout.writeUTF(HomePage.CT.get(i).Month);
                dout.flush();
                dout.writeInt(HomePage.CT.get(i).Year);
                dout.flush();
                dout.writeUTF(HomePage.CT.get(i).Time);
                dout.flush();
                dout.writeInt(HomePage.CT.get(i).pid);
                dout.flush();
                dout.writeInt(HomePage.CT.get(i).imgbyte.length);
                dout.flush();
                System.out.println("Image length bytes is  flushed");
                dout.write(HomePage.CT.get(i).imgbyte, 0, HomePage.CT.get(i).imgbyte.length);
                dout.flush();
                dout.writeUTF(HomePage.CT.get(i).Desc);
                dout.flush();
                dout.writeUTF(HomePage.CT.get(i).MFG);
                dout.flush();
                dout.writeUTF(HomePage.CT.get(i).type);
                dout.flush();
                dout.writeInt(HomePage.CT.get(i).Quant);
                dout.flush();
                dout.writeUTF(HomePage.CT.get(i).Cost);
                dout.flush();
                dout.writeUTF(HomePage.CT.get(i).Comp);
                dout.flush();
                System.out.println("Data sent");
            }
            catch(Exception ex) 
            {
                System.out.println("Error in Payment Gateway Class in proceed button action performed");
            }
        }
        try
        {
            dout.writeUTF("false");
            dout.flush();
        }
        catch(Exception e)
        {
            System.out.println("Error In payment GateWay in ntb payment style block in sending transaction history to server");
        }
        System.out.println("Complete Data Sent");*/
        cdb.deleteAllTempCart();
        //close();
        HomePage.CT.clear();
    rcpt.receit.setEnabledAt(0,false);
    rcpt.receit.setEnabledAt(2,false);
   // Cart.PG.setVisible(false);
   close();
    rcpt.setVisible(true); 
}  
else
{
    JOptionPane.showMessageDialog(null,"Please Select One of the CheckBoxes");
}
    }//GEN-LAST:event_proceedActionPerformed

    private void ModifyAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifyAddressActionPerformed
        Address.setEditable(true);
    }//GEN-LAST:event_ModifyAddressActionPerformed

    private void SaveAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveAddressActionPerformed
        Address.setEditable(false);
    }//GEN-LAST:event_SaveAddressActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        HomePage.CTRT.setVisible(true);
    }//GEN-LAST:event_formWindowClosed
public void close()
 {
     WindowEvent winevt=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
     Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winevt);
 }
    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
                cdb.deleteAllTempCart();
                int i;
                for(i=0;i<HomePage.CT.size();i++)
                {
                    try 
                    {
                        cdb.addTempCartData(HomePage.CT.get(i)/*.pid,HomePage.CT.get(i).pname,HomePage.CT.get(i).Date,HomePage.CT.get(i).Time,HomePage.CT.get(i).Comp,HomePage.CT.get(i).Desc,HomePage.CT.get(i).MFG,HomePage.CT.get(i).Cost,HomePage.CT.get(i).Quant,HomePage.CT.get(i).imgbyte*/);
                    } 
                    catch (ClassNotFoundException ex) {
                        System.out.println("Error in Payment Gteway CAl  in cancel Button Action event performed");
                    }
                }
                close();
               // HomePage.CT.clear();
    }//GEN-LAST:event_cancelActionPerformed

    private void CODActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CODActionPerformed
       if(COD.isSelected())
       {
           Address.setVisible(true);
        ModifyAddress.setVisible(true);
        SaveAddress.setVisible(true);
       }
    }//GEN-LAST:event_CODActionPerformed
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextArea Address;
    public javax.swing.JTable CD;
    private javax.swing.JRadioButton CDP;
    private javax.swing.JRadioButton COD;
    public javax.swing.JButton ModifyAddress;
    private javax.swing.JRadioButton NTB;
    public javax.swing.JButton SaveAddress;
    public javax.swing.JTextField TCst;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JButton proceed;
    // End of variables declaration//GEN-END:variables
}
