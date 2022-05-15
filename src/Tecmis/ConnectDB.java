/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tecmis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KA VI YA
 */
public class ConnectDB {
    String driverMsg = "",driverErr = "",loginMsg = "",loginErr = "";
    
    public Connection MyDBConnection (String inuser, String inpass) {
        String url = "jdbc:mysql://localhost:3306/fot_tecmis";
        String user = "root";
        String pass = "";
        Connection connection = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            driverMsg = "Driver loaded...\n";
            connection = DriverManager.getConnection(url,user,pass);
            loginMsg = "Connected!\n";
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            driverErr = "Driver Error!\n";
        } catch (SQLException ex) {
            loginErr = "User name or password incorrect!\n";
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
}
 
