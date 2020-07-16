package com.kodilla.spring.calculator;

import org.springframework.stereotype.Component;

@Component
public class Display {

    double val;

    void displayValue(double val){
        System.out.println(val);

    }
}
