package com.example;


import com.example.Models.BoxDimentions;
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
    public void getCalculateTest() throws Exception {
        Calculator calculator = Calculator.builder()
                .operation("add")
                .x(4D)
                .y(5d)
                .build();

        String result = mathService.calculateWithOperator(calculator);
        System.out.println(result);
        Assert.assertEquals(result, "4 + 5 = 9");
    }

    @Test
    public void getSumTest() throws Exception {
        MultiValueMap<String, List<String>> inputMap = new LinkedMultiValueMap<>();

        inputMap.add("n", asList("4", "4", "3"));
        String result = mathService.calculateSum(inputMap);
        System.out.println(result);
        Assert.assertEquals(result, "4 + 4 + 3 = 11");
    }

    @Test
    public void calculateVolumeTest() {
        BoxDimentions boxDimentions = BoxDimentions.builder()
                .length(42)
                .width(56)
                .height(79)
                .build();
        String result = mathService.calculateVolume(boxDimentions);
        System.out.println(result);
        Assert.assertEquals(result,"The volume of a 42x56x79 rectangle is 185808" );
    }
}
