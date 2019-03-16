package org.randall.teagan.Principles;

public class LSPrinciple {

    //  *Code that violates the LSPrinciple
    public class Engine{

        private String engine;

        public Engine() {
        }

        public void setEngine(String engine){
            this.engine = engine;
        }

        public String getEngine(){
            return this.engine;
        }
    }

    public class TrasportationDevice
    {
        String name;
        double speed;
        Engine engine;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }

        public Engine getEngine() {
            return engine;
        }

        public void setEngine(Engine engine) {
            this.engine = engine;
        }

        public void startEngine(){
            System.out.println("Engine started.");
        }
    }

    public class Car extends TrasportationDevice{
        @Override
        public void startEngine(){
            System.out.println("Vroom! Vroom! Engine started.");
        }
    }

    public class Skateboard extends TrasportationDevice{
        @Override
        public void startEngine(){
//      *Liskov Substitution Principle violation as skateboard cannot be substituted another subtype of TransportationDevice*
        }
    }

//  Refactored TransportationDevice class
    public static class SolutionTrasportationDevice
    {
    String name;
    double speed;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }
    }

// Transportation device is extended by two classes DeviceWithoutEngine and DeviceWithEngine who each have their own
//  methods for movement.

    public static class DeviceWithoutEngine extends SolutionTrasportationDevice {
        public void move(){
            System.out.println("Moving.");
        }
    }


    public static class DeviceWithEngine extends SolutionTrasportationDevice {
        Engine engine;

        public void startDeviceEngine(){
            System.out.println("Engine started.");
        }
    }

//  Finally our classes (Car and Skateboard) extend these classes and override their methods. This means that we can
//  substitute any instance of DeviceWithoutEngine and DeviceWithEngine with any of their respective subclasses.

    public static class SolutionCar extends DeviceWithEngine {
        public SolutionCar() {
        }

        @Override
        public void startDeviceEngine() {
            System.out.println("Vroom! Vroom! Engine started.");
        }
    }

    public static class SolutionMotorBike extends DeviceWithEngine{
        public SolutionMotorBike(){

        }

        @Override
        public void startDeviceEngine(){
            System.out.println("Beep! Beep! Engine started.");
        }
    }

    public static class SolutionSkateboard extends DeviceWithoutEngine {

        public SolutionSkateboard() {
        }
        @Override
        public void move(){
            System.out.println("Started to move along.");
        }
    }

    public static void main(String[] args){

        DeviceWithEngine device = new DeviceWithEngine();
        SolutionCar car = new SolutionCar();
        SolutionMotorBike motorBike = new SolutionMotorBike();

//      *NB We can swap out DeviceWithEngine's startDeviceEngine() method with an instance of subclass MotorBike or Car
//      and it will not break the implementation

        device.startDeviceEngine();
//      or
        motorBike.startDeviceEngine();
//      or
        car.startDeviceEngine();
    }
}
