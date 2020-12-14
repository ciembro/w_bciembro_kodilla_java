package com.kodilla.testing.shape;

class Circle implements  Shape{
    double r;
    String name;

    public Circle(double r, String name) {
        this.r = r;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public double getShapeArea(){
        return Math.PI*r*r;
    }

}