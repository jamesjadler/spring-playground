package com.example.Models;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ticket {
    @JsonProperty("Passenger")
    private Passenger passenger;
    @JsonProperty("Price")
    private int price;

}