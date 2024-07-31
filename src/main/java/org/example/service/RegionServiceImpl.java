package org.example.service;

import com.opencsv.exceptions.CsvException;
import org.example.dto.RegionDto;
import org.example.dto.RegionDtoWithGradient;
import org.example.dto.RegionDtoWithPercentageDifferent;
import org.example.entity.Region;
import org.example.repository.RegionRepository;
import org.example.util.ApiUtil;
import org.example.util.CsvUtil;
import org.example.util.RegionConverterUtil;
import org.example.util.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;

    private final ApiUtil apiUtil;

    @Autowired
    public RegionServiceImpl(RegionRepository regionRepository, ApiUtil apiUtil) {
        this.regionRepository = regionRepository;
        this.apiUtil = apiUtil;
    }

    @Override
    public List<RegionDto> getAndSaveRegionsFromApi() {
        List<RegionDto> regionData = apiUtil.fetchRegionData();
        regionRepository.saveAll(regionData.stream()
                .map(RegionConverterUtil::convertDtoToEntity)
                .collect(Collectors.toList()));
        return regionData;
    }

    @Override
    public List<RegionDto> getAndSaveRegionsFromCsv(MultipartFile file) throws IOException, CsvException {
        List<RegionDto> regionDtoList = CsvUtil.parseCsv(new InputStreamReader(file.getInputStream()));
        regionRepository.saveAll(regionDtoList.stream()
                .map(RegionConverterUtil::convertDtoToEntity)
                .collect(Collectors.toList()));
        return regionDtoList;
    }

    @Override
    public List<RegionDto> getAndSaveRegionsFromText(String textData) {
        List<RegionDto> regionDtoList = TextUtil.parseText(textData);
        regionRepository.saveAll(regionDtoList.stream()
                .map(RegionConverterUtil::convertDtoToEntity)
                .collect(Collectors.toList()));
        return regionDtoList;
    }

    @Override
    public List<RegionDtoWithGradient> getRegionsWithGradient() {
        List<Region> regions = regionRepository.findAll();
        return regions.stream()
                .map(RegionConverterUtil::convertToDtoWithGradient)
                .collect(Collectors.toList());
    }

    @Override
    public List<RegionDtoWithPercentageDifferent> getRegionsWithPercentageDifferent() {
        Region latestRegion = regionRepository.findLatestRegion()
                .orElseThrow(() -> new RuntimeException("No regions found"));

        List<Region> regions = regionRepository.findAll();

        return regions.stream()
                .map(region -> RegionConverterUtil.convertToDtoWithPercentageDifferent(region, latestRegion))
                .collect(Collectors.toList());
    }
}