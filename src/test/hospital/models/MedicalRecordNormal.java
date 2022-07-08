package test.hospital.models;

import java.time.LocalDate;

public class MedicalRecordNormal extends MedicalRecord {
    private double hospitalFees;

    public MedicalRecordNormal() {
    }

    public MedicalRecordNormal(double hospitalFees) {
        this.hospitalFees = hospitalFees;
    }

    public MedicalRecordNormal(int idPatient, String codePatient, String codePeople, String namePatient, LocalDate startHospitalize, LocalDate endHospitalize, String reasonHospitalize, double hospitalFees) {
        super(idPatient, codePatient, codePeople, namePatient, startHospitalize, endHospitalize, reasonHospitalize);
        this.hospitalFees = hospitalFees;
    }

    public double getHospitalFees() {
        return hospitalFees;
    }

    public void setHospitalFees(double hospitalFees) {
        this.hospitalFees = hospitalFees;
    }

    public String getData() {
        return super.getData() + getHospitalFees();
    }

    @Override
    public String toString() {
        return "MedicalRecordNormal{" + super.toString() +
                "hospitalFees=" + hospitalFees +
                "} ";
    }
}
