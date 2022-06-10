package com.codegym;
public class Main {
    public static int[] selectionSort(int... a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[i]) {
                    int tempt = a[i];
                    a[i] = a[j];
                    a[j] = tempt;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] numbers = new int[100000];
        StopWatch stopWatch = new StopWatch();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 100);
        }
        System.out.printf("Thoi gian bat dau: %.3f millisecond", 0.000);
        stopWatch.startTime();
        selectionSort(numbers);
        stopWatch.endTime();
        System.out.printf("\nThoi gian troi qua: %.3f millisecond", stopWatch.getElapsedTime());
        System.out.println("\n");
        for(int x : numbers){
            System.out.print(x);
        }
    }
}
