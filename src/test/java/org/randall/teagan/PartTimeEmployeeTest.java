package org.randall.teagan;

import org.junit.Test;
import static org.junit.Assert.*;

public class PartTimeEmployeeTest {

    PartTimeEmployee partTimeEmp = new PartTimeEmployee();

    @Test
    public void does() {
        assertEquals("The does() method will return 'Technical support.' if called as a PartTimeEmployee", true, partTimeEmp.does().equals("Technical support."));
    }
}