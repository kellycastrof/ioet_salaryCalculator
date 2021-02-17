/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salarycalculator;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import model.Employee;
import model.WorkingTime;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kelly
 */
public class SalaryCalculatorTest {
    SalaryCalculator instance;
    
    public SalaryCalculatorTest() {
        instance = new SalaryCalculator();
    }
    
    /**
     * Test of calculateSalaryEmployee method, of class SalaryCalculator.
     */
    @Test
    public void testCalculateEmployee() {
        System.out.println("calculateEmployee");
        Employee employee = new Employee("KELLY");
        ArrayList<WorkingTime> workingtimes = new ArrayList<>( Arrays.asList( 
                new WorkingTime("MO","20:00","21:00"),
                new WorkingTime("WE","10:00","12:00"),
                new WorkingTime("SA","02:00","05:00")));
        employee.setSchedule(workingtimes);
        double expResult = 140.0;
        double result = instance.calculateSalaryEmployee(employee);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calculateSalaryEmployee method with invalid range, of class SalaryCalculator.
     */
    @Test
    public void testCalculateEmployeeInvalidRange() {
        System.out.println("calculateEmployee with invalid range");
        Employee employee = new Employee("VALERY");
        ArrayList<WorkingTime> workingtimes = new ArrayList<>( Arrays.asList( 
                new WorkingTime("MO","08:00","15:00")));
        employee.setSchedule(workingtimes);
        double expResult = 0.0;
        double result = instance.calculateSalaryEmployee(employee);
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * Test of calculateSalaryEmployee method with boundary value for 18:01-00:00 and nd 00:01-09:00 , of class SalaryCalculator.
     */
    @Test
    public void testCalculateEmployeeBoundaryValue() {
        System.out.println("calculateEmployee with boundary value for timestamp 18:01-00:00 and 00:01-09:00");
        Employee employee = new Employee("BRITHANY");
        ArrayList<WorkingTime> workingtimes = new ArrayList<>( Arrays.asList( 
                new WorkingTime("SU","19:00","00:00"),
                new WorkingTime("FR","04:00","09:00")));
        employee.setSchedule(workingtimes);
        double expResult = 250.0;
        double result = instance.calculateSalaryEmployee(employee);
        assertEquals(expResult, result, 0.0);
    }
    
    
    /**
     * Test of calculateSalaryEmployee method with non-exact hours, of class SalaryCalculator.
     */
    @Test
    public void testCalculateEmployeeWithNotExactHour() {
        System.out.println("calculateEmployee with non-exact hours");
        Employee employee = new Employee("LUCY");
        ArrayList<WorkingTime> workingtimes = new ArrayList<>( Arrays.asList( 
                new WorkingTime("TH","19:30","21:00")));
        employee.setSchedule(workingtimes);
        double expResult = 30.0;
        double result = instance.calculateSalaryEmployee(employee);
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * Test of calculateSalaryEmployee method with a working time less than one hour, of class SalaryCalculator.
     */
    @Test
    public void testCalculateEmployeeLeesThanOneHour() {
        System.out.println("calculateEmployee with a working time less than one hour");
        Employee employee = new Employee("LUCY");
        ArrayList<WorkingTime> workingtimes = new ArrayList<>( Arrays.asList( 
                new WorkingTime("SU","02:15","03:00")));
        employee.setSchedule(workingtimes);
        double expResult = 22.5;
        double result = instance.calculateSalaryEmployee(employee);
        assertEquals(expResult, result, 0.0);
    }
    
    
    
    /**
     * Test of getAmountPerDay method, of class SalaryCalculator.
     */
    @Test
    public void testGetAmountPerDay() {
        System.out.println("getAmountPerDay");
        String key = "09:01-18:00";
        WorkingTime time = new WorkingTime("MO", "12:00", "18:00");
        double expResult = 90.0;
        double result = instance.getAmountPerDay(key, time);
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * Test of getAmountPerDay method for null key, of class SalaryCalculator.
     */
    @Test
    public void testNullGetAmountPerDay() {
        System.out.println("getAmountPerDay with Null Timestamp");
        String key = null;
        WorkingTime time = new WorkingTime("MO", "12:00", "18:00");
        double expResult = 0.0;
        double result = instance.getAmountPerDay(key, time);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of isWeekend method for a weekday, of class SalaryCalculator.
     */
    @Test
    public void testIsWeekday() {
        System.out.println("isWeekday");
        String day = "MO";
        boolean expResult = false;
        boolean result = instance.isWeekend(day);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isWeekend method, of class SalaryCalculator.
     */
    @Test
    public void testIsWeekend() {
        System.out.println("isWeekend");
        String day = "SU";
        boolean expResult = true;
        boolean result = instance.isWeekend(day);
        assertEquals(expResult, result);
    }

    /**
     * Test of isInTimeStamp method, of class SalaryCalculator.
     */
    @Test
    public void testIsInTimeStamp() {
        System.out.println("isInTimeStamp");
        LocalTime start = LocalTime.of(18, 01);
        LocalTime end = LocalTime.of(00,00);
        LocalTime employeeIn = LocalTime.of(20, 0);
        LocalTime employeeOut = LocalTime.of(00,00);
        
        boolean expResult = true;
        boolean result = instance.isInTimeStamp(start, end, employeeIn, employeeOut);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isInTimeStamp method with an employee timestamp that is not part of the valid timestamps, of class SalaryCalculator.
     */
    @Test
    public void testNotInTimeStamp() {
        System.out.println("NotInTimeStamp");
        LocalTime start = LocalTime.of(18, 01);
        LocalTime end = LocalTime.of(00,00);
        LocalTime employeeIn = LocalTime.of(10, 0);
        LocalTime employeeOut = LocalTime.of(12,00);
        
        boolean expResult = false;
        boolean result = instance.isInTimeStamp(start, end, employeeIn, employeeOut);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isInTimeStamp method with null Employee LocalTime argument, of class SalaryCalculator.
     */
    @Test
    public void testIsInTimeStampWithNullArg() {
        System.out.println("TimeStampWithNullArgument");
        LocalTime start = LocalTime.of(18, 01);
        LocalTime end = LocalTime.of(00,00);
        LocalTime employeeIn = LocalTime.of(10, 0);
        LocalTime employeeOut = null;
        
        boolean expResult = false;
        boolean result = instance.isInTimeStamp(start, end, employeeIn, employeeOut);
        assertEquals(expResult, result);
    }
    
    

    /**
     * Test of belongsRange method with valid timestamp, of class SalaryCalculator.
     */
    @Test
    public void testValidBelongsRange() {
        System.out.println("belongsRange");
        WorkingTime time = new WorkingTime("SU", "10:00", "14:00");
        String expResult = "09:01-18:00";
        String result = instance.belongsRange(time);
        assertEquals(expResult, result);
    }
    /**
     * Test of belongsRange method with an invalid timestamp, of class SalaryCalculator.
     */
    @Test
    public void testInvalidBelongsRange() {
        System.out.println("belongsRange with invalid timestamp");
        WorkingTime time = new WorkingTime("SU", "00:00", "14:00");
        String expResult = null;
        String result = instance.belongsRange(time);
        assertEquals(expResult, result);
    }
    
}
