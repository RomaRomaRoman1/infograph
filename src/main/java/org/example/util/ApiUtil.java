package org.example.util;

import org.example.dto.RegionDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ApiUtil {

    private final String API_URL = "http://www.cikrf.ru/api";

    public List<RegionDto> fetchRegionData() {
        RestTemplate restTemplate = new RestTemplate();
        RegionDto[] response = restTemplate.getForObject(API_URL, RegionDto[].class);
        if (response != null && response.length > 0) {
            List<RegionDto> regionDtos = Arrays.asList(response);
            regionDtos.forEach(region -> region.setDateTime(LocalDateTime.now())); // Example of processing the response
            return regionDtos;
        }
        return Collections.emptyList();
    }
}