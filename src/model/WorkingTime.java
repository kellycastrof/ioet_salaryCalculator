/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.time.LocalTime; 

/**
 *
 * @author Kelly
 */
public class WorkingTime {
    private String day;
    private LocalTime timeIn;
    private LocalTime timeOut;
    
    public WorkingTime(String day, String start, String end){
        this.day= day;
        this.timeIn = getHour(start);
        this.timeOut = getHour(end);
    }

    
    public double getTimestamp(){
        return 0.0;
    }
    
    
    public LocalTime getHour(String time){
        try{
            String[] data = time.split(":");
            String hour = data[0];
            String minutes = data[1];
            LocalTime result = LocalTime.of(Integer.parseInt(hour), Integer.parseInt(minutes));
            return result;
        }catch(NumberFormatException exception){
            return null;
        }catch(Exception e){
            return null;
        }
    }

    public String getDay() {
        return day;
    }

    public LocalTime getTimeIn() {
        return timeIn;
    }

    public LocalTime getTimeOut() {
        return timeOut;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setTimeIn(LocalTime timeIn) {
        this.timeIn = timeIn;
    }

    public void setTimeOut(LocalTime timeOut) {
        this.timeOut = timeOut;
    }

    @Override
    public String toString() {
        return "WorkingTime{" + "day=" + day + ", timeIn=" + timeIn + ", timeOut=" + timeOut + '}';
    }
    
    
}
