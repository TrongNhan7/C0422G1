package test.hospital.models;

import java.time.LocalDate;

public abstract class MedicalRecord {
    private int idPatient;
    private String codePatient;

    private String codePeople;
    private String namePatient;
    private LocalDate startHospitalize;
    private LocalDate endHospitalize;
    private String reasonHospitalize;

    public MedicalRecord() {
    }

    public MedicalRecord(int idPatient, String codePatient, String codePeople, String namePatient, LocalDate startHospitalize, LocalDate endHospitalize, String reasonHospitalize) {
        this.idPatient = idPatient;
        this.codePatient = codePatient;
        this.codePeople = codePeople;
        this.namePatient = namePatient;
        this.startHospitalize = startHospitalize;
        this.endHospitalize = endHospitalize;
        this.reasonHospitalize = reasonHospitalize;
    }

    public String getCodePeople() {
        return codePeople;
    }

    public void setCodePeople(String codePeople) {
        this.codePeople = codePeople;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public String getCodePatient() {
        return codePatient;
    }

    public void setCodePatient(String codePatient) {
        this.codePatient = codePatient;
    }

    public String getNamePatient() {
        return namePatient;
    }

    public void setNamePatient(String namePatient) {
        this.namePatient = namePatient;
    }

    public LocalDate getStartHospitalize() {
        return startHospitalize;
    }

    public void setStartHospitalize(LocalDate startHospitalize) {
        this.startHospitalize = startHospitalize;
    }

    public LocalDate getEndHospitalize() {
        return endHospitalize;
    }

    public void setEndHospitalize(LocalDate endHospitalize) {
        this.endHospitalize = endHospitalize;
    }

    public String getReasonHospitalize() {
        return reasonHospitalize;
    }

    public void setReasonHospitalize(String reasonHospitalize) {
        this.reasonHospitalize = reasonHospitalize;
    }

    public String getData() {
        return getIdPatient() + "," + getCodePatient() + "," + getCodePeople() + "," + getNamePatient() + "," + getStartHospitalize() + "," + getEndHospitalize() + "," + getReasonHospitalize() + ",";
    }

    @Override
    public String toString() {
        return "idPatient=" + idPatient +
                ", codePatient='" + codePatient + '\'' +
                ", codePeople='" + codePeople + '\'' +
                ", namePatient='" + namePatient + '\'' +
                ", startHospitalize=" + startHospitalize +
                ", endHospitalize=" + endHospitalize +
                ", reasonHospitalize='" + reasonHospitalize + '\'' +
                '}';
    }
}
