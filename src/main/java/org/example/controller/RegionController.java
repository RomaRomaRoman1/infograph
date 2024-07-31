package org.example.controller;
import com.opencsv.exceptions.CsvException;
import org.example.dto.RegionDto;
import org.example.dto.RegionDtoWithGradient;
import org.example.dto.RegionDtoWithPercentageDifferent;
import org.example.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/regions")
public class RegionController {

    private final RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("/with-gradient")
    public List<RegionDtoWithGradient> getRegionsWithGradient() {
        return regionService.getRegionsWithGradient();
    }

    @GetMapping("/with-percentage-different")
    public List<RegionDtoWithPercentageDifferent> getRegionsWithPercentageDifferent() {
        return regionService.getRegionsWithPercentageDifferent();
    }

    @PostMapping("/from-api")
    public List<RegionDto> getAndSaveRegionsFromApi() {
        return regionService.getAndSaveRegionsFromApi();
    }

    @PostMapping("/from-csv")
    public List<RegionDto> getAndSaveRegionsFromCsv(@RequestParam("file") MultipartFile file) throws IOException, CsvException {
        return regionService.getAndSaveRegionsFromCsv(file);
    }

    @PostMapping("/from-text")
    public List<RegionDto> getAndSaveRegionsFromText(@RequestParam("textData") String textData) {
        return regionService.getAndSaveRegionsFromText(textData);
    }
}