package test.bank.util;

import test.bank.models.Bank;
import test.bank.models.PaymentAccount;
import test.bank.models.SavingAccount;

import java.io.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class ReadAndWriteBank {
    public static <E> void writeList(List<E> eList, String pathFile, boolean append) {
        File file = new File(pathFile);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (E e : eList) {
                if (e instanceof SavingAccount) {
                    bufferedWriter.write(((SavingAccount) e).getData());
                    bufferedWriter.newLine();
                }
                if (e instanceof PaymentAccount) {
                    bufferedWriter.write(((PaymentAccount) e).getData());
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Bank> readFileList(String pathFile) {
        List<Bank> list = new LinkedList<>();
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
                    list.add(new SavingAccount(Integer.parseInt(array[0]), array[1], array[2], LocalDate.parse(array[3]),
                            Double.parseDouble(array[4]), LocalDate.parse(array[5]), Double.parseDouble(array[6]),
                            Integer.parseInt(array[7])));
                }
                if (array.length == 6) {
                    list.add(new PaymentAccount(Integer.parseInt(array[0]), array[1], array[2], LocalDate.parse(array[3]),
                            Integer.parseInt(array[4]), Double.parseDouble(array[5])));

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
