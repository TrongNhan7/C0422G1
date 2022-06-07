package com.codegym;

public class Triangle extends Shape {
    private double side1 = 1;
    private double side2 = 1;
    private double side3 = 1;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

    }

    public Triangle(String color, boolean filled, double side1, double side2, double side3) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public boolean isValid() {
        if (((side1 + side2) > side3) &&
                ((side1 + side3) > side2) &&
                ((side3 + side2) > side1)) {
            return true;
        }
        return false;
    }


    public double getArea() {
        double p = (side1 + side2 + side3) / 2;
        double ha = (2 * Math.sqrt(p * (p - side1) * (p - side2) * (p - side3))) / side1;
        return side1 * ha / 2;
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        if (!isValid()) {
            return "không phải 1 tam giác hợp lệ!";
        }
        return "Triangle:\n" +
                "+ chiều dài 3 cạnh: " +
                this.side1 + ", " +
                this.side2 + ", " +
                this.side3 + "\n" +
                "+ Color: " + this.getColor() + "\n" +
                "+ fill: " + this.isFilled() + "\n" +
                "+ Perimeter: " + this.getPerimeter() + "\n" +
                "+ Area: " + this.getArea() + "\n";
    }
}