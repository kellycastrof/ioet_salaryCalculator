# Salary Calculator

## Description
This project calculates the total that the company has to pay an employee, based on the hours they worked and the times during which they worked based.

## Structure
The source code is in two packages: model and salarycalculator

### model
It contains the following classes:
 - Employee: This class contains the name, salary and a list with all the working time of the employee. 
 - WorkingTime: This class contains the day, the entry hour and departure time of an specific employee.

### salarycalculator
This package has all the classes that are needed to calculate the salary of employees using the classes in model. 
 - EmployeeBuilder: It is responsible for reading the .txt file and creating a list of employees.
 - ScheduleTable: It has two HashMap with the information of the payment according to day and hour.
 - SalaryCalculator: It has all the methods that calculate the salary of employees.

In this package is the txt file employees with all the information about working time and days for each employee.

## How it works
The program loads the information in the txt file, creates the Employee objects with their respective WorkingTime, for each employee the timestamp are verified and the interval in the payment HashMap is obtained, the duration is calculated and the pay per day, and finally, the salary for each employee is obtained.

## How to start
```
git clone https://github.com/kellycastrof/ioet_salaryCalculator.git
cd SalaryCalculator/dist
java -jar SalaryCalculator.jar
```

## Results
This is an example of the output of the program.
```
The amount to pay RENE is: 215.0 USD.
The amount to pay ASTRID is: 85.0 USD.
The amount to pay VALERY is: 195.0 USD.
The amount to pay LUCY is: 320.0 USD.
The amount to pay NICOLAS is: 170.0 USD.

```

## JUnit Test
In test packages is the class for testing SalaryCalculator with diferent test cases with valid and invalid arguments. 
![test_result](https://i.postimg.cc/zGRm3Mt2/test-Result.jpg)
