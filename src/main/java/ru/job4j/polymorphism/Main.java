package ru.job4j.polymorphism;

public class Main {
    public static void main(String[] args) {
        System.out.println("TownCar: ");
        Vehicle townCar = new TownCar();
        townCar.accelerate();
        townCar.brake();
        townCar.changeGear();
        townCar.steer();

        System.out.println();

        System.out.println("SportCar: ");
        Vehicle sportCar = new SportCar();
        sportCar.changeGear();
        sportCar.accelerate();
        sportCar.steer();
        sportCar.brake();

        System.out.println();

        System.out.println("SportCar1: ");
        SportCar sportCar1 = new SportCar();
        Vehicle vehicle = sportCar1;
        Fuel fuel = sportCar1;
        vehicle.changeGear();
        vehicle.accelerate();
        vehicle.steer();
        vehicle.brake();
        fuel.refill();
    }
}
