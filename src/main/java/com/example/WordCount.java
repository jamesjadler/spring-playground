package com.example;


import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class WordCount {

    public Map<String, Integer> count(String str) {
        System.out.println("Attempting to count: \n" + str);
        Map<String, Integer> map = new HashMap<>();
        List<String> strList = Arrays.asList(str.split(" "));
        System.out.printf("Splitting list:" + strList);
        strList.forEach(row -> {
            row = row.replaceAll(",", "");
            if (!map.containsKey(row)) {
                map.put(row, 1);
            } else {
                int count = map.get(row);
                map.put(row, count + 1);
            }

        });
        System.out.println(map);
        return map;
    }


}
