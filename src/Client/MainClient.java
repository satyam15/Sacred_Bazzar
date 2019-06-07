package Client;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MainClient
{
    public  static SL sl=null;
    public static void main(String[] args) 
    {
        try 
        {
            for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
            {
                if("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch(ClassNotFoundException ex) 
        {
            java.util.logging.Logger.getLogger(SL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(SL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (IllegalAccessException ex) 
        {
            java.util.logging.Logger.getLogger(SL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (javax.swing.UnsupportedLookAndFeelException ex) 
        {
            java.util.logging.Logger.getLogger(SL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                try {
                    sl=new SL();
                    sl.setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    } 
}