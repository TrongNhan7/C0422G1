package test.product.util;

import test.product.models.ExportProduct;
import test.product.models.ImportProduct;
import test.product.models.Product;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class ReadAndWriteProduct {
    public static <E> void writeList(List<E> eList, String pathFile, boolean append) {
        File file = new File(pathFile);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (E e : eList) {
                if (e instanceof ImportProduct) {
                    bufferedWriter.write(((ImportProduct) e).getData());
                    bufferedWriter.newLine();
                }
                if (e instanceof ExportProduct) {
                    bufferedWriter.write(((ExportProduct) e).getData());
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> readFileList(String pathFile) {
        List<Product> list = new LinkedList<>();
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
                if (array.length == 9) {
                    list.add(new ImportProduct(Integer.parseInt(array[0]), array[1], array[2], Double.parseDouble(array[3]),
                            Integer.parseInt(array[4]), array[5], Double.parseDouble(array[6]),
                            array[7], Double.parseDouble(array[8])));
                }
                if (array.length == 8) {
                    list.add(new ExportProduct(Integer.parseInt(array[0]), array[1], array[2], Double.parseDouble(array[3]),
                            Integer.parseInt(array[4]), array[5], Double.parseDouble(array[6]),
                            array[7]));
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
