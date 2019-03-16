package org.randall.teagan.Principles;

public class ISPrinciple {

//  Code that violates the interface segregation principle
    public interface Manager {

        void manage();
        void report();
        void hire();
        void fire();
    }

    public class Teagan implements Manager {

        @Override
        public void manage() {
            System.out.println("Teagan is managing. . .");
        }

        @Override
        public void report() {
            System.out.println("Teagan is reporting to stakeholders. . .");
        }

        //Methods that cannot be used by Teagan as a Manager as they fall under the HRManager class
        @Override
        public void hire() {
        }

        @Override
        public void fire() {
        }
    }

//  Code that satisfies the Interface Segregation principle by having two interfaces and splitting the unused methods

    public interface SolutionManager {
        void manage();
    }

    public interface GeneralManager extends SolutionManager {
        void manage();
        void report();
    }

    public interface HRManager extends SolutionManager{
        void manage();
        void hire();
        void fire();
    }

//  Therefore Teagan will not have to implement methods that he is incapable of performing
    public class SolutionTeagan implements GeneralManager{

        @Override
        public void manage() {
            System.out.println("Teagan is managing. . .");
        }
        @Override
        public void report() {
            System.out.println("Teagan is reporting to stakeholders. . .");
        }
    }

//  The HRManager class that implements HRManager also only has to implement methods that it is capable of performing
//  such as hiring and firing
    public class SolutionHRManager implements HRManager{

        @Override
        public void manage() {
            System.out.println("HRManager is managing. . .");
        }

        @Override
        public void hire() {
            System.out.println("HRManager is hiring employees. . .");
        }

        @Override
        public void fire() {
            System.out.println("HRManager is firing employees. . .");
        }
    }
}
