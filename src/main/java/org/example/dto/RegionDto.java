package org.example.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class RegionDto {

    private String nameRegion;
    private String shortName;
    private double percentage;
    private LocalDateTime dateTime;
    private int regionCode;
}