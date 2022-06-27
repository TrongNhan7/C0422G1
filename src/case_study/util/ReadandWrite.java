package case_study.util;

import case_study.models.Person.Customer;
import case_study.models.Person.Employee;
import case_study.models.Person.Person;
import case_study.models.facility.Facility;
import case_study.models.facility.House;
import case_study.models.facility.Room;
import case_study.models.facility.Villa;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ReadandWrite {
    public static void writeFile(Map<Facility, Integer> facilityMap, String pathFile, boolean append) {
        File file = new File(pathFile);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
                if (entry.getKey() instanceof Villa) {
                    bufferedWriter.write(entry.getKey().getData() + entry.getValue());
                    bufferedWriter.newLine();
                }
                if (entry.getKey() instanceof Room) {
                    bufferedWriter.write(entry.getKey().getData() + entry.getValue());
                    bufferedWriter.newLine();
                }
                if (entry.getKey() instanceof House) {
                    bufferedWriter.write(entry.getKey().getData() + "," + entry.getValue());
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Facility, Integer> readFile(String pathFile) {
        Map<Facility, Integer> facilityMap = new LinkedHashMap<>();
        File file = new File(pathFile);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line = "";
        String[] array = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                if (array.length == 10) {
                    // dung neu length bang nhau   if(array[0].contains("SVVL"))
                    facilityMap.put(new Villa(array[0], array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3])
                            , Integer.parseInt(array[4]), array[5], array[6]
                            , Double.parseDouble(array[7]), Integer.parseInt(array[8])), Integer.parseInt(array[9]));
                }
                if (array.length == 9) {
                    facilityMap.put(new House(array[0], array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3])
                            , Integer.parseInt(array[4]), array[5], array[6]
                            , Integer.parseInt(array[7])), Integer.parseInt(array[8]));
                }
                if (array.length == 8) {
                    facilityMap.put(new Room(array[0], array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3])
                            , Integer.parseInt(array[4]), array[5], array[6]), Integer.parseInt(array[7]));

                }
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return facilityMap;
    }

    public static <E> void writeAndReadList(List<E> eList, String pathFile, boolean append) {
        File file = new File(pathFile);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (E e : eList) {
                if (e instanceof Employee) {
                    bufferedWriter.write(((Employee) e).getData());
                    bufferedWriter.newLine();
                }
                if (e instanceof Customer) {
                    bufferedWriter.write(((Customer) e).getData());
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <E> List<E> readFileList(String pathFile) {
        List<E> eList = new ArrayList<>();
        File file = new File(pathFile);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line = "";
        String[] array = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                if (array.length == 10) {
                    eList.add((E) new Employee(Integer.parseInt(array[0]), array[1], array[2], array[3],
                            array[4], array[5], array[6], array[7], array[8], Double.parseDouble(array[9])));
                }
                if (array.length == 9) {
                    eList.add((E) new Customer(Integer.parseInt(array[0]), array[1], array[2], array[3],
                            array[4], array[5], array[6], array[7], array[8]));
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return eList;
    }
}


