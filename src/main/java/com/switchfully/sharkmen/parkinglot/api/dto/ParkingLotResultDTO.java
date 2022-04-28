package com.switchfully.sharkmen.parkinglot.api.dto;

import com.switchfully.sharkmen.infrastructure.Address;
import com.switchfully.sharkmen.infrastructure.api.dto.AddressDto;
import com.switchfully.sharkmen.parkinglot.Category;
import com.switchfully.sharkmen.parkinglot.ContactPerson;

public class ParkingLotResultDTO {
    private final Long id;
    private final String name;
    private final Category category;
    private final int capacity;
    private final ContactPersonDTO contactPersonDTO;
    private final AddressDto addressDto;

    public ParkingLotResultDTO(Long id, String name, Category category, int capacity, ContactPersonDTO contactPersonDTO, AddressDto addressDto) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.capacity = capacity;
        this.contactPersonDTO = contactPersonDTO;
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

    public ContactPersonDTO getContactPersonDTO() {
        return contactPersonDTO;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }
}
