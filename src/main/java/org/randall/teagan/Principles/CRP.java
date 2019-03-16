package org.randall.teagan.Principles;

import org.randall.teagan.Company;
import org.randall.teagan.Employee;
import org.randall.teagan.PartTimeEmployee;

import java.util.ArrayList;

public class CRP{

// Java code to demonstrate composition ('has-a' relationship) an alternative to inheritance
// Another example of an alternative would be the use of an interface

    static class Company {

        private ArrayList<Employee> emps;

//  Company has employees that rely on the object of company in order to exist

        public Company(ArrayList<Employee> employees) {
            this.emps = employees;
        }

        public ArrayList<Employee> getEmps() {
            return emps;
        }
    }
        public static void main(String[] args){

//      creating a hardcoded reference to objects of type Employee (heavy reliance on employee objects)

            Employee employee1 =  new Employee(111, "Marco", "Paulo", "Full-time");
            PartTimeEmployee employee2 =  new PartTimeEmployee(112, "Dk", "Wyngaard", "Part-time");
            Employee employee3 =  new Employee(113, "Teagan", "Basson", "Full-time");

            ArrayList<Employee> companyEmps = new ArrayList<>();
            companyEmps.add(employee1);
            companyEmps.add(employee2);
            companyEmps.add(employee3);

//      Passing an ArrayList of employees in the 'Company's constructor

            org.randall.teagan.Company studentsInc = new org.randall.teagan.Company(companyEmps);

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
