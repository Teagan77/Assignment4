package org.randall.teagan;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 * Unit test for simple Company.
 */

public class CompanyTest {

    private ArrayList<Employee> emps = new ArrayList<>();
    private Employee e1 =  new Employee(111, "Teagan", "Randall", "Full-time");

    @Test
    public void getEmps() {
        emps.add(e1);
        assertTrue("getEmps() will return an ArrayList of type Employee", emps.get(0) instanceof Employee );
    }
}