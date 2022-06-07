package com.codegym;

import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Triangle triangle1 = new Triangle();
        System.out.println("canh 1: ");
        double side1 = Integer.parseInt(scanner.nextLine());
        System.out.println("canh 2: ");
        double side2 = Integer.parseInt(scanner.nextLine());
        System.out.println("canh 3: ");
        double side3 = Integer.parseInt(scanner.nextLine());
        System.out.println("color: ");
        String color = scanner.nextLine();
        triangle1.setSide1(side1);
        triangle1.setSide2(side2);
        triangle1.setSide3(side3);
        triangle1.setColor(color);
        System.out.println(triangle1.toString());
    }
}
