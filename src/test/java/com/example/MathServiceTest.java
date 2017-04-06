package com.example;


import com.example.Models.Calculator;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

import static java.util.Arrays.asList;

public class MathServiceTest {
    private MathService mathService = new MathService();

    @Test
    public void getCalculateTest()throws Exception {
        Calculator calculator = new Calculator();
        calculator.setOperation("add");
        calculator.setX(4D);
        calculator.setY(5D);
        String result = mathService.getCalculate(calculator);
        System.out.println(result);
        Assert.assertEquals(result,"4 + 5 = 9");
    }

    @Test
    public void getSumTest()throws Exception {
        MultiValueMap<String,List<String>> inputMap = new LinkedMultiValueMap<>();

        inputMap.add("n",asList("4","4","3"));
        String result = mathService.getSum(inputMap);
        System.out.println(result);
        Assert.assertEquals(result,"4 + 4 + 3 = 11");
        }

}
