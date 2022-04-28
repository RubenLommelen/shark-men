package com.switchfully.sharkmen.infrastructure;

public class PostalCode {
    private final long id;
    private final String zipcode;
    private final String city;

    public PostalCode(long id, String zipcode, String city) {
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
}
