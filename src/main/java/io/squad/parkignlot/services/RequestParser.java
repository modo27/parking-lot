package io.squad.parkignlot.services;

import io.squad.parkignlot.exceptions.ParkingException;
import io.squad.parkignlot.exceptions.RequestNotFoundException;
import io.squad.parkignlot.models.Car;
import io.squad.parkignlot.utils.RequestList;

import java.util.List;

public class RequestParser {
    ParkingService parkingService;

    public RequestParser() {
        parkingService = new ParkingService();
    }

    public void parseRequest(String request) throws RequestNotFoundException, ParkingException {
        String[] requestParams = request.trim().split(" ");
        String requestType = requestParams[0].toUpperCase();
        if (!RequestList.REQUESTS.contains(requestType)) {
            throw new RequestNotFoundException(requestType);
        }
        if (requestParams.length != RequestList.REQUEST_VALIDATION.get(requestType))
            throw new RequestNotFoundException("Argument length doesn't match for for request type " + requestType);
        try {
            executeRequest(requestType, requestParams);
        } catch (Exception e) {
            throw new ParkingException(e.getMessage(), e);
        }
    }

    private void executeRequest(String requestType, String[] requestParams) throws ParkingException {
        if (requestType.equals(RequestList.CREATE_PARKING_LOT)) {
            try {
                int cap = Integer.parseInt(requestParams[1]);
                int parkingLotCapacity = parkingService.createParkingLot(cap);
                System.out.println("Created parking of " + parkingLotCapacity + " slots");
            } catch (NumberFormatException ex) {
                throw new NumberFormatException("Requires integer but passed string " + requestParams[1]);
            }
        } else if (requestType.equals(RequestList.LEAVE)) {
            try {
                int slotNum = Integer.parseInt(requestParams[1]);
                Car removedCar = parkingService.leaveParkingLot(slotNum);
                if (removedCar == null)
                    System.out.println();
                else
                    System.out.println("Slot number " + slotNum + " vacated, the car with vehicle registration number" +
                            " \"" + removedCar.getRegistrationNum() + "\" left the space, the driver of the car was of age " +
                            removedCar.getDriverAge());
            } catch (NumberFormatException ex) {
                throw new NumberFormatException("Requires integer but passed string " + requestParams[1]);
            }
        } else if (requestType.equals(RequestList.SLOT_NUMBERS_FOR_DRIVER_OF_AGE)) {
            try {
                int age = Integer.parseInt(requestParams[1]);
                List<Integer> slots = parkingService.getSlotsForDriversAge(age);
                if (slots.size() == 0)
                    System.out.println();
                else {
                    for (int i = 0; i < slots.size() - 1; i++)
                        System.out.print(slots.get(i) + ",");
                    if (slots.size() > 0)
                        System.out.print(slots.get(slots.size() - 1));
                }
                System.out.println();
            } catch (NumberFormatException ex) {
                throw new NumberFormatException("Requires integer but passed string " + requestParams[1]);
            }
        } else if (requestType.equals(RequestList.SLOT_NUMBER_FOR_CAR_WITH_NUMBER)) {
            String regNum = requestParams[1];
            int slot = parkingService.getSlotForRegNum(regNum);
            if (slot != 0) {
                System.out.println(slot);
            } else {
                System.out.println();
            }
        } else if (requestType.equals(RequestList.PARK)) {
            try {
                String regNum = requestParams[1];
                int age = Integer.parseInt(requestParams[3]);
                int slot = parkingService.parkCar(regNum, age);
                if (slot != -1) {
                    System.out.println("Car with vehicle registration number \"" + regNum + "\" has been parked at slot number " + slot);
                } else {
                    System.out.println("Error: All slots filled, can't park new vehicle");
                }
            } catch (NumberFormatException ex) {
                throw new NumberFormatException("Requires integer but passed string " + requestParams[1]);
            }
        } else if (requestType.equals(RequestList.VEHICLE_REGISTRATION_NUMBER_FOR_DRIVER_OF_AGE)) {
            try {
                int age = Integer.parseInt(requestParams[1]);
                List<String> regNums = parkingService.getRegNumsForDriverWithAge(age);
                if (regNums.size() == 0)
                    System.out.println();
                else {
                    for (int i = 0; i < regNums.size() - 1; i++)
                        System.out.print(regNums.get(i) + ",");
                    if (regNums.size() > 0)
                        System.out.print(regNums.get(regNums.size() - 1));
                }
                System.out.println();
            } catch (NumberFormatException ex) {
                throw new NumberFormatException("Requires integer but passed string " + requestParams[1]);
            }
        }
    }
}
