package com.example.wordcount;


import com.example.WordCount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class WordCountUnitTest {
    private WordCount wordCount = new WordCount();

    @Test
    public void test(){
        String str = "test test a";
       HashMap<String,Integer> map =  (HashMap<String,Integer>)wordCount.count(str);
        System.out.println(map);
       assert(map.get("test")==2);
       assert(map.get("a")==1);

    }
}
