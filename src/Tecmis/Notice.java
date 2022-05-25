/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tecmis;

/**
 *
 * @author KA VI YA
 */
public class Notice {
    public  String  ntID;
    public  String  nttitle;
    public  String  ntDate;
    public  String  ntContent;

public void setNoticeId(String ntID){
    this.ntID=ntID;
}
public String getNoticeId(){
    return ntID;
}
public void setNoticeTitle(String nttitle){
    this.nttitle=nttitle;
}
public String getnoticeTitle(){
    return nttitle;
}

public void setNoticeDate(String ntDate){
    this.ntDate=ntDate;
}

public String getNoticedate(){
    return ntDate;
}

public void setNoticeContent(String ntContent){
    this.ntContent=ntContent;
}

public String getNoticeContent(){
    return ntContent;
}
}
