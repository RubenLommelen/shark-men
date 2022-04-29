package com.switchfully.sharkmen.infrastructure.api.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateAddressDto {

    @NotBlank(message = "streetName is blank or null")
    private final String streetName;
    @NotBlank(message = "streetNumber is blank or null")
    private final String streetNumber;
    @Valid
    @NotNull(message = "createPostalCode is null")
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

    public CreatePostalCodeDto getCreatePostalCodeDto() {
        return createPostalCodeDto;
    }

    @Override
    public String toString() {
        return "CreateAddressDto{" +
                "streetName='" + streetName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", createPostalCodeDto=" + createPostalCodeDto +
                '}';
    }
}
