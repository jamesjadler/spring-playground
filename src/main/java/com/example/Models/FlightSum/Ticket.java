package com.example.Models.FlightSum;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ticket {
    private Passenger passenger;
    private int price;
}