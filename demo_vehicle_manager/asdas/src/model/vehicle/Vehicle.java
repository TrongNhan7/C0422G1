package model.vehicle;

import model.Manufacture.Manufacture;

public abstract class Vehicle {
    private String numberPlate;
    private Manufacture manufacture;
    private int year;
    private String owner;

    public  Vehicle(){}
    public Vehicle(String numberPlate, Manufacture manufacture, int year, String owner) {
        this.numberPlate = numberPlate;
        this.manufacture = manufacture;
        this.year = year;
        this.owner = owner;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "numberPlate='" + numberPlate + '\'' +
                ", manufacture=" + manufacture +
                ", year=" + year +
                ", owner='" + owner + '\'' +
                '}';
    }
}
