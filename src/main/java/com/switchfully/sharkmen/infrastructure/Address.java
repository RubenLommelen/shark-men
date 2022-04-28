package com.switchfully.sharkmen.infrastructure;

public class Address {
    private final String streetName;
    private final String streetNumber;
    private final PostalCode postalCode;

    public Address(String streetName, String streetNumber, PostalCode postalCode) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
    }
}
