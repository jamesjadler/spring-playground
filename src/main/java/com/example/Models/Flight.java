package com.example.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode
public class Flight {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonProperty("Departs")
    private Date departs;
    @JsonProperty("Tickets")
    private List<Ticket> tickets;
    @Data
    @Builder
    @EqualsAndHashCode
    public static class Ticket {
        @JsonProperty("Passenger")
        private Passenger passenger;
        @JsonProperty("Price")
        private int price;

    }

    @Data
    @Builder
    @EqualsAndHashCode
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Passenger {
        @JsonProperty("FirstName")
        private String firstName;
        @JsonProperty("LastName")
        private String lastName;

    }

}