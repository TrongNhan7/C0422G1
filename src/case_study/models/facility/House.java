package case_study.models.facility;

public class House extends Facility {
    private String standardRoom;
    private int numberOfFloors;

    public House() {
    }

    public House(String standardRoom, int numberOfFloors) {
        this.standardRoom = standardRoom;
        this.numberOfFloors = numberOfFloors;
    }

    public House(String idFacility, String nameService, double areaUse, double rentalCosts, int peopleMax, String rentalType, String standardRoom, int numberOfFloors) {
        super(idFacility, nameService, areaUse, rentalCosts, peopleMax, rentalType);
        this.standardRoom = standardRoom;
        this.numberOfFloors = numberOfFloors;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
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
        if (obj == null || !(obj instanceof House)) {
            return false;
        }
        House house = (House) obj;
        return this.getIdFacility() == house.getIdFacility();
    }

    public String getData() {
        return super.getData() + getStandardRoom() + "," + getNumberOfFloors() + ",";
    }

    @Override
    public String toString() {
        return "House{" + super.toString() +
                "standardRoom='" + standardRoom + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }
}
