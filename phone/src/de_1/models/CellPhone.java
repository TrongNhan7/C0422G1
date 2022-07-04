package de_1.models;

public class CellPhone extends Phone {
    private String countryCell;
    private String status;

    public CellPhone() {
    }

    public CellPhone(String countryCell, String status) {
        this.countryCell = countryCell;
        this.status = status;
    }

    public CellPhone(int idPhone, String namePhone, double pricePhone, int amountPhone, String manufacture, String countryCell, String status) {
        super(idPhone, namePhone, pricePhone, amountPhone, manufacture);
        this.countryCell = countryCell;
        this.status = status;
    }

    public String getCountryCell() {
        return countryCell;
    }

    public void setCountryCell(String countryCell) {
        this.countryCell = countryCell;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getData() {
        return super.getData() + getCountryCell() + "," + getStatus() ;
    }

    @Override
    public String toString() {
        return "CellPhone{" + super.toString() +
                ",countryCell=" + countryCell + '\'' +
                ",status=" + status + '}';
    }
}
