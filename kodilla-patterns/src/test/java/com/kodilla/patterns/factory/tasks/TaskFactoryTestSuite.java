package com.kodilla.patterns.factory.tasks;

import com.kodilla.patterns.factory.Shape;
import com.kodilla.patterns.factory.ShapeFactory;
import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {

    @Test
    public void testFactoryShopping() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shopping = factory.makeTask(TaskFactory.SHOPPING);
        //Then
        Assert.assertEquals("Shopping", shopping.getTaskName());
        Assert.assertEquals(true, shopping.isTaskExecuted());
    }

    @Test
    public void testFactoryPainting() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task painting = factory.makeTask(TaskFactory.PAINTING);
        //Then
        Assert.assertEquals("Painting", painting.getTaskName());
        Assert.assertEquals("Task to be executed", painting.executeTask());
    }

    @Test
    public void testFactoryDriving() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task driving = factory.makeTask(TaskFactory.DRIVING);
        //Then
        Assert.assertEquals("Driving", driving.getTaskName());
        Assert.assertEquals(false, driving.isTaskExecuted());
    }

}
