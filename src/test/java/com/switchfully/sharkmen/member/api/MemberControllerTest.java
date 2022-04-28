package com.switchfully.sharkmen.member.api;

import com.switchfully.sharkmen.infrastructure.Address;
import com.switchfully.sharkmen.infrastructure.PostalCode;
import com.switchfully.sharkmen.member.api.dto.CreateMemberDto;
import com.switchfully.sharkmen.member.api.dto.MemberDto;
import com.switchfully.sharkmen.member.domain.LicensePlate;
import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;

import static io.restassured.http.ContentType.JSON;
import static org.springframework.http.HttpStatus.CREATED;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureTestDatabase
class MemberControllerTest {

    @LocalServerPort
    private int port;

    @Test
    void givenMember_WhenPostMembers_ThenReturnMemberId() {
        //  GIVEN
        CreateMemberDto expectedCreateMemberDto = new CreateMemberDto("Harry ", "Potter"
                , new Address(12515,"Privet drive", "4", new PostalCode(1252,"WD25", "Watfort")),
                "0475080808", "HarryPotter@Hogwarts.uk", new LicensePlate("1515", "UK"));
        //  WHEN
        MemberDto actualMemberDto = RestAssured
                .given()
                .body(expectedCreateMemberDto)
                .accept(JSON)
                .contentType(JSON)
                .when()
                .port(port)
                .post("members")
                .then()
                .assertThat()
                .statusCode(CREATED.value())
                .extract()
                .as(MemberDto.class);
        //  THEN
        Assertions.assertThat(actualMemberDto.getMemberId()).isNotNull();
        Assertions.assertThat(actualMemberDto.getName()).isEqualTo(expectedCreateMemberDto.getFirstName());
        Assertions.assertThat(actualMemberDto.getAddress()).isEqualTo(expectedCreateMemberDto.getAddress());
        Assertions.assertThat(actualMemberDto.getPhoneNumber()).isEqualTo(expectedCreateMemberDto.getPhoneNumber());
        Assertions.assertThat(actualMemberDto.getEmailAddress()).isEqualTo(expectedCreateMemberDto.getEmailAddress());
        Assertions.assertThat(actualMemberDto.getLicensePlate()).isEqualTo(expectedCreateMemberDto.getLicensePlate());

    }
}