package Client;

import static Client.HomePage.CT;
import static Client.HomePage.CTRT;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
/*
 *
 * @author Pranjal
 */
public class Cart extends JFrame 
{
    public static PaymentGateway PG;

    public void refresh() 
    {
        DefaultTableModel Moodle = new DefaultTableModel(new Object[][]{}, new String[]{"Date", "Pid", "Image", "Description", "MFG", "Type", "Quant", "Cost", "Company", "Time"}) {
            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                if (columnIndex == 2) {
                    return ImageIcon.class;
                } else {
                    return types[columnIndex];
                }
            }

            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        HomePage.CTRT.CD.setModel(Moodle);
        HomePage.CTRT.CD.setColumnSelectionAllowed(false);
        HomePage.CTRT.CD.setName("");
        HomePage.CTRT.CD.setRowHeight(200);
        HomePage.CTRT.CD.setRowMargin(2);
        HomePage.CTRT.CD.setBackground(new java.awt.Color(204, 255, 204));
        HomePage.CTRT.CD.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 3, true));
        HomePage.CTRT.CD.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        HomePage.CTRT.CD.setForeground(new java.awt.Color(51, 51, 255));
        HomePage.CTRT.CD.setSelectionBackground(new java.awt.Color(0, 255, 255));
        HomePage.CTRT.CD.setSelectionForeground(new java.awt.Color(255, 0, 0));
        HomePage.CTRT.CD.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        HomePage.CTRT.ScrollPane1.setViewportView(HomePage.CTRT.CD);
        HomePage.CTRT.CD.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (HomePage.CTRT.CD.getColumnModel().getColumnCount() > 0) {
            HomePage.CTRT.CD.getColumnModel().getColumn(0).setPreferredWidth(20);
            HomePage.CTRT.CD.getColumnModel().getColumn(1).setPreferredWidth(10);
            HomePage.CTRT.CD.getColumnModel().getColumn(2).setPreferredWidth(200);
            HomePage.CTRT.CD.getColumnModel().getColumn(3).setPreferredWidth(100);
            HomePage.CTRT.CD.getColumnModel().getColumn(4).setPreferredWidth(10);
            HomePage.CTRT.CD.getColumnModel().getColumn(5).setPreferredWidth(10);
            HomePage.CTRT.CD.getColumnModel().getColumn(6).setPreferredWidth(10);
            HomePage.CTRT.CD.getColumnModel().getColumn(7).setPreferredWidth(10);
            HomePage.CTRT.CD.getColumnModel().getColumn(8).setPreferredWidth(10);
            HomePage.CTRT.CD.getColumnModel().getColumn(9).setPreferredWidth(10);
        }

        int i;
        for (i = 0; i < HomePage.CT.size(); i++) {
            ImageIcon image = null;
            Image newimg = CT.get(i).img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            image = new ImageIcon(newimg);
            Moodle.addRow(new Object[]{CT.get(i).Date, CT.get(i).pid, image, CT.get(i).Desc, CT.get(i).MFG, CT.get(i).pname, CT.get(i).Quant, CT.get(i).Cost, CT.get(i).Comp, CT.get(i).Time});
            // System.out.println("All the Data of "+" th electronics product added in the table ");     
        }

    }

    public Cart() {
        initComponents();
        PG = new PaymentGateway();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ScrollPane1 = new javax.swing.JScrollPane();
        CD = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        CD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CDMouseClicked(evt);
            }
        });
        ScrollPane1.setViewportView(CD);

        jButton1.setText("PROCEED  TO  BUY");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("DELETE  ITEM");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1296, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(235, 235, 235))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(ScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int ind = CD.getSelectedRow();
        HomePage.CT.remove(ind);
        refresh();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void CDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CDMouseClicked
        int ind = CD.getSelectedRow();
        System.out.println(ind);
    }//GEN-LAST:event_CDMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        float TotalCst = 0,indCst;
        DefaultTableModel Moodle = new DefaultTableModel(new Object[][]{}, new String[]{"Date", "Pid", "Image", "Description", "MFG", "Type", "Quant", "Cost", "Company", "Time"}) {
            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                if (columnIndex == 2) {
                    return ImageIcon.class;
                } else {
                    return types[columnIndex];
                }
            }

            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        System.out.println("Model Crated for PaymentGateWay.");
        PG.CD.setModel(Moodle);
        PG.CD.setColumnSelectionAllowed(false);
        PG.CD.setName("");
        PG.CD.setRowHeight(200);
        PG.CD.setRowMargin(2);
        PG.CD.setBackground(new java.awt.Color(204, 255, 204));
        PG.CD.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 3, true));
        PG.CD.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        PG.CD.setForeground(new java.awt.Color(51, 51, 255));
        PG.CD.setSelectionBackground(new java.awt.Color(0, 255, 255));
        PG.CD.setSelectionForeground(new java.awt.Color(255, 0, 0));
        PG.CD.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        PG.jScrollPane3.setViewportView(CTRT.CD);
        PG.CD.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        
        if(PG.CD.getColumnModel().getColumnCount() > 0) {
            PG.CD.getColumnModel().getColumn(0).setPreferredWidth(20);
            PG.CD.getColumnModel().getColumn(1).setPreferredWidth(10);
            PG.CD.getColumnModel().getColumn(2).setPreferredWidth(200);
            PG.CD.getColumnModel().getColumn(3).setPreferredWidth(100);
            PG.CD.getColumnModel().getColumn(4).setPreferredWidth(10);
            PG.CD.getColumnModel().getColumn(5).setPreferredWidth(10);
            PG.CD.getColumnModel().getColumn(6).setPreferredWidth(10);
            PG.CD.getColumnModel().getColumn(7).setPreferredWidth(10);
            PG.CD.getColumnModel().getColumn(8).setPreferredWidth(10);
            PG.CD.getColumnModel().getColumn(9).setPreferredWidth(10);
        }
        int i;
        System.out.println("Going to add row to PaymntGateway");
        for (i = 0; i < HomePage.CT.size(); i++) 
        {
            ImageIcon image = null;

            Image newimg = CT.get(i).img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            image = new ImageIcon(newimg);
            System.out.println("All preparations for Image HAs been Done");
            Moodle.addRow(new Object[]{CT.get(i).Date, CT.get(i).pid, image, CT.get(i).Desc, CT.get(i).MFG, CT.get(i).pname, CT.get(i).Quant, CT.get(i).Cost, CT.get(i).Comp, CT.get(i).Time});
            System.out.println("Row added to PaymentGateway.");
            indCst=Float.parseFloat(CT.get(i).Cost);
            TotalCst+=(indCst*((float)CT.get(i).Quant));
            System.out.println("TotalCst Added and Incremented.");
        }
        PG.TCst.setText(TotalCst + "");
        PG.TCst.setEditable(false);
        PG.Address.append("Address : ");
        PG.Address.append(SL.UserAddress);
        PG.Address.setEditable(false);
        PG.Address.setVisible(false);
        PG.ModifyAddress.setVisible(false);
        PG.SaveAddress.setVisible(false);
        PG.pack();
        PG.setDefaultCloseOperation(HIDE_ON_CLOSE);
        System.out.println("Going to call Main Func");
        MAIN();
        HomePage.CTRT.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void MAIN() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PaymentGateway.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentGateway.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentGateway.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentGateway.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PG.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable CD;
    public javax.swing.JScrollPane ScrollPane1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
