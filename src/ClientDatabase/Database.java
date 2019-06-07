package ClientDatabase;

import Client.TRAC;
import Client.HomePage;
import java.awt.Image;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Database {

    private static Connection conn = null;
    private static String sql = null;
    private static PreparedStatement pstmt = null;
    private DateFormat df = null;
    private java.util.Date dateobj = null;

    public Database() throws ClassNotFoundException {
        df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
        dateobj = new java.util.Date();
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:UserDatabase.db");
            System.out.println("Connection to Sqlite has been established.");
        } catch (SQLException e) {
            System.out.println("Error in dbConnectivity() constructor");
        }
    }

    
    public void addTransactionData(TRAC AR) throws ClassNotFoundException 
    {
        sql = "INSERT INTO PurchaseHistory(Day,Month,Year,Time,Pid,Image,Description,MFG,Type,Quant,Cost,Company) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            System.out.println("Entered try block");
            pstmt = conn.prepareStatement(sql);
            System.out.println("1 ex");
            pstmt.setInt(1, AR.Day);
            System.out.println("2 ex");
            pstmt.setString(2, AR.Month);
            System.out.println("3 ex");
            pstmt.setInt(3, AR.Year);
            System.out.println("4 ex");
            pstmt.setString(4, AR.Time);
            System.out.println("5 ex");
            pstmt.setInt(5, AR.pid);
            System.out.println("6 ex");
            pstmt.setBytes(6, AR.imgbyte);
            System.out.println("7 ex");
            pstmt.setString(7, AR.Desc);
            System.out.println("8 ex");
            pstmt.setString(8, AR.MFG);
            System.out.println("9 ex");
            pstmt.setString(9, AR.pname);
            System.out.println("10 ex");
            pstmt.setInt(10, AR.Quant);
            System.out.println("11 ex");
            pstmt.setString(11, AR.Cost);
            System.out.println("12 ex");
            pstmt.setString(12, AR.Comp);
            System.out.println("13 ex");
            pstmt.execute();
            System.out.println("Values of Transaction Data Inserted Successfully");
            //  return 1;
        } catch (SQLException e) 
        {
            System.out.println("Exception in dbConnectivity Class in addTransactionData function");
        }
    }
    public void updateTotalPurchase(String TCst)
    {
        String date[] = df.format(dateobj).split(" ");
        String myd[] = date[0].split("/"), mth = null;
        switch (myd[1]) {
            case "01": {
                mth = "January";
                break;
            }
            case "02": {
                mth = "February";
                break;
            }
            case "03": {
                mth = "March";
                break;
            }
            case "04": {
                mth = "April";
                break;
            }
            case "05": {
                mth = "May";
                break;
            }
            case "06": {
                mth = "June";
                break;
            }
            case "07": {
                mth = "July";
                break;
            }
            case "08": {
                mth = "August";
                break;
            }
            case "09": {
                mth = "September";
                break;
            }
            case "10": {
                mth = "October";
                break;
            }
            case "11": {
                mth = "November";
                break;
            }
            case "12": {
                mth = "December";
                break;
            }
        }
        ResultSet rs = null;
        String query = "SELECT * FROM [TotalPurchaseThisMonth] WHERE Month=? and Year=?;";
        System.out.println("query initialised");
        try {
            System.out.println("Entered Try Block");
            pstmt = conn.prepareStatement(query);
            System.out.println("pstmt executed");
            pstmt.setString(1,mth);
            pstmt.setString(2,myd[2]);
            rs = pstmt.executeQuery();
            System.out.println("RS executed");
            if(rs.next())
            {
                Float TT=Float.parseFloat(rs.getString(3));
                TT+=(Float.parseFloat(TCst));
                query="UPDATE TotalPurchaseThisMonth SET Total=? where Month=? and Year=?";
                pstmt = conn.prepareStatement(query);
            System.out.println("pstmt executed");
            pstmt.setString(1,TT.toString());
            pstmt.setString(2,mth);
            pstmt.setString(3,myd[2]);
            rs = pstmt.executeQuery();
            System.out.println("RS executed");
            }
            else
            {
                query="INSERT INTO TotalPurchaseThisMonth(Month,Year,Total) VALUES(?,?,?)";
                pstmt = conn.prepareStatement(query);
            System.out.println("pstmt executed");
            pstmt.setString(1,mth);
            pstmt.setString(2,myd[2]);
            pstmt.setString(3,TCst);
            rs = pstmt.executeQuery();
            System.out.println("Values of update Total Purchase updated Successfully");
            }
        } catch (Exception e) {
            System.out.println("Error in updateTotalPurchase in DbConnectivity class");
        }
    }
    
    public void deleteAllTempCart() 
    {
        sql = "DELETE FROM TempCart;";
        PreparedStatement Prep = null;
        try {
            System.out.println("Entered try block");
            Prep = conn.prepareStatement(sql);
            Prep.execute();
            System.out.println("Values Deleted from Temp Cart Successfully");
        } catch (SQLException e) {
            System.out.println("Exception in dbConnectivity Class in deleteAll function");
        }
    }

    public ResultSet getTempCartData() 
    {
        ResultSet rs = null;
        String query = "SELECT * FROM [TempCart];";
        System.out.println("query initialised");
        try {
            System.out.println("Entered Try Block");
            pstmt = conn.prepareStatement(query);
            System.out.println("pstmt executed");
            rs = pstmt.executeQuery();
            System.out.println("RS executed Get TempCart DAta Executed");
        } catch (Exception e) {
            System.out.println("Error in getTempCartData in DbConnectivity class");
        }
        return rs;
    }

    public void addTempCartData(int pid, String pname, String date, String time, String Comp, String desc, String Mfg, String Cost, int Q, byte[] img) throws ClassNotFoundException {
        sql = "INSERT INTO TempCart(pid,pname,Date,Time,Company,Description,MFG,Cost,Quantity,Image) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            System.out.println("Entered try block");
            pstmt = conn.prepareStatement(sql);
            System.out.println("1 ex");
            pstmt.setInt(1, pid);
            System.out.println("2 ex");
            pstmt.setString(2, pname);
            System.out.println("3 ex");
            pstmt.setString(3, date);
            System.out.println("4 ex");
            pstmt.setString(4, time);
            System.out.println("5 ex");
            pstmt.setString(5, Comp);
            System.out.println("6 ex");
            pstmt.setString(6, desc);
            System.out.println("7 ex");
            pstmt.setString(7, Mfg);
            System.out.println("8 ex");
            pstmt.setString(8, Cost);
            System.out.println("9 ex");
            pstmt.setInt(9, Q);
            System.out.println("10 ex");
            pstmt.setBytes(10, img);
            System.out.println("11 ex");
            pstmt.execute();
            System.out.println("Values Inserted in Temp Cart Successfully");
            //  return 1;
        } catch (SQLException e) {
            System.out.println("Exception in dbConnectivity Class addTempCArt method in function");
            // return 0;
        }
    }

    public int getLoginLogs(String User, String pass) {
        ResultSet rs = null;
        String query = "select * from UserDetails   where UserName=? and Password=?";
        System.out.println("query initialised");
        try {
            System.out.println("Entered Try Block");
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, User);
            pstmt.setString(2, pass);
            System.out.println("pstmt executed");
            rs = pstmt.executeQuery();
            System.out.println("RS executed");
            if (rs != null) {
                rs.next();
                System.out.println("User Name is : " + rs.getString(2));
                // if(rs.getString(3).equals(pass))
                // {
                System.out.println("Password  is : " + rs.getString(3));
                System.out.println("Returning 1 from DbConnectivity class in checkLogin  method");
                return 1;
                // }
                /* else
                {
                    System.out.println("User Nanme matched but password not matched : "+rs.getString(2)+"   "+rs.getString(3));
                    System.out.println("Returning 0 from DbConnectivity class in checkLogin  method");
                    return 0;
                }*/
            } else {
                System.out.println("rs is null . !! No result found in the database");
            }
        } catch (Exception e) {
            System.out.println("Error in getAllData in DbConnectivity class");
            System.out.println(e);
            System.out.println("Returning 0 from DbConnectivity class in checkLogin  Method due to exception");
            return 0;
        }
        return 0;
    }

    public ResultSet getAllTransactioData() 
    {
        ResultSet rs = null;
        String query = "SELECT * FROM [PurchaseHistory];";
        PreparedStatement Prep = null;
        System.out.println("query initialised in getAllTransactionData method in client Database.");
        try {
            System.out.println("Entered Try Block");
            Prep = conn.prepareStatement(query);
            System.out.println("pstmt executed");
            rs = Prep.executeQuery();
            System.out.println("RS executed");
        } catch (Exception e) {
            System.out.println("Error in getAllTransactionData Method in client Database Class in DbConnectivity class");
        }
        return rs;
    }

    public ResultSet getTransactionHistoryDateWise(String mon, int yr) {
        ResultSet rs = null;
        String query = "SELECT * FROM [PurchaseHistory] where Month=? and Year = ?;";
        System.out.println("query initialised");
        try {
            System.out.println("Entered Try Block");
            pstmt = conn.prepareStatement(query);
            System.out.println("pstmt executed");
            pstmt.setString(1, mon);
            pstmt.setInt(2, yr);
            rs = pstmt.executeQuery();
            System.out.println("RS executed getTransactionHistoryDateWise Executed");
        } catch (Exception e) {
            System.out.println("Error in getTransactionHistoryDateWise Method in client Database Class in DbConnectivity class");
        }
        return rs;
    }

}