package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

public class ShapeCollectorTestSuite {

    @Nested
    class SquareTests {

        @DisplayName("when creating square object with name, should return correct name")
        @Test
        void testGetName(){
            //Given
            Square square = new Square("square", 1);
            //When
            String result = square.getName();
            //Then
            Assertions.assertEquals("square", result);
        }

        @DisplayName("when create object with side 1, should return area 1")
        @Test
        void testGetShapeArea(){
            //Given
            Square square = new Square("square", 1);
            //When
            double area = square.getShapeArea();
            //Then
            Assertions.assertEquals(1, area);
        }
    }

    @Nested
    class CircleTests {
        @DisplayName("when creating circle object with name, should return correct name")
        @Test
        void testGetName(){
            //Given
            Circle circle = new Circle(1,"circle");
            //When
            String result = circle.getName();
            //Then
            Assertions.assertEquals("circle", result);
        }

        @DisplayName("when creating circle with radius 1, should return area pi")
        @Test
        void testGetShapeArea(){
            //Given
            Circle circle = new Circle(1,"circle");
            //When
            double area = circle.getShapeArea();
            //Then
            Assertions.assertEquals(Math.PI, area);
        }
    }

    @Nested
    class TriangleTests {

        @DisplayName("when creating triangle object with name, should return correct name")
        @Test
        void testGetName(){
            //Given
            Triangle triangle = new Triangle("triangle", 2, 1, 1, 1);
            //When
            String result = triangle.getName();
            //Then
            Assertions.assertEquals("triangle", result);
        }

        @DisplayName("when create triangle with side 2 and height 1, should return area 1")
        @Test
        void testGetShapeArea(){
            //Given
            Triangle triangle = new Triangle("triangle", 2, 1, 1, 1);
            //When
            double area = triangle.getShapeArea();
            //Then
            Assertions.assertEquals(1, area);  //0.5*2*1
        }

    }

    @Nested
    class TestShapeCollector {

        @DisplayName("when add new object to empty list, the size should be 1")
        @Test
        void testAddShape(){
            //Given
            ShapeCollector collector = new ShapeCollector();
            //When
            Circle circle = new Circle(1, "circle");
            collector.addShape(circle);
            //Then
            Assertions.assertEquals(1, collector.shapeList.size());

        }

        @DisplayName("when remove shape that not exist in list, size of list should be 0")
        @Test
        void testRemoveShapeNotExisting(){
            //Given
            ShapeCollector collector = new ShapeCollector();
            Circle circle = new Circle(1,"circle");
            //When
            boolean result = collector.shapeList.remove(circle);
            //Then
            Assertions.assertFalse(result);
            Assertions.assertEquals(0, collector.shapeList.size());
        }

        @DisplayName("when remove shape from 1-element list , size of list should be 0")
        @Test
        void testRemoveShape(){
            //Given
            ShapeCollector collector = new ShapeCollector();
            Circle circle = new Circle(1,"circle");
            collector.addShape(circle);
            //When
            boolean result = collector.shapeList.remove(circle);
            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, collector.shapeList.size());
        }

        @DisplayName("when retrieving object from non existing list index, should throw exception")
        @Test
        void testGetShapeNotExisting(){
            //Given
            ShapeCollector collector = new ShapeCollector();
            //Then
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> collector.getShape(0));
        }

        @DisplayName("when retrieving object from index=0, the function should return object")
        @Test
        void testGetShape(){
            //Given
            ShapeCollector collector = new ShapeCollector();
            Circle circle = new Circle(1,"circle");
            collector.shapeList.add(circle);
            //When
            Shape shape = collector.getShape(0);
            //Then
            Assertions.assertEquals(circle, shape);
        }

        @DisplayName("when shapeList is empty, the function should return null")
        @Test
        void testShowShapesWhenNoShape(){
            //Given
            ShapeCollector collector = new ShapeCollector();
            //When
            String result = collector.showShapes();
            //Then
            Assertions.assertNull(null);

        }

        @DisplayName("when shapeList is not empty, should return string with all names from list")
        @Test
        void testShowShapesOnNonEmptyList(){
            //Given
            ShapeCollector collector = new ShapeCollector();
            Circle circle = new Circle(1,"circle");
            collector.addShape(circle);
            //When
            String result = collector.showShapes();
            //Then
            Assertions.assertEquals("circle", result);
        }
    }

}
