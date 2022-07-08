package test.hospital.common;

public class NotFoundMedicalRecordException extends Exception {
    public NotFoundMedicalRecordException(String message) {
        super(message);
    }
}
