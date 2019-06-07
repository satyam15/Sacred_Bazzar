package ClientDatabase;
import Client.TRAC;
import Client.HomePage;
import java.awt.Image;
import java.sql.*;
import java.util.ArrayList;

public class Database 
{
    private static Connection conn=null;
    private static String sql=null;
    private static PreparedStatement pstmt=null;
    public  Database() throws ClassNotFoundException 
    {
        try 
        {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:UserDatabase.db");
            System.out.println("Connection to Sqlite has been established.");
        }
        catch (SQLException e) 
        {
            System.out.println("Error in dbConnectivity() constructor");
        } 
    }

    public  void addTransactionData(TRAC AR) throws ClassNotFoundException
    {
        sql = "INSERT INTO PurchaseHistory(Day,Month,Year,Time,Pid,Image,Description,MFG,Type,Quant,Cost,Company) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try 
        {
            System.out.println("Entered try block");
            pstmt=conn.prepareStatement(sql);
            System.out.println("1 ex");
            pstmt.setInt(1,AR.Day);
            System.out.println("2 ex");
            pstmt.setString(2,AR.Month);
            System.out.println("3 ex");
            pstmt.setInt(3,AR.Year);
            System.out.println("4 ex");
            pstmt.setString(4,AR.Time);
            System.out.println("5 ex");
            pstmt.setInt(5,AR.pid);
            System.out.println("6 ex");
            pstmt.setBytes(6,AR.imgbyte);
            System.out.println("7 ex");
            pstmt.setString(7,AR.Desc);
            System.out.println("8 ex");
            pstmt.setString(8,AR.MFG);
            System.out.println("9 ex");
            pstmt.setString(9,AR.pname);
            System.out.println("10 ex");
            pstmt.setInt(10,AR.Quant);  
            System.out.println("11 ex");
            pstmt.setString(11,AR.Cost);
            System.out.println("12 ex");
            pstmt.setString(12,AR.Comp);
            System.out.println("13 ex");
            pstmt.execute();
            System.out.println("Values Inserted Successfully");
          //  return 1;
        }
        catch (SQLException e) 
        {
            System.out.println("Exception in dbConnectivity Class in addData function");
           // return 0;
        }
    }
    
    public void deleteAllTempCart()
    {
        sql="DELETE FROM TempCart;";
        PreparedStatement Prep=null;
        try 
        {
            System.out.println("Entered try block");
            Prep=conn.prepareStatement(sql);
            Prep.execute();
            System.out.println("Values Deleted Successfully");
        }
        catch (SQLException e) 
        {
            System.out.println("Exception in dbConnectivity Class in addData function");
        }
    }
   
    
    
    
    public  ResultSet getTempCartData()
    {
        ResultSet rs=null;
        String query="SELECT * FROM [TempCart];";
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
            System.out.println("Error in getTempCartData in DbConnectivity class");
        }
        return rs;
    }
      
    public  void addTempCartData(int pid,String pname,String date,String time,String Comp,String desc,String Mfg,String Cost,int Q,byte[] img) throws ClassNotFoundException
    {
        sql = "INSERT INTO TempCart(pid,pname,Date,Time,Company,Description,MFG,Cost,Quantity,Image) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try 
        {
            System.out.println("Entered try block");
            pstmt=conn.prepareStatement(sql);
            System.out.println("1 ex");
            pstmt.setInt(1,pid);
            System.out.println("2 ex");
            pstmt.setString(2,pname);
            System.out.println("3 ex");
            pstmt.setString(3,date);
            System.out.println("4 ex");
            pstmt.setString(4,time);
            System.out.println("5 ex");
            pstmt.setString(5,Comp);
            System.out.println("6 ex");
            pstmt.setString(6,desc);
            System.out.println("7 ex");
            pstmt.setString(7,Mfg);
            System.out.println("8 ex");
            pstmt.setString(8,Cost);
            System.out.println("9 ex");
            pstmt.setInt(9,Q);
            System.out.println("10 ex");
            pstmt.setBytes(10,img);
            System.out.println("11 ex");
            pstmt.execute();
            System.out.println("Values Inserted Successfully");
          //  return 1;
        }
        catch (SQLException e) 
        {
            System.out.println("Exception in dbConnectivity Class in addData function");
           // return 0;
        }
    }
    
    
    public int getLoginLogs(String User,String pass)
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
               // if(rs.getString(3).equals(pass))
               // {
                    System.out.println("Password  is : "+rs.getString(3));
                    System.out.println("Returning 1 from DbConnectivity class in checkLogin  method");
                    return 1;
               // }
               /* else
                {
                    System.out.println("User Nanme matched but password not matched : "+rs.getString(2)+"   "+rs.getString(3));
                    System.out.println("Returning 0 from DbConnectivity class in checkLogin  method");
                    return 0;
                }*/
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
    
    
    public  ResultSet getAllTransactioData()
    {
        ResultSet rs=null;
        String query="SELECT * FROM [PurchaseHistory];";
        PreparedStatement Prep=null;
        System.out.println("query initialised in getAllTransactionData method in client Database.");
        try
        {
            System.out.println("Entered Try Block");
            Prep=conn.prepareStatement(query);
            System.out.println("pstmt executed");
            rs=Prep.executeQuery();
            System.out.println("RS executed");
        }
        catch(Exception e)
        {
            System.out.println("Error in getAllTransactionData Method in client Database Class in DbConnectivity class");
        }
        return rs;
    }
    
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
    
    public ResultSet getTransactionHistoryDateWise(String mon,int yr)
    {
        ResultSet rs=null;
        String query="SELECT * FROM [PurchaseHistory] where Month=? and Year = ?;";
        System.out.println("query initialised");
        try
        {
            System.out.println("Entered Try Block");
            pstmt=conn.prepareStatement(query);
            System.out.println("pstmt executed");
            pstmt.setString(1,mon);
            pstmt.setInt(2,yr);
            rs=pstmt.executeQuery();
            System.out.println("RS executed");
        }
        catch(Exception e)
        {
            System.out.println("Error in getAllTransactionData Method in client Database Class in DbConnectivity class");
        }
        return rs;
    }
    
    
}