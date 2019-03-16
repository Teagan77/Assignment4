package org.randall.teagan;
/**
 * @author Teagan
 * @stdNo 215095111
 * @group B
 */

// Java code to demonstrate inheritance ('is-a' relationship) as well as polymorphism (many forms)

public class PartTimeEmployee extends Employee implements Person {

    public PartTimeEmployee(){

    }

    public PartTimeEmployee(int id, String name, String surname, String type){
        this.setEmpId(id);
        this.setEmpName(name);
        this.setEmpSurname(surname);
        this.setEmpType(type);
    }

    private String type = "Part-time";
    private String name = "Dan";
    private String surname = "Jhonson";
    private int id = 554;

//  Implementing superclass does() method, using the same method to perform a different function by overriding it (Polymorphism)
    @Override
    public String does(){
        return "Technical support.";
    }

    public static void main (String[] args){

//      Polymorphic parTimeEmployee implementing Person in the following line (purely a demonstrative example)
//      Person firstPerson = partTimeEmp;

        PartTimeEmployee partTimeEmp = new PartTimeEmployee();

//      redundant method uses to demonstrate that PartTimeEmp can access superclass Employee's methods (Inheritance)
        partTimeEmp.setEmpId(partTimeEmp.id);
        partTimeEmp.setEmpName(partTimeEmp.name);
        partTimeEmp.setEmpSurname(partTimeEmp.surname);
        partTimeEmp.setEmpType(partTimeEmp.type);

        System.out.println("-----------------------------------");
        System.out.println("Employee Number: " + partTimeEmp.getEmpId());
        System.out.println("-----------------------------------");
        System.out.println("Name/Surname: " + partTimeEmp.getEmpName() + "  " + partTimeEmp.getEmpSurname());
        System.out.println("Employee Type: " + partTimeEmp.getEmpType());
        System.out.println("Employee role: " + partTimeEmp.does());
        System.out.println("-----------------------------------");
    }
}
