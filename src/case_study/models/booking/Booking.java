package case_study.models.booking;

import case_study.models.Person.Customer;
import case_study.models.facility.Facility;


import java.time.LocalDate;


public class Booking {
    private String idBooking;
    private LocalDate startDay;
    private LocalDate endDay;
    private Customer idCustomer;
    private Facility serviceName;
    private String serviceType;

    public Booking() {
    }

    public Booking(String idBooking, LocalDate startDay, LocalDate endDay, Customer idCustomer, Facility serviceName, String serviceType) {
        this.idBooking = idBooking;
        this.startDay = startDay;
        this.endDay = endDay;
        this.idCustomer = idCustomer;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    public LocalDate getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDate endDay) {
        this.endDay = endDay;
    }

    public Customer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Customer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Facility getServiceName() {
        return serviceName;
    }

    public void setServiceName(Facility serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public int hashCode() {
        return idBooking.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Booking)) {
            return false;
        }
        Booking booking = (Booking) obj;
        return this.idBooking == booking.idBooking &&
                this.idCustomer == booking.idCustomer &&
                this.serviceName == booking.serviceName ;
    }


    @Override
    public String toString() {
        return "Booking{" +
                "idBooking='" + idBooking + '\'' +
                ", startDay=" + startDay +
                ", endDay=" + endDay +
                ", idCustomer=" + idCustomer.getId() +
                ", serviceName=" + serviceName.getNameService() +
                ", serviceType='" + serviceType + '\'' +
                '}';
    }
}
