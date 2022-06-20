package vehicle_manager.models.vehicle;

import vehicle_manager.models.Manufacturer.Manufacture;

import java.util.List;

public class Car extends Vehicle {
    private int numberSeat;
    private String typeCar;

    public Car(List<String> data) {
        super(data.get(0), new Manufacture(data.get(1)), Integer.parseInt(data.get(2)), data.get(3));
        this.numberSeat = Integer.parseInt(data.get(4));
        this.typeCar = data.get(5);
    }

    public static String getPropertiesCar() {
        return "NUMBER_PLATE,MANUFACTURE,YEAR,OWNER,NUMBER_SEAT,TYPE_CAR";
    }

    @Override
    public String toString() {
        return "Car{" +
                "numberPlate='" + getNumberPlate() + '\'' +
                ", " + getManufacture() +
                ", Year=" + getYear() +
                ", Owner='" + getOwner() + '\'' +
                ", numberSeat=" + numberSeat +
                ", typeCar='" + typeCar + '\'' +
                '}';
    }
}
