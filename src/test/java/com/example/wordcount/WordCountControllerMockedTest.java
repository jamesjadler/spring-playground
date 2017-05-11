package com.example.wordcount;

import com.example.WordCount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class WordCountControllerMockedTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    WordCount mockedWordCount;

    @Test
    public void mockedTest() throws Exception {
        String str = "this is a test test test";
        Map<String,Integer> map = new HashMap<>();
        map.put("mockedValue",2);
        when(mockedWordCount.count(str)).thenReturn(map);

        MockHttpServletRequestBuilder request = post("/words/count")
                .contentType(MediaType.APPLICATION_JSON)
                .content(str);
        System.out.println("Calling /words/count");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mockedValue", is(2)));


    }
}
