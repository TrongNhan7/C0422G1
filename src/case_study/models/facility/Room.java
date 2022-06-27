package case_study.models.facility;

public class Room extends Facility {
    private String serviceFree;

    public Room() {
    }

    public Room(String serviceFree) {
        this.serviceFree = serviceFree;
    }

    public Room(String idFacility, String nameService, double areaUse, double rentalCosts, int peopleMax, String rentalType, String serviceFree) {
        super(idFacility, nameService, areaUse, rentalCosts, peopleMax, rentalType);
        this.serviceFree = serviceFree;
    }

    public String getServiceFree() {
        return serviceFree;
    }

    public void setServiceFree(String serviceFree) {
        this.serviceFree = serviceFree;
    }

    @Override
    public int hashCode() {
        return getIdFacility().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Room)) {
            return false;
        }
        Room room = (Room) obj;
        return this.getIdFacility() == room.getIdFacility();
    }

    public String getData() {
        return super.getData() + getServiceFree() + ",";
    }

    @Override
    public String toString() {
        return "Room{" + super.toString() +
                "serviceFree='" + serviceFree + '\'' +
                '}';
    }
}
