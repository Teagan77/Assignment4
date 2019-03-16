package org.randall.teagan.Principles;

import org.junit.Assert;
import org.junit.Test;

public class OCPrincipleTest {


    @Test
    public void processRequest() throws Exception {
        OCPrinciple.SolutionSickLeaveRequestAdmin sickAdmin = new OCPrinciple.SolutionSickLeaveRequestAdmin();
        OCPrinciple.SolutionHRAdmin hrAdmin = new OCPrinciple.SolutionHRAdmin();

        Assert.assertEquals("If called as a SickLeaveRequestAdmin processRequest() will return 'SickLeaveRequestApprovalAdmin: Validating sick leave request.' and true", true, hrAdmin.processRequest(sickAdmin));
    }

    @Test
    public void processRequest2() throws Exception {
        OCPrinciple.SolutionLeaveRequestAdmin leaveAdmin = new OCPrinciple.SolutionLeaveRequestAdmin();
        OCPrinciple.SolutionHRAdmin hrAdmin = new OCPrinciple.SolutionHRAdmin();

        Assert.assertEquals("If called as a LeaveRequestAdmin processRequest() will return 'LeaveRequestApprovalAdmin: Validating leave request.' and true", true, hrAdmin.processRequest(leaveAdmin));
    }
}
