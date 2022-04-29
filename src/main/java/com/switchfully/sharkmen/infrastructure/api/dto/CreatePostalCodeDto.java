package com.switchfully.sharkmen.infrastructure.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreatePostalCodeDto {
    @NotBlank(message = "zipcode is blank or null")
    private final String zipcode;
    @NotBlank(message = "city is blank or null")
    private final String city;

    public CreatePostalCodeDto(String zipcode, String city) {
        this.zipcode = zipcode;
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "CreatePostalCodeDto{" +
                "zipcode='" + zipcode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
