package com.example;


import com.example.Models.BoxDimentions;
import com.example.Models.Calculator;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;


@RestController
public class EndpointsController {
    private MathService mathService = new MathService();

    @GetMapping("/math/pi")
    public String getPi() {
        return Double.toString(Math.PI);
    }

    @GetMapping("/math/calculate")
    public String getCalculate(Calculator calculator) {
        return mathService.calculateWithOperator(calculator);
    }

    @PostMapping("/math/sum")
    public String getSum(@RequestParam MultiValueMap queryString) {
        return mathService.calculateSum(queryString);
    }

    @RequestMapping("/math/volume/{length}/{width}/{height}")
    public String getVolume(BoxDimentions boxDimentions) {
        return mathService.calculateVolume(boxDimentions);
    }
}