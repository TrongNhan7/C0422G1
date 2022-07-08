package test.bank.models;

import java.time.LocalDate;

public class PaymentAccount extends Bank {
    private int cardNumber;
    private double amountAccount;

    public PaymentAccount() {
    }

    public PaymentAccount(int cardNumber, double amountAccount) {
        this.cardNumber = cardNumber;
        this.amountAccount = amountAccount;
    }

    public PaymentAccount(int idAccount, String codeAccount, String nameAccount, LocalDate creationDateAccount, int cardNumber, double amountAccount) {
        super(idAccount, codeAccount, nameAccount, creationDateAccount);
        this.cardNumber = cardNumber;
        this.amountAccount = amountAccount;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getAmountAccount() {
        return amountAccount;
    }

    public void setAmountAccount(double amountAccount) {
        this.amountAccount = amountAccount;
    }

    public String getData() {
        return super.getData() + "," + getCardNumber() + "," + getAmountAccount();
    }

    @Override
    public String toString() {
        return "PaymentAccount{" + super.toString() +
                "cardNumber=" + cardNumber +
                ", amountAccount=" + amountAccount +
                "} ";
    }
}
