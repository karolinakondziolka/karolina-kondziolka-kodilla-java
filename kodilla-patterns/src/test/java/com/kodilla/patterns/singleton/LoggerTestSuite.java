package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {
    private static Logger logger;

    @BeforeClass
    public static void logSth(){
        logger = new Logger();
        Logger.getInstance().log("Login1");
    }

    @Test
    public void testGetLastLog(){
        //Given
        //When
        String lastLog = Logger.getInstance().getLastLog();
        System.out.println("Last log:" + lastLog);
        //Then
        Assert.assertEquals("Login1", lastLog);
    }



}
