package com.switchfully.sharkmen.member.domain;

import com.switchfully.sharkmen.infrastructure.Address;
import com.switchfully.sharkmen.infrastructure.PostalCode;
import com.switchfully.sharkmen.infrastructure.api.dto.AddressDto;
import com.switchfully.sharkmen.infrastructure.api.dto.PostalCodeDto;
import com.switchfully.sharkmen.member.license_plate.api.dto.LicensePlateDto;
import com.switchfully.sharkmen.member.license_plate.domain.LicensePlate;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static io.restassured.http.ContentType.JSON;

class MemberTest {

    @Test
    void givenANewMember_WhenFirstNameNull_ThenNullPointerIsThrown() {
        Assertions.assertThrows(NullPointerException.class,
                ()->new Member(null, "Potter", new Address("Privet drive", "4", new PostalCode("WD25", "Watfort")),
                        "0475080808", "HarryPotter@Hogwarts.uk", new LicensePlate("1515", "UK")));
    }

    @Test
    void givenANewMember_WhenLastNameNull_ThenNullPointerIsThrown() {
        Assertions.assertThrows(NullPointerException.class,
                ()->new Member("Harry", null, new Address("Privet drive", "4", new PostalCode("WD25", "Watfort")),
                        "0475080808", "HarryPotter@Hogwarts.uk", new LicensePlate("1515", "UK")));
    }

    @Test
    void givenANewMember_WhenAddressNull_ThenNullPointerIsThrown() {
        Assertions.assertThrows(NullPointerException.class,
                ()->new Member("Harry", "Potter", null,
                        "0475080808", "HarryPotter@Hogwarts.uk", new LicensePlate("1515", "UK")));
    }

    @Test
    void givenANewMember_WhenPhoneNumberNull_ThenNullPointerIsThrown() {
        Assertions.assertThrows(NullPointerException.class,
                ()->new Member("Harry", "Potter", new Address("Privet drive", "4", new PostalCode("WD25", "Watfort")),
                        null, "HarryPotter@Hogwarts.uk", new LicensePlate("1515", "UK")));
    }

    @Test
    void givenANewMember_WhenEmailAddressNull_ThenNullPointerIsThrown() {
        Assertions.assertThrows(NullPointerException.class,
                ()->new Member("Harry", "Potter", new Address("Privet drive", "4", new PostalCode("WD25", "Watfort")),
                        "0475080808", null, new LicensePlate("1515", "UK")));
    }

    @Test
    void givenANewMember_WhenLicensePlateNull_ThenNullPointerIsThrown() {
        Assertions.assertThrows(NullPointerException.class,
                ()->new Member("Harry", "Potter", new Address("Privet drive", "4", new PostalCode("WD25", "Watfort")),
                        "0475080808", "HarryPotter@Hogwarts.uk", null));
    }
}