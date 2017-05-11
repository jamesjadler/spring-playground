package com.example;


import com.example.Models.config.WordCountConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WordCount {
    @Autowired
    private WordCountConfig config;

    public Map<String, Integer> count(String str) {
        System.out.println("====== CONFIG PRINT ======");
        System.out.println(config);
        System.out.println("==== CONFIG PRINT END ====");

        Map<String, Integer> map = config.getCaseSensitive() ? new HashMap<>() : new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        List<String> strList = Arrays.asList(str.split(" "));
        System.out.printf("Splitting list:" + strList);
        strList.forEach(row -> {
            row = row.replaceAll(",", "");

            if (!map.containsKey(row) && !config.getWords().getSkip().contains(row)) {
                map.put(row, 1);

            } else if (!config.getWords().getSkip().contains(row)) {
                int count = map.get(row);
                map.put(row, count + 1);
            }

        });
        System.out.println(map);
        return map;
    }


}
