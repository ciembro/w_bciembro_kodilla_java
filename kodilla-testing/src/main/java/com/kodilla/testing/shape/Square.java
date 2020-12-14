package com.kodilla.testing.shape;

class Square{
    String name;
    double a;

    public Square(String name, double a) {
        this.name = name;
        this.a = a;
    }

    public String getName(){
        return "square";
    }

    public double getShapeArea(){
        return a*a;
    }

}
