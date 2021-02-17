/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salarycalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Kelly
 */
public class ScheduleTable {
    
    public static HashMap<String, Double> paymentWeekday = new HashMap<>();
    public static HashMap<String, Double> paymentWeekend = new HashMap<>();
    public static ArrayList<String> hours;
    
    static{
        getWeekend();
        getWeekday();
        hours = new ArrayList<>(Arrays.asList("00:01-09:00", "09:01-18:00","18:01-00:00" ));
    }
    
    public static void getWeekend(){
        paymentWeekend.put("00:01-09:00",30.0);
        paymentWeekend.put("09:01-18:00",20.0);
        paymentWeekend.put("18:01-00:00",25.0);
        
    }
    
    public static void getWeekday(){
        paymentWeekday.put("00:01-09:00",25.0);
        paymentWeekday.put("09:01-18:00",15.0);
        paymentWeekday.put("18:01-00:00",20.0);
    }
    
}
