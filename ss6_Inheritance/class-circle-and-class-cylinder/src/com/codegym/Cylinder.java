package com.codegym;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
    super();
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


    @Override
    public double getArea() {
        return getRadius()*2*Math.PI*height + 2*super.getArea();
    }
    public double getVolume() {
        return super.getArea() * getHeight();
    }

    public String toString() {
        return super.toString()
                + " V = "
                + getVolume();
    }
}
