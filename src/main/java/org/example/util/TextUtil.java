package org.example.util;

import org.example.dto.RegionDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TextUtil {

    public static List<RegionDto> parseText(String textData) {
        List<RegionDto> regionDtoList = new ArrayList<>();
        String[] rows = textData.split("\n");
        for (String row : rows) {
            String[] columns = row.split(",");
            RegionDto regionDto = new RegionDto();
            regionDto.setNameRegion(columns[0]);
            regionDto.setShortName(columns[1]);
            regionDto.setPercentage(Double.parseDouble(columns[2]));
            regionDto.setDateTime(LocalDateTime.parse(columns[3]));
            regionDto.setRegionCode(Integer.parseInt(columns[4]));
            regionDtoList.add(regionDto);
        }
        return regionDtoList;
    }
}