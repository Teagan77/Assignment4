package org.randall.teagan;
/**
 * @author Teagan
 * @stdNo 215095111
 * @group B
 */

// Java code to demonstrate encapsulation

public class Employee implements Person{

//  private variables only accessible via public methods in the class

    private int empId;
    private String empName;
    private String empSurname;
    private String empType;

    public Employee(){
    }

    public Employee(int employeeId, String employeeName, String employeeSurname, String employeeType){
        setEmpId(employeeId);
        setEmpName(employeeName);
        setEmpSurname(employeeSurname);
        setEmpType(employeeType);
    }

//    methods for getting & setting values of the private class variables

    public String getEmpSurname(){
        return empSurname;
    }

    public void setEmpSurname(String empSurname){
        this.empSurname = empSurname;
    }

    public int getEmpId(){
        return empId;
    }

    public void setEmpId(int empId){
        this.empId = empId;
    }

    public String getEmpName(){
        return empName;
    }

    public void setEmpName(String empName){
        this.empName = empName;
    }

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    @Override
    public String does(){
        return "Software development";
    }
    
    public static void main(String[] args){
        Employee firstEmp = new Employee();

        firstEmp.setEmpId(311);
        firstEmp.setEmpName("Teagan");
        firstEmp.setEmpSurname("Randall");
        firstEmp.setEmpType("Full-time");

//      Altering private variables through set / get methods

        System.out.println("Employee Number: " + firstEmp.getEmpId());
        System.out.println("-----------------------------------");
        System.out.println("Name/Surname: " + firstEmp.getEmpName() + "  " + firstEmp.getEmpSurname());
        System.out.println("Employee Type: " + firstEmp.getEmpType());
        System.out.println("Employee role: " + firstEmp.does());
        System.out.println("-----------------------------------");
    }
}

