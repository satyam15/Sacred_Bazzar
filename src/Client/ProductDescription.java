package Client;

import static Client.HomePage.CT;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException; 
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Pranjal
 */
public class ProductDescription extends javax.swing.JFrame 
{
    public  byte[] imgByte=null;
    private DateFormat df=null;
    private Date  dateobj=null;
    private   DefaultTableModel Moodle=null;
    public ProductDescription() 
    {
        initComponents();
        df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
        dateobj = new Date();
        Moodle=new DefaultTableModel(new Object [][]{},new String [] {"DateTime","Pid","Image","Description","MFG", "Type", "Quant","Cost","Company"})
        {
        Class[] types = new Class [] 
        {
        java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
        };

        public Class getColumnClass(int columnIndex) 
        {
            if(columnIndex==2)
            {
                return ImageIcon.class;
            }
            else
            {
                return types [columnIndex];
            }
        }
        public boolean isCellEditable(int row, int col) 
        {
            return false;
        }
        };
    }
  /*  public boolean checkDuplicate()
    {
        System.out.println("Inside checkDuplicate Method of ProductDescription Class");
        int pid=Integer.parseInt(PID.getText());
        String date[]=df.format(dateobj).split(" ");
        int i;
        for(i=0;i<HomePage.CT.size();i++)
        {
            if(HomePage.CT.get(i).pid==pid&&HomePage.CT.get(i).Date==date[0]&&HomePage.CT.get(i).pname==HomePage.Dtp)
            {
                System.out.println("Got Dupliate in cart .");
                HomePage.CT.get(i).Quant+=(Integer.parseInt(Quant_ity.getText()));
                System.out.println("Added Quantity to the existing product in the Cart");
                return true;
            }
        }
        return false;
    }
    */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        img1 = new javax.swing.JLabel();
        img2 = new javax.swing.JLabel();
        img3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        desc = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        DESC = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        PID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        COMP = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        MFG = new javax.swing.JTextField();
        RATE = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        COST = new javax.swing.JTextField();
        atc = new javax.swing.JButton();
        bn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        Quant_ity = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Pname = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        img1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        img2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        img3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        desc.setColumns(20);
        desc.setRows(5);
        jScrollPane1.setViewportView(desc);

        jLabel1.setText("Reviews");

        DESC.setColumns(20);
        DESC.setRows(5);
        jScrollPane2.setViewportView(DESC);

        jLabel2.setText("Description");

        jLabel3.setText("Product ID");

        jLabel4.setText("Company");

        jLabel5.setText("MFG");

        jLabel6.setText("Ratings");

        jLabel7.setText("Cost");

        atc.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        atc.setForeground(new java.awt.Color(255, 0, 0));
        atc.setText("Add To Cart");
        atc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atcActionPerformed(evt);
            }
        });

        bn.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        bn.setForeground(new java.awt.Color(255, 51, 51));
        bn.setText("Buy Now");
        bn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnActionPerformed(evt);
            }
        });

        jLabel8.setText("Quantity");

        Quant_ity.setText("1");

        jLabel9.setText("P Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(img1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(img2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(img3, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Quant_ity, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                                .addGap(73, 73, 73)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(PID)
                                    .addComponent(COMP, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                                .addGap(100, 100, 100)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(MFG)
                                    .addComponent(RATE, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(COST, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Pname))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(315, 315, 315)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(atc)
                            .addComponent(bn))
                        .addGap(71, 71, 71))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(img1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .addComponent(img2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(img3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Quant_ity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MFG, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(COST, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(atc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(COMP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(RATE, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)
                                .addComponent(Pname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addComponent(bn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1215, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atcActionPerformed
       try 
        {
           // if(!checkDuplicate())
            //{
                ImageIcon Img=(ImageIcon)img1.getIcon();
                TRAC obj=new TRAC(); 
                String date[]=df.format(dateobj).split(" ");
                obj.Date=date[0];
              //  System.out.println();
                String myd[]=date[0].split("/");
                obj.Day=Integer.parseInt(myd[0]);
                obj.Year=Integer.parseInt(myd[2]);
                switch(myd[1])
                {
                    case "01":
                    {
                        obj.Month="January";
                        break;
                    }
                    case "02":
                    {
                        obj.Month="February";
                        break;
                    }
                    case "03":
                    {
                        obj.Month="March";
                        break;
                    }
                    case "04":
                    {
                        obj.Month="April";
                        break;
                    }
                    case "05":
                    {
                        obj.Month="May";
                        break;
                    }
                    case "06":
                    {
                        obj.Month="June";
                        break;
                    }
                     case "07":
                    {
                        obj.Month="July";
                        break;
                    }
                    case "08":
                    {
                        obj.Month="August";
                        break;
                    }
                    case "09":
                    {
                        obj.Month="September";
                        break;
                    }
                    case "10":
                    {
                        obj.Month="October";
                        break;
                    }
                    case "11":
                    {
                        obj.Month="November";
                        break;
                    }
                    case "12":
                    {
                        obj.Month="December";
                        break;
                    }
                }
                System.out.println("Date :"+obj.Date);
                obj.Time=date[1]+" "+date[2];
                System.out.println("Time :"+obj.Time);
                obj.img=Img.getImage();
                System.out.println("Image Added :"+obj.img);
                obj.Quant=Integer.parseInt(Quant_ity.getText());
                System.out.println("Quant :"+obj.Quant);
                obj.pid=Integer.parseInt(PID.getText());
                System.out.println("PID :"+obj.pid);
                obj.Comp=COMP.getText();
                System.out.println("Company :"+obj.Comp);
                obj.MFG=MFG.getText();
                System.out.println("MFG :"+obj.MFG);
                obj.Desc=DESC.getText();
                System.out.println("Description :"+obj.Desc);
                obj.type=Pname.getText();
                System.out.println("Type :"+obj.type);
                obj.Cost=COST.getText();
                System.out.println("Cost :"+obj.Cost);
              
                obj.imgbyte=imgByte;
                System.out.println("imgbyte Added");
                HomePage.CT.add(obj);
                System.out.println("Object Added");
          //  }
        } 
        catch (Exception ex) 
        {
            
        }
                
    }//GEN-LAST:event_atcActionPerformed

    private void bnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnActionPerformed

        try 
        {
          //  if(!checkDuplicate())
         //   {
                ImageIcon Img=(ImageIcon)img1.getIcon();
                TRAC obj=new TRAC(); 
                String date[]=df.format(dateobj).split(" ");
                obj.Date=date[0];
                String myd[]=date[0].split("/");
                obj.Day=Integer.parseInt(myd[0]);
                obj.Year=Integer.parseInt(myd[2]);
                switch(myd[1])
                {
                    case "01":
                    {
                        obj.Month="January";
                        break;
                    }
                    case "02":
                    {
                        obj.Month="February";
                        break;
                    }
                    case "03":
                    {
                        obj.Month="March";
                        break;
                    }
                    case "04":
                    {
                        obj.Month="April";
                        break;
                    }
                    case "05":
                    {
                        obj.Month="May";
                        break;
                    }
                    case "06":
                    {
                        obj.Month="June";
                        break;
                    }
                     case "07":
                    {
                        obj.Month="July";
                        break;
                    }
                    case "08":
                    {
                        obj.Month="August";
                        break;
                    }
                    case "09":
                    {
                        obj.Month="September";
                        break;
                    }
                    case "10":
                    {
                        obj.Month="October";
                        break;
                    }
                    case "11":
                    {
                        obj.Month="November";
                        break;
                    }
                    case "12":
                    {
                        obj.Month="December";
                        break;
                    }
                }
                obj.Time=date[1]+" "+date[2];
                obj.img=Img.getImage();
                obj.Quant=Integer.parseInt(Quant_ity.getText());
                obj.pid=Integer.parseInt(PID.getText());
                obj.Comp=COMP.getText();
                obj.MFG=MFG.getText();
                obj.Desc=DESC.getText();
                obj.type=Pname.getText();
                obj.Cost=COST.getText();
                obj.imgbyte=imgByte;
                System.out.println("imgbyte Added");
                HomePage.CT.add(obj);
         //   }
        }
        catch (Exception ex) 
        {
            
        }
 
      if (Moodle.getRowCount() > 0) {
    for (int i = Moodle.getRowCount() - 1; i > -1; i--) {
        Moodle.removeRow(i);
    }
        }
        HomePage.CTRT.CD.setModel(Moodle);
        HomePage.CTRT.CD.setColumnSelectionAllowed(false);
        HomePage.CTRT.CD.setName(""); 
        HomePage.CTRT.CD.setRowHeight(200);
        HomePage.CTRT.CD.setRowMargin(2);
        HomePage.CTRT.CD.setBackground(new java.awt.Color(204, 255, 204));
        HomePage.CTRT.CD.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 3, true));
        HomePage.CTRT.CD.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        HomePage.CTRT.CD.setForeground(new java.awt.Color(51, 51, 255));
        HomePage.CTRT.CD.setSelectionBackground(new java.awt.Color(0,255,255));
        HomePage.CTRT.CD.setSelectionForeground(new java.awt.Color(255,0,0));
        HomePage.CTRT.CD.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        HomePage.CTRT.ScrollPane1.setViewportView(HomePage.CTRT.CD);
        HomePage.CTRT.CD.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if(HomePage.CTRT.CD.getColumnModel().getColumnCount() > 0) 
        {
            HomePage.CTRT.CD.getColumnModel().getColumn(0).setPreferredWidth(20);
            HomePage.CTRT.CD.getColumnModel().getColumn(1).setPreferredWidth(10);
            HomePage.CTRT.CD.getColumnModel().getColumn(2).setPreferredWidth(200);
            HomePage.CTRT.CD.getColumnModel().getColumn(3).setPreferredWidth(100);
            HomePage.CTRT.CD.getColumnModel().getColumn(4).setPreferredWidth(10);
            HomePage.CTRT.CD.getColumnModel().getColumn(5).setPreferredWidth(10);
            HomePage.CTRT.CD.getColumnModel().getColumn(6).setPreferredWidth(10);
            HomePage.CTRT.CD.getColumnModel().getColumn(7).setPreferredWidth(10);
            HomePage.CTRT.CD.getColumnModel().getColumn(8).setPreferredWidth(10); 
        }  
        
            int i;
            for(i=0;i<HomePage.CT.size();i++)
            {
                ImageIcon image=null;
                Image newimg=CT.get(i).img.getScaledInstance(200,200,Image.SCALE_SMOOTH);
                image=new ImageIcon(newimg);
               Moodle.addRow(new Object[]{CT.get(i).Date,CT.get(i).pid,image,CT.get(i).Desc,CT.get(i).MFG,CT.get(i).type,CT.get(i).Quant,CT.get(i).Cost,CT.get(i).Comp}); 
               // System.out.println("All the Data of "+" th electronics product added in the table ");     
            }
            HomePage.CTRT.pack();
            HomePage.CTRT.setDefaultCloseOperation(HIDE_ON_CLOSE);
           close();
             Main(); 
    }//GEN-LAST:event_bnActionPerformed
public void close()
 {
     WindowEvent winevt=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
     Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winevt);
 }
     public static void Main() {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HomePage.CTRT.setVisible(true); 
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField COMP;
    public javax.swing.JTextField COST;
    public javax.swing.JTextArea DESC;
    public javax.swing.JTextField MFG;
    public javax.swing.JTextField PID;
    public javax.swing.JTextField Pname;
    public javax.swing.JTextField Quant_ity;
    public javax.swing.JTextField RATE;
    private javax.swing.JButton atc;
    private javax.swing.JButton bn;
    public javax.swing.JTextArea desc;
    public javax.swing.JLabel img1;
    public javax.swing.JLabel img2;
    public javax.swing.JLabel img3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
