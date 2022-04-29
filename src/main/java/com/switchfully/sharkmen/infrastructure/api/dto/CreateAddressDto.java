package com.switchfully.sharkmen.infrastructure.api.dto;

public class CreateAddressDto {
    private final String streetName;
    private final String streetNumber;
    private final CreatePostalCodeDto createPostalCodeDto;

    public CreateAddressDto(String streetName, String streetNumber, CreatePostalCodeDto createPostalCodeDto) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.createPostalCodeDto = createPostalCodeDto;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public CreatePostalCodeDto getCreatePostalCode() {
        return createPostalCodeDto;
    }
}
