package io.squad.parkignlot.models;

public class Car extends Vehicle {

    private final String registrationNum;
    private final int driverAge;

    public Car(String registrationNum, int age) {
        super(registrationNum, age);
        this.registrationNum = registrationNum;
        this.driverAge = age;
    }

    public String getRegistrationNum() {
        return this.registrationNum;
    }

    public int getDriverAge() {
        return this.driverAge;
    }
}
