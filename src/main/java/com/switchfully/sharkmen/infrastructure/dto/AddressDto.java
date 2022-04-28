package com.switchfully.sharkmen.infrastructure.dto;

import com.switchfully.sharkmen.infrastructure.PostalCode;

import java.util.Objects;

public class AddressDto {
    private final long id;
    private final String streetName;
    private final String streetNumber;
    private final PostalCodeDto postalCode;

    public AddressDto(long id, String streetName, String streetNumber, PostalCodeDto postalCode) {
        this.id = id;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
    }

    public long getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDto address = (AddressDto) o;
        return Objects.equals(streetName, address.streetName) && Objects.equals(streetNumber, address.streetNumber) && Objects.equals(postalCode, address.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetName, streetNumber, postalCode);
    }
}
