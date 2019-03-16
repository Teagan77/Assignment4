package org.randall.teagan.Principles;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.randall.teagan.Principles.SRPrinciple;
import org.randall.teagan.Principles.SRPrinciple.EmployeePromotionChecker;
import java.util.Date;

/**
 * Unit test for simple EmployeePromotionChecker.
 */

public class EmployeePromotionCheckerTest {

    EmployeePromotionChecker check = new EmployeePromotionChecker();
    SRPrinciple.EmployeeSRPCorrection emp = new SRPrinciple.EmployeeSRPCorrection();

    @Before
    public void beforeMethod(){
        Date dateJoined = new Date(2010,4,15);
        emp.setEmpId(125);
        emp.setEmpName("Teagan");
        emp.setEmpSurname("Randall");
        emp.setEmpType("Full-time");
        emp.setDateJoined(dateJoined);
    }
    @Test
    public void isPromotionDue(){
        Assert.assertEquals("isPromotionDue() will return true if an Employee joined 5 or more years ago.", true, check.isPromotionDue(emp));
    }
}
