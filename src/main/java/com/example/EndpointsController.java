package com.example;


import com.example.Models.Calculator;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class EndpointsController {
    private MathService mathService = new MathService();

    @GetMapping("/math/pi")
    public String getPi() {
        return Double.toString(Math.PI);
    }

    @GetMapping("/math/calculate")
    public String getCalculate(Calculator calculator) {
        return mathService.getCalculate(calculator);
    }

    @PostMapping("/math/sum")
    public String getSum(@RequestParam MultiValueMap queryString) {
        return mathService.getSum(queryString);
    }

}