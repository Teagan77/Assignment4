package org.randall.teagan.Principles;

import org.randall.teagan.Employee;
import org.randall.teagan.PartTimeEmployee;

import java.util.ArrayList;

public class PrincipleLK {

//   Code that violates the Principle of Least Knowledge.

    public static class ClassA {

        public static ClassB getB(){
            ClassB b = new ClassB();
            return b;
        }
    }

    public static class ClassB {

        public ClassC getC(){
            ClassC c = new ClassC();
            return c;
        }
    }

    public static class ClassC {

        public Employee getEmp(){
            Employee emp = new Employee();
            return emp;
        }

    }

//    Code that complies with the principle of least knowledge.
    public static class LawOfDemeterInJava {

        public void goodExamples(Employee emp) {
            ArrayList<Employee> employees = new ArrayList<>();
            employees.add(emp);
            CRP.Company comp = new CRP.Company(employees);

            // We can call our own methods
            ourMethod();

            // We can call methods on an object passed in our method
            int identificationNo = emp.getEmpId();

            // We can call the methods of any objects we have created
            PartTimeEmployee ptEmp = new PartTimeEmployee();
            String empName = ptEmp.getEmpName();

            // We can call any directly held component objects
            System.out.println("These are object references to our Array:" + comp.getEmps());
        }
        private void ourMethod() {
            System.out.println("According to the PLK, this is a legal method call.");
        }
    }
    public static void main(String[] args){

//      Calling violation classes to demonstrate how they are flawed:
        ClassA classA = new ClassA();
        Employee firstEmp = ClassA.getB().getC().getEmp();

//      Calling classes that adhere to the PLK
        LawOfDemeterInJava law = new LawOfDemeterInJava();
        Employee emp = new Employee(125, "Teagan", "Randall", "Full-time");
        law.goodExamples(emp);
    }
}

