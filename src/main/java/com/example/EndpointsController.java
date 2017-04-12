package com.example;


import com.example.Models.AreaRequest;
import com.example.Models.BoxDimentions;
import com.example.Models.Calculator;
import com.example.Models.Flight;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.Arrays;
import java.util.List;


@RestController
public class EndpointsController {
    private MathService mathService = new MathService();

    @GetMapping("/math/pi")
    public String getPi() {
        return Double.toString(Math.PI);
    }

    @GetMapping("/math/calculate")
    public String getCalculate(Calculator calculator) {
        return mathService.calculateWithOperator(calculator);
    }

    @PostMapping("/math/sum")
    public String getSum(@RequestParam MultiValueMap queryString) {
        return mathService.calculateSum(queryString);
    }

    @RequestMapping("/math/volume/{length}/{width}/{height}")
    public String getVolume(BoxDimentions boxDimentions) {
        return mathService.calculateVolume(boxDimentions);
    }

    @PostMapping("/math/area")
    public String getArea(AreaRequest areaRequest) {
        return mathService.calculateArea(areaRequest);
    }

    @GetMapping("/flights/flight")
    public Flight getFlight() {
        System.out.println("I'm in flight");
        Flight flight = null;
        try {
            flight = Flight.builder()
                    .departs( new SimpleDateFormat("yyyy-MM-dd HH:mm")
                            .parse("2017-04-21 14:34"))
                    .tickets(Arrays.asList(Flight.Ticket.builder()
                            .passenger(Flight.Passenger.builder()
                                    .firstName("Some name")
                                    .lastName("Some other name")
                                    .build())
                            .price(200)
                            .build()))
                    .build();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(flight.toString());
        return flight;
    }

    @GetMapping("/flights")
    public List<Flight> getFlights() {
        System.out.println("I'm in flights");
        List<Flight> flights = new ArrayList<>();
        try {
            flights.add(Flight.builder()
                    .departs( new SimpleDateFormat("yyyy-MM-dd HH:mm")
                            .parse("2017-04-21 14:34"))
                    .tickets(Arrays.asList(Flight.Ticket.builder()
                            .passenger(Flight.Passenger.builder()
                                    .firstName("Some name")
                                    .lastName("Some other name")
                                    .build())
                            .price(200)
                            .build()))
                    .build());

            flights.add(Flight.builder()
                    .departs( new SimpleDateFormat("yyyy-MM-dd HH:mm")
                            .parse("2017-04-21 14:34"))
                    .tickets(Arrays.asList(Flight.Ticket.builder()
                            .passenger(Flight.Passenger.builder()
                                    .firstName("Some other name")
                                    .build())
                            .price(400)
                            .build()))
                    .build());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(flights.toString());
        return flights;
    }
}