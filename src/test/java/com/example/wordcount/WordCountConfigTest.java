package com.example.wordcount;


import com.example.Models.config.WordCountConfig;
import com.example.WordCount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(properties = {
        "wordCount.caseSensitive=false",
        "wordCount.words.skip[0]=hi",
        "wordCount.words.skip[1]=there",
        "wordCount.words.skip[2]=galvanize"
})
public class WordCountConfigTest {
    @Autowired
    WordCountConfig config;

    @Test
    public void testCaseSensitiveFalse() {
        assert (config.getCaseSensitive() == false);
        assert (config.getWords().getSkip().get(0).equals("hi"));
        assert (config.getWords().getSkip().get(1).equals("there"));
        assert (config.getWords().getSkip().get(2).equals("galvanize"));


    }
}
