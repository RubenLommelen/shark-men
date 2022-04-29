package com.switchfully.sharkmen.parkinglot.api.dto;

import com.switchfully.sharkmen.infrastructure.Address;
import com.switchfully.sharkmen.infrastructure.api.dto.AddressDto;
import com.switchfully.sharkmen.infrastructure.api.dto.CreateAddressDto;
import com.switchfully.sharkmen.parkinglot.Category;

public class CreateParkingLotDTO {
    private final String name;
    private final Category category;
    private final int capacity;
    private final int contactPersonID;
    private final CreateAddressDto createAddressDto;

    public CreateParkingLotDTO(String name, Category category, int capacity, int contactPersonID, CreateAddressDto createAddressDto) {
        this.name = name;
        this.category = category;
        this.capacity = capacity;
        this.contactPersonID = contactPersonID;
        this.createAddressDto = createAddressDto;
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

    public CreateAddressDto getCreateAddressDto() {
        return createAddressDto;
    }
}
