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
   

    public static Connection MyDBConnection () {
        String url = "jdbc:mysql://localhost:3306/fot_tecmis";
        String user = "root";
        String pass = "";
        Connection conn1 = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn1=DriverManager.getConnection(url,user,pass);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
              Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn1;
    }
}

 
