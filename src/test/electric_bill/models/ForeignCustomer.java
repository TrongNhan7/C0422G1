package test.electric_bill.models;

public class ForeignCustomer extends Customer {
    private String nationality;

    public ForeignCustomer() {
    }

    public ForeignCustomer(String nationality) {
        this.nationality = nationality;
    }

    public ForeignCustomer(String idCustomer, String nameCustomer, String nationality) {
        super(idCustomer, nameCustomer);
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getData() {
        return super.getData() + "," + getNationality();
    }

    @Override
    public String toString() {
        return "ForeignCustomer{" + super.toString() +
                "nationality='" + nationality + '\'' +
                "} ";
    }
}
