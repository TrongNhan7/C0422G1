package com.codegym;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("QuadraticEquation: ax2 + bx + x = 0");
        System.out.print("Enter a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter c: ");
        double c = scanner.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        System.out.println("Delta = " + quadraticEquation.getDiscriminant());
        if (quadraticEquation.getDiscriminant() < 0) {
            System.out.print("The equation has no roots");
        } else if (quadraticEquation.getDiscriminant() == 0) {
            System.out.print("The solution of the equation is: \nr = " + quadraticEquation.getRoot1());
        } else {
            System.out.println("The solution of the equation is: " + "\nr1= " + quadraticEquation.getRoot1()
                    + "\nr2= " + quadraticEquation.getRoot2());
        }
    }
}
