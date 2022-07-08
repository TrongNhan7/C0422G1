package test.bank.models;

import java.time.LocalDate;

public class Bank {
    private int idAccount;
    private String codeAccount;
    private String nameAccount;
    private LocalDate creationDateAccount;

    public Bank() {
    }

    public Bank(int idAccount, String codeAccount, String nameAccount, LocalDate creationDateAccount) {
        this.idAccount = idAccount;
        this.codeAccount = codeAccount;
        this.nameAccount = nameAccount;
        this.creationDateAccount = creationDateAccount;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getCodeAccount() {
        return codeAccount;
    }

    public void setCodeAccount(String codeAccount) {
        this.codeAccount = codeAccount;
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public LocalDate getCreationDateAccount() {
        return creationDateAccount;
    }

    public void setCreationDateAccount(LocalDate creationDateAccount) {
        this.creationDateAccount = creationDateAccount;
    }

    public String getData() {
        return getIdAccount() + "," + getCodeAccount() + "," + getNameAccount() + "," + getCreationDateAccount();
    }

    @Override
    public String toString() {
        return "idAccount=" + idAccount +
                ", codeAccount='" + codeAccount + '\'' +
                ", nameAccount='" + nameAccount + '\'' +
                ", creationDateAccount=" + creationDateAccount +
                '}';
    }
}
