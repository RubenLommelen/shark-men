package com.switchfully.sharkmen.member.domain;

import com.switchfully.sharkmen.infrastructure.domain.Address;
import com.switchfully.sharkmen.member.license_plate.domain.LicensePlate;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "MEMBER")
public class Member {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq")
    @SequenceGenerator(name = "member_seq", sequenceName = "member_seq", allocationSize = 1)
    private Long memberId;
    @Column(name = "FIRSTNAME")
    private String firstName;
    @Column(name = "LASTNAME")
    private String lastName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_ADDRESS_ID")
    private Address address;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_LICENSE_PLATE_ID")
    private LicensePlate licensePlate;
    @Column(name = "REGISTRATION_DATE", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime registrationDate;
    @Transient
    private MembershipLevel membershipLevel;

    public Member(String firstName, String lastName, Address address, String phoneNumber, String emailAddress, LicensePlate licensePlate, MembershipLevel membershipLevel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.licensePlate = licensePlate;
        this.registrationDate = OffsetDateTime.now();
        this.membershipLevel = membershipLevel;
    }

    public Member() {
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

    public MembershipLevel getMembershipLevel() {
        return membershipLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(firstName, member.firstName) && Objects.equals(lastName, member.lastName) && Objects.equals(address, member.address) && Objects.equals(phoneNumber, member.phoneNumber) && Objects.equals(emailAddress, member.emailAddress) && Objects.equals(licensePlate, member.licensePlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, address, phoneNumber, emailAddress, licensePlate);
    }

    @Override
    public String toString() {
        return "Member{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", licensePlate=" + licensePlate +
                '}';
    }
}
