package model.vehicle;

import model.Manufacture.Manufacture;

public class Motobike extends Vehicle {
    private double wattage;

    public Motobike(double wattage) {
        this.wattage = wattage;
    }

    public Motobike(String numberPlate, Manufacture manufacture, int year, String owner, double wattage) {
        super(numberPlate, manufacture, year, owner);
        this.wattage = wattage;
    }

    public double getWattage() {
        return wattage;
    }

    public void setWattage(double wattage) {
        this.wattage = wattage;
    }

    @Override
    public String toString() {
        return "Motobike{" +
                super.toString() +
                "wattage=" + wattage +
                '}';
    }
}
