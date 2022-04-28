package com.switchfully.sharkmen.infrastructure;

public class Address {
    private final long id;
    private final String streetName;
    private final String streetNumber;
    private final PostalCode postalCode;

    public Address(long id, String streetName, String streetNumber, PostalCode postalCode) {
        this.id = id;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
    }
}
