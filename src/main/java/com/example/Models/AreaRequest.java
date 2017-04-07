package com.example.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AreaRequest {
    private String type;
    private Double radius;
    private Double width;
    private Double height;
}
