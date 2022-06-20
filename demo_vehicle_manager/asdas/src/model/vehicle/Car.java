package model.vehicle;

import model.Manufacture.Manufacture;

public class Car extends Vehicle{
    private int numberSeat;
    private String typeCar;

    public Car(int numberSeat, String typeCar) {
        this.numberSeat = numberSeat;
        this.typeCar = typeCar;
    }

    public Car(String numberPlate, Manufacture manufacture, int year, String owner, int numberSeat, String typeCar) {
        super(numberPlate, manufacture, year, owner);
        this.numberSeat = numberSeat;
        this.typeCar = typeCar;
    }

    public int getNumberSeat() {
        return numberSeat;
    }

    public void setNumberSeat(int numberSeat) {
        this.numberSeat = numberSeat;
    }

    public String getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(String typeCar) {
        this.typeCar = typeCar;
    }

    @Override
    public String toString() {
        return "Car{" +
                super.toString() +
                "numberSeat=" + numberSeat +
                ", typeCar='" + typeCar + '\'' +
                '}';
    }
}
