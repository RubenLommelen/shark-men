package com.switchfully.sharkmen.parkinglot.api.dto;

import com.switchfully.sharkmen.infrastructure.Address;
import com.switchfully.sharkmen.parkinglot.Category;
import com.switchfully.sharkmen.parkinglot.ContactPerson;

public class ParkingLotResultDTO {
    private final long id;
    private final String name;
    private final Category category;
    private final int capacity;
    private final ContactPerson contactPerson;
    private final Address address;

    public ParkingLotResultDTO(long id, String name, Category category, int capacity, ContactPerson contactPerson, Address address) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.capacity = capacity;
        this.contactPerson = contactPerson;
        this.address = address;
    }

    public long getId() {
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
}
