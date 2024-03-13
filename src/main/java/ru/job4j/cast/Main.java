package ru.job4j.cast;

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[9];
        Bus bus = new Bus();
        Bus schoolBus = new Bus();
        Bus factoryBus = new Bus();
        Plane airPlane = new Plane();
        Plane copter = new Plane();
        Plane firstPlane = new Plane();
        Train firstTrain = new Train();
        Train highSpeedTrain = new Train();
        Train train = new Train();

        vehicles[0] = bus;
        vehicles[1] = schoolBus;
        vehicles[2] = factoryBus;
        vehicles[3] = airPlane;
        vehicles[4] = copter;
        vehicles[5] = firstPlane;
        vehicles[6] = firstTrain;
        vehicles[7] = highSpeedTrain;
        vehicles[8] = train;

        for (Vehicle vehicle : vehicles) {
           vehicle.move();
        }
    }
}
