package com.switchfully.sharkmen.parkinglot.api.dto;

import com.switchfully.sharkmen.infrastructure.api.dto.CreateAddressDto;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateContactPersonDto {

    @NotBlank(message = "firstName is blank or null")
    private final String firstName;
    @NotBlank(message = "lastName is blank or null")
    private final String lastName;
    @NotBlank(message = "mobilePhoneNumber is blank or null")
    private final String mobilePhoneNumber;
    @NotBlank(message = "phoneNumber is blank or null")
    private final String phoneNumber;
    @Email(regexp = "^(\\S+)@(\\S+)\\.([a-zA-Z]+)$", message = "email is not in the right format")
    @NotBlank(message = "email is blank or null")
    private final String email;
    @Valid
    @NotNull(message = "createAddressDto is null")
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
