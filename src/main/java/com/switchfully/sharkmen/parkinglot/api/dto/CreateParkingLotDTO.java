package com.switchfully.sharkmen.parkinglot.api.dto;

import com.switchfully.sharkmen.infrastructure.Address;
import com.switchfully.sharkmen.parkinglot.Category;

public class CreateParkingLotDTO {
    private final String name;
    private final Category category;
    private final int capacity;
    private final int contactPersonID;
    private final Address address;

    public CreateParkingLotDTO(String name, Category category, int capacity, int contactPersonID, Address address) {
        this.name = name;
        this.category = category;
        this.capacity = capacity;
        this.contactPersonID = contactPersonID;
        this.address = address;
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

    public int getContactPersonID() {
        return contactPersonID;
    }

    public Address getAddress() {
        return address;
    }
}
