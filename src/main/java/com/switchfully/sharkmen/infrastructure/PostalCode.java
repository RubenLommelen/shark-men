package com.switchfully.sharkmen.infrastructure;

public class PostalCode {
    private final String zipcode;
    private final String city;

    public PostalCode(String zipcode, String city) {
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
}
