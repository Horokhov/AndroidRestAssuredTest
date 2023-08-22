package org.tests;

import apiCalls.GetRandomNumberRequest;
import io.appium.java_client.android.AndroidDriver;
import org.base.BaseAndroid;
import org.testng.annotations.Test;
import pages.Calculator;

public class CalculatorApiTests extends BaseAndroid{

    @Test
    public void check(){
        GetRandomNumberRequest getRandomNumberRequest = new GetRandomNumberRequest();
        String numberA = getRandomNumberRequest.getRandromNumber(0,100);
        String numberB = getRandomNumberRequest.getRandromNumber(0,100);

        Calculator calculator = passingDriver();
        calculator.enterNumber(numberA);
        calculator.add();
        calculator.enterNumber(numberB);
        calculator.equals();
        String answer1 = calculator.getAnswer();
        System.out.println(answer1);

        calculator.enterNumber(numberA);
        calculator.multiply();
        calculator.enterNumber(numberB);
        calculator.equals();
        String answer2 = calculator.getAnswer();
        System.out.println(answer2);

        calculator.enterNumber(answer1);
        calculator.divide();
        calculator.enterNumber(answer2);
        calculator.equals();
        String finalAnswer = calculator.getAnswer();
        System.out.println(finalAnswer);

    }
}
