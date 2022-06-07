package com.codegym;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int number, hundred, dozens, units, numberDozens;
        String result = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your number: ");
        number = scanner.nextInt();
        if (number < 0) {
            System.out.println("Input number >= 0");
        } else if (number >= 1000) {
            System.out.println("Out of ability");
        } else {
            hundred = (int) Math.floor(number / 100);
            if (hundred > 0) {
                switch (hundred) {
                    case 1:
                        result = " One Hundred";
                        break;
                    case 2:
                        result = " Two Hundred";
                        break;
                    case 3:
                        result = " Three Hundred";
                        break;
                    case 4:
                        result = " Four Hundred";
                        break;
                    case 5:
                        result = " Five Hundred";
                        break;
                    case 6:
                        result = " Six Hundred";
                        break;
                    case 7:
                        result = " Seven Hundred";
                        break;
                    case 8:
                        result = " Eight Hundred";
                        break;
                    case 9:
                        result = " Nine Hundred";
                        break;
                }
            }
            dozens = (number % 100);
            if (dozens < 20 && dozens >= 10) {
                switch (dozens) {
                    case 10:
                        result += " ten";
                        break;
                    case 11:
                        result += " eleven";
                        break;
                    case 12:
                        result += " twelve";
                        break;
                    case 13:
                        result += " three";
                        break;
                    case 14:
                        result += " fourteen";
                        break;
                    case 15:
                        result += " fifteen";
                        break;
                    case 16:
                        result += " sixteen";
                        break;
                    case 17:
                        result += " seventeen";
                        break;
                    case 18:
                        result += " eighteen";
                        break;
                    case 19:
                        result += " nineteen";
                        break;
                }
            } else {
                numberDozens = (int) Math.floor(dozens / 10);
                units = (dozens % 10);
                result += numberDozens == 2 ? " twenty" : numberDozens == 3 ? " thirty" : numberDozens == 4 ? " forty" : numberDozens == 5 ? " fifty" : numberDozens == 6 ? " sixty" : numberDozens == 7 ? " seventy" : numberDozens == 8 ? " eighty" : numberDozens == 9 ? " ninety" : "";
                result += units == 1 ? " one" : units == 2 ? " two" : units == 3 ? " three" : units == 4 ? " four" : units == 5 ? " five" : units == 6 ? " six" : units == 7 ? " seven" : units == 8 ? " eight" : units == 9 ? " nine" : "";
            }
            System.out.println("Number to text is: " + result);
        }
    }
}