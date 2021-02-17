/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Kelly
 */
public class Employee {
    private String name;
    private double salary;
    private ArrayList<WorkingTime> schedule;
    
    public Employee(String name){
        this.name = name;
        this.schedule = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
    
    public ArrayList<WorkingTime> getSchedule(){
        return schedule;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public void setSchedule(ArrayList<WorkingTime> schedule){
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", salary=" + salary + ", schedule=" + schedule + '}';
    }
    
    public void showSalary(){
        System.out.println("The amount to pay "+ this.name +" is: "+ this.salary+ " USD.");
    }
    
}
