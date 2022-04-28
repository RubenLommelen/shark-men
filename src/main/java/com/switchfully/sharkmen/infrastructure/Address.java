package com.switchfully.sharkmen.infrastructure;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "STREET_NAME")
    private String streetName;

    @Column(name = "STREET_NUMBER")
    private String streetNumber;

    @OneToOne
    @JoinColumn(name = "FK_POSTAL_CODE_ID")
    private PostalCode postalCode;

    public Address() {
    }

    public Address(long id, String streetName, String streetNumber, PostalCode postalCode) {
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

    public PostalCode getPostalCode() {
        return postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(streetName, address.streetName) && Objects.equals(streetNumber, address.streetNumber) && Objects.equals(postalCode, address.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetName, streetNumber, postalCode);
    }
}
