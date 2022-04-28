package com.switchfully.sharkmen.parkinglot.domain;

import com.switchfully.sharkmen.infrastructure.Address;
import com.switchfully.sharkmen.parkinglot.Category;
import com.switchfully.sharkmen.parkinglot.ContactPerson;

import javax.persistence.*;

@Entity
@Table(name = "PARKING_LOT")
public class ParkingLot {

    @Id
    @GeneratedValue
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
}
