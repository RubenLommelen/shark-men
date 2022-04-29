package com.switchfully.sharkmen.member.domain;

import com.switchfully.sharkmen.infrastructure.Address;
import com.switchfully.sharkmen.member.license_plate.domain.LicensePlate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "MEMBER")
public class Member {
    @Transient
    private final Logger memberLogger = LoggerFactory.getLogger(Member.class);

    @Id
    @GeneratedValue
    private Long memberId;
    @Column(name = "FIRSTNAME")
    private String firstName;
    @Column(name = "LASTNAME")
    private String lastName;
    @OneToOne
    @JoinColumn(name = "FK_ADDRESS_ID")
    private Address address;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;
    @OneToOne
    @JoinColumn(name = "FK_LICENSE_PLATE_ID")
    private LicensePlate licensePlate;
    @Column(name = "REGISTRATION_DATE", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime registrationDate;

    public Member(String firstName, String lastName, Address address, String phoneNumber, String emailAddress, LicensePlate licensePlate) {
        fieldsNullCheck(firstName, lastName, address, phoneNumber, emailAddress, licensePlate);
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.licensePlate = licensePlate;
        this.registrationDate = OffsetDateTime.now();
    }

    public Member() {
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

    public OffsetDateTime getRegistrationDate() {
        return registrationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(memberLogger, member.memberLogger) && Objects.equals(memberId, member.memberId) && Objects.equals(firstName, member.firstName) && Objects.equals(lastName, member.lastName) && Objects.equals(address, member.address) && Objects.equals(phoneNumber, member.phoneNumber) && Objects.equals(emailAddress, member.emailAddress) && Objects.equals(licensePlate, member.licensePlate) && Objects.equals(registrationDate, member.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberLogger, memberId, firstName, lastName, address, phoneNumber, emailAddress, licensePlate, registrationDate);
    }
}
