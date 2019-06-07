package Client;
import Client.TRAC;
import ClientDatabase.Database;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.input.KeyCode.R;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class HomePage extends javax.swing.JFrame 
{  
    enum mth 
{ 
    RED,January,February,March,April,May,June,July,August,September,October,November,December; 
} 
    public static ArrayList <TRAC> CT=new ArrayList<>();
    public static TransactionHistory tsH=null;
    private static ProductDescription PDesc;
    public static String Dtp;
    public static Cart CTRT=null;
    private DefaultTableModel DFM;
    private static Database cdb=null;
    private int str;
    public HomePage() throws ClassNotFoundException 
    {
        initComponents();
        str=0;
        PDesc=new ProductDescription();
        tsH=new TransactionHistory();
        System.out.println("tsH created");
        CTRT=new Cart();
        cdb=new Database();
        DFM=new DefaultTableModel(new Object [][]{},new String [] {"ProductId","ProductName","Type","Cost","Description","Company","MFGDate","Image"})
        {
            Class[] types = new Class [] 
            {
                java.lang.Object.class,java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            public Class getColumnClass(int columnIndex) 
            {
                if(columnIndex==7)
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        NewlyAdded = new javax.swing.JButton();
        Electronics = new javax.swing.JButton();
        Clothes = new javax.swing.JButton();
        Books = new javax.swing.JButton();
        MoreItem = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ContentDisplay = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        Refresh = new javax.swing.JButton();
        SignOut = new javax.swing.JButton();
        Person = new javax.swing.JButton();
        More = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        SearchBox = new javax.swing.JTextField();
        Search = new javax.swing.JButton();
        CartButton = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 51), 3));

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 153), 1, true));

        NewlyAdded.setText("Newly Added");
        NewlyAdded.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewlyAddedActionPerformed(evt);
            }
        });

        Electronics.setText("Electronics");
        Electronics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ElectronicsActionPerformed(evt);
            }
        });

        Clothes.setText("Clothes");
        Clothes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClothesActionPerformed(evt);
            }
        });

        Books.setText("Books");
        Books.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BooksActionPerformed(evt);
            }
        });

        MoreItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "none", "Food", "Games" }));

        jButton1.setText("My Orders");

        jButton3.setText("View Offers");

        jButton4.setText("View Tranctions");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(NewlyAdded, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Electronics, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Clothes, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Books, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MoreItem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NewlyAdded, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Electronics, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Clothes, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MoreItem, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Books, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 204, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 255), 2, true));

        jLabel1.setBackground(new java.awt.Color(255, 255, 153));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Sort BY");
        jLabel1.setOpaque(true);

        jCheckBox1.setText("Price");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jCheckBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jCheckBox1)
                .addContainerGap(468, Short.MAX_VALUE))
        );

        ContentDisplay.setBackground(new java.awt.Color(204, 255, 204));
        ContentDisplay.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 3, true));
        ContentDisplay.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        ContentDisplay.setForeground(new java.awt.Color(51, 51, 255));
        ContentDisplay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        ContentDisplay.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ContentDisplay.setGridColor(new java.awt.Color(0, 0, 51));
        ContentDisplay.setRowHeight(200);
        ContentDisplay.setSelectionBackground(new java.awt.Color(0, 255, 255));
        ContentDisplay.setSelectionForeground(new java.awt.Color(255, 0, 0));
        ContentDisplay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ContentDisplayMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ContentDisplay);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1217, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserSideResources/ref.jpg"))); // NOI18N
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        SignOut.setText("SignOut");
        SignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignOutActionPerformed(evt);
            }
        });

        Person.setText("Trending");
        Person.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PersonActionPerformed(evt);
            }
        });

        More.setText("More");

        jLabel3.setBackground(new java.awt.Color(255, 255, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("MNNIT   BAZZAR");
        jLabel3.setOpaque(true);

        SearchBox.setBackground(new java.awt.Color(255, 153, 153));
        SearchBox.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        SearchBox.setForeground(new java.awt.Color(51, 0, 255));
        SearchBox.setText("Type to Search ........");
        SearchBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SearchBoxFocusGained(evt);
            }
        });
        SearchBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchBoxKeyReleased(evt);
            }
        });

        Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserSideResources/search.gif"))); // NOI18N
        Search.setFocusable(false);
        Search.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Search.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        CartButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserSideResources/cart.jpg"))); // NOI18N
        CartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CartButtonActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserSideResources/home.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchBox, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Person, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SignOut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(More, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(SearchBox)
            .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(Person, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(SignOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(More, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        int sz,pid,i;
        float Cst;
        byte [] IMGBYTE=null;
        String desc,comp,mfg,pname,type;
        System.out.println("Table Model Created And now moving towards try block.");
        try
        {
            Socket s1=new Socket("127.0.0.1",7598);
            DataOutputStream DouT=new DataOutputStream(s1.getOutputStream());
            DataInputStream DiN=new DataInputStream(s1.getInputStream());
            DouT.writeUTF(SearchBox.getText());
            DouT.flush();
            System.out.println("Search text sent");
            String flag=null;
            while(true)
            {
                System.out.println("Entered the while loop");
                flag=DiN.readUTF();
                if(flag.equals("false"))
                {
                    break;
                }
                pid=DiN.readInt();
                System.out.println("Pid received : "+pid);
                Cst=DiN.readFloat();
                System.out.println("Cost received"+Cst);
                desc=DiN.readUTF();
                System.out.println("Description received"+desc);
                pname=DiN.readUTF();
                System.out.println("pname received"+pname);
                type=DiN.readUTF();
                System.out.println("type received"+type); 
                comp=DiN.readUTF();
                System.out.println("Company NAme received"+comp);
                mfg=DiN.readUTF();
                System.out.println("MFG  received"+mfg);
                sz=DiN.readInt();
                System.out.println("Image Size  received"+sz);
                IMGBYTE=new byte[sz];
                int j;
                for(j=0;j<sz;j++)
                {
                    IMGBYTE[j]=DiN.readByte();
                }
                System.out.println ("Image Bytes All received");
                ImageIcon image=null;
                ImageIcon IMAGE=new ImageIcon(new ImageIcon(IMGBYTE).getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
                System.out.println("IMAGE  bytes executed");
                Image img=IMAGE.getImage();
                Image newimg=img.getScaledInstance(400/*Picture.getWidth()*/,/*Picture.getHeight()*/400,Image.SCALE_SMOOTH);
                image=new ImageIcon(newimg);
                DFM.addRow(new Object[]{pid,pname,type,Cst,desc,comp,mfg,image}); 
                System.out.println("All the Data of "+" th electronics product added in the table ");
            }
         }
         catch(Exception e)
         {
             System.out.println("Error in electronics Button of Home Page class");
         }  
       
    }//GEN-LAST:event_SearchActionPerformed

    private void ElectronicsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ElectronicsActionPerformed
        Dtp="Electronics";
        int sz,pid,i;
        float R,Cst;
        byte [] IMGBYTE=null;
        String desc,comp,mfg,pname;
      
        DefaultTableModel model=new DefaultTableModel(new Object [][]{},new String [] {"ProductId","ProductName", "Cost", "Description", "Ratings", "Company", "MFGDate", "Image"})
        {
            Class[] types = new Class [] 
            {
                java.lang.Object.class,java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
        public Class getColumnClass(int columnIndex) 
        {
            if(columnIndex==7)
            {
                return ImageIcon.class;
            }
            else
            {
                return types [columnIndex];
            }
        }//{pid,pname,Cst,desc,R,comp,mfg,image}); 
        public boolean isCellEditable(int row, int col)
        {
            return false;
        }
        };
        ContentDisplay.setModel(model);
        ContentDisplay.setColumnSelectionAllowed(false);
        ContentDisplay.setName(""); 
        ContentDisplay.setRowHeight(200);
        ContentDisplay.setRowMargin(2);
        ContentDisplay.setBackground(new java.awt.Color(204, 255, 204));
        ContentDisplay.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 3, true));
        ContentDisplay.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        ContentDisplay.setForeground(new java.awt.Color(51, 51, 255));
        ContentDisplay.setSelectionBackground(new java.awt.Color(0,255,255));
        ContentDisplay.setSelectionForeground(new java.awt.Color(255,0,0));
        ContentDisplay.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(ContentDisplay);
        ContentDisplay.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if(ContentDisplay.getColumnModel().getColumnCount()>0)
        {
            ContentDisplay.getColumnModel().getColumn(0).setPreferredWidth(5);
            ContentDisplay.getColumnModel().getColumn(1).setPreferredWidth(10);
            ContentDisplay.getColumnModel().getColumn(2).setPreferredWidth(10);
            ContentDisplay.getColumnModel().getColumn(3).setPreferredWidth(70);
            ContentDisplay.getColumnModel().getColumn(4).setPreferredWidth(5);
            ContentDisplay.getColumnModel().getColumn(5).setPreferredWidth(15);
            ContentDisplay.getColumnModel().getColumn(6).setPreferredWidth(15);
            ContentDisplay.getColumnModel().getColumn(7).setPreferredWidth(200);    
        }
        System.out.println("Table Model Created And now moving towards try block.");
        try
        {
            Socket s1=new Socket("127.0.0.1",9000);
            DataOutputStream DouT=new DataOutputStream(s1.getOutputStream());
            DataInputStream DiN=new DataInputStream(s1.getInputStream());
            DouT.writeUTF("Electronics");
            DouT.flush();
            DouT.writeInt(str);
            DouT.flush();
            System.out.println("Electronics Table Name sent");
            String flag=null;
            while(true)
            {
                System.out.println("Entered the while loop");
                flag=DiN.readUTF();
                if(flag.equals("false"))
                {
                    break;
                }
                pid=DiN.readInt();
                System.out.println("Pid received : "+pid);
                pname=DiN.readUTF();
                System.out.println("Pname received : "+pname);
                Cst=DiN.readFloat();
                System.out.println("Cost received"+Cst);
                desc=DiN.readUTF();
                System.out.println("Description received"+desc);
                R=DiN.readFloat();
                System.out.println("Ratings received"+R);
                comp=DiN.readUTF();
                System.out.println("Company NAme received"+comp);
                mfg=DiN.readUTF();
                System.out.println("MFG  received"+mfg);
                sz=DiN.readInt();
                System.out.println("Image Size  received"+sz);
                IMGBYTE=new byte[sz];
                int j;
                for(j=0;j<sz;j++)
                {
                    IMGBYTE[j]=DiN.readByte();
                }
                    System.out.println ("Image Bytes All received");
                    ImageIcon image=null;
                    ImageIcon IMAGE=new ImageIcon(new ImageIcon(IMGBYTE).getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
                    System.out.println("IMAGE  bytes executed");
                    Image img=IMAGE.getImage();
                    Image newimg=img.getScaledInstance(200/*Picture.getWidth()*/,/*Picture.getHeight()*/200,Image.SCALE_SMOOTH);
                    image=new ImageIcon(newimg);
                    model.addRow(new Object[]{pid,pname,Cst,desc,R,comp,mfg,image}); 
                    System.out.println("All the Data of "+" th electronics product added in the table ");
                }
         }
         catch(Exception e)
         {
             System.out.println("Error in electronics Button of Home Page class");
         }
    }//GEN-LAST:event_ElectronicsActionPerformed

    private void NewlyAddedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewlyAddedActionPerformed
        DefaultTableModel model = new DefaultTableModel(new String[] {"data","price"},0);
        ContentDisplay.setModel(model);
        for (int count = 1; count <= 10; count++) 
        {
            model.addRow(new Object[]{ count,"gsdgd",35346});
        }
    }//GEN-LAST:event_NewlyAddedActionPerformed

    private void PersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PersonActionPerformed
        
    }//GEN-LAST:event_PersonActionPerformed

    private void ClothesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClothesActionPerformed
        Dtp="Clothes";
        int sz,pid,i;
        float R,Cst;
        byte [] IMGBYTE=null;
        String desc,comp,mfg,pname;
        DefaultTableModel model=new DefaultTableModel(new Object [][]{},new String [] {"ProductId","ProductName", "Cost", "Description", "Ratings", "Company", "MFGDate", "Image"})
        {
        Class[] types = new Class [] 
        {
        java.lang.Object.class,java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
        };

        public Class getColumnClass(int columnIndex) 
        {
            if(columnIndex==7)
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
        ContentDisplay.setModel(model);
        ContentDisplay.setColumnSelectionAllowed(false);
        ContentDisplay.setName(""); 
        ContentDisplay.setRowHeight(200);
        ContentDisplay.setRowMargin(2);
        ContentDisplay.setBackground(new java.awt.Color(204, 255, 204));
        ContentDisplay.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 3, true));
        ContentDisplay.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        ContentDisplay.setForeground(new java.awt.Color(51, 51, 255));
        ContentDisplay.setSelectionBackground(new java.awt.Color(0,255,255));
        ContentDisplay.setSelectionForeground(new java.awt.Color(255,0,0));
        ContentDisplay.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(ContentDisplay);
        ContentDisplay.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if(ContentDisplay.getColumnModel().getColumnCount() > 0) 
        {
            ContentDisplay.getColumnModel().getColumn(0).setPreferredWidth(5);
            ContentDisplay.getColumnModel().getColumn(1).setPreferredWidth(10);
            ContentDisplay.getColumnModel().getColumn(2).setPreferredWidth(10);
            ContentDisplay.getColumnModel().getColumn(3).setPreferredWidth(70);
            ContentDisplay.getColumnModel().getColumn(4).setPreferredWidth(5);
            ContentDisplay.getColumnModel().getColumn(5).setPreferredWidth(15);
            ContentDisplay.getColumnModel().getColumn(6).setPreferredWidth(15);
            ContentDisplay.getColumnModel().getColumn(7).setPreferredWidth(200);  
        } 
        System.out.println("Table Model Created And now moving towards try block.");
        try
        {
            Socket s1=new Socket("127.0.0.1",9000);
            DataOutputStream DouT=new DataOutputStream(s1.getOutputStream());
            DataInputStream DiN=new DataInputStream(s1.getInputStream());
            DouT.writeUTF("Clothes");
            DouT.flush();
            DouT.writeInt(str);
            DouT.flush();
            System.out.println("Clothes Table Name sent");
            String flag=null;
            while(true)
            {
                System.out.println("Entered the while loop");
                flag=DiN.readUTF();
                if(flag.equals("false"))
                {
                    break;
                }
                pid=DiN.readInt();
                System.out.println("Pid received : "+pid);
                pname=DiN.readUTF();
                System.out.println("Pname received : "+pname);
                Cst=DiN.readFloat();
                System.out.println("Cost received"+Cst);
                desc=DiN.readUTF();
                System.out.println("Description received"+desc);
                R=DiN.readFloat();
                System.out.println("Ratings received"+R);
                comp=DiN.readUTF();
                System.out.println("Company NAme received"+comp);
                mfg=DiN.readUTF();
                System.out.println("MFG  received"+mfg);
                sz=DiN.readInt();
                System.out.println("Image Size  received"+sz);
                IMGBYTE=new byte[sz];
                int j;
                for(j=0;j<sz;j++)
                {
                    IMGBYTE[j]=DiN.readByte();
                }
                System.out.println ("Image Bytes All received");
                ImageIcon image=null;
                ImageIcon IMAGE=new ImageIcon(new ImageIcon(IMGBYTE).getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
                System.out.println("IMAGE  bytes executed");
                Image img=IMAGE.getImage();
                Image newimg=img.getScaledInstance(200/*Picture.getWidth()*/,/*Picture.getHeight()*/200,Image.SCALE_SMOOTH);
                image=new ImageIcon(newimg);
                model.addRow(new Object[]{pid,pname,Cst,desc,R,comp,mfg,image}); 
                System.out.println("All the Data of "+" th electronics product added in the table ");
                }
         }
         catch(Exception e)
         {
             System.out.println("Error in electronics Button of Home Page class");
         }
    }//GEN-LAST:event_ClothesActionPerformed

    private void BooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BooksActionPerformed
        Dtp="Books";
        // Book.clear();
        int sz,pid,i;
        float R,Cst;
        byte [] IMGBYTE=null;
        String desc,comp,mfg,pname;
        DefaultTableModel model=new DefaultTableModel(new Object [][]{},new String [] {"ProductId","ProductName", "Cost", "Description", "Ratings", "Company", "MFGDate", "Image"})
        {
        Class[] types = new Class [] 
        {
        java.lang.Object.class,java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
        };

        public Class getColumnClass(int columnIndex) 
        {
            if(columnIndex==7)
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
        ContentDisplay.setModel(model);
        ContentDisplay.setColumnSelectionAllowed(false);
        ContentDisplay.setName(""); 
        ContentDisplay.setRowHeight(200);
        ContentDisplay.setRowMargin(2);
        ContentDisplay.setBackground(new java.awt.Color(204, 255, 204));
        ContentDisplay.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 3, true));
        ContentDisplay.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        ContentDisplay.setForeground(new java.awt.Color(51, 51, 255));
        ContentDisplay.setSelectionBackground(new java.awt.Color(0,255,255));
        ContentDisplay.setSelectionForeground(new java.awt.Color(255,0,0));
        ContentDisplay.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(ContentDisplay);
        ContentDisplay.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if(ContentDisplay.getColumnModel().getColumnCount() > 0) 
        {
            ContentDisplay.getColumnModel().getColumn(0).setPreferredWidth(5);
            ContentDisplay.getColumnModel().getColumn(1).setPreferredWidth(10);
            ContentDisplay.getColumnModel().getColumn(2).setPreferredWidth(10);
            ContentDisplay.getColumnModel().getColumn(3).setPreferredWidth(70);
            ContentDisplay.getColumnModel().getColumn(4).setPreferredWidth(5);
            ContentDisplay.getColumnModel().getColumn(5).setPreferredWidth(15);
            ContentDisplay.getColumnModel().getColumn(6).setPreferredWidth(15);
            ContentDisplay.getColumnModel().getColumn(7).setPreferredWidth(200);
            
            
            
            
        }  
        System.out.println("Table Model Created And now moving towards try block.");
        try
        {
            Socket s1=new Socket("127.0.0.1",9000);
            DataOutputStream DouT=new DataOutputStream(s1.getOutputStream());
            DataInputStream DiN=new DataInputStream(s1.getInputStream());
            DouT.writeUTF("Books");
            DouT.flush();
            DouT.writeInt(str);
            DouT.flush();
            System.out.println("Books Table Name sent");
            String flag=null;
            while(true)
            {
                System.out.println("Entered the while loop");
                flag=DiN.readUTF();
                if(flag.equals("false"))
                {
                    break;
                }
                pid=DiN.readInt();
                System.out.println("Pid received : "+pid);
                pname=DiN.readUTF();
                System.out.println("Pname received : "+pname);
                Cst=DiN.readFloat();
                System.out.println("Cost received"+Cst);
                desc=DiN.readUTF();
                System.out.println("Description received"+desc);
                R=DiN.readFloat();
                System.out.println("Ratings received"+R);
                comp=DiN.readUTF();
                System.out.println("Company NAme received"+comp);
                mfg=DiN.readUTF();
                System.out.println("MFG  received"+mfg);
                sz=DiN.readInt();
                System.out.println("Image Size  received"+sz);
                IMGBYTE=new byte[sz];
                int j;
                for(j=0;j<sz;j++)
                {
                    IMGBYTE[j]=DiN.readByte();
                }
                System.out.println ("Image Bytes All received");
                ImageIcon image=null;
                ImageIcon IMAGE=new ImageIcon(new ImageIcon(IMGBYTE).getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
                System.out.println("IMAGE  bytes executed");
                Image img=IMAGE.getImage();
                Image newimg=img.getScaledInstance(200/*Picture.getWidth()*/,/*Picture.getHeight()*/200,Image.SCALE_SMOOTH);
                image=new ImageIcon(newimg);
                model.addRow(new Object[]{pid,pname,Cst,desc,R,comp,mfg,image});
                System.out.println("All the Data of "+" th electronics product added in the table ");
                }
         }
         catch(Exception e)
         {
             System.out.println("Error in electronics Button of Home Page class");
         }
    }//GEN-LAST:event_BooksActionPerformed

    private void SearchBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchBoxFocusGained
        SearchBox.setText("");
        ContentDisplay.setModel(DFM);
        ContentDisplay.setColumnSelectionAllowed(false);
        ContentDisplay.setName(""); 
        ContentDisplay.setRowHeight(200);
        ContentDisplay.setRowMargin(2);
        ContentDisplay.setBackground(new java.awt.Color(204, 255, 204));
        ContentDisplay.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 3, true));
        ContentDisplay.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        ContentDisplay.setForeground(new java.awt.Color(51, 51, 255));
        ContentDisplay.setSelectionBackground(new java.awt.Color(0,255,255));
        ContentDisplay.setSelectionForeground(new java.awt.Color(255,0,0));
        ContentDisplay.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(ContentDisplay);
        ContentDisplay.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if(ContentDisplay.getColumnModel().getColumnCount() > 0) 
        {
            ContentDisplay.getColumnModel().getColumn(0).setPreferredWidth(10);
            ContentDisplay.getColumnModel().getColumn(1).setPreferredWidth(20);
            ContentDisplay.getColumnModel().getColumn(2).setPreferredWidth(20);
            ContentDisplay.getColumnModel().getColumn(3).setPreferredWidth(20);
            ContentDisplay.getColumnModel().getColumn(4).setPreferredWidth(100);
            ContentDisplay.getColumnModel().getColumn(5).setPreferredWidth(10);
            ContentDisplay.getColumnModel().getColumn(7).setPreferredWidth(200);
        }   
    }//GEN-LAST:event_SearchBoxFocusGained

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        if(str==1)
        {
           // JTable table = new JTable(DFM);
                TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(ContentDisplay.getModel());
                ContentDisplay.setRowSorter(sorter);

                List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
                sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
               // sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
                sorter.setSortKeys(sortKeys);
        }        
    }//GEN-LAST:event_RefreshActionPerformed

    private void ContentDisplayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ContentDisplayMouseClicked
        int ind=ContentDisplay.getSelectedRow();
        TableModel tm=ContentDisplay.getModel();
        
        //{pid,pname,Cst,desc,R,comp,mfg,image}); 
        PDesc.PID.setText(tm.getValueAt(ind,0).toString());
        PDesc.COST.setText(tm.getValueAt(ind,2).toString());
        PDesc.DESC.setText(tm.getValueAt(ind,3).toString());
        PDesc.RATE.setText(tm.getValueAt(ind,4).toString());
        PDesc.COMP.setText(tm.getValueAt(ind,5).toString());
        PDesc.Pname.setText(tm.getValueAt(ind,1).toString());
        PDesc.MFG.setText(tm.getValueAt(ind,6).toString());
        PDesc.Quant_ity.setText("1");
        int sz,pid,i,j;
        String extras;
        float R,Cst;
        byte [] IMGBYTE=null;
        ByteArrayInputStream bis =null;
        BufferedImage bImage2=null ;
        Image newimg=null;
        ImageIcon image=null;
        System.out.println("Table Model Created And now moving towards try block.");
        try
        {
            Socket s1=new Socket("127.0.0.1",7000);
            DataOutputStream DouT=new DataOutputStream(s1.getOutputStream());
            DataInputStream DiN=new DataInputStream(s1.getInputStream());
            DouT.writeUTF(Dtp);
            DouT.flush();
            System.out.println("Table Name sent");
            DouT.writeUTF(tm.getValueAt(ind,0).toString());
            DouT.flush();
            System.out.println("Table Name sent");
            String flag=null;
            while(true)
            {
                System.out.println("Entered the while loop");
                flag=DiN.readUTF();
                if(flag.equals("false"))
                {
                    break;
                }
                sz=DiN.readInt();
                System.out.println("Image Size  received"+sz);
                IMGBYTE=new byte[sz];
               
                for(j=0;j<sz;j++)
                {
                    IMGBYTE[j]=DiN.readByte();
                }
                PDesc.imgByte=IMGBYTE;
                System.out.println ("Image Bytes All received");
                bis = new ByteArrayInputStream(IMGBYTE);
                bImage2 = ImageIO.read(bis);      
                newimg=bImage2.getScaledInstance(PDesc.img1.getWidth(),PDesc.img1.getHeight(),Image.SCALE_SMOOTH);
                image=new ImageIcon(newimg);
                PDesc.img2.setIcon(image); 
                sz=DiN.readInt();
                System.out.println("Image Size  received"+sz);
                for(j=0;j<sz;j++)
                {
                    IMGBYTE[j]=DiN.readByte();
                }
                System.out.println ("Image Bytes All received");
                bis = new ByteArrayInputStream(IMGBYTE);
                bImage2 = ImageIO.read(bis);     
                newimg=bImage2.getScaledInstance(PDesc.img2.getWidth(),PDesc.img2.getHeight(),Image.SCALE_SMOOTH);
                image=new ImageIcon(newimg);
                PDesc.img3.setIcon(image); 
                extras=DiN.readUTF();
                System.out.println("reviews received"+extras);
                PDesc.desc.setText(extras);
                image=(ImageIcon) tm.getValueAt(ind,7);
                newimg=image.getImage();
                newimg=newimg.getScaledInstance(PDesc.img1.getWidth(),PDesc.img1.getHeight(),Image.SCALE_SMOOTH);
                image=new ImageIcon(newimg);
                PDesc.img1.setIcon(image);
                
                System.out.println("All the Data of "+" th electronics product added in the table ");
                }  
            PDesc.pack();
                PDesc.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                 main();  
         }
         catch(Exception e)
         {
             System.out.println("Error in Product Description");
         }   
          
    }//GEN-LAST:event_ContentDisplayMouseClicked

    public static void main() 
    {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProductDescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductDescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductDescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductDescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() {
                PDesc.setVisible(true);
            }
        });
    }
    
    
    
    
    
    
    
    
    
    private void CartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CartButtonActionPerformed
        DefaultTableModel Moodle=new DefaultTableModel(new Object [][]{},new String [] {"Date","Pid","Image","Description","MFG", "Type", "Quant","Cost","Company","Time"})
        {
        Class[] types = new Class [] 
        {
        java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
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
        CTRT.CD.setModel(Moodle);
        CTRT.CD.setColumnSelectionAllowed(false);
        CTRT.CD.setName(""); 
        CTRT.CD.setRowHeight(200);
        CTRT.CD.setRowMargin(2);
        CTRT.CD.setBackground(new java.awt.Color(204, 255, 204));
        CTRT.CD.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 3, true));
        CTRT.CD.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        CTRT.CD.setForeground(new java.awt.Color(51, 51, 255));
        CTRT.CD.setSelectionBackground(new java.awt.Color(0,255,255));
        CTRT.CD.setSelectionForeground(new java.awt.Color(255,0,0));
        CTRT.CD.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        CTRT.ScrollPane1.setViewportView(CTRT.CD);
        CTRT.CD.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if(CTRT.CD.getColumnModel().getColumnCount() > 0) 
        {
            CTRT.CD.getColumnModel().getColumn(0).setPreferredWidth(20);
            CTRT.CD.getColumnModel().getColumn(1).setPreferredWidth(10);
            CTRT.CD.getColumnModel().getColumn(2).setPreferredWidth(200);
            CTRT.CD.getColumnModel().getColumn(3).setPreferredWidth(100);
            CTRT.CD.getColumnModel().getColumn(4).setPreferredWidth(10);
            CTRT.CD.getColumnModel().getColumn(5).setPreferredWidth(10);
            CTRT.CD.getColumnModel().getColumn(6).setPreferredWidth(10);
            CTRT.CD.getColumnModel().getColumn(7).setPreferredWidth(10);
            CTRT.CD.getColumnModel().getColumn(8).setPreferredWidth(10); 
            CTRT.CD.getColumnModel().getColumn(9).setPreferredWidth(10); 
        } 
            int i;
            for(i=0;i<HomePage.CT.size();i++)
            {
                ImageIcon image=null;
               
                Image newimg=CT.get(i).img.getScaledInstance(200,200,Image.SCALE_SMOOTH);
                image=new ImageIcon(newimg);
               Moodle.addRow(new Object[]{CT.get(i).Date,CT.get(i).pid,image,CT.get(i).Desc,CT.get(i).MFG,CT.get(i).pname,CT.get(i).Quant,CT.get(i).Cost,CT.get(i).Comp,CT.get(i).Time});      
            }
            CTRT.pack();
            CTRT.setDefaultCloseOperation(HIDE_ON_CLOSE);
            Main();
    }//GEN-LAST:event_CartButtonActionPerformed

    
    
    
     public static void Main() 
     {
       
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
                CTRT.setVisible(true); 
            }
        });
    }
    
    
    
    private void SearchBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchBoxKeyReleased
/* int sz,pid,i;
        float Cst;
        byte [] IMGBYTE=null;
        String desc,comp,mfg,pname,type;
        System.out.println("Table Model Created And now moving towards try block.");
        try
        {
            Socket s1=new Socket("127.0.0.1",7598);
            DataOutputStream DouT=new DataOutputStream(s1.getOutputStream());
            DataInputStream DiN=new DataInputStream(s1.getInputStream());
            DouT.writeUTF(SearchBox.getText());
            DouT.flush();
            System.out.println("Search text sent");
            String flag=null;
            while(true)
            {
                System.out.println("Entered the while loop");
                flag=DiN.readUTF();
                if(flag.equals("false"))
                {
                    break;
                }
                pid=DiN.readInt();
                System.out.println("Pid received : "+pid);
                Cst=DiN.readFloat();
                System.out.println("Cost received"+Cst);
                desc=DiN.readUTF();
                System.out.println("Description received"+desc);
                pname=DiN.readUTF();
                System.out.println("pname received"+pname);
                type=DiN.readUTF();
                System.out.println("pname received"+type); 
                comp=DiN.readUTF();
                System.out.println("Company NAme received"+comp);
                mfg=DiN.readUTF();
                System.out.println("MFG  received"+mfg);
                sz=DiN.readInt();
                System.out.println("Image Size  received"+sz);
                IMGBYTE=new byte[sz];
                int j;
                for(j=0;j<sz;j++)
                {
                    IMGBYTE[j]=DiN.readByte();
                }
                System.out.println ("Image Bytes All received");
                ImageIcon image=null;
                ImageIcon IMAGE=new ImageIcon(new ImageIcon(IMGBYTE).getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
                System.out.println("IMAGE  bytes executed");
                Image img=IMAGE.getImage();
                Image newimg=img.getScaledInstance(400/*Picture.getWidth()*///,/*Picture.getHeight()*/400,Image.SCALE_SMOOTH);
            /*    image=new ImageIcon(newimg);
                DFM.addRow(new Object[]{pid,pname,type,Cst,desc,comp,mfg,image}); 
                System.out.println("All the Data of "+" th electronics product added in the table ");
            }
         }
         catch(Exception e)
         {
             System.out.println("Error in electronics Button of Home Page class");
         }  */
             
    }//GEN-LAST:event_SearchBoxKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            new SL().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ResultSet rs=cdb.getAllTransactioData();
        DefaultTableModel TSH=new DefaultTableModel(new Object [][]{},new String [] {"Date","Time", "Pid", "Image","Description", "MFG", "Type", "Quant", "Cost","Company"})
        {
            Class[] types = new Class [] 
            {
                java.lang.Object.class,java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
        public Class getColumnClass(int columnIndex) 
        {
            if(columnIndex==3)
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
        tsH.CDTable.setModel(TSH);
        tsH.CDTable.setColumnSelectionAllowed(false);
        tsH.CDTable.setName(""); 
        tsH.CDTable.setRowHeight(200);
        tsH.CDTable.setRowMargin(2);
        tsH.CDTable.setBackground(new java.awt.Color(204, 255, 204));
        tsH.CDTable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 3, true));
        tsH.CDTable.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        tsH.CDTable.setForeground(new java.awt.Color(51, 51, 255));
        tsH.CDTable.setSelectionBackground(new java.awt.Color(0,255,255));
        tsH.CDTable.setSelectionForeground(new java.awt.Color(255,0,0));
        tsH.CDTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tsH.jScrollPane1.setViewportView(tsH.CDTable);
        tsH.CDTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if(tsH.CDTable.getColumnModel().getColumnCount()>0)
        {
            tsH.CDTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            tsH.CDTable.getColumnModel().getColumn(1).setPreferredWidth(10);
            tsH.CDTable.getColumnModel().getColumn(2).setPreferredWidth(5);
            tsH.CDTable.getColumnModel().getColumn(3).setPreferredWidth(200);
            tsH.CDTable.getColumnModel().getColumn(4).setPreferredWidth(100);
            tsH.CDTable.getColumnModel().getColumn(5).setPreferredWidth(10);
            tsH.CDTable.getColumnModel().getColumn(6).setPreferredWidth(10);
            tsH.CDTable.getColumnModel().getColumn(7).setPreferredWidth(10);
            tsH.CDTable.getColumnModel().getColumn(8).setPreferredWidth(15);
            tsH.CDTable.getColumnModel().getColumn(9).setPreferredWidth(20);    
        }
        System.out.println("Table Model Created And now moving towards try block.");
        try
        {
           while(rs.next())
           {
               System.out.println("Entered while loop");
               mth Moth=mth.valueOf(rs.getString(2));
               TSH.addRow(new Object[]{(rs.getInt(1)+"/"+Moth.ordinal()+"/"+rs.getInt(3)),rs.getString(4),rs.getInt(5),rs.getBytes(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getString(11),rs.getString(12)});
               System.out.println("Row Added");
           }
          //tsH.pack();
           tsH.setDefaultCloseOperation(HIDE_ON_CLOSE);
           //mAin();
           tsH.setVisible(true);
        }
         catch(Exception e)
         {
             System.out.println("Error in View History Button of Home Page class");
         }
    }//GEN-LAST:event_jButton4ActionPerformed

    
    
     
    
    
    private void SignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignOutActionPerformed
        SL.hp.dispose();
        MainClient.sl.setVisible(true);
    }//GEN-LAST:event_SignOutActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
                int i;
                for(i=0;i<CT.size();i++)
                {
                    try 
                    {
                        cdb.addTempCartData(CT.get(i).pid,CT.get(i).pname,CT.get(i).Date,CT.get(i).Time,CT.get(i).Comp,CT.get(i).Desc,CT.get(i).MFG,CT.get(i).Cost,CT.get(i).Quant,CT.get(i).imgbyte);
                    }
                    catch (ClassNotFoundException ex) {
                        System.out.println("Error in Payment Gteway CAl  in cancel Button Action event performed");
                    }
                }        
    }//GEN-LAST:event_formWindowClosed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        System.out.println("Action JCheckBox");
         if(jCheckBox1.isSelected()==true)
       {
           str=1;
           JOptionPane.showMessageDialog(null,"You Should Press Refresh Button");
       }
        else
        {
            str=0;
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Books;
    private javax.swing.JButton CartButton;
    private javax.swing.JButton Clothes;
    private javax.swing.JTable ContentDisplay;
    private javax.swing.JButton Electronics;
    private javax.swing.JButton More;
    private javax.swing.JComboBox<String> MoreItem;
    private javax.swing.JButton NewlyAdded;
    private javax.swing.JButton Person;
    private javax.swing.JButton Refresh;
    private javax.swing.JButton Search;
    private javax.swing.JTextField SearchBox;
    private javax.swing.JButton SignOut;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
