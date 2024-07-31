package org.example.util;

import org.example.dto.RegionDto;
import org.example.dto.RegionDtoWithGradient;
import org.example.dto.RegionDtoWithPercentageDifferent;
import org.example.entity.Region;

public class RegionConverterUtil {

    public static RegionDtoWithPercentageDifferent convertToDtoWithPercentageDifferent(Region region, Region latestRegion) {
        RegionDtoWithPercentageDifferent dto = new RegionDtoWithPercentageDifferent();
        dto.setRegionCode(region.getRegionCode());
        dto.setNameRegion(region.getNameRegion());
        dto.setShortName(region.getShortName());
        dto.setPercentage(region.getPercentage());
        dto.setDateTime(region.getDateTime());
        dto.setPercentageDifferent(region.getPercentage() - latestRegion.getPercentage());
        return dto;
    }

    public static RegionDtoWithGradient convertToDtoWithGradient(Region region) {
        RegionDtoWithGradient dto = new RegionDtoWithGradient();
        dto.setRegionCode(region.getRegionCode());
        dto.setNameRegion(region.getNameRegion());
        dto.setShortName(region.getShortName());
        dto.setPercentage(region.getPercentage());
        dto.setDateTime(region.getDateTime());
        dto.setGradientCode(GradientUtil.calculateGradient(region.getPercentage()));
        return dto;
    }

    public static Region convertDtoToEntity(RegionDto regionDto) {
        Region region = new Region();
        region.setRegionCode(regionDto.getRegionCode());
        region.setNameRegion(regionDto.getNameRegion());
        region.setShortName(regionDto.getShortName());
        region.setDateTime(regionDto.getDateTime());
        region.setPercentage(regionDto.getPercentage());
        return region;
    }
}
