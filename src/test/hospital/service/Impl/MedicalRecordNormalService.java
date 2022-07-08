package test.hospital.service.Impl;


import case_study.models.Person.Customer;
import test.hospital.common.InvalidDateCheckException;
import test.hospital.common.NotFoundMedicalRecordException;
import test.hospital.models.MedicalRecord;
import test.hospital.models.MedicalRecordNormal;
import test.hospital.service.IService.IService;
import test.hospital.util.ReadAndWrite;
import test.hospital.util.Regex;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class MedicalRecordNormalService implements IService {
    static Scanner scanner = new Scanner(System.in);

    private static final String PATH_FILE_MEDIARECORD = "src/test/hospital/data/medical_records.csv";

    @Override
    public void add() {
        List<MedicalRecord> medicalRecord;
        medicalRecord = ReadAndWrite.readFileList(PATH_FILE_MEDIARECORD);
        System.out.println("Nhập thông tin theo yêu cầu");
        int idPatient = 0;
        int max = 0;
        if (medicalRecord == null) {
            idPatient = 1;
        } else {
            for (MedicalRecord record : medicalRecord) {
                if (record.getIdPatient() > max) {
                    max = record.getIdPatient();
                }
            }
        }
        idPatient = max + 1;
        String codePatient = null;
        String codePeople = null;
        boolean flag = true;
        do {
            codePatient = Regex.inputPatient();
            for (MedicalRecord medicalRecord1 : medicalRecord) {
                flag = false;
                if (medicalRecord1.getCodePatient().equals(codePatient)) {
                    System.out.println("Bạn đã nhập trùng mã bệnh án");
                    flag = true;
                    break;
                }
            }
        } while (flag);

        do {
            codePeople = Regex.inputPeople();
            for (MedicalRecord medicalRecord1 : medicalRecord) {
                flag = false;
                if (medicalRecord1.getCodePeople().equals(codePeople)) {
                    System.out.println("Bạn đã nhập trùng mã bệnh nhân");
                    flag = true;
                    break;
                }
            }
        } while (flag);
        System.out.println("Nhập tên bệnh nhân");
        String namePatient = scanner.nextLine();
        LocalDate startDay = null;
        LocalDate endDay = null;

        while (true) {
            try {
                System.out.println("Nhập ngày bắt đầu");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                startDay = LocalDate.parse(scanner.nextLine(), formatter);
                InvalidDateCheckException.checkDateStart(startDay);
                break;
            } catch (DateTimeParseException e) {
                System.err.println("Nhập ngày theo định dạng dd/MM/yyyy");
            } catch (InvalidDateCheckException e) {
                System.err.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Nhập ngày kết thúc");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                endDay = LocalDate.parse(scanner.nextLine(), formatter);
                InvalidDateCheckException.checkDateEnd(startDay, endDay);
                break;
            } catch (DateTimeParseException e) {
                System.err.println("Nhập ngày theo định dạng dd/MM/yyyy");
            } catch (InvalidDateCheckException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println("Nhập lý do bệnh án");
        String reasonHospitalize = scanner.nextLine();
        double hospitalFees;
        while (true) {
            try {
                System.out.println("Nhập viện phí");
                hospitalFees = Double.parseDouble(scanner.nextLine());
                if (hospitalFees < 0) {
                    System.err.println("Nhập số nguyên dương");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Nhập sai định dạng");
            }
        }
        MedicalRecordNormal recordNormal = new MedicalRecordNormal(idPatient, codePatient, codePeople, namePatient,
                startDay, endDay, reasonHospitalize, hospitalFees);
        medicalRecord.add(recordNormal);
        ReadAndWrite.writeList(medicalRecord, PATH_FILE_MEDIARECORD, false);
    }


    @Override
    public void delete() {
        List<MedicalRecord> medicalRecord;
        medicalRecord = ReadAndWrite.readFileList(PATH_FILE_MEDIARECORD);
        for (MedicalRecord item : medicalRecord) {
            if (item instanceof MedicalRecordNormal) {
                System.out.println(item);
            }
        }
        boolean flag = true;
        do {
            String codePatient = Regex.inputPatient();
            int count = 0;
            String inputChoose = null;
            for (int i = 0; i < medicalRecord.size(); i++) {
                if (medicalRecord.get(i) instanceof MedicalRecordNormal && medicalRecord.get(i).getCodePatient().equals(codePatient)) {
                    System.out.println("Bạn có chắc chắn muốn xóa hay không?");
                    System.out.println("1. có");
                    System.out.println("2. không");

                    inputChoose = scanner.nextLine();

                    switch (inputChoose) {
                        case "1":
                            medicalRecord.remove(i);
                            System.out.println("đã xóa thành công");
                            count++;
                            flag = false;
                            break;
                        case "2":
                            count++;
                            flag = false;
                            break;
                    }
                }
            }
            try {
                if (count == 0) {
                    throw new NotFoundMedicalRecordException("Mã bệnh án không tồn tại,vui lòng nhập lại");
                }
            } catch (NotFoundMedicalRecordException e) {
                System.out.println(e.getMessage());
            }
        } while (flag);
        ReadAndWrite.writeList(medicalRecord, PATH_FILE_MEDIARECORD, false);
    }

    @Override
    public void display() {
        List<MedicalRecord> medicalRecord;
        medicalRecord = ReadAndWrite.readFileList(PATH_FILE_MEDIARECORD);
        for (MedicalRecord item : medicalRecord) {
            if (item instanceof MedicalRecordNormal) {
                System.out.println(item);
            }
        }

    }


}
