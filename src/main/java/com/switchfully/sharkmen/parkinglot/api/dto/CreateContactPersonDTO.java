package com.switchfully.sharkmen.parkinglot.api.dto;

import com.switchfully.sharkmen.infrastructure.Address;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class CreateContactPersonDTO {

    private final String firstName;
    private final String lastName;
    private final String mobilePhoneNumber;
    private final String phoneNumber;
    private final String email;
    private final AddressDTO addressDTO;

    public CreateContactPersonDTO(String firstName, String lastName, String mobilePhoneNumber, String phoneNumber, String email, AddressDTO addressDTO) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.addressDTO = addressDTO;
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

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }
}
