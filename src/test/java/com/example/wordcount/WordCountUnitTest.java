package com.example.wordcount;


import com.example.Models.config.WordCountConfig;
import com.example.WordCount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class WordCountUnitTest {
    @Autowired
    WordCountConfig config;
    @Autowired
    WordCount wordCount;

    @Test
    public void testCaseSensitiveFalse() {
        System.out.println(config);
        System.out.println(config.getWords());
        config.setCaseSensitive(false);
        String str = "test TEST a";
        Map<String, Integer> map = wordCount.count(str);
        System.out.println(map);
        assert (map.get("test") == 2);

    }
    @Test
    public void testCaseSensitiveTrue() {
        System.out.println(config);
        System.out.println(config.getWords());
        config.setCaseSensitive(true);
        String str = "test TEST a";
        Map<String, Integer> map =  wordCount.count(str);
        System.out.println(map);
        assert (map.get("test") == 1);
        assert (map.get("TEST") == 1);

    }
}
