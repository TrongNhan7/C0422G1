package vehicle_manager.models.vehicle;

import vehicle_manager.models.Manufacturer.Manufacture;

import java.util.List;

public class Truck extends Vehicle {
    private int tonnage;

    public Truck(List<String> data) {
        super(data.get(0), new Manufacture(data.get(1)), Integer.parseInt(data.get(2)), data.get(3));
        this.tonnage = Integer.parseInt(data.get(4));
    }

    public static String getPropertiesTruck() {
        return "NUMBER_PLATE,MANUFACTURE,YEAR,OWNER,TONNAGE";
    }

    @Override
    public String toString() {
        return "Truck{" +
                "numberPlate='" + getNumberPlate() + '\'' +
                ", " + getManufacture() +
                ", Year=" + getYear() +
                ", Owner='" + getOwner() + '\'' +
                ", tonnage=" + tonnage +
                '}';
    }
}
