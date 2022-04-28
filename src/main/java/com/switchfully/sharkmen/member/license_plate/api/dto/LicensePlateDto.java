package com.switchfully.sharkmen.member.license_plate.api.dto;

import java.util.Objects;

public class LicensePlateDto {
    private final String licensePlateNumber;
    private final String country;

    public LicensePlateDto(String licensePlateNumber, String country) {
        this.licensePlateNumber = licensePlateNumber;
        this.country = country;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LicensePlateDto that = (LicensePlateDto) o;
        return Objects.equals(licensePlateNumber, that.licensePlateNumber) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licensePlateNumber, country);
    }
}
