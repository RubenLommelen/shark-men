package com.switchfully.sharkmen.member.domain;

import com.switchfully.sharkmen.infrastructure.Address;
import com.switchfully.sharkmen.member.license_plate.domain.LicensePlate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Random;

public class Member {
    private final Logger memberLogger = LoggerFactory.getLogger(Member.class);

    private final Long memberId;
    private final String firstName;
    private final String lastName;
    private final Address address;
    private final String phoneNumber;
    private final String emailAddress;
    private final LicensePlate licensePlate;
    private final LocalDate registrationDate;

    public Member(String firstName, String lastName, Address address, String phoneNumber, String emailAddress, LicensePlate licensePlate) {
        fieldsNullCheck(firstName, lastName, address, phoneNumber, emailAddress, licensePlate);
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.licensePlate = licensePlate;
        this.memberId = new Random().nextLong();
        this.registrationDate = LocalDate.now();
    }

    private void fieldsNullCheck(String firstName, String lastName, Address address, String phoneNumber, String emailAddress, LicensePlate licensePlate) {
        if (firstName == null) {
            memberLogger.error("First name is null !");
            throw new NullPointerException("Please provide a first name!");
        }
        if (lastName == null) {
            memberLogger.error("Last name is null !");
            throw new NullPointerException("Please provide a last name!");
        }
        if (address == null) {
            memberLogger.error("Address is null !");
            throw new NullPointerException("Please provide an address!");
        }
        if (phoneNumber == null) {
            memberLogger.error("Phone number is null !");
            throw new NullPointerException("Please provide a phone number!");
        }
        if (emailAddress == null) {
            memberLogger.error("Email address is null !");
            throw new NullPointerException("Please provide an email address!");
        }
        if (licensePlate == null) {
            memberLogger.error("License plate is null !");
            throw new NullPointerException("Please provide a licensePlate!");
        }
    }

    public Long getMemberId() {
        return memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
}
