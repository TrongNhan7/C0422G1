package com.codegym;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a size:");
        size = scanner.nextInt();
        array = new int[size + 1];
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print("Enter element" + (i + 1) + " : ");
            array[i] = scanner.nextInt();
        }
        int elementAdd;
        int indexElement;
        System.out.println("Input element need add: ");
        elementAdd = scanner.nextInt();
        System.out.println("Input index element");
        indexElement = scanner.nextInt();
        addElelement(array, elementAdd, indexElement);
        displayArr(array);
    }

    static void addElelement(int[] arr, int x, int index) {
        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = x;
    }

    static void displayArr(int[] arr) {
        System.out.println("Array: ");
        for (int element : arr) {
            System.out.print(element + "\t");
        }
    }
}
