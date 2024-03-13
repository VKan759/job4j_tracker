package ru.job4j.polymorphism;

public interface Transport {
    void ride();

    void passengers(int passengersAmount);

    double fullFill(double fuelAmount, double fuelPrice);
}
