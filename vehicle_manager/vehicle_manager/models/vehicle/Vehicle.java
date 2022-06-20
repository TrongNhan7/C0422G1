package vehicle_manager.models.vehicle;

import vehicle_manager.models.Manufacturer.Manufacture;

public abstract class Vehicle {
    private String numberPlate;
    private Manufacture manufacture;
    private int Year;
    private String Owner;

    public Vehicle(String numberPlate, Manufacture manufacture, int year, String owner) {
        this.numberPlate = numberPlate;
        this.manufacture = manufacture;
        Year = year;
        Owner = owner;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public Vehicle setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
        return this;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }

    public Vehicle setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
        return this;
    }

    public int getYear() {
        return Year;
    }

    public Vehicle setYear(int year) {
        Year = year;
        return this;
    }

    public String getOwner() {
        return Owner;
    }

    public Vehicle setOwner(String owner) {
        Owner = owner;
        return this;
    }

    public boolean hasNumberPlate(String numberPlate) {
        return getNumberPlate().equalsIgnoreCase(numberPlate);
    }

    @Override
    public abstract String toString();
}
