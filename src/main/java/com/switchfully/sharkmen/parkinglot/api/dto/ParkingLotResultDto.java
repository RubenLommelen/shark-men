package com.switchfully.sharkmen.parkinglot.api.dto;

import com.switchfully.sharkmen.infrastructure.api.dto.AddressDto;
import com.switchfully.sharkmen.parkinglot.Category;

public class ParkingLotResultDto {
    private final Long id;
    private final String name;
    private final Category category;
    private final int capacity;
    private final ContactPersonDto contactPersonDto;
    private final AddressDto addressDto;

    public ParkingLotResultDto(Long id, String name, Category category, int capacity, ContactPersonDto contactPersonDto, AddressDto addressDto) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.capacity = capacity;
        this.contactPersonDto = contactPersonDto;
        this.addressDto = addressDto;
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

    public ContactPersonDto getContactPersonDto() {
        return contactPersonDto;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }
}
