/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tecmis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Logger;

/**
 *
 * @author KA VI YA
 */
public class caMarks {
    private static int credite=0;
    private static int noQuiz=0;
    private static int noAsses=0;
    private static double SQuiz=0;
    private static double SAsss=0;
    private static double SMid=0;
    private static double STheory=0;
    private static double Spractical=0;
    public  String CCode="";
    public double fQuizmarks=0.00;
    public double fAssmarks=0;
    public double fMidmarks=0;
    public double ftheory=0;
    public double fpatrical=0;
    public double fPractical=0;
    public double CAFinal=0;
    public String Status="";
    public String Grade="";

    Connection conn1;
    PreparedStatement insert;
    PreparedStatement CID;

StudentDashboard sdash=new StudentDashboard();
private static DecimalFormat df = new DecimalFormat("0.00");
    public String calculateCA(String UID,String CCode){
    
    try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/fot_tecmis","root","");
                       insert=conn1.prepareStatement("select *  from course_module where cmod_id='"+CCode+"'");
                    ResultSet rs= insert.executeQuery();

                      while(rs.next()){ 

                            credite=rs.getInt("cmod_credite");
                            noQuiz=rs.getInt("con_quiz");
                            noAsses=rs.getInt("con_ass");
                            SQuiz=rs.getDouble("quiz_marks");
                            SAsss=rs.getDouble("assess_marks");
                            SMid=rs.getDouble("mid_marks");
                            STheory=rs.getDouble("theory_marks");
                            Spractical=rs.getDouble("patrical_marks");

                        }
                    insert=conn1.prepareStatement("select * from exam_marks where exm_type='Q' and exm_st_id='"+UID+"' and exm_cmod_id='"+CCode+"' limit "+noQuiz);
                    ResultSet Camarks= insert.executeQuery();
                    int quizm=0;
                    while(Camarks.next()){
                        quizm=quizm+Camarks.getInt("exm_score");
                        
                    }
                    fQuizmarks=(quizm/noQuiz)*(SQuiz/100);

                    insert=conn1.prepareStatement("select * from exam_marks where exm_type='A' and exm_st_id='"+UID+"' and exm_cmod_id='"+CCode+"' limit "+noAsses);
                    ResultSet Caasses= insert.executeQuery();
                    int assm=0;
                    while(Caasses.next()){
                        assm=assm+Caasses.getInt("exm_score");                        
                    }
                    if(noAsses>0){
                        fAssmarks=(assm/noAsses)*(SAsss/100);
                    }else{
                        fAssmarks=0;
                    }

                    insert=conn1.prepareStatement("select * from exam_marks where exm_type='MID' and exm_st_id='"+UID+"' and exm_cmod_id='"+CCode+"'");
                    ResultSet Camid= insert.executeQuery();

                    int midm=0;
                    while(Camid.next()){
                        midm=midm+Camid.getInt("exm_score");
                        
                    }
                    fMidmarks=(midm)*(SMid/100);

                    CAFinal=fAssmarks+fQuizmarks+fMidmarks;

                    double CAfifypresent=(SQuiz+SMid+SAsss)/2;
                   
                   
                    if(CAfifypresent<CAFinal){
                        Status="Eligible";
                    }else{
                        Status="Not Eligible";
                    }

                    int theory=0;
                    insert=conn1.prepareStatement("select * from exam_marks where exm_type='FT' and exm_st_id='"+UID+"' and exm_cmod_id='"+CCode+"'");
                    ResultSet FinalTheory= insert.executeQuery();
                    while(FinalTheory.next()){
                        theory=FinalTheory.getInt("exm_score");
                        
                    }
                    ftheory=theory*(STheory/100);

                    int practical=0;
                    insert=conn1.prepareStatement("select * from exam_marks where exm_type='FT' and exm_st_id='"+UID+"' and exm_cmod_id='"+CCode+"'");
                    ResultSet FinalPractical= insert.executeQuery();
                    while(FinalPractical.next()){
                        practical=FinalPractical.getInt("exm_score");
                      
                    }
                    fPractical=Spractical*(Spractical/100);
  
        } catch (ClassNotFoundException classNotFoundException) {
                System.out.println("File not found");

        } catch (SQLException ex) {
            Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

  return Status;      
}
public String findGrade(double marks){
        if(marks >= 80 && marks <= 100){
		Grade="A+";
        }else if(marks < 80 && marks >= 75){
		Grade="A";
        }else if(marks < 75 && marks >= 70){
		Grade="A-";
        }else if(marks < 70 && marks >= 65){
		Grade="B+";
	}else if(marks < 65 && marks >= 60){
		Grade="B";
        }else if(marks < 60 && marks >=55){
		Grade="B-";
        }else if(marks < 55 && marks >= 50){
		Grade="C+";  
        }else if(marks < 50 && marks >= 45){
		Grade="C";
        }else if(marks < 45 && marks >= 40){
		Grade="C-";   
        }else if(marks < 40 && marks >= 30){
		Grade="D";
        }else if(marks < 30 && marks >= 0){
		Grade="E";          
        }else {
		Grade="Not Valid";
	}
return Grade;
}
   public String QuizMarks(){
        return df.format(fQuizmarks);
    
    }
  public String AssesMarks(){
        return df.format(fAssmarks);
    
    }
  public String MidMarks(){
        return df.format(fMidmarks);
    
    }
    public double Ftheory(){
        return (ftheory);
    
    }
    public double Fpractical(){
        return (fPractical);
    
    }

    public double FinalCA(){
        return  CAFinal;
    
    }
}
