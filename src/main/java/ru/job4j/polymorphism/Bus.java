package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void ride() {
        System.out.println("Автобус начал движение.");
    }

    @Override
    public void passengers(int passengersAmount) {
        System.out.println("Количество пассажиров: " + passengersAmount);
    }

    @Override
    public double fullFill(double fuelAmount, double fuelPrice) {
        return fuelAmount * fuelPrice;
    }
}
