
package empmgmt.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DbConnection {
    static private Connection con;
    static {
     try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/empmgmtdb","root","Hell@197");
        JOptionPane.showConfirmDialog(null,"Connected Successfully to the db");
     }
     catch(ClassNotFoundException e) {
        JOptionPane.showConfirmDialog(null,"Error in DriverMAnager "+e.getMessage()); 
        e.printStackTrace();
     }
     catch(SQLException e) {
         JOptionPane.showConfirmDialog(null,"Error in SQL "+e.getMessage());
         e.printStackTrace();
     }
    }
    
    public static Connection DbConnection() {
        return con;
    }
    
    public static void CloseDbConnection() {
        try {
            con.close();
        }
        catch(SQLException e) {
         JOptionPane.showConfirmDialog(null,"Error in SQL "+e.getMessage());
         e.printStackTrace();
        }
    }
    
    
}
