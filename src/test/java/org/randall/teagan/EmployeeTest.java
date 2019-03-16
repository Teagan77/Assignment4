package org.randall.teagan;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Unit test for simple Employee.
 */

public class EmployeeTest {

    private Employee firstEmp = new Employee();

//   direct access to employee class variables is impossible except through public methods.
    @Test
    public void getEmpSurname() {
        firstEmp.setEmpSurname("Jeffrey");
        assertTrue("getEmpSurname() will return 'Jeffrey'.", firstEmp.getEmpSurname().equals("Jeffrey"));
    }

    @Test
    public void setEmpSurname() {
        firstEmp.setEmpSurname("Holmes");
        assertTrue("setEmpSurname() sets the employee's surname to 'Holmes'", firstEmp.getEmpSurname().equals("Holmes"));
    }

    @Test
    public void getEmpId() {
        firstEmp.setEmpId(215);
        assertTrue("getEmpId() returns '215'", firstEmp.getEmpId() == 215);
    }

    @Test
    public void setEmpId() {
        firstEmp.setEmpId(111);
        assertTrue("setEmpId()'sets the employee's ID to '111'", firstEmp.getEmpId() == 111);
    }

    @Test
    public void getEmpName() {
        firstEmp.setEmpName("Smith");
        assertTrue("getEmpName() returns 'Smith'", firstEmp.getEmpName().equals("Smith"));
    }

    @Test
    public void setEmpName() {
        firstEmp.setEmpName("Sherlok");
        assertTrue("setEmpName() sets the employee's name to 'Sherlok'", firstEmp.getEmpName().equals("Sherlok"));
    }

    @Test
    public void getEmpType() {
        firstEmp.setEmpType("Full-time");
        assertTrue("getEmpType() returns 'Full-time'", firstEmp.getEmpType().equals("Full-time"));
    }

    @Test
    public void setEmpType() {
        firstEmp.setEmpType("Part-time");
        assertTrue("setEmpType() sets the employee's type to 'Part-time'", firstEmp.getEmpType().equals("Part-time"));
    }

    @Test
    public void does() {
        assertEquals("The does() method will return 'Software development' if called as an Employee", true, firstEmp.does().equals("Software development"));
    }
}
