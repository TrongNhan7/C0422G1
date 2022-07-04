package de_1.models;

import java.util.StringJoiner;

public abstract class Phone {
    private int idPhone;
    private String namePhone;
    private double pricePhone;
    private int amountPhone;
    private String manufacture;

    public Phone() {
    }

    public Phone(int idPhone, String namePhone, double pricePhone, int amountPhone, String manufacture) {
        this.idPhone = idPhone;
        this.namePhone = namePhone;
        this.pricePhone = pricePhone;
        this.amountPhone = amountPhone;
        this.manufacture = manufacture;
    }

    public int getIdPhone() {
        return idPhone;
    }

    public void setIdPhone(int idPhone) {
        this.idPhone = idPhone;
    }

    public String getNamePhone() {
        return namePhone;
    }

    public void setNamePhone(String namePhone) {
        this.namePhone = namePhone;
    }

    public double getPricePhone() {
        return pricePhone;
    }

    public void setPricePhone(double pricePhone) {
        this.pricePhone = pricePhone;
    }

    public int getAmountPhone() {
        return amountPhone;
    }

    public void setAmountPhone(int amountPhone) {
        this.amountPhone = amountPhone;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getData() {
        return getIdPhone() + "," + getNamePhone() + "," + getPricePhone() + "," + getAmountPhone() + "," +
                getAmountPhone() + ",";
    }

    @Override
    public String toString() {
        return
                "idPhone=" + idPhone +
                        ",namePhone='" + namePhone + '\'' +
                        ",pricePhone=" + pricePhone +
                        ",amountPhone=" + amountPhone +
                        ",manufacture='" + manufacture + '\'';
    }
}
