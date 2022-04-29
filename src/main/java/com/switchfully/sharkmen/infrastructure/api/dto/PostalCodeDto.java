package com.switchfully.sharkmen.infrastructure.api.dto;

import java.util.Objects;

public class PostalCodeDto {
    private final String zipcode;
    private final String city;

    public PostalCodeDto(String zipcode, String city) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostalCodeDto that = (PostalCodeDto) o;
        return Objects.equals(zipcode, that.zipcode) && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zipcode, city);
    }

    @Override
    public String toString() {
        return "PostalCodeDto{" +
                "zipcode='" + zipcode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
