package com.example;

import com.example.Models.AreaRequest;
import com.example.Models.BoxDimentions;
import com.example.Models.Calculator;

import java.util.Map;

public class MathService {

    public MathService() {
    }

    public String calculateWithOperator(Calculator calculator) {
        String operator = "";
        String result = "";
        switch (null == calculator.getOperation() ? "NULL" : calculator.getOperation().toUpperCase()) {
            case "ADD":
                operator = "+";
                result = Integer.toString((int) Math.round(calculator.getX() + calculator.getY()));
                break;

            case "SUBTRACT":
                operator = "-";
                result = Integer.toString((int) Math.round(calculator.getX() - calculator.getY()));
                break;

            case "MULTIPLY":
                operator = "*";
                result = Integer.toString((int) Math.round(calculator.getX() * calculator.getY()));
                break;

            case "DIVIDE":
                operator = "/";
                if (calculator.getY() == 0) {
                    result = "Nice Try!";
                } else {
                    result = Integer.toString((int) Math.round(calculator.getX() / calculator.getY()));
                }
                break;

            default:
                operator = "+";
                result = Integer.toString((int) Math.round(calculator.getX() + calculator.getY()));
                break;
        }


        return Math.round(calculator.getX()) + " " + operator + " " + Math.round(calculator.getY()) + " = " + result;
    }

    public String calculateSum(Map queryString) {
        StringBuilder sumString = new StringBuilder();
        long sum = 0;

        String str = queryString.get("n").toString().replace("[", "").replace("]", "");
        String[] strList = str.split(",");

        int i = 0;

        for (String val : strList) {
            val = val.trim();
            if (i == 0) {
                sumString.append(val);
                i++;
            } else {
                sumString.append(" + " + val);
            }
            sum += Long.valueOf(val.trim());

        }

        return sumString + " = " + sum;
    }

    public String calculateVolume(BoxDimentions boxDimentions) {
        int volume = boxDimentions.getHeight() * boxDimentions.getLength() * boxDimentions.getWidth();
        return String.format("The volume of a %dx%dx%d rectangle is %d",
                boxDimentions.getLength(),
                boxDimentions.getWidth(),
                boxDimentions.getHeight(),
                volume);
    }

    public String calculateArea(AreaRequest areaRequest) {

        switch (areaRequest.getType().toUpperCase()) {

            case "CIRCLE":
                if (areaRequest.getRadius() != null) {
                    Double area = Math.PI * (Math.pow(areaRequest.getRadius(), 2.0));
                    return String.format("Area of a circle with a radius of %.0f is %.5f", areaRequest.getRadius(), area);
                } else {
                    return "Invalid";
                }

            case "RECTANGLE":
                if (areaRequest.getHeight() != null && areaRequest.getWidth() != null){
                    Double area = areaRequest.getHeight() * areaRequest.getWidth();
                    return String.format("Area of a %.0fx%.0f rectangle is %.0f",areaRequest.getHeight(),areaRequest.getWidth(),area);
                }else{
                    return "Invalid";
                }
            default:
                return "Invalid";


        }


    }
}
