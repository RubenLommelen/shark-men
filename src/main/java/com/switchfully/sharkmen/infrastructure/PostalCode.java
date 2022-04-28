package com.switchfully.sharkmen.infrastructure;

import javax.persistence.*;
import java.util.Objects;
import java.util.Random;

@Entity
@Table(name = "POSTAL_CODE")
public class PostalCode {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "ZIP_CODE")
    private String zipcode;

    @Column(name = "CITY")
    private String city;

    public PostalCode() {
    }

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
