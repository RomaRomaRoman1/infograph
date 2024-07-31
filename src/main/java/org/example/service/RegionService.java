package org.example.service;

import com.opencsv.exceptions.CsvException;
import org.example.dto.RegionDto;
import org.example.dto.RegionDtoWithGradient;
import org.example.dto.RegionDtoWithPercentageDifferent;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface RegionService {
    //method for getting and saving values from Api CIK
    List<RegionDto> getAndSaveRegionsFromApi();
    //method for getting and saving values from Csv file
    List<RegionDto> getAndSaveRegionsFromCsv(MultipartFile file) throws IOException, CsvException;
    //method for getting and saving values from Text
    List<RegionDto> getAndSaveRegionsFromText(String textData);
    List<RegionDtoWithGradient> getRegionsWithGradient();
    List<RegionDtoWithPercentageDifferent> getRegionsWithPercentageDifferent();
}
