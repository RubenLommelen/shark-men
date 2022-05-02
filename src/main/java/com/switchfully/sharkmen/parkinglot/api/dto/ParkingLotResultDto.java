package com.switchfully.sharkmen.parkinglot.api.dto;

import com.switchfully.sharkmen.contact_person.api.dto.ContactPersonDto;
import com.switchfully.sharkmen.infrastructure.api.dto.AddressDto;
import com.switchfully.sharkmen.parkinglot.domain.Category;

public class ParkingLotResultDto {
    private final Long id;
    private final String name;
    private final Category category;
    private final int capacity;
    private final ContactPersonDto contactPerson;
    private final AddressDto address;

    public ParkingLotResultDto(Long id, String name, Category category, int capacity, ContactPersonDto contactPerson, AddressDto address) {
        this.id = id;
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

    public ContactPersonDto getContactPerson() {
        return contactPerson;
    }

    public AddressDto getAddress() {
        return address;
    }
}
