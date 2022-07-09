package test.electric_bill.models;

import java.time.LocalDate;

public class Receipt {
    private String idReceipt;
    private LocalDate dateReceipt;
    private double amount;
    private double priceReceipt;
    private double intoMoney;

    public Receipt() {
    }

    public Receipt(String idReceipt, LocalDate dateReceipt, double amount, double priceReceipt, double intoMoney) {
        this.idReceipt = idReceipt;
        this.dateReceipt = dateReceipt;
        this.amount = amount;
        this.priceReceipt = priceReceipt;
        this.intoMoney = intoMoney;
    }

    public String getIdReceipt() {
        return idReceipt;
    }

    public void setIdReceipt(String idReceipt) {
        this.idReceipt = idReceipt;
    }

    public LocalDate getDateReceipt() {
        return dateReceipt;
    }

    public void setDateReceipt(LocalDate dateReceipt) {
        this.dateReceipt = dateReceipt;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPriceReceipt() {
        return priceReceipt;
    }

    public void setPriceReceipt(double priceReceipt) {
        this.priceReceipt = priceReceipt;
    }

    public double getIntoMoney() {
        return intoMoney;
    }

    public void setIntoMoney(double intoMoney) {
        this.intoMoney = intoMoney;
    }

    public String getData() {
        return getIdReceipt() + "," + getDateReceipt() + ","
                + getAmount() + "," + getPriceReceipt() + "," + getIntoMoney();
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "idReceipt=" + idReceipt +
                ", dateReceipt=" + dateReceipt +
                ", amount=" + amount +
                ", priceReceipt=" + priceReceipt +
                ", intoMoney=" + intoMoney +
                '}';
    }
}
