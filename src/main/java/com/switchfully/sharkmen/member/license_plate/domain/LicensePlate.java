package com.switchfully.sharkmen.member.license_plate.domain;

import java.util.Objects;

public class LicensePlate {
    private final String licensePlateNumber;
    private final String country;

    public LicensePlate(String licensePlateNumber, String country) {
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
        LicensePlate that = (LicensePlate) o;
        return Objects.equals(licensePlateNumber, that.licensePlateNumber) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licensePlateNumber, country);
    }
}
