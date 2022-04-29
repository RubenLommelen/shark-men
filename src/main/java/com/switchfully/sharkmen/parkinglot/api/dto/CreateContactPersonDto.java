package com.switchfully.sharkmen.parkinglot.api.dto;

import com.switchfully.sharkmen.infrastructure.api.dto.CreateAddressDto;

public class CreateContactPersonDto {

    private final String firstName;
    private final String lastName;
    private final String mobilePhoneNumber;
    private final String phoneNumber;
    private final String email;
    private final CreateAddressDto createAddressDto;

    public CreateContactPersonDto(String firstName, String lastName, String mobilePhoneNumber, String phoneNumber, String email, CreateAddressDto createAddressDto) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.createAddressDto = createAddressDto;
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

    public CreateAddressDto getCreateAddressDto() {
        return createAddressDto;
    }

    @Override
    public String toString() {
        return "CreateContactPersonDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobilePhoneNumber='" + mobilePhoneNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", createAddressDto=" + createAddressDto +
                '}';
    }
}
