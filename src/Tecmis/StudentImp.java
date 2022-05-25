/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tecmis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KA VI YA
 */

public class StudentImp implements StudentIF{
PreparedStatement select;
    @Override
    public void Notice(Notice notice){
    

}
 @Override
 public List<Notice> List(){
    List<Notice> list=new ArrayList<>();
     try {
            Connection conn1=ConnectDB.MyDBConnection();
            select=conn1.prepareStatement("select *  from notice");
            ResultSet rs= select.executeQuery();

            while(rs.next()){
                    Notice Nt=new Notice();              
                    Nt.setNoticeId(rs.getString("Notice_ID"));
                    Nt.setNoticeDate(rs.getString("DATE"));
                    Nt.setNoticeTitle(rs.getString("Subject"));
                    list.add(Nt);
 
             }

       } catch (SQLException ex) {
            Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
         return list;   
       }
}
