package com.switchfully.sharkmen.infrastructure.dto;

import java.util.Objects;

public class PostalCodeDto {
    private final long id;
    private final String zipcode;
    private final String city;

    public PostalCodeDto(long id, String zipcode, String city) {
        this.id = id;
        this.zipcode = zipcode;
        this.city = city;
    }

    public long getId() {
        return id;
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
}
