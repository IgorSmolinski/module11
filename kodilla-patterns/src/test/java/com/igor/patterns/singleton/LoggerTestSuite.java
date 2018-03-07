package com.igor.patterns.singleton;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {

    @BeforeClass
    public static void LogInTest(){
        Logger.getInstance();
        Logger.getInstance().log("Cos nie cos!");
    }

    @Test
    public void getLastTest(){
        //Given
        //When
        String result =Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("Cos nie cos!", result);

    }

}
