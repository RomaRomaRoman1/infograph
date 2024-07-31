package org.example.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegionDtoWithGradient {
    private String nameRegion;
    private String shortName;
    private double percentage;
    private LocalDateTime dateTime;
    private int regionCode;
    //additional field for gradient
    private int gradientCode;
}
