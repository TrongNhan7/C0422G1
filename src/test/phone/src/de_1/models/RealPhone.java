package test.phone.src.de_1.models;

public class RealPhone extends Phone {
    private int timeInsurance;
    private String coverInsurance;

    public RealPhone() {
    }

    public RealPhone(int timeInsurance, String coverInsurance) {
        this.timeInsurance = timeInsurance;
        this.coverInsurance = coverInsurance;
    }

    public RealPhone(int idPhone, String namePhone, double pricePhone, int amountPhone, String manufacture, int timeInsurance, String coverInsurance) {
        super(idPhone, namePhone, pricePhone, amountPhone, manufacture);
        this.timeInsurance = timeInsurance;
        this.coverInsurance = coverInsurance;
    }

    public int getTimeInsurance() {
        return timeInsurance;
    }

    public void setTimeInsurance(int timeInsurance) {
        this.timeInsurance = timeInsurance;
    }

    public String getCoverInsurance() {
        return coverInsurance;
    }

    public void setCoverInsurance(String coverInsurance) {
        this.coverInsurance = coverInsurance;
    }

    public String getData() {
        return super.getData() + getTimeInsurance() + "," + getCoverInsurance();
    }

    @Override
    public String toString() {
        return "RealPhone{" + super.toString() +
                ",timeInsurance=" + timeInsurance + '\'' +
                ",coverInsurance=" + coverInsurance + '}';
    }
}
