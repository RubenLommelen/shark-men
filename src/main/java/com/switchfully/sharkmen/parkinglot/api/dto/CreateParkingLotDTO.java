package com.switchfully.sharkmen.parkinglot.api.dto;

import com.switchfully.sharkmen.infrastructure.api.dto.CreateAddressDto;
import com.switchfully.sharkmen.parkinglot.Category;

public class CreateParkingLotDTO {
    private final String name;
    private final Category category;
    private final int capacity;
    private final CreateContactPersonDTO createContactPersonDto;
    private final CreateAddressDto createAddressDto;

    public CreateParkingLotDTO(String name, Category category, int capacity, CreateContactPersonDTO createContactPersonDto, CreateAddressDto createAddressDto) {
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

    public CreateContactPersonDTO getCreateContactPersonDto() {
        return createContactPersonDto;
    }

    public CreateAddressDto getCreateAddressDto() {
        return createAddressDto;
    }
}
