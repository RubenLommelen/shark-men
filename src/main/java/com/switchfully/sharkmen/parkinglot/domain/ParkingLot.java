package com.switchfully.sharkmen.parkinglot.domain;

import com.switchfully.sharkmen.infrastructure.Address;
import com.switchfully.sharkmen.parkinglot.Category;
import com.switchfully.sharkmen.parkinglot.ContactPerson;

import javax.persistence.*;

@Entity
@Table(name = "PARKING_LOT")
public class ParkingLot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORY")
    private Category category;

    @Column(name = "CAPACITY")
    private int capacity;

    @OneToOne
    @JoinColumn(name = "FK_CONTACT_PERSON_ID")
    private ContactPerson contactPerson;

    @OneToOne
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
}
