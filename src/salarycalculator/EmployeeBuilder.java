/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salarycalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import model.Employee;
import model.WorkingTime;

/**
 *
 * @author Kelly
 */
public class EmployeeBuilder {

    public ArrayList<Employee> getEmployees(String filename) {
        ArrayList<Employee> employees = new ArrayList<>();

        try (InputStream inputStream = getClass().getResourceAsStream(filename);
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = reader.readLine();
            while (line != null) {
                String[] data = line.split("=");
                Employee employee = new Employee(data[0]);
                this.saveSchedule(data[1],
                        employee.getSchedule());
                employees.add(employee);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public void saveSchedule(String data, ArrayList<WorkingTime> schedule) {
        String[] working = data.split(",");

        for (String dayInfo : working) {
            String[] hours = dayInfo.split("-");
            String day = hours[0].substring(0, 2);
            String start = hours[0].substring(2);
            schedule.add(new WorkingTime(day, start, hours[1]));
        }
    }

}
