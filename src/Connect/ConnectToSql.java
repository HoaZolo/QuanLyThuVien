/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connect;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author WIN1064
 */

public class ConnectToSql {
   private static Connection conn;
   public static Connection connectDb(){
       String server = "DESKTOP-LM1JJVT\\SQLEXPRESS";
        String user = "sa";
        String password = "123456";
        String db = "QLTV";
        var port = 1433;
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser(user);
        ds.setPassword(password);
        ds.setDatabaseName(db);
        ds.setServerName(server);
        ds.setPortNumber(port);
        try{
            conn = ds.getConnection();
            System.out.println("Kết nối thành công");
            return conn;
        } catch (SQLServerException ex) {
            ex.printStackTrace();
            return null;
        }
   }
   public static void closeConnect(){
       try {
           conn.close();
           System.out.println("Close connection");
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
       }
   }
}
