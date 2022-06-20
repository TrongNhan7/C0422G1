package model.vehicle;

import model.Manufacture.Manufacture;

public class Truck extends Vehicle {
    private double load;

    public Truck(double load) {
        this.load = load;
    }

    public Truck(String numberPlate, Manufacture manufacture, int year, String owner, double load) {
        super(numberPlate, manufacture, year, owner);
        this.load = load;
    }

    public double getLoad() {
        return load;
    }

    public void setLoad(double load) {
        this.load = load;
    }

    @Override
    public String toString() {
        return "Truck{" +
                super.toString() +
                "load=" + load +
                '}';
    }
}
