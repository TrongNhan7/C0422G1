package com.codegym;

import java.util.Scanner;

public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Nhập số tiền USD muốn đổi: ");
        double usd = scanner.nextDouble();
        double vnd = usd * 23000;
        System.out.printf("Số tiền VND là: " + vnd + " VND");

        }