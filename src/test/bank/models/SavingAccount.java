package test.bank.models;

import java.time.LocalDate;

public class SavingAccount extends Bank {
    private double savedMoney;
    private LocalDate savedDateMoney;
    private double interest;
    private int period;

    public SavingAccount() {
    }

    public SavingAccount(double savedMoney, LocalDate savedDateMoney, double interest, int period) {
        this.savedMoney = savedMoney;
        this.savedDateMoney = savedDateMoney;
        this.interest = interest;
        this.period = period;
    }

    public SavingAccount(int idAccount, String codeAccount, String nameAccount, LocalDate creationDateAccount, double savedMoney, LocalDate savedDateMoney, double interest, int period) {
        super(idAccount, codeAccount, nameAccount, creationDateAccount);
        this.savedMoney = savedMoney;
        this.savedDateMoney = savedDateMoney;
        this.interest = interest;
        this.period = period;
    }

    public double getSavedMoney() {
        return savedMoney;
    }

    public void setSavedMoney(double savedMoney) {
        this.savedMoney = savedMoney;
    }

    public LocalDate getSavedDateMoney() {
        return savedDateMoney;
    }

    public void setSavedDateMoney(LocalDate savedDateMoney) {
        this.savedDateMoney = savedDateMoney;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
    public String getData() {
        return super.getData() + "," + getSavedMoney() + "," + getSavedDateMoney() + "," + getInterest()
                + "," + getPeriod();
    }
    @Override
    public String toString() {
        return "SavingAccount{" + super.toString() +
                "savedMoney=" + savedMoney +
                ", savedDateMoney=" + savedDateMoney +
                ", interest=" + interest +
                ", period=" + period +
                "} ";
    }
}
