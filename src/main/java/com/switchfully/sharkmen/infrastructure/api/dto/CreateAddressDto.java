package com.switchfully.sharkmen.infrastructure.api.dto;

public class CreateAddressDto {
    private final String streetName;
    private final String streetNumber;
    private final PostalCodeDto postalCode;

    public CreateAddressDto(String streetName, String streetNumber, PostalCodeDto postalCode) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public PostalCodeDto getPostalCode() {
        return postalCode;
    }
}
