package com.switchfully.sharkmen.parkinglot.api.dto;

import com.switchfully.sharkmen.infrastructure.api.dto.CreateAddressDto;
import com.switchfully.sharkmen.parkinglot.Category;

public class CreateParkingLotDto {
    private final String name;
    private final Category category;
    private final int capacity;
    private final CreateContactPersonDto createContactPersonDto;
    private final CreateAddressDto createAddressDto;

    public CreateParkingLotDto(String name, Category category, int capacity, CreateContactPersonDto createContactPersonDto, CreateAddressDto createAddressDto) {
        this.name = name;
        this.category = category;
        this.capacity = capacity;
        this.createContactPersonDto = createContactPersonDto;
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

    public CreateContactPersonDto getCreateContactPersonDto() {
        return createContactPersonDto;
    }

    public CreateAddressDto getCreateAddressDto() {
        return createAddressDto;
    }

    @Override
    public String toString() {
        return "CreateParkingLotDto{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", capacity=" + capacity +
                ", createContactPersonDto=" + createContactPersonDto +
                ", createAddressDto=" + createAddressDto +
                '}';
    }
}
