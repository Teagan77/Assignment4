package org.randall.teagan.Principles;

public class OCPrinciple {

//  *Code that violates the OCPrinciple, both classes below are functional until a new requirement to process sick leave
//  requests is issued by upper management. This would require a new SickLeaveRequestAdmin class as well as
//  modification to the HRAdmin class which is demonstrated immediately after the two initial classes.*

    public static class HRAdmin{
        public boolean isValidRequest(){
            System.out.println("HR Admin: Validating leave request.");
            return true;
        }
    }

    public class LeaveRequestAdmin {
        public void processLeaveRequest(HRAdmin admin) {
            if(admin.isValidRequest()){
                System.out.println("RequestAdmin: Valid request.");
            }
        }
    }

//  *NB The following code is commented out as it serves as an example of the modifications that would need to take place
//  should a new requirement to process sick leave requests be issued by upper management.*
/*

//  *A new SickLeaveRequestAdmin class needs to be created.*

    public class SickLeaveRequestAdmin{
         public void processSickLeaveRequest(SickLeaveAdmin admin) {
            if(admin.isValidRequest()){
                System.out.println("SickLeaveRequestAdmin: Valid request.");
            }
        }
    }

//  *The HRAdmin class needs a new processSickLeaveRequest() method for the new requirement.*

    public class HRAdmin {

        public void processLeaveRequest (LeaveRequestAdmin admin) {
            if(admin.isValidRequest()){
                System.out.println("LeaveRequestAdmin: Valid request.");
            }
        }

        public void processSickLeaveRequest(SickLeaveRequestAdmin admin){
            if(admin.isValidClaim()){
                System.out.println("SickLeaveRequestAdmin: Valid request.");
            }
        }
    }
*/

//  *The following code demonstrates adherence to the OCPrinciple. To achieve this, we introduce a layer of abstraction
//   by creating an abstract class RequestAdmin to represent different request processing behaviors. We then extend our
//   admin and sickAdmin classes by RequestAdmin and override the processRequest() method.

    public static class SolutionHRAdmin {

        public boolean processRequest(RequestAdmin admin) {
            boolean processed = false;
            if (admin.isValidRequest()) {
               processed = true;
            }
            return processed;
        }
    }

//  The abstract class and subsequent overridden methods.
    public static abstract class RequestAdmin {
        public abstract boolean isValidRequest();
    }

    public static class SolutionLeaveRequestAdmin extends RequestAdmin{
        @Override
        public boolean isValidRequest(){
            System.out.println("LeaveRequestApprovalAdmin: Validating leave request.");
            return true;
        }
    }

    public static class SolutionSickLeaveRequestAdmin extends RequestAdmin{
        @Override
        public boolean isValidRequest(){
            System.out.println("SickLeaveRequestApprovalAdmin: Validating sick leave request.");
            return true;
        }
    }

    //  Main has been added to show demonstrate functionality
    public static void main(String[] args){

        //  calling the processRequest() method with sickAdmin as the argument.
        OCPrinciple.SolutionSickLeaveRequestAdmin sickAdmin = new OCPrinciple.SolutionSickLeaveRequestAdmin();
        OCPrinciple.SolutionHRAdmin hrAdmin = new OCPrinciple.SolutionHRAdmin();
        hrAdmin.processRequest(sickAdmin);

        //  calling the processRequest() method again with leaveAdmin as the argument.
        OCPrinciple.SolutionLeaveRequestAdmin leaveAdmin = new OCPrinciple.SolutionLeaveRequestAdmin();
        OCPrinciple.SolutionHRAdmin hrAdmin2 = new OCPrinciple.SolutionHRAdmin();
        hrAdmin2.processRequest(leaveAdmin);
    }
}
