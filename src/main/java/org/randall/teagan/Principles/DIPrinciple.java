package org.randall.teagan.Principles;

import java.util.ArrayList;
import java.util.List;

public class DIPrinciple {

//  code that violates the dependency inversion principle
    public class Developer {

    public void writeJava() {
        System.out.println("Coding Java. . .");
    }
}
    public class dbDeveloper {

        public void writeSQL() {
            System.out.println("Coding SQL. . .");
        }
    }

    public class Project {

//      Both the first, and second parts of the dependency inversion principle are violated as we depend on concretions
//      and the methods writeJava() and writeSQL() are each class bound.

        private Developer dev = new Developer();
        private dbDeveloper dbDev = new dbDeveloper();

        public void implement() {
            dev.writeJava();
            dbDev.writeSQL();
        }

    }

//  code that complies with the dependency inversion principle
    public interface DevEmployee {
        void develop();
    }

    public static class SolutionDeveloper implements DevEmployee {

        @Override
        public void develop() {
            writeJava();
        }

        public void writeJava() {
            System.out.println("Coding Java. . .");
        }
    }

    public static class SolutionDBDeveloper implements DevEmployee {

        @Override
        public void develop() {
            writeSQL();
        }

        public void writeSQL() {
            System.out.println("Coding SQL. . .");
        }
    }

//  The SolutionProject class does not depend on lower level modules. It depends on abstractions.
    public static class SolutionProject {

        private List<DevEmployee> developers;

        public SolutionProject(List<DevEmployee> developers) {
            this.developers = developers;
        }

        public void codeProject() {
            for(int i = 0;i < developers.size();i++){
                developers.get(i).develop();
            }
        }
    }

    public static void main(String[] args){

        SolutionDeveloper dev1 = new SolutionDeveloper();
        SolutionDeveloper dev2 = new SolutionDeveloper();
        SolutionDBDeveloper sqlDev1 = new SolutionDBDeveloper();
        SolutionDBDeveloper sqlDev2 = new SolutionDBDeveloper();

        List<DevEmployee> devs = new ArrayList<>();
        devs.add(dev1);
        devs.add(dev2);
        devs.add(sqlDev1);
        devs.add(sqlDev2);

        SolutionProject proj = new SolutionProject(devs);
        proj.codeProject();
    }
}
