package org.randall.teagan.Principles;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//  *NB Tests for this class are omitted as the inner class (Employee) has already been tested in Q1 & Q2 of this assignment.
//  However a test class for EmployeePromotionChecker as been created to test the CheckPromotionDue() method.
public class SRPrinciple {

    //  Example of an Employee class (SRPrincipleViolation) that violates the SR principle as it has the responsibility of
    //  creating objects of Employee as well as determining when an Employee is due for a promotion.
    public class SRPrinciplViolation {

        private int empId;
        private String empName;
        private String empSurname;
        private String empType;
        private Date dateJoined;
        private Date currDate;

        //  SR Principle is violated here:
        public boolean isPromotionDueThisYear() {
            return (currDate.getYear() - dateJoined.getYear()) >= 5;
        }

        public int getEmpId() {
            return empId;
        }

        public void setEmpId(int empId) {
            this.empId = empId;
        }

        public String getEmpName() {
            return empName;
        }

        public void setEmpName(String empName) {
            this.empName = empName;
        }

        public String getEmpSurname() {
            return empSurname;
        }

        public void setEmpSurname(String empSurname) {
            this.empSurname = empSurname;
        }

        public String getEmpType() {
            return empType;
        }

        public void setEmpType(String empType) {
            this.empType = empType;
        }

        public Date getDateJoined() {
            return dateJoined;
        }

        public void setDateJoined(Date dateJoined) {
            this.dateJoined = dateJoined;
        }

        public Date getCurrDate() {
            return currDate;
        }

        public void setCurrDate(Date currDate) {
            this.currDate = currDate;
        }
    }


    //  In the following class, Employee is responsible only for the creation of Employee objects and the promotion
    //  check has been moved to a separate class called EmployeePromotionChecker
    public static class EmployeeSRPCorrection {

        private int empId;
        private String empName;
        private String empSurname;
        private String empType;
        private Date dateJoined;

        public EmployeeSRPCorrection() {
        }

        public EmployeeSRPCorrection(int id, String name, String surname, String type, Date dateJoined) {
            this.empId = id;
            this.empName = name;
            this.empSurname = surname;
            this.empType = type;
            this.dateJoined = dateJoined;
        }

        public int getEmpId() {
            return empId;
        }

        public void setEmpId(int empId) {
            this.empId = empId;
        }

        public String getEmpName() {
            return empName;
        }

        public void setEmpName(String empName) {
            this.empName = empName;
        }

        public String getEmpSurname() {
            return empSurname;
        }

        public void setEmpSurname(String empSurname) {
            this.empSurname = empSurname;
        }

        public String getEmpType() {
            return empType;
        }

        public void setEmpType(String empType) {
            this.empType = empType;
        }

        public Date getDateJoined() {
            return dateJoined;
        }

        public void setDateJoined(Date dateJoined) {
            this.dateJoined = dateJoined;
        }
    }

    //  The class used only to check if an Employee is due for a promotion
    public static class EmployeePromotionChecker {

        private DateFormat dateFormat = new SimpleDateFormat("yyyy");
        private Date date = new Date();

        public boolean isPromotionDue(EmployeeSRPCorrection emp) {
            return (Integer.parseInt(dateFormat.format(date)) - emp.getDateJoined().getYear()) >= 5;
        }
    }

    //  Main has been added to show demonstrate functionality
    public static void main(String[] args){

        Date dateJoined = new Date(2010,4,15);
        EmployeeSRPCorrection emp = new EmployeeSRPCorrection(125,"Teagan", "Randall", "Full-time", dateJoined);
        EmployeePromotionChecker check = new EmployeePromotionChecker();

        System.out.println(check.isPromotionDue(emp));
    }
}






