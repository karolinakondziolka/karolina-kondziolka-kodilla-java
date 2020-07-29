package com.kodilla.patterns.factory.tasks;

import com.kodilla.patterns.factory.Circle;
import com.kodilla.patterns.factory.Rectangle;
import com.kodilla.patterns.factory.Shape;
import com.kodilla.patterns.factory.Square;

public class TaskFactory {

    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPING:
                return new ShoppingTask("Shopping", "Body", 1);
            case PAINTING:
                return new PaintingTask("Painting", "Blue", "Poster");
            case DRIVING:
                return new DrivingTask("Driving", "Driving home for christmas", "car");
            default:
                return null;
        }
    }
}
