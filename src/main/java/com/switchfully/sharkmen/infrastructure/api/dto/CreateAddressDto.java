package com.switchfully.sharkmen.infrastructure.api.dto;

public class CreateAddressDto {
    private final String streetName;
    private final String streetNumber;
    private final CreatePostalCodeDto createPostalCode;

    public CreateAddressDto(String streetName, String streetNumber, CreatePostalCodeDto createPostalCode) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.createPostalCode = createPostalCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public CreatePostalCodeDto getPostalCode() {
        return createPostalCode;
    }
}
