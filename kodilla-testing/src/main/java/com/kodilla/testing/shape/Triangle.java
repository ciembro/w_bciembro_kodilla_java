package com.kodilla.testing.shape;

class Triangle{
    String name;
    double a,b,c,h;

    public Triangle(String name, double a, double b, double c, double h) {
        this.name = name;
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = h;
    }

    public String getName(){
        return "triangle";
    }

    public double getShapeArea(){
        return 0.5*a*h;
    }
}
