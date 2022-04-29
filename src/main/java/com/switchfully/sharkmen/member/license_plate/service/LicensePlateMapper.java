package com.switchfully.sharkmen.member.license_plate.service;

import com.switchfully.sharkmen.member.license_plate.api.dto.CreateLicensePlateDto;
import com.switchfully.sharkmen.member.license_plate.api.dto.LicensePlateDto;
import com.switchfully.sharkmen.member.license_plate.domain.LicensePlate;
import org.springframework.stereotype.Component;

@Component
public class LicensePlateMapper {

    public LicensePlate toLicensePlate(LicensePlateDto licensePlateDto) {
        return new LicensePlate(licensePlateDto.getLicensePlateNumber(), licensePlateDto.getCountry());
    }

    public LicensePlate toLicensePlate(CreateLicensePlateDto createLicensePlateDto) {
        return new LicensePlate(createLicensePlateDto.getLicensePlateNumber(), createLicensePlateDto.getCountry());
    }

    public LicensePlateDto toDto(LicensePlate licensePlate) {
        return new LicensePlateDto(licensePlate.getLicensePlateNumber(), licensePlate.getCountry());
    }
}
