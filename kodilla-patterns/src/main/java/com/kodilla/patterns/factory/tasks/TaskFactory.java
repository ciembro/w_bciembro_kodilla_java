package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String SHOPPING_TASK = "SHOPPING";
    public static final String PAINTING_TASK = "PAINTING";
    public static final String DRIVING_TASK = "DRIVING";

    public Task createTask(final String task){

        switch (task) {

            case SHOPPING_TASK:
                return new ShoppingTask("buy newspaper", "newspaper", 2);

            case PAINTING_TASK:
                return new PaintingTask("paint fence", "green", "fence");

            case DRIVING_TASK:
                return new DrivingTask("drive car", "Krakow", "car");

            default:
                return null;
        }
    }
}
