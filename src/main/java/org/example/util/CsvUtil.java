package org.example.util;

import org.example.dto.RegionDto;

import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class CsvUtil {
    public static List<RegionDto> parseCsv(InputStreamReader inputStreamReader) throws IOException, CsvException{
        List<RegionDto> regionDtoList = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(inputStreamReader)) {
            List<String[]> rows = csvReader.readAll();
            for (String[] row : rows) {
                RegionDto regionDto = new RegionDto();
                regionDto.setNameRegion(row[0]);
                regionDto.setShortName(row[1]);
                regionDto.setPercentage(Double.parseDouble(row[2]));
                regionDto.setDateTime(LocalDateTime.parse(row[3]));
                regionDto.setRegionCode(Integer.parseInt(row[4]));
                regionDtoList.add(regionDto);
            }
        }
        return regionDtoList;
    }
}
