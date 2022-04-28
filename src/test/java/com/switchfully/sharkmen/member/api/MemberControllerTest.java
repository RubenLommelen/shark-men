package com.switchfully.sharkmen.member.api;

import com.switchfully.sharkmen.infrastructure.Address;
import com.switchfully.sharkmen.infrastructure.PostalCode;
import com.switchfully.sharkmen.member.api.dto.CreateMemberDto;
import com.switchfully.sharkmen.member.api.dto.MemberDto;
import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;

import static io.restassured.http.ContentType.JSON;
import static org.springframework.http.HttpStatus.CREATED;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class MemberControllerTest {

    @LocalServerPort
    private int port;

    @Test
    void givenMember_WhenPostMembers_ThenReturnMemberId() {
        //  GIVEN
        CreateMemberDto expectedCreateMemberDto = new CreateMemberDto("Harry Potter",
                new Address("Privet drive", "4", new PostalCode("WD25", "Watfort")),
                "0475080808", "HarryPotter@Hogwarts.uk", "7990TD");
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
        Assertions.assertThat(actualMemberDto.getMemberId())
                .isNotBlank()
                .isNotNull();
        Assertions.assertThat(actualMemberDto.getName()).isEqualTo(expectedCreateMemberDto.getName());
    }
}