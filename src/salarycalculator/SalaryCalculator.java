/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salarycalculator;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import model.Employee;
import model.WorkingTime;

/**
 *
 * @author Kelly
 */
public class SalaryCalculator {
    private final EmployeeBuilder eb;
    public HashMap<String, Double> paymentWeekday;
    public HashMap<String, Double> paymentWeekend;
    public ArrayList<String> hours;
    
    public SalaryCalculator(){
        this.eb = new EmployeeBuilder();
        this.paymentWeekday = ScheduleTable.paymentWeekday;
        this.paymentWeekend = ScheduleTable.paymentWeekend;
        this.hours = ScheduleTable.hours;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SalaryCalculator calculator = new SalaryCalculator();
        ArrayList<Employee> employees = calculator.eb.getEmployees("src/files/employees.txt");
        calculator.calculateSalary(employees);
    }
    
    public void calculateSalary(ArrayList<Employee> employees){
        for(Employee emp : employees){
            double salary= calculateSalaryEmployee(emp);
            emp.setSalary(salary);
            emp.showSalary();
        }
    }
    
    public double calculateSalaryEmployee(Employee employee){
        double salary =0.0;
        for(WorkingTime time: employee.getSchedule()){
            String timestamp= belongsRange(time); 
            salary+=getAmountPerDay(timestamp, time);
        }
        return salary;
    }
    
    public double getAmountPerDay(String key, WorkingTime time){
        if(key==null || time.getTimeIn()==null || time.getTimeOut()==null){
            return 0.0;
        }
        double amount= isWeekend(time.getDay())? paymentWeekend.get(key): paymentWeekday.get(key); 
   
        Duration difference = Duration.between(time.getTimeIn(), time.getTimeOut());
        double duration = (double) difference.toMinutes()/60;    
        duration = time.getTimeOut().getHour()==0? 24-time.getTimeIn().getHour(): duration;
        //System.out.println("duration: "+duration+" amount: "+amount +" total: "+ (amount*duration));
        return amount * duration;
        
    }
    
    
    public boolean isWeekend(String day){
        return (day.equals("SA") || day.equals("SU"));
    }
    
    public boolean isInTimeStamp(LocalTime start, LocalTime end, LocalTime employeeIn, LocalTime employeeOut){
        if(employeeIn == null || employeeOut==null) 
            return false;
        boolean withStart=  employeeIn.isAfter(start) || employeeIn.equals(start);
        boolean withEnd= employeeOut.isBefore(end) || employeeOut.equals(end) ;
        
        if(end.getHour()==0 && employeeOut.getHour()!=0 ){
            withEnd = employeeOut.getHour()< 24 || employeeOut.getHour()==24;
        }else if(employeeOut.getHour()==0){
            withEnd= employeeOut.equals(end);
        }
        
        return withStart && withEnd;
    }
    
    
    public String belongsRange(WorkingTime time){
        for(String timestamp: hours){
            String[] timeArray = timestamp.split("-");
            LocalTime start = time.getHour(timeArray[0]);
            LocalTime end = time.getHour(timeArray[1]);
            if(isInTimeStamp(start, end, time.getTimeIn(), time.getTimeOut())){
                return timestamp;
            }
        }  
        return null;
    }
    
}
