package ru.job4j.cast;

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[9];
        Vehicle bus = new Bus();
        Vehicle schoolBus = new Bus();
        Vehicle factoryBus = new Bus();
        Vehicle airPlane = new Plane();
        Vehicle copter = new Plane();
        Vehicle firstPlane = new Plane();
        Vehicle firstTrain = new Train();
        Vehicle highSpeedTrain = new Train();
        Vehicle train = new Train();

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
