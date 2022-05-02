package com.switchfully.sharkmen.parkinglot.api.dto;

import com.switchfully.sharkmen.contact_person.api.dto.CreateContactPersonDto;
import com.switchfully.sharkmen.infrastructure.api.dto.CreateAddressDto;
import com.switchfully.sharkmen.parkinglot.domain.Category;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class CreateParkingLotDto {
    @NotBlank(message = "name is blank or null")
    private final String name;
    @NotNull(message = "category is blank or null")
    private final Category category;
    @Positive
    @NotNull(message = "capacity is null")
    private final int capacity;
    @Valid
    @NotNull(message = "createContactPersonDto is null")
    private final CreateContactPersonDto contactPerson;
    @Valid
    @NotNull(message = "createAddressDto is null")
    private final CreateAddressDto address;

    public CreateParkingLotDto(String name, Category category, int capacity, CreateContactPersonDto contactPerson, CreateAddressDto address) {
        this.name = name;
        this.category = category;
        this.capacity = capacity;
        this.contactPerson = contactPerson;
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

    public CreateContactPersonDto getContactPerson() {
        return contactPerson;
    }

    public CreateAddressDto getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "CreateParkingLotDto{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", capacity=" + capacity +
                ", contact person=" + contactPerson +
                ", address =" + address +
                '}';
    }
}
