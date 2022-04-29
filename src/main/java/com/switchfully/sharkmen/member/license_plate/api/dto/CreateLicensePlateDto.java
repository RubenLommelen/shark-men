package com.switchfully.sharkmen.member.license_plate.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class CreateLicensePlateDto {
    @NotBlank(message = "LicensePlateNumber is blank or null")
    private final String licensePlateNumber;
    @NotBlank(message = "Country is blank or null")
    private final String country;

    public CreateLicensePlateDto(String licensePlateNumber, String country) {
        this.licensePlateNumber = licensePlateNumber;
        this.country = country;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public String getCountry() {
        return country;
    }


}
