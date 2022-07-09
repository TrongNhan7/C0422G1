package test.electric_bill.util;

import test.electric_bill.models.*;

import java.io.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class ReadAndWriteCustomer {

    private static final String PATH_FILE_TYPECUSTOMER = "src/test/electric_bill/data/loaiKhach.csv";

    public static <E> void writeList(List<E> eList, String pathFile, boolean append) {
        File file = new File(pathFile);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (E e : eList) {
                if (e instanceof VNCustomer) {
                    bufferedWriter.write(((VNCustomer) e).getData());
                    bufferedWriter.newLine();
                }
                if (e instanceof ForeignCustomer) {
                    bufferedWriter.write(((ForeignCustomer) e).getData());
                    bufferedWriter.newLine();
                }
                if (e instanceof TypeCustomer) {
                    bufferedWriter.write(((TypeCustomer) e).getData());
                    bufferedWriter.newLine();
                }
                if (e instanceof Receipt) {
                    bufferedWriter.write(((Receipt) e).getData());
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Customer> readFileList(String pathFile) {
        List<Customer> list = new LinkedList<>();
        File file = new File(pathFile);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line = "";
        String[] array = null;
        TypeCustomer typeCustomer = null;
        List<TypeCustomer> typeCustomerList = ReadAndWriteCustomer.readFileListTypeCustomer(PATH_FILE_TYPECUSTOMER);

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) continue;
                array = line.split(",");
                for (int i = 0; i < typeCustomerList.size(); i++) {
                    if (typeCustomerList.get(i).getUsagePattern().equals(array[2])) {
                        typeCustomer = typeCustomerList.get(i);
                    }
                }
                if (array.length == 4) {
                    list.add(new VNCustomer(array[0], array[1], typeCustomer, Integer.parseInt(array[3])));
                }
                if (array.length == 3) {
                    list.add(new ForeignCustomer(array[0], array[1], array[2]));
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

    public static List<TypeCustomer> readFileListTypeCustomer(String pathFile) {
        List<TypeCustomer> list = new LinkedList<>();
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
                list.add(new TypeCustomer(array[0], array[1]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Receipt> readFileListReceipt(String pathFile) {
        List<Receipt> list = new LinkedList<>();
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
                list.add(new Receipt(Integer.parseInt(array[0]), LocalDate.parse(array[1]),
                        Double.parseDouble(array[2]), Double.parseDouble(array[3]), Double.parseDouble(array[4])));
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
