package org.randall.teagan;

import java.util.ArrayList;

/**
 * @author Teagan
 * @stdNo 215095111
 * @group B
 */

// Java code to demonstrate composition ('has-a' relationship) an alternative to inheritance
// Another example of an alternative would be the use of an interface

public class Company {

    private ArrayList<Employee> emps;

//  Company has employees that rely on the object of company in order to exist

    public Company(ArrayList<Employee> employees){
        this.emps = employees;
    }

    public ArrayList<Employee> getEmps() {
        return emps;
    }

    public static void main(String[] args){

//      creating a reference to objects of Employee

        Employee e1 =  new Employee(111, "Dk", "Basson", "Full-time");
        PartTimeEmployee e2 =  new PartTimeEmployee(112, "Chad", "Wyngaard", "Part-time");
        Employee e3 =  new Employee(113, "Teagan", "Randall", "Full-time");

        ArrayList<Employee> companyEmps = new ArrayList<>();
        companyEmps.add(e1);
        companyEmps.add(e2);
        companyEmps.add(e3);

//      Passing an ArrayList of employees in the 'Company's constructor

        Company studentsInc = new Company(companyEmps);

        ArrayList<Employee> employees = studentsInc.getEmps();

//      we are able to access methods in the Employee class through compositional inheritance by creating objects and
//      referencing their methods without actually extending the Employee class (concrete inheritance) Employee's rely
//      on Company to exist.

        for(Employee emp : employees){
            System.out.println("-----------------------------------");
            System.out.println("Employee Number: " + emp.getEmpId());
            System.out.println("-----------------------------------");
            System.out.println("Name/Surname: " + emp.getEmpName() + " " + emp.getEmpSurname());
            System.out.println("Employee Type: " + emp.getEmpType());

//          role() method once again demonstrates polymorphism based on which type of employee is calling the method

            System.out.println("Employee role: " + emp.does());
            System.out.println("-----------------------------------\n");
        }
    }
}
