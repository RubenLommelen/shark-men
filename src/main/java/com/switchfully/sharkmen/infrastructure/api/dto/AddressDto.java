package com.switchfully.sharkmen.infrastructure.api.dto;

import java.util.Objects;

public class AddressDto {
    private final String streetName;
    private final String streetNumber;
    private final PostalCodeDto postalCodeDto;

    public AddressDto(String streetName, String streetNumber, PostalCodeDto postalCodeDto) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCodeDto = postalCodeDto;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public PostalCodeDto getPostalCodeDto() {
        return postalCodeDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDto that = (AddressDto) o;
        return Objects.equals(streetName, that.streetName) && Objects.equals(streetNumber, that.streetNumber) && Objects.equals(postalCodeDto, that.postalCodeDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetName, streetNumber, postalCodeDto);
    }
}
