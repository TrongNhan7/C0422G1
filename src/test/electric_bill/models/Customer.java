package test.electric_bill.models;

public abstract class Customer {
    private String idCustomer;
    private String nameCustomer;

    public Customer() {
    }

    public Customer(String idCustomer, String nameCustomer) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getData() {
        return getIdCustomer() + "," + getNameCustomer();
    }

    @Override
    public String toString() {
        return "idCustomer='" + idCustomer + '\'' +
                ", nameCustomer='" + nameCustomer + '\'' + ",";
    }
}
