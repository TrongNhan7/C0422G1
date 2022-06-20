package ss13_search_algorithm.find_the_ascending;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            int a = sc.nextInt();
            arr[i] = a;
            System.out.println("Element [" + i + "] = " + a);
        }
        Arrays.sort(arr);
        System.out.print("Value want search: ");
        int value = sc.nextInt();
        System.out.printf("List : %s\n", Arrays.toString(arr));
        int index = searchRecursive(arr, 0, size - 1, value);
        if (index != -1) {
            System.out.printf("index %d of value %d", index, value);
        } else {
            System.out.println(value + " does not exist in array!");
        }
    }

    public static int searchRecursive(int[] arr, int left, int right, int value) {
        int mid = (left + right) / 2;
        if (arr[mid] == value) return mid;
        if (arr[mid] > value) return searchRecursive(arr, left, right = mid - 1, value);
        if (arr[mid] < value) return searchRecursive(arr, left = mid + 1, right, value);
        return -1;


    }
}
