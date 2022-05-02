package com.switchfully.sharkmen.member.license_plate.service;

import com.switchfully.sharkmen.member.license_plate.api.dto.CreateLicensePlateDto;
import com.switchfully.sharkmen.member.license_plate.api.dto.LicensePlateDto;
import com.switchfully.sharkmen.member.license_plate.domain.LicensePlate;
import com.switchfully.sharkmen.member.service.MemberMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LicensePlateMapper {

    private final Logger licensePlateMapperLogger = LoggerFactory.getLogger(LicensePlateMapper.class);

    // CreateLicensePlateDto replaces this
    //public LicensePlate toLicensePlate(LicensePlateDto licensePlateDto) {
    //    return new LicensePlate(licensePlateDto.getLicensePlateNumber(), licensePlateDto.getCountry());
    //}

    public LicensePlate toLicensePlate(CreateLicensePlateDto createLicensePlateDto) {
        licensePlateMapperLogger.info("CreateLicensePlateDto conversion to LicensePlate");
        return new LicensePlate(createLicensePlateDto.getLicensePlateNumber(), createLicensePlateDto.getCountry());
    }

    public LicensePlateDto toDto(LicensePlate licensePlate) {
        licensePlateMapperLogger.info("LicensePlate conversion to LicensePlateDto");
        return new LicensePlateDto(licensePlate.getLicensePlateNumber(), licensePlate.getCountry());
    }
}
