package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardTestSuite {
    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        TaskList toDoList = board.getToDoList();
        TaskList inProgressList = board.getInProgressList();
        TaskList doneList = board.getDoneList();
        toDoList.addTasks("Rozwiązać 2 zadania");
        inProgressList.addTasks("Rozwiązać 1 zadanie");
        doneList.addTasks("Rozwiązane 4 zadania");
        String toDoTask = toDoList.showTasksList(0);
        String inProgressTask = inProgressList.showTasksList(0);
        String doneTask = doneList.showTasksList(0);

        //Then
        Assert.assertEquals("Rozwiązać 2 zadania", toDoTask);
        Assert.assertEquals("Rozwiązać 1 zadanie", inProgressTask);
        Assert.assertEquals("Rozwiązane 4 zadania", doneTask);


    }
}
