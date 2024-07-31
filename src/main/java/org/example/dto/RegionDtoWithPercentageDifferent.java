package org.example.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegionDtoWithPercentageDifferent {
    private String nameRegion;
    private String shortName;
    private double percentage;
    private LocalDateTime dateTime;
    private int regionCode;
    //additional field for percentage different
    private double percentageDifferent;
}
