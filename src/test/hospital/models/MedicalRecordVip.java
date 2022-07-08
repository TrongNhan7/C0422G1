package test.hospital.models;

import java.time.LocalDate;

public class MedicalRecordVip extends MedicalRecord {
    private String typeVip;
    private LocalDate termVIp;

    public MedicalRecordVip() {
    }

    public MedicalRecordVip(String typeVip, LocalDate termVIp) {
        this.typeVip = typeVip;
        this.termVIp = termVIp;
    }

    public MedicalRecordVip(int idPatient, String codePatient, String codePeople, String namePatient, LocalDate startHospitalize, LocalDate endHospitalize, String reasonHospitalize, String typeVip, LocalDate termVIp) {
        super(idPatient, codePatient, codePeople, namePatient, startHospitalize, endHospitalize, reasonHospitalize);
        this.typeVip = typeVip;
        this.termVIp = termVIp;
    }

    public String getTypeVip() {
        return typeVip;
    }

    public void setTypeVip(String typeVip) {
        this.typeVip = typeVip;
    }

    public LocalDate getTermVIp() {
        return termVIp;
    }

    public void setTermVIp(LocalDate termVIp) {
        this.termVIp = termVIp;
    }

    public String getData() {
        return super.getData() + getTypeVip() + "," + getTermVIp();
    }

    @Override
    public String toString() {
        return "MedicalRecordVip{" + super.toString() +
                "typeVip='" + typeVip + '\'' +
                ", termVIp=" + termVIp +
                '}';
    }
}

