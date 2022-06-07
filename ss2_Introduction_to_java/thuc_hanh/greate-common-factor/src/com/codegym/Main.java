package com.codegym;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        int a;
        int b;
        int common = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a: ");
        a = input.nextInt();
        System.out.println("Enter b: ");
        b = input.nextInt();
        a = Math.abs(a);
        b = Math.abs(b);

        if (a == 0 || b == 0) {
            System.out.println("No greatest common factor");
        }
       /* while (a != b) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        System.out.println("Greatest common factor: " + a);
        */

        for (int i=1; i<=a && i<=b; i++){
            if(a%i == 0 && b%i == 0){
                common = i;
            }
        }
        System.out.printf("Ước chung lớn nhất của %d và %d là: %d", a, b, common);
    }
}
