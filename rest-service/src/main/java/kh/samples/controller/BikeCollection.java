package kh.samples.controller;

import kh.samples.model.Bike;
import kh.samples.model.BikeType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by krzysiek on 27.03.17.
 */
public class BikeCollection {

    private static List<Bike> bikes;

    static {
        bikes = new ArrayList<>();
        Bike bike1 = new Bike();
        bike1.setSerialNumber("ABC123");
        bike1.setBrand("Kelly's");
        bike1.setModel("Image");
        bike1.setType(BikeType.MTB);
        bike1.setWeight(12.5f);

        Bike bike2 = new Bike();
        bike2.setSerialNumber("QWERTY789");
        bike2.setBrand("B'TWin");
        bike2.setModel("Triban 500");
        bike2.setType(BikeType.ROAD);
        bike2.setWeight(10f);

        bikes.add(bike1);
        bikes.add(bike2);
    }

    public static List<Bike> list() {
        return bikes;
    }

    public static Bike add(Bike bike) {
        bikes.add(bike);
        return bike;
    }

    public static Bike get(String serialNumber) {
        return bikes.stream().filter(b -> b.getSerialNumber().equals(serialNumber)).findFirst().get();
    }

    public static Bike update(String serialNumber, Bike bike) {
        Optional<Bike> existingBike = bikes.stream().filter(b -> b.getSerialNumber().equals(serialNumber)).findFirst();
        if (!existingBike.isPresent()) {
            return null;
        }

        bikes.removeIf(b -> b.getSerialNumber().equals(serialNumber));
        bikes.add(bike);
        return bike;
    }

    public static Bike delete(String serialNumber) {
        Optional<Bike> existingBike = bikes.stream().filter(b -> b.getSerialNumber().equals(serialNumber)).findFirst();
        if (!existingBike.isPresent()) {
            return null;
        }

        bikes.removeIf(b -> b.getSerialNumber().equals(serialNumber));
        return existingBike.get();
    }
}
