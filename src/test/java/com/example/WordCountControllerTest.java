package com.example;

import com.example.Models.Database.Lesson;
import com.example.Models.Database.LessonRepository;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.http.client.MockClientHttpRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class WordCountControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void lessonTest() throws Exception {
//        String str = "this is a test test test";
        String str = "How now, brown cow";

        MockHttpServletRequestBuilder request = post("/words/count")
                .contentType(MediaType.APPLICATION_JSON)
                .content(str);
        System.out.println("Calling /words/count");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.this", is(1)))
                .andExpect(jsonPath("$.is", is(1)))
                .andExpect(jsonPath("$.a", is(1)))
                .andExpect(jsonPath("$.test", is(3)));


    }
}
