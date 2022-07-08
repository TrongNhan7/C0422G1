package test.hospital.util;


import test.hospital.models.MedicalRecord;
import test.hospital.models.MedicalRecordNormal;
import test.hospital.models.MedicalRecordVip;


import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {

    public static <E> void writeList(List<E> eList, String pathFile, boolean append) {
        File file = new File(pathFile);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (E e : eList) {
                if (e instanceof MedicalRecordNormal) {
                    bufferedWriter.write(((MedicalRecordNormal) e).getData());
                    bufferedWriter.newLine();
                }
                if (e instanceof MedicalRecordVip) {
                    bufferedWriter.write(((MedicalRecordVip) e).getData());
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<MedicalRecord> readFileList(String pathFile) {
        List<MedicalRecord> list = new ArrayList<>();
        File file = new File(pathFile);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line = "";
        String[] array = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) continue;
                array = line.split(",");
                if (array.length == 8) {
                    list.add(new MedicalRecordNormal(Integer.parseInt(array[0]), array[1], array[2], array[3], LocalDate.parse(array[4]),
                            LocalDate.parse(array[5]), array[6], Double.parseDouble(array[7])));
                }
                if (array.length == 9) {
                    list.add(new MedicalRecordVip(Integer.parseInt(array[0]), array[1], array[2], array[3], LocalDate.parse(array[4]),
                            LocalDate.parse(array[5]), array[6], array[7], LocalDate.parse(array[8])));
                }

            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


}
