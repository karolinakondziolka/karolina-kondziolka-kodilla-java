package com.kodilla.spring.calculator;

import com.kodilla.spring.library.Library;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    @Test
    public void addAtoB(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double result=calculator.add(4,5);
        //Then
        Assert.assertEquals(9, result,0);
    }
    @Test
    public void subBfromA(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double result=calculator.sub(6,5);
        //Then
        Assert.assertEquals(1, result,0);
    }
    @Test
    public void mulAandB(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double result=calculator.mul(4,5);
        //Then
        Assert.assertEquals(20, result,0);
    }
    @Test
    public void divAtoB(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double result=calculator.div(5,5);
        //Then
        Assert.assertEquals(1, result,0);
    }





}
