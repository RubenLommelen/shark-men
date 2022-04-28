package com.switchfully.sharkmen.infrastructure;

import java.util.Objects;
import java.util.Random;

public class PostalCode {
    private final long id;
    private final String zipcode;
    private final String city;

    public PostalCode(String zipcode, String city) {
        this.id = new Random().nextInt();
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
        PostalCode that = (PostalCode) o;
        return Objects.equals(zipcode, that.zipcode) && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zipcode, city);
    }
}
