package com.switchfully.sharkmen.parkinglot.api.dto;

import com.switchfully.sharkmen.infrastructure.api.dto.AddressDto;

public class ContactPersonDTO {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String mobilePhoneNumber;
    private final String phoneNumber;
    private final String email;
    private final AddressDto addressDto;

    public ContactPersonDTO(Long id, String firstName, String lastName, String mobilePhoneNumber, String phoneNumber, String email, AddressDto addressDto) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.addressDto = addressDto;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }
}
