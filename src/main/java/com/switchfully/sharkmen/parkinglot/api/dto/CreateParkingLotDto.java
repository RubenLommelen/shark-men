package com.switchfully.sharkmen.parkinglot.api.dto;

import com.switchfully.sharkmen.infrastructure.api.dto.CreateAddressDto;
import com.switchfully.sharkmen.parkinglot.Category;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateParkingLotDto {
    @NotBlank(message = "name is blank or null")
    private final String name;
    @NotNull(message = "category is blank or null")
    private final Category category;
    @Min(value = 0)
    @NotNull(message = "capacity is null")
    private final int capacity;
    @Valid
    @NotNull(message = "createContactPersonDto is null")
    private final CreateContactPersonDto createContactPersonDto;
    @Valid
    @NotNull(message = "createAddressDto is null")
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
