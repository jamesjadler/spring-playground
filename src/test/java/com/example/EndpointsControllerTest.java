package com.example;

import com.example.Models.Flight;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.DynAnyPackage.Invalid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static com.jayway.jsonpath.internal.function.ParamType.JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EndpointsController.class)
public class EndpointsControllerTest {
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mvc;

    @Test
    public void testIndexEndpoint() throws Exception {
        this.mvc.perform(get("/math/pi").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string(Double.toString(Math.PI)));
    }

    @Test
    public void testCalculate() throws Exception {
        this.mvc.perform(get("/math/calculate?operation=add&x=4&y=6").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("4 + 6 = 10"));
        this.mvc.perform(get("/math/calculate?operation=multiply&x=4&y=6").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("4 * 6 = 24"));
        this.mvc.perform(get("/math/calculate?operation=subtract&x=4&y=6").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("4 - 6 = -2"));
        this.mvc.perform(get("/math/calculate?operation=divide&x=30&y=5").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("30 / 5 = 6"));
        this.mvc.perform(get("/math/calculate?x=30&y=5").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("30 + 5 = 35"));
    }

    @Test
    public void testSum() throws Exception {
        this.mvc.perform(post("/math/sum?n=4&n=5&n=6").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("4 + 5 + 6 = 15"));
    }

    @Test
    public void testVolume() throws Exception {
        this.mvc.perform(post("/math/volume/42/56/79").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 42x56x79 rectangle is 185808"));

        this.mvc.perform(get("/math/volume/42/56/79").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 42x56x79 rectangle is 185808"));

        this.mvc.perform(patch("/math/volume/42/56/79").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 42x56x79 rectangle is 185808"));

    }

    @Test
    public void testArea() throws Exception {
        MockHttpServletRequestBuilder request1 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "circle")
                .param("radius", "4");

        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string("Area of a circle with a radius of 4 is 50.26548"));

        MockHttpServletRequestBuilder request2 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "circle");

        this.mvc.perform(request2)
                .andExpect(status().isOk())
                .andExpect(content().string("Invalid"));

        MockHttpServletRequestBuilder request3 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "rectangle")
                .param("height", "4")
                .param("width", "7");

        this.mvc.perform(request3)
                .andExpect(status().isOk())
                .andExpect(content().string("Area of a 4x7 rectangle is 28"));

        MockHttpServletRequestBuilder request4 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "rectangle")
                .param("length", "4");

        this.mvc.perform(request4)
                .andExpect(status().isOk())
                .andExpect(content().string("Invalid"));
    }

    @Test
    public void getFlight() throws Exception {
        String expected = "{\"Departs\":\"2017-04-21 20:34\",\"Tickets\":[{\"Passenger\":{\"FirstName\":\"Some name\",\"LastName\":\"Some other name\"},\"Price\":200}]}";

        this.mvc.perform(get("/flights/flight").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(expected));

    }

    @Test
    public void getFlights() throws Exception {
        String expected = "[{\"Departs\":\"2017-04-21 20:34\",\"Tickets\":[{\"Passenger\":{\"FirstName\":\"Some name\",\"LastName\":\"Some other name\"},\"Price\":200}]},{\"Departs\":\"2017-04-21 20:34\",\"Tickets\":[{\"Passenger\":{\"FirstName\":\"Some other name\"},\"Price\":400}]}]";

        this.mvc.perform(get("/flights").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(expected));

    }

}