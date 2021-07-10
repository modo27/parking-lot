import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParkingLot {

    private final int capacity;
    private final Car[] slots;
    private int filledSlots;
    private Set<String> carRegNums = new HashSet<>();
    private int nearestAvailableSlot;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.slots = new Car[capacity + 1];
        this.filledSlots = 0;
        this.nearestAvailableSlot = 1;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFilledSlots() {
        return filledSlots;
    }

    public Car[] getSlots() {
        return slots;
    }

    public Car vacateSlot(int slot) {
        if (filledSlots == 0 || slots[slot] == null || slot < 1 || slot > capacity)
            return null;
        else if (slots[slot] != null) {
            this.filledSlots--;
            this.nearestAvailableSlot = Math.min(nearestAvailableSlot, slot);
            Car leavingCar = slots[slot];
            slots[slot] = null;
            return leavingCar;
        }
        return null;
    }

    public List<Integer> getSlotsForDriverAge(int age) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= capacity; i++) {
            if (slots[i] != null) {
                if (slots[i].getDriverAge() == age) {
                    res.add(i);
                }
            }
        }
        return res;
    }

    public int getSlotsForRegNum(String regNum) {
        for (int i = 1; i <= capacity; i++) {
            if (slots[i] != null) {
                if (slots[i].getRegistrationNum().equals(regNum))
                    return i;
            }
        }
        return 0;
    }

    public int parkCar(String regNum, int age) {
        if (carRegNums.contains(regNum) || filledSlots >= capacity || nearestAvailableSlot == -1)
            return -1;
        filledSlots++;
        slots[nearestAvailableSlot] = new Car(regNum, age);
        int slotUsed = nearestAvailableSlot;
        nearestAvailableSlot = getNearestAvailableSlot();
        return slotUsed;
    }

    public List<String> getRegNumsForDriverWithAge(int age) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= capacity; i++) {
            if (slots[i] != null) {
                if (slots[i].getDriverAge() == age) {
                    res.add(slots[i].getRegistrationNum());
                }
            }
        }
        return res;
    }

    private int getNearestAvailableSlot() {
        if (filledSlots >= capacity)
            return -1;
        for (int i = 1; i <= capacity; i++) {
            if (slots[i] == null)
                return i;
        }
        return -1;
    }
}