package com.codegym;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] arr1;
        int size1;
        int[] arr2;
        int size2;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a size1: ");
        size1 = scanner.nextInt();
        arr1 = new int[size1];
        createArr(arr1, size1);
        System.out.print("\nEnter a size2: ");
        size2 = scanner.nextInt();
        arr2 = new int[size2];
        createArr(arr2, size2);
        int[] arr3;
        int size3 = size1 + size2;
        arr3 = new int[size3];
        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            arr3[arr1.length + i] = arr2[i];
        }
        displayArr(arr3);
    }

    static void createArr(int[] arr, int size) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter element" + (i + 1) + " : ");
            arr[i] = scanner.nextInt();
        }
        displayArr(arr);
    }

    static void displayArr(int[] arr) {
        System.out.println("\nArray: ");
        for (int element : arr) {
            System.out.print(element + "\t");
        }
    }
}
