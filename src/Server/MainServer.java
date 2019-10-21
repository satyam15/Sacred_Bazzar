package Server;
import ServerDatabase.DbConnectivity;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;                     
import java.net.ServerSocket;              
import java.net.Socket;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class MainServer extends javax.swing.JFrame 
{
    public  class Transaction implements Runnable
    {
        private Socket socketTRC=null;
        private ServerSocket serverTRC=null;
        private DataInputStream inTRC=null;
        private DataOutputStream outTRC=null;
        private String UName,passwd,Month,Time,Desc,MFG,Type,Cost,Comp,fg;
        private int Day,Year,Pid,imgSz,Quant;
        private byte[] imgByte=null;
        private int states=0;
        //Day,Month,Year,Time,Pid,Image,Description,MFG,Type,Quant,Cost,Company;
        private byte[] imgbyte=null;
        private DbConnectivity objTRC=null;
        public Transaction(int port)
        {
            try
            {
                objTRC=new DbConnectivity();
                System.out.println("DbConnectivity base signuo created");
                serverTRC= new ServerSocket(port); 
                System.out.println("server TRC created");
            }
            catch(Exception e)
            {
            System.out.println("Error in ServerCode class in TRC based Constructor"); 
            }
        }
        public void RUN()
        {
             System.out.println("TRC Accept Server StartedEntered RUN method : ");
               try 
               {
                socketTRC=serverTRC.accept();
                System.out.println("TRC Client accepted"); 
                inTRC = new DataInputStream(new BufferedInputStream(socketTRC.getInputStream())); 
                System.out.println("inTRC created");
                outTRC=new DataOutputStream(new BufferedOutputStream(socketTRC.getOutputStream()));
                System.out.println("outTRC created");
                UName=inTRC.readUTF();
                System.out.println("User Name Accepted : "+UName);
                passwd=inTRC.readUTF();
                System.out.println("Password Accepted : "+passwd);
                   System.out.println("Going to Receive Transaction History Row by Row");
                while(true)
                {
                    fg=inTRC.readUTF();
                    System.out.println("fg : "+fg);
                    if(fg.equals("false"))
                    {
                        break;
                    }
                    Day=inTRC.readInt();
                System.out.println("Day Accepted : "+Day);
                Month=inTRC.readUTF();
                    System.out.println("Month Accepted : "+Month);
                 
                        Year=inTRC.readInt();
                        System.out.println("Year Accepted : "+Year);
                        Time=inTRC.readUTF();
                        System.out.println("Time Accepted : "+Time);
                        Pid=inTRC.readInt();
                        imgSz=inTRC.readInt();
                        System.out.printf("The Size of Byte Array is received : %d\n",imgSz);
                        imgbyte=new byte[imgSz];
                        System.out.println("Going to print byte array : ");
                        for(int i=0;i<imgSz;i++)
                        {
                            imgbyte[i]=inTRC.readByte();
                            System.out.printf("%d ",imgbyte[i]);
                        }
                        System.out.println("Received Image in byte format ");
                        Desc=inTRC.readUTF();
                        System.out.println("Description Accepted : "+Desc);
                   MFG=inTRC.readUTF();
                   Type=inTRC.readUTF();
                   Quant=inTRC.readInt();
                   Cost=inTRC.readUTF();
                   Comp=inTRC.readUTF();
                        objTRC.addTransactionData(UName,passwd,Day,Month,Year,Time,Pid,imgbyte,Desc,MFG,Type,Quant,Cost,Comp);
                        System.out.println("Accept TRC request handled successfully.  State value :"+states);
                       
                }
        }
            catch (Exception ex) 
            {
                System.out.println("Error in ServerCode TRC Inner Class"); 
            }
        }
        
        
        public void run()
        { 
           while(true) 
           {
               System.out.println("Going to call  RUN method from run method of Transaction class in MainServer");
              RUN();
           }
        }
    }
    
   
    public class checkUserName implements Runnable 
    {
        private Socket ScUN = null;
        private ServerSocket SScUN = null;
        private int port;
        private DataInputStream DINcUN = null;
        private DataOutputStream DOUTcUN = null;
        private String UN;
        private int rs;
        private  DbConnectivity dbcCUN=null;
        public checkUserName(int port)
        {
            try 
            {
                rs=1;
                SScUN= new ServerSocket(port);
               this.port=port;
                dbcCUN=new DbConnectivity();
                System.out.println("checkUserName Constructor Successful");
            }
            catch (Exception e) 
            {
                System.out.println("Error in checkUsername Inner Class of Server.");
            }
        }

        public void run() 
        {
            System.out.println("checkUserName server started ");
            while(true)
            {
                try 
                {
                    ScUN = SScUN.accept(); 
                    System.out.println(" check User Name based socket Accepted");
                    DOUTcUN = new DataOutputStream(ScUN.getOutputStream());
                    DINcUN = new DataInputStream(ScUN.getInputStream());
                    System.out.println("Both types of IO Stream Initialised");
                    UN = DINcUN.readUTF();
                    System.out.println("User Name to be checked Accepted : " + UN);
                    rs=dbcCUN.checkUserName(UN);
                    DOUTcUN.writeInt(rs);
                    DOUTcUN.flush();
                    System.out.println("rs from checkUserrName flushed : " +rs);
                } 
                catch(Exception e)
                {
                    System.out.println("error in check User Nname class Try catch Block");
                }
            }
        }
    }
    
   /* public class SendSearchData implements Runnable 
    {
        private Socket SPD = null;
        private ServerSocket SSPD = null;
        private DataInputStream DINPD = null;
        private DataOutputStream DOUTPD = null;
        private byte[] IBPD = null;
        private DbConnectivity dbSD = null;

        public SendSearchData(int port) 
        {
            try 
            {
                dbSD = new DbConnectivity();
                SSPD = new ServerSocket(port);
            }
            catch (Exception e) 
            {
                System.out.println("Error in signUp Inner Class of Server.");
            }
        }

        public void run() 
        {
            int cnt = 0;
            while(true) 
            {
                System.out.println("Entered the run method  of search database " + (cnt++) + "times");
                try 
                {
                    SPD = SSPD.accept();
                    System.out.println("Search send data Accepted");
                    DOUTPD = new DataOutputStream(SPD.getOutputStream());
                    DINPD = new DataInputStream(SPD.getInputStream());
                    System.out.println("Both types of IO Stream Initialised");
                    String search = DINPD.readUTF();
                    System.out.println("Search Text read as : " + search);
                    dbSD.getSearchData(search);//
                    System.out.println("Got all search data ready to transfer all data.");
                    int C = 1,i;
                    System.out.println("Received the result set and also initialised C with 1");
                    for(i=0;i<DbConnectivity.SCH.size();i++)
                    {                  
                        System.out.println("Entered the RS.next While loop : " + C + " times");
                        System.out.println("Going to flush the value true to the client.");
                        DOUTPD.writeUTF("true");
                        DOUTPD.flush();
                        C++;
                        System.out.println("C value Incremented");
                        DOUTPD.writeInt(DbConnectivity.SCH.get(i).pid);
                        DOUTPD.flush();
                        System.out.println("Product ID flushed: "+DbConnectivity.SCH.get(i).pid);
                        DOUTPD.writeFloat(DbConnectivity.SCH.get(i).Cost);
                        DOUTPD.flush();
                        System.out.println("Cost of Product is  flushed: "+DbConnectivity.SCH.get(i).Cost);
                        DOUTPD.writeUTF(DbConnectivity.SCH.get(i).Desc);
                        DOUTPD.flush();
                        System.out.println("Description is  flushed: "+DbConnectivity.SCH.get(i).Desc);                       
                        DOUTPD.writeUTF(DbConnectivity.SCH.get(i).pname);
                        DOUTPD.flush();
                        System.out.println("Pname flushed:"+DbConnectivity.SCH.get(i).pname);
                        DOUTPD.writeUTF(DbConnectivity.SCH.get(i).Type);
                        DOUTPD.flush();
                        System.out.println("Type flushed:"+DbConnectivity.SCH.get(i).Type); 
                        DOUTPD.writeUTF(DbConnectivity.SCH.get(i).Comp);
                        DOUTPD.flush();
                        System.out.println("Company flushed");
                        DOUTPD.writeUTF(DbConnectivity.SCH.get(i).MFG);
                        DOUTPD.flush();
                        System.out.println("MFG is  flushed :"+DbConnectivity.SCH.get(i).MFG);
                        ImageIcon image = null;
                        if (DbConnectivity.SCH.get(i).img != null) 
                        {     
                            IBPD = DbConnectivity.SCH.get(i).img;
                            System.out.println("IMAGE  bytes executed");
                        }
                        DOUTPD.writeInt(IBPD.length);
                        DOUTPD.flush();
                        System.out.println("Image length bytes is  flushed");
                        DOUTPD.write(IBPD, 0, IBPD.length);
                        DOUTPD.flush();
                        System.out.println("Image in the form of bytes  flushed");
                        System.out.println("All data of Row Flushed");
                   }
                   DOUTPD.writeUTF("false");
                   DOUTPD.flush();
                   DbConnectivity.SCH.clear();
                } 
                catch (Exception e) 
                {
                    System.out.println(e);
                }
         }
        }
    }
  */
    public class SendProductData implements Runnable 
    {
        private Socket SPD = null;
        private ServerSocket SSPD = null;
        private DataInputStream DINPD = null;
        private DataOutputStream DOUTPD = null;
        private byte[] IBPD = null;
        private DbConnectivity dbPD = null;
        private int str;
        public SendProductData(int port) 
        {
            try 
            {
                dbPD = new DbConnectivity();
                SSPD = new ServerSocket(port);
            } 
            catch(Exception e) 
            {
                System.out.println("Error in signUp Inner Class of Server.");
            }
        }

        public void run() 
        {
            int cnt = 0;
            while(true) 
            {
                System.out.println("Entered the run method " + (cnt++) + "times");
                try 
                {
                    SPD = SSPD.accept();
                    System.out.println("Product Based Client Accepted");
                    DOUTPD = new DataOutputStream(SPD.getOutputStream());
                    DINPD = new DataInputStream(SPD.getInputStream());
                    System.out.println("Both types of IO Stream Initialised");
                    String pdtype = DINPD.readUTF();
                    System.out.println("Product Type read is : " + pdtype);
                    str=DINPD.readInt();
                    ResultSet aqwer;
                    if(str==0)
                    {
                        aqwer = dbPD.getProductData(pdtype);
                    }
                    else
                    {
                        aqwer = dbPD.getSortedProductData(pdtype);
                    }
                    int C = 1;
                    System.out.println("Received the result set and also initialised C with 1");
                    while(aqwer.next()) 
                    {                                      
                        System.out.println("Entered the RS.next While loop : " + C + " times");
                        System.out.println("Going to flush the value true to the client.");
                        DOUTPD.writeUTF("true");
                        DOUTPD.flush();
                        C++;
                        System.out.println("C value Incremented");
                        DOUTPD.writeInt(aqwer.getInt(1));
                        DOUTPD.flush();
                        System.out.println("Product ID flushed: "+aqwer.getInt(1));
                        DOUTPD.writeUTF(aqwer.getString(2));
                        DOUTPD.flush();
                        System.out.println("Product Name flushed: "+aqwer.getString(2));
                        DOUTPD.writeFloat(aqwer.getFloat(3));
                        DOUTPD.flush();
                        System.out.println("Cost of Product is  flushed: "+aqwer.getFloat(3));
                        DOUTPD.writeUTF(aqwer.getString(4));
                        DOUTPD.flush();
                        System.out.println("Description is  flushed: "+aqwer.getString(4));
                        DOUTPD.writeFloat(aqwer.getFloat(5));
                        DOUTPD.flush();
                        System.out.println("Rating flushed:"+aqwer.getFloat(5));
                        DOUTPD.writeUTF(aqwer.getString(6));
                        DOUTPD.flush();
                        System.out.println("Company flushed");
                        DOUTPD.writeUTF(aqwer.getString(7));
                        DOUTPD.flush();
                        System.out.println("MFG is  flushed :"+aqwer.getString(7));
                        ImageIcon image = null;
                        if (aqwer.getBytes(8) != null) 
                        {     
                            IBPD = aqwer.getBytes(8);
                            System.out.println("IMAGE  bytes executed");
                        }
                        DOUTPD.writeInt(IBPD.length);
                        DOUTPD.flush();
                        System.out.println("Image length bytes is  flushed");
                        DOUTPD.write(IBPD, 0, IBPD.length);
                        DOUTPD.flush();
                        System.out.println("Image in the form of bytes  flushed");
                        System.out.println("All data of Row Flushed");
                   }
                   DOUTPD.writeUTF("false");
                   DOUTPD.flush();
                } 
                catch (Exception e) 
                {
                    System.out.println(e);
                }
         }
        }
    }
    
    
    public class SendProductDescription implements Runnable
    {
        private Socket SPD = null;
        private ServerSocket SSPD = null;
        private DataInputStream DINPD = null;
        private DataOutputStream DOUTPD = null;
        private byte[] IBPD = null;
        private DbConnectivity dbPDesc = null;
        private String pdtype,pid;
        
        public SendProductDescription(int port) 
        {
            try 
            {
                dbPDesc = new DbConnectivity();
                SSPD = new ServerSocket(port);
                System.out.println("Send Product Description class successfully created");
            } 
            catch (Exception e) 
            {
                System.out.println("Error in send product description Inner Class of Server.");
            }
        }
        @Override
        public void run() 
        {
             int cnt = 0;
            while(true) 
            {
                System.out.println("Entered the run method " + (cnt++) + "times");
                try 
                {
                    SPD = SSPD.accept();
                    System.out.println("Product Based Client Accepted");
                    DOUTPD = new DataOutputStream(SPD.getOutputStream());
                    DINPD = new DataInputStream(SPD.getInputStream());
                    System.out.println("Both types of IO Stream Initialised");
                    pdtype = DINPD.readUTF();
                    System.out.println("Product Type read is : " + pdtype);
                    pid = DINPD.readUTF();
                    System.out.println("Product Type read is : " + pid);
                    ResultSet aqwer = dbPDesc.getProductDescription(pdtype,pid);
                    int C = 1;
                    System.out.println("Received the result set and also initialised C with 1");
                    while(aqwer.next()) 
                    {                                      
                        System.out.println("Entered the RS.next While loop : " + C + " times");
                        System.out.println("Going to flush the value true to the client.");
                        DOUTPD.writeUTF("true");
                        DOUTPD.flush();
                        C++;
                        System.out.println("C value Incremented");
                    
                        ImageIcon image = null;
                        if (aqwer.getBytes(9) != null) 
                        {     
                            IBPD = aqwer.getBytes(9);
                            System.out.println("IMAGE  bytes executed");
                        }
                        DOUTPD.writeInt(IBPD.length);
                        DOUTPD.flush();
                        System.out.println("Image length bytes is  flushed");
                        DOUTPD.write(IBPD, 0, IBPD.length);
                        DOUTPD.flush();
                        System.out.println("Image in the form of bytes  flushed");
                        
                        if (aqwer.getBytes(10) != null) 
                        {     
                            IBPD = aqwer.getBytes(10);
                            System.out.println("IMAGE  bytes executed");
                        }
                        DOUTPD.writeInt(IBPD.length);
                        DOUTPD.flush();
                        System.out.println("Image length bytes is  flushed");
                        DOUTPD.write(IBPD, 0, IBPD.length);
                        DOUTPD.flush();
                        System.out.println("Image in the form of bytes  flushed");
                        
                        DOUTPD.writeUTF(aqwer.getString(11));
                        DOUTPD.flush();
                        System.out.println("Reviews is  flushed: "+aqwer.getString(11));
                        
                        
                        System.out.println("All data of Row Flushed");
                   }
                   DOUTPD.writeUTF("false");
                   DOUTPD.flush();
                } 
                catch (Exception e) 
                {
                    System.out.println(e);
                }
         }
        }
        
    }
    
    
    
    public  class LoginServer implements Runnable
    {
        private Socket socketlogin=null;
        private ServerSocket serverlogin=null;
        private DataInputStream inlogin=null;
        private DataOutputStream outlogin=null;
        private String passwd;
        private String username;
        private int statel=0;
        private DbConnectivity objl=null;
        public LoginServer(int port)
        {
            try
            {
                objl=new DbConnectivity();
                System.out.println("DbConnectivity base login created");
                serverlogin = new ServerSocket(port); 
                System.out.println("server login created");
            }
            catch(Exception e)
            {
                System.out.println("Error in ServerCode class in ServerCode login based Constructor"); 
            }
        }
        public void run()
        {
           while(true)
           {
                System.out.println("Login Accept Server Started : ");
                try 
                {
                    socketlogin=serverlogin.accept();
                    System.out.println("Login Client accepted"); 
                    inlogin = new DataInputStream(new BufferedInputStream(socketlogin.getInputStream())); 
                    System.out.println("Inlogin created");
                    outlogin=new DataOutputStream(new BufferedOutputStream(socketlogin.getOutputStream()));  
                    System.out.println("outLogin created");
                    username=inlogin.readUTF();
                    passwd=inlogin.readUTF();
                    // Match the data in database. and then do state=1;
                    statel=objl.checkLogin(username, passwd);
                    System.out.println("Login Accept Request accepted successfully");
                }
                catch (Exception ex) 
                {
                    System.out.println("Error in ServerCodeLogin class");
                    System.out.println(ex);
                    statel=0;
                }
                try 
                {
                    if(statel==1)
                    {
                        System.out.println("Going to flush statesL : "+statel);
                        outlogin.writeUTF("1");
                        outlogin.flush();
                        System.out.println("value of statel flushed  : "+statel);
                        outlogin.writeUTF(DbConnectivity.UserAddress);
                        outlogin.flush();
                        System.out.println("value of UserAddress flushed  : "+DbConnectivity.UserAddress);
                    }
                    else
                    {
                        System.out.println("Going to flush statesL : "+statel);
                        outlogin.writeUTF("0");
                        outlogin.flush();
                        System.out.println("value of statel flushed  : "+statel);
                        outlogin.writeUTF(DbConnectivity.UserAddress);
                        outlogin.flush();
                        System.out.println("value of UserAddress flushed  : "+DbConnectivity.UserAddress);
                    }
                }
                catch (Exception ex) 
                {
                    System.out.println("Error in servercodeLogin  class secong try catch block");
                    System.out.println(ex);
                }
           }
        }
    }
 
    
    public  class SignupServer implements Runnable
    {
        private Socket socketsignup=null;
        private ServerSocket serversignup=null;
        private DataInputStream insignup=null;
        private DataOutputStream outsignup=null;
        private String Name,emailid,dob,passwd,username,add,phone;
        private int states=0;
        
        private byte[] imgbyte=null;
        private DbConnectivity objs=null;
        public SignupServer(int port)
        {
            try
            {
                objs=new DbConnectivity();
                System.out.println("DbConnectivity base signuo created");
                serversignup= new ServerSocket(port); 
                System.out.println("server signup created");
            }
            catch(Exception e)
            {
            System.out.println("Error in ServerCode class in ServerCode signup based Constructor"); 
            }
        }
        
        public void run()
        {
            
           while(true) 
           {
               System.out.println("SignUp Accept Server Started : ");
               try 
               {
                socketsignup=serversignup.accept();       //adding a client socket connection with server socket for communication
                System.out.println("SignUp Client accepted"); 
                insignup = new DataInputStream(new BufferedInputStream(socketsignup.getInputStream())); 
                System.out.println("insignUp created");
                outsignup=new DataOutputStream(new BufferedOutputStream(socketsignup.getOutputStream()));  //reading a string 
                System.out.println("outsignUp created");                            //reading user detail for signup
                Name=insignup.readUTF();
                System.out.println("Name Accepted : "+Name);
                username=insignup.readUTF();
                System.out.println("User Name Accepted : "+username);
                passwd=insignup.readUTF();
                System.out.println("Password Accepted : "+passwd);
                emailid=insignup.readUTF();
                    System.out.println("emailid Accepted : "+emailid);
                 
                        phone=insignup.readUTF();
                        System.out.println("phone Accepted : "+phone);
                        dob=insignup.readUTF();
                        System.out.println("dob Accepted : "+dob);
                        int sz;
                        sz=insignup.readInt();
                        System.out.printf("The Size of Byte Array is received : %d\n",sz);
                        imgbyte=new byte[sz];
                        System.out.println("Going to print byte array : ");
                        for(int i=0;i<sz;i++)
                        {
                            imgbyte[i]=insignup.readByte();
                            System.out.printf("%d ",imgbyte[i]);
                        }
                        System.out.println("Received Image in byte format and now going to receive address");
                        add=insignup.readUTF();
                        System.out.println("address Accepted : "+add);
                   
                        states=objs.addUserData(Name,username,passwd,emailid,phone,dob,imgbyte,add);
                        System.out.println("Accept signUp request handled successfully.  State value :"+states);
                       
                        outsignup.writeInt(states);
                        outsignup.flush();
                        System.out.println("outsign Flushed");
                }
            catch (Exception ex) 
            {
                System.out.println("Error in ServerCodeSignUp class");
                System.out.println(ex);
                states=0;
                try
                {
                   outsignup.writeInt(states);
                System.out.println("Sent the states value to the client");
                outsignup.flush();
                System.out.println("outsign Flushed"); 
                }
                catch(Exception e)
                {
                    System.out.println("Error in ServerCodeSignUp class in lower try catch block");
                    System.out.println(e);
                }
            }
           }
        }
    }
    
 
    
    public MainServer() throws ClassNotFoundException 
    {
        initComponents();
       // dbc=new DbConnectivity();
        signup=new Thread(new SignupServer(8005));
        login=new Thread(new LoginServer(6040));
        SPD=new Thread(new SendProductData(9000));
        SPDesc=new Thread(new SendProductDescription(7000));
        cUName=new Thread(new checkUserName(6090));
        TRC=new Thread(new Transaction(9876));
      //  Search=new Thread(new SendSearchData(7598));
        signup.start();
        login.start();
        SPD.start();
        SPDesc.start();
        cUName.start();
        TRC.start();
      //  Search.start();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1376, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 712, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public static void main(String args[]) throws Exception
    {
        try 
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
            {
                if ("Nimbus".equals(info.getName())) 
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (ClassNotFoundException ex) 
        {
            java.util.logging.Logger.getLogger(MainServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) 
        {
            java.util.logging.Logger.getLogger(MainServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (IllegalAccessException ex) 
        {
            java.util.logging.Logger.getLogger(MainServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex) 
        {
            java.util.logging.Logger.getLogger(MainServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                try { 
                    new MainServer().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    
    class MultithreadingDemo extends Thread    //to make allow multi user to login at a time
  { 
    public void run() 
    { 
        try
        { 
            // Displaying the thread that is running 
            System.out.println ("Thread " + 
                  Thread.currentThread().getId() + 
                  " is running"); 
  
        } 
        catch (Exception e) 
        { 
            // Throwing an exception 
            System.out.println ("Exception is caught"); 
        } 
    } 
} 
  
// Main Class 
public class Multithread 
{ 
    public static void main(String[] args) 
    { 
        int n = 8; // Number of threads 
        for (int i=0; i<8; i++) 
        { 
            MultithreadingDemo object = new MultithreadingDemo(); 
            object.start(); 
        } 
    } 
} 
    private  Thread signup=null;
    private  Thread login=null;
    private  Thread SPD=null;
    private Thread SPDesc=null;
    private Thread Search=null;
    private Thread cUName=null;
    private Thread TRC=null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
