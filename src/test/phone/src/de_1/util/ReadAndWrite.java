package test.phone.src.de_1.util;


import test.phone.src.de_1.models.CellPhone;
import test.phone.src.de_1.models.RealPhone;

import java.io.*;
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
                if (e instanceof RealPhone) {
                    bufferedWriter.write(((RealPhone) e).getData());
                    bufferedWriter.newLine();
                }
                if (e instanceof CellPhone) {
                    bufferedWriter.write(((CellPhone) e).getData());
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static List<String> readObjectToCSV(String pathFile) {
        List<String> strings = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(pathFile));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) continue;
                strings.add(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File không tồn tại");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return strings;
    }
    public static List<RealPhone> readRealPhoneToCSV(String pathFile) {
        List<RealPhone> realPhones = new ArrayList<>();
        List<String> strings = readObjectToCSV(pathFile);
        String[] array;
        for (int i = 0; i < strings.size(); i++) {
            array = strings.get(i).split(",");
            realPhones.add(new RealPhone(Integer.parseInt(array[0]), array[1], Double.parseDouble(array[2]),
                    Integer.parseInt(array[3]), array[4], Integer.parseInt(array[5]), array[6]));
        }
        return realPhones;
    }
    public static List<CellPhone> readCellPhoneToCSV(String pathFile) {
        List<CellPhone> cellPhones = new ArrayList<>();
        List<String> strings = readObjectToCSV(pathFile);
        String[] array;
        for (int i = 0; i < strings.size(); i++) {
            array = strings.get(i).split(",");
            cellPhones.add(new CellPhone(Integer.parseInt(array[0]), array[1], Double.parseDouble(array[2]),
                    Integer.parseInt(array[3]), array[4], array[5], array[6]));
        }
        return cellPhones;
    }




}
