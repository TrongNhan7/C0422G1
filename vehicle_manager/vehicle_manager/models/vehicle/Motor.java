package vehicle_manager.models.vehicle;

import vehicle_manager.models.Manufacturer.Manufacture;

import java.util.List;

public class Motor extends Vehicle {
    private int capacity;

    public Motor(List<String> data) {
        super(data.get(0), new Manufacture(data.get(1)), Integer.parseInt(data.get(2)), data.get(3));
        this.capacity = Integer.parseInt(data.get(4));
    }

    public static String getPropertiesMotor() {
        return "NUMBER_PLATE,MANUFACTURE,YEAR,OWNER,CAPACITY";
    }

    @Override
    public String toString() {
        return "Motor{" +
                "numberPlate='" + getNumberPlate() + '\'' +
                ", " + getManufacture() +
                ", Year=" + getYear() +
                ", Owner='" + getOwner() + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
