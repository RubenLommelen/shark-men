package com.switchfully.sharkmen.parking_lot.domain;

import com.switchfully.sharkmen.contact_person.domain.ContactPerson;
import com.switchfully.sharkmen.infrastructure.domain.Address;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PARKING_LOT")
public class ParkingLot {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parking_lot_seq")
    @SequenceGenerator(name = "parking_lot_seq", sequenceName = "parking_lot_seq", allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORY")
    private Category category;

    @Column(name = "CAPACITY")
    private int capacity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_CONTACT_PERSON_ID")
    private ContactPerson contactPerson;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_ADDRESS_ID")
    private Address address;

    public ParkingLot() {
    }

    public ParkingLot(String name, Category category, int capacity, ContactPerson contactPerson, Address address) {
        this.name = name;
        this.category = category;
        this.capacity = capacity;
        this.contactPerson = contactPerson;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getCapacity() {
        return capacity;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", capacity=" + capacity +
                ", contactPerson=" + contactPerson +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingLot that = (ParkingLot) o;
        return capacity == that.capacity && Objects.equals(name, that.name) && category == that.category && Objects.equals(contactPerson, that.contactPerson) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, capacity, contactPerson, address);
    }
}
