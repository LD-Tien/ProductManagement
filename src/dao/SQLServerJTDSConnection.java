package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * HoTen: LeDucTien
 * MSV: 2050531200309
 * LHP: 221LTJNC01
 */

public class SQLServerJTDSConnection {
    public static Connection getSQLServerConnection(){
        String connectionURL = "jdbc:jtds:sqlserver://localhost:1433/ProductManagement";
        String userName = "sa";
        String password = "12345sa";
        
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            return DriverManager.getConnection(connectionURL, userName, password);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SQLServerJTDSConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    
        ////  Kiểm tra kêt nối DB
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        Connection conn = getSQLServerConnection();
//        
//        System.out.println("Get connection " + conn);
//        if (conn != null)
//            System.out.println("Done!");
//        else
//            System.out.println("Error!");
//    }
}
