package com.switchfully.sharkmen.infrastructure.api.dto;

public class CreatePostalCodeDto {
    private final String zipcode;
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
