package com.codegym;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Size should not exceed 20");
        } while (size > 20);
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter element" + (i + 1) + " : ");
            array[i] = scanner.nextInt();
        }
        outputArr(array);

        System.out.println("\nInput element to be Delete: ");
        int elementNeedDelete = scanner.nextInt();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == elementNeedDelete) {
                deleteArrToBeIndex(array, i);
            }
        }
       outputArr(array);


    }

    public static void outputArr(int[] arr) {
        System.out.print("Property list: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    public static void deleteArrToBeIndex(int[] arr, int index) {
        for (int i = index; i < arr.length-1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length-1] = 0;
    }
}
