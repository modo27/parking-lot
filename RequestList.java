import java.util.Map;
import java.util.Set;

public class RequestList {
    public static final String CREATE_PARKING_LOT = "CREATE_PARKING_LOT";
    public static final String PARK = "PARK";
    public static final String SLOT_NUMBERS_FOR_DRIVER_OF_AGE = "SLOT_NUMBERS_FOR_DRIVER_OF_AGE";
    public static final String SLOT_NUMBER_FOR_CAR_WITH_NUMBER = "SLOT_NUMBER_FOR_CAR_WITH_NUMBER";
    public static final String LEAVE = "LEAVE";
    public static final String VEHICLE_REGISTRATION_NUMBER_FOR_DRIVER_OF_AGE = "VEHICLE_REGISTRATION_NUMBER_FOR_DRIVER_OF_AGE";
    public static final Set<String> REQUESTS = Set.of(
            CREATE_PARKING_LOT,
            PARK,
            SLOT_NUMBERS_FOR_DRIVER_OF_AGE,
            SLOT_NUMBER_FOR_CAR_WITH_NUMBER,
            LEAVE,
            VEHICLE_REGISTRATION_NUMBER_FOR_DRIVER_OF_AGE
    );

    public static final Map<String, Integer> REQUEST_VALIDATION = Map.of(
            CREATE_PARKING_LOT, 2,
            PARK, 4,
            SLOT_NUMBERS_FOR_DRIVER_OF_AGE, 2,
            SLOT_NUMBER_FOR_CAR_WITH_NUMBER, 2,
            LEAVE, 2,
            VEHICLE_REGISTRATION_NUMBER_FOR_DRIVER_OF_AGE, 2

    );
}
