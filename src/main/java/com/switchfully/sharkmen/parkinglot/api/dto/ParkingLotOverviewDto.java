package com.switchfully.sharkmen.parkinglot.api.dto;

import com.switchfully.sharkmen.contact_person.api.dto.ContactPersonDto;
import com.switchfully.sharkmen.infrastructure.api.dto.AddressDto;
import com.switchfully.sharkmen.parkinglot.domain.Category;

import java.util.Objects;

public class ParkingLotOverviewDto {
    private final Long id;
    private final String name;
    private final int capacity;
    private final String phoneNumber;
    private final String email;

    public ParkingLotOverviewDto(Long id, String name, int capacity, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingLotOverviewDto that = (ParkingLotOverviewDto) o;
        return capacity == that.capacity && Objects.equals(name, that.name) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capacity, phoneNumber, email);
    }
}
