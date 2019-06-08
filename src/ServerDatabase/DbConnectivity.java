package ServerDatabase;

import java.awt.Image;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DbConnectivity
{
    private DateFormat df =null;
    private java.util.Date dateobj = null;
    private String Datefrmt = "dd/MM/yy HH:mm:ss a";
    public static String UserAddress=null;
    public class Sch
    {
        public int pid;
        public float Cost;
        public String pname,Desc,Comp,MFG,Type; 
        public byte[] img;
    }
    
    public static ArrayList <Sch> SCH=new ArrayList<>();
    private static Connection conn=null;
    private static String sql=null;
    private static PreparedStatement pstmt=null;
    public  DbConnectivity() throws ClassNotFoundException 
    {
         df = new SimpleDateFormat(Datefrmt);
        dateobj = new java.util.Date();
        try 
        {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:ClientInfo.db");
            System.out.println("Connection to Sqlite has been established.");
        }
        catch (SQLException e) 
        {
            System.out.println("Error in dbConnectivity() constructor");
        }
    }

    public void addTransactionData(String UName,String passwd,int Day,String Month,int Year,String Time,int Pid,byte [] imgbyte,String Desc,String MFG,String Type,int Quant,String Cost,String Comp)
    {
            sql = "INSERT INTO PurchaseHistory(UserName,Password,Day,Month,Year,Time,Pid,Image,Description,MFG,Type,Quant,Cost,Company) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            try {
            System.out.println("Entered try block");
            pstmt = conn.prepareStatement(sql);
            System.out.println("1 ex");
            pstmt.setString(1,UName);
            System.out.println("2 ex");
            pstmt.setString(2,passwd);
            System.out.println("3 ex");
            pstmt.setInt(3,Day);
            System.out.println("4 ex");
            pstmt.setString(4,Month);
            System.out.println("5 ex");
            pstmt.setInt(5,Year);
            System.out.println("6 ex");
            pstmt.setString(6,Time);
            System.out.println("7 ex");
            pstmt.setInt(7,Pid);
            System.out.println("8 ex");
            pstmt.setBytes(8,imgbyte);
            System.out.println("9 ex");
            pstmt.setString(9,Desc);
            System.out.println("10 ex");
            pstmt.setString(10,MFG);
            System.out.println("11 ex");
            pstmt.setString(11,Type);
            System.out.println("12 ex");
            pstmt.setInt(12,Quant);
            System.out.println("13 ex");
            pstmt.setString(13,Cost);
            System.out.println("14 ex");
            pstmt.setString(14,Comp);
            System.out.println("15 ex");
            pstmt.execute();
            System.out.println("Values of Transaction Data Inserted Successfully");
        } catch (SQLException e) 
        {
            System.out.println("Exception in dbConnectivity Class in addTransactionData function");
        }
    }
    
    
    public  int addUserData(String sn,String un,String pd,String em,String ph,String dob,byte[] imgByte,String add) throws ClassNotFoundException
    {
        sql = "INSERT INTO UserDetails(Name,UserName,Password,Email,Phone,Dob,Image,Address,Date,Time,Discount,TotalPurchase) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        String date[] = df.format(dateobj).split(" ");
        try 
        {
            System.out.println("Entered try block");
            pstmt=conn.prepareStatement(sql);
            System.out.println("1 ex");
            pstmt.setString(1,sn);
            System.out.println("2 ex");
            pstmt.setString(2,un);
            System.out.println("3 ex");
            pstmt.setString(3,pd);
            System.out.println("4 ex");
            pstmt.setString(4,em);
            System.out.println("5 ex");
            pstmt.setString(5,ph);
            System.out.println("6 ex");
            pstmt.setString(6,dob);
            System.out.println("7 ex");
            pstmt.setBytes(7,imgByte);
            System.out.println("8 ex");
            pstmt.setString(8,add);
            System.out.println("9 ex");
            pstmt.setString(9,date[0]);
            System.out.println("10 ex");
            pstmt.setString(10,date[1]+" "+date[2]);
            System.out.println("11 ex");
            pstmt.setString(11,"0");
            System.out.println("12 ex");
            pstmt.setString(12,"0");
            System.out.println("13 ex");
            pstmt.execute();
            System.out.println("Values Inserted Successfully");
            return 1;
        } 
        catch (SQLException e) 
        {
            System.out.println("Exception in dbConnectivity Class in addUserData function");
            return 0;
        }
    }
    
    public int checkLogin(String User,String pass)
    {
        ResultSet rs=null;
        String query="select * from UserDetails   where UserName=? and Password=?";
        System.out.println("query initialised");
        try
        {
            System.out.println("Entered Try Block");
            pstmt=conn.prepareStatement(query);
            pstmt.setString(1,User);
            pstmt.setString(2,pass);
            System.out.println("pstmt executed");
            rs=pstmt.executeQuery();
            System.out.println("RS executed");
            if(rs!=null)
            {
                rs.next();
                System.out.println("User Name is : "+rs.getString(2));
                System.out.println("Password  is : "+rs.getString(3));
                System.out.println("Returning 1 from DbConnectivity class in checkLogin  method");
                UserAddress=rs.getString(8);
                return 1;
            }
            else
            {
                System.out.println("rs is null . !! No result found in the database");
            }
        }
        catch(Exception e)
        {
            System.out.println("Error in getAllData in DbConnectivity class");
            System.out.println(e);
            System.out.println("Returning 0 from DbConnectivity class in checkLogin  Method due to exception");
            return 0;
        }
        return 0;
    }
    
    
  /*  public  ResultSet getAllData()
    {
        ResultSet rs=null;
        String query="SELECT * FROM [UserDetails];";
        System.out.println("query initialised");
        try
        {
            System.out.println("Entered Try Block");
            pstmt=conn.prepareStatement(query);
            System.out.println("pstmt executed");
            rs=pstmt.executeQuery();
            System.out.println("RS executed");
        }
        catch(Exception e)
        {
            System.out.println("Error in getAllData in DbConnectivity class");
        }
        return rs;
    }*/
    public ResultSet getProductData(String tableName) 
    {
        System.out.println("Entered getProductData method of database class");
        ResultSet xyz = null;
        String query = "SELECT * FROM [" + tableName + "] ;";
        System.out.println("query initialised");
        try 
        {
            System.out.println("Entered Try Block");
            pstmt = conn.prepareStatement(query);
            System.out.println("pstmt executed");
            xyz = pstmt.executeQuery();
            System.out.println("RS executed");
        } 
        catch (Exception e) 
        {
            System.out.println("Error in getProductData in DataBase class");
            xyz=null;
        }
        if(xyz!=null)
        {
            System.out.println("going to return nut null resultSet from getProductData from dataase class");
         
        }
        return xyz;
    }
    
    
    
    public ResultSet getSortedProductData(String tableName) 
    {
        System.out.println("Entered getProductData method of database class");
        ResultSet xyz = null;
        String query = "SELECT * FROM [" + tableName + "] ORDER BY Cost ASC;";
        System.out.println("query initialised");
        try 
        {
            System.out.println("Entered Try Block");
            pstmt = conn.prepareStatement(query);
            System.out.println("pstmt executed");
            xyz = pstmt.executeQuery();
            System.out.println("RS executed");
        } 
        catch (Exception e) 
        {
            System.out.println("Error in getProductData in DataBase class");
            xyz=null;
        }
        if(xyz!=null)
        {
            System.out.println("going to return nut null resultSet from getProductData from dataase class");
         
        }
        return xyz;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    public ResultSet getProductDescription(String tableName,String pid) 
    {
        System.out.println("Entered getProductData method of database class");
        ResultSet xyz = null;
        String query = "SELECT * FROM [" + tableName + "] where ProductID = "+pid+" ;";
        System.out.println("query initialised");
        try 
        {
            System.out.println("Entered Try Block");
            pstmt = conn.prepareStatement(query);
            System.out.println("pstmt executed");
            xyz = pstmt.executeQuery();
            System.out.println("RS executed");
        } 
        catch (Exception e) 
        {
            System.out.println("Error in getProductData in DataBase class");
            xyz=null;
        }
        if(xyz!=null)
        {
            System.out.println("going to return nut null resultSet from getProductData from dataase class");
        }
        return xyz;
    }
    
    
    
    
    
    
    
   /* public void updateData(byte[] by1,byte[] by2,String Reviews,String type,int id)
    {
        //sql = "UPDATE INTO Electronics(ProductId,Cost,Description,Ratings,Company,MFGDate,Image) VALUES(?,?,?,?,?,?,?)";
        sql = "UPDATE "+type+" set Image2 = ? , Image3 = ? , Extras = ? where ProductID = "+id+" ;";
        try
        {
            System.out.println("Entered Electronics try block");
            pstmt = conn.prepareStatement(sql);
            System.out.println("1 ex");
            pstmt.setBytes(1,by1);
            System.out.println("2 ex");
            pstmt.setBytes(2,by2);
            System.out.println("3 ex");
            pstmt.setString(3,Reviews);
            pstmt.execute();
            //  pstmt.executeUpdate();
            System.out.println("Values Updated Successfully");
        } 
        catch (SQLException e) 
        {
            System.out.println("Exception in dbConnectivity Class in addElectronicsData function");
        }
    }
    */
    
    
    
    
  /*  public void addElectronicsData(int id, float cost, String Desc, float Rating, String Comp, String mfgDate, byte[] ib) {
        sql = "INSERT INTO Electronics(ProductId,Cost,Description,Ratings,Company,MFGDate,Image) VALUES(?,?,?,?,?,?,?)";
        try {
            System.out.println("Entered Electronics try block");
            pstmt = conn.prepareStatement(sql);
            System.out.println("1 ex");
            pstmt.setInt(1, id);
            System.out.println("2 ex");
            pstmt.setFloat(2, cost);
            System.out.println("3 ex");
            pstmt.setString(3, Desc);
            System.out.println("4 ex");
            pstmt.setFloat(4, Rating);
            System.out.println("5 ex");
            pstmt.setString(5, Comp);
            System.out.println("6 ex");
            pstmt.setString(6, mfgDate);
            System.out.println("7 ex");
            pstmt.setBytes(7, ib);
            System.out.println("8 ex");
            pstmt.execute();
            //  pstmt.executeUpdate();
            System.out.println("Values Inserted Successfully");
        } catch (SQLException e) {
            System.out.println("Exception in dbConnectivity Class in addElectronicsData function");
        }
    }

    public void addBooksData(int id, float cost, String Desc, float Rating, String Comp, String mfgDate, byte[] ib) {
        sql = "INSERT INTO Books(ProductId,Cost,Description,Ratings,Company,MFGDate,Image) VALUES(?,?,?,?,?,?,?)";
        try {
            System.out.println("Entered Books try block");
            pstmt = conn.prepareStatement(sql);
            System.out.println("1 ex");
            pstmt.setInt(1, id);
            System.out.println("2 ex");
            pstmt.setFloat(2, cost);
            System.out.println("3 ex");
            pstmt.setString(3, Desc);
            System.out.println("4 ex");
            pstmt.setFloat(4, Rating);
            System.out.println("5 ex");
            pstmt.setString(5, Comp);
            System.out.println("6 ex");
            pstmt.setString(6, mfgDate);
            System.out.println("7 ex");
            pstmt.setBytes(7, ib);
            System.out.println("8 ex");
            pstmt.execute();
            //  pstmt.executeUpdate();
            System.out.println("Values Inserted Successfully");
        } catch (SQLException e) {
            System.out.println("Exception in dbConnectivity Class in addBooksData function");
        }
    }

    public void addClothesData(int id, float cost, String Desc, float Rating, String Comp, String mfgDate, byte[] ib) {
        sql = "INSERT INTO Clothes(ProductId,Cost,Description,Ratings,Company,MFGDate,Image) VALUES(?,?,?,?,?,?,?)";
        try {
            System.out.println("Entered Clothes try block");
            pstmt = conn.prepareStatement(sql);
            System.out.println("1 ex");
            pstmt.setInt(1, id);
            System.out.println("2 ex");
            pstmt.setFloat(2, cost);
            System.out.println("3 ex");
            pstmt.setString(3, Desc);
            System.out.println("4 ex");
            pstmt.setFloat(4, Rating);
            System.out.println("5 ex");
            pstmt.setString(5, Comp);
            System.out.println("6 ex");
            pstmt.setString(6, mfgDate);
            System.out.println("7 ex");
            pstmt.setBytes(7, ib);
            System.out.println("8 ex");
            pstmt.execute();
            //  pstmt.executeUpdate();
            System.out.println("Values Inserted Successfully");
        } catch (SQLException e) {
            System.out.println("Exception in dbConnectivity Class in addClothesData function");
        }
    }
    
    
    
    */
    public int checkUserName(String un)
    {
       ResultSet rs=null;
        String query="select * from UserDetails   where UserName=?";
        System.out.println("query initialised");
        try
        {
            System.out.println("Entered Try Block of checckUserName method in DbConnectivity");
            pstmt=conn.prepareStatement(query);
            pstmt.setString(1,un);
            System.out.println("pstmt executed ans username fixed into the query.");
            rs=pstmt.executeQuery();
            System.out.println("RS executed");
            if(rs.next())
            {
                System.out.println("rs is not null . !!result not found in the database  returning 0");
                return 0;
            }
            else
            {
                System.out.println("rs is null . !!result found in the database  returning 1");
                return 1;
            }
        }
        catch(Exception e)
        {
            System.out.println("Error in getAllData in DbConnectivity class");
            System.out.println(e);
            System.out.println("Returning 0 from DbConnectivity class in checkLogin  Method due to exception");
            return 0;
        }
    }
    
    
    
    
    
    
    
    
    
   /* public int checkEmail(String em)
    {
       ResultSet rs=null;
        String query="select * from UserDetails   where Email=?";
        System.out.println("query initialised");
        try
        {
            System.out.println("Entered Try Block");
            pstmt=conn.prepareStatement(query);
            pstmt.setString(1,em);
            System.out.println("pstmt executed");
            rs=pstmt.executeQuery();
            System.out.println("RS executed");
            if(rs.next()!=false)
            {
                System.out.println("rs is null . !!result not found in the database  returning 1");
                return 0;
            }
            else
            {
                System.out.println("rs is null . !! No result found in the database");
                return 1;
            }
        }
        catch(Exception e)
        {
            System.out.println("Error in getAllData in DbConnectivity class");
            System.out.println(e);
            System.out.println("Returning 0 from DbConnectivity class in checkLogin  Method due to exception");
            return 0;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public void addGamesData(int id, float cost, String Desc, float Rating, String Comp, String mfgDate, byte[] ib) {
        sql = "INSERT INTO Games(ProductId,Cost,Description,Ratings,Company,MFGDate,Image) VALUES(?,?,?,?,?,?,?)";
        try {
            System.out.println("Entered Games try block");
            pstmt = conn.prepareStatement(sql);
            System.out.println("1 ex");
            pstmt.setInt(1, id);
            System.out.println("2 ex");
            pstmt.setFloat(2, cost);
            System.out.println("3 ex");
            pstmt.setString(3, Desc);
            System.out.println("4 ex");
            pstmt.setFloat(4, Rating);
            System.out.println("5 ex");
            pstmt.setString(5, Comp);
            System.out.println("6 ex");
            pstmt.setString(6, mfgDate);
            System.out.println("7 ex");
            pstmt.setBytes(7, ib);
            System.out.println("8 ex");
            pstmt.execute();
            //  pstmt.executeUpdate();
            System.out.println("Values Inserted Successfully");
        } catch (SQLException e) {
            System.out.println("Exception in dbConnectivity Class in addGamesData function");
        }
    }

    public void addFoodData(int id, float cost, String Desc, float Rating, String Comp, String mfgDate, byte[] ib) {
        sql = "INSERT INTO Food(ProductId,Cost,Description,Ratings,Company,MFGDate,Image) VALUES(?,?,?,?,?,?,?)";
        try {
            System.out.println("Entered Food try block");
            pstmt = conn.prepareStatement(sql);
            System.out.println("1 ex");
            pstmt.setInt(1, id);
            System.out.println("2 ex");
            pstmt.setFloat(2, cost);
            System.out.println("3 ex");
            pstmt.setString(3, Desc);
            System.out.println("4 ex");
            pstmt.setFloat(4, Rating);
            System.out.println("5 ex");
            pstmt.setString(5, Comp);
            System.out.println("6 ex");
            pstmt.setString(6, mfgDate);
            System.out.println("7 ex");
            pstmt.setBytes(7, ib);
            System.out.println("8 ex");
            pstmt.execute();
            //  pstmt.executeUpdate();
            System.out.println("Values Inserted Successfully");
        } catch (SQLException e) {
            System.out.println("Exception in dbConnectivity Class in addFoodData function");
        }
    }
    
    
    
    
    */
    
    
    
}