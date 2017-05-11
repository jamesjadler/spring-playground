package com.example.Models.config;

import lombok.Data;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties("wordCount")
public class WordCountConfig {
    private Boolean caseSensitive;
    private Words words;

    @Data
    public static class Words {
        private List<String> skip;
    }
}

