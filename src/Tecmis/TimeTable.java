/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tecmis;

/**
 *
 * @author KA VI YA
 */
public class TimeTable {
    public String  Level;
    public String  tSem;
    public String  tDepID;
    public String S_name;
    public String S_time;
    public String E_time;
    public String L_location;
    public String L_type;

    public String getS_name() {
        return S_name;
    }

    public void setS_name(String S_name) {
        this.S_name = S_name;
    }

    public String getS_time() {
        return S_time;
    }

    public void setS_time(String S_time) {
        this.S_time = S_time;
    }

    public String getE_time() {
        return E_time;
    }

    public void setE_time(String E_time) {
        this.E_time = E_time;
    }

    public String getL_location() {
        return L_location;
    }

    public void setL_location(String L_location) {
        this.L_location = L_location;
    }

    public String getL_type() {
        return L_type;
    }

    public void setL_type(String L_type) {
        this.L_type = L_type;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String Level) {
        this.Level = Level;
    }

    public String gettSem() {
        return tSem;
    }

    public void settSem(String tSem) {
        this.tSem = tSem;
    }

    public String gettDepID() {
        return tDepID;
    }

    public void settDepID(String tDepID) {
        this.tDepID = tDepID;
    }
    
}
