package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/words")
public class WordCountController {
    @Autowired
    WordCount wordCount;



    @PostMapping("/count")
    public Map<String,Integer> getWordCount(@RequestBody String request){
        return wordCount.count(request);
    }
}
