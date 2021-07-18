package io.squad.parkignlot.services;

import io.squad.parkignlot.models.Car;
import io.squad.parkignlot.models.ParkingLot;

import java.util.List;

public class ParkingService {
    private ParkingLot parkingLot;

    public int createParkingLot(int capacity) {
        this.parkingLot = new ParkingLot(capacity);
        return this.parkingLot.getCapacity();
    }

    public Car leaveParkingLot(int slot) {
        return parkingLot.vacateSlot(slot);
    }

    public List<Integer> getSlotsForDriversAge(int age) {
        return parkingLot.getSlotsForDriverAge(age);
    }

    public int getSlotForRegNum(String regNum) {
        return parkingLot.getSlotsForRegNum(regNum);
    }

    public int parkCar(String regNum, int age) {
        return parkingLot.parkCar(regNum, age);
    }

    public List<String> getRegNumsForDriverWithAge(int age) {
        return parkingLot.getRegNumsForDriverWithAge(age);
    }
}
