package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    private List<Shape> shapeList = new ArrayList<>();

    public void addShape(Shape shape){
        if (shape != null)
            shapeList.add(shape);
    }

    public boolean removeShape(Shape shape){
        return shapeList.remove(shape);
    }

    public List<Shape> getShapeList(){
        return shapeList;
    }

    public Shape getShape(int index){
        return shapeList.get(index);
    }

    public String showShapes(){
        if (shapeList.isEmpty())
            return null;
        String names = "";
        for (int i = 0; i < shapeList.size() - 1; i++){
            names += getShape(i).getName();
        }
        names += shapeList.get(shapeList.size() - 1).getName();
        return names;
    }
}
