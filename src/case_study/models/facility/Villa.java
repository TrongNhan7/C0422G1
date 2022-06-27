package case_study.models.facility;

public class Villa extends Facility {
    private String standardRoom;
    private double areaPool;
    private int numberOfFloors;

    public Villa() {
    }

    public Villa(String standardRoom, double areaPool, int numberOfFloors) {
        this.standardRoom = standardRoom;
        this.areaPool = areaPool;
        this.numberOfFloors = numberOfFloors;
    }

    public Villa(String idFacility, String nameService, double areaUse, double rentalCosts, int peopleMax, String rentalType, String standardRoom, double areaPool, int numberOfFloors) {
        super(idFacility, nameService, areaUse, rentalCosts, peopleMax, rentalType);
        this.standardRoom = standardRoom;
        this.areaPool = areaPool;
        this.numberOfFloors = numberOfFloors;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public int hashCode() {
        return getIdFacility().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Villa)) {
            return false;
        }
        Villa villa = (Villa) obj;
        return this.getIdFacility() == villa.getIdFacility();
    }

    public String getData() {
        return super.getData() + getStandardRoom() + "," + getAreaPool() + "," + getNumberOfFloors()+ ",";
    }

    @Override
    public String toString() {
        return "Villa{" + super.toString() +
                "standardRoom='" + standardRoom + '\'' +
                ", areaPool=" + areaPool +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }
}
