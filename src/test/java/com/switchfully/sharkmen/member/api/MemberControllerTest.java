package com.switchfully.sharkmen.member.api;

import com.switchfully.sharkmen.infrastructure.api.dto.CreateAddressDto;
import com.switchfully.sharkmen.infrastructure.api.dto.CreatePostalCodeDto;
import com.switchfully.sharkmen.member.api.dto.CreateMemberDto;
import com.switchfully.sharkmen.member.api.dto.MemberDto;
import com.switchfully.sharkmen.member.domain.MembershipLevel;
import com.switchfully.sharkmen.member.license_plate.api.dto.CreateLicensePlateDto;
import com.switchfully.sharkmen.member.service.MemberMapper;
import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;

import static io.restassured.http.ContentType.JSON;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureTestDatabase
class MemberControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private MemberMapper memberMapper;


    @Test
    void givenMember_WhenPostMembers_ThenReturnMemberId() {
        //  GIVEN

        CreateMemberDto expectedCreateMemberDto = new CreateMemberDto("Harry ", "Potter"
                , new CreateAddressDto("Privet drive", "4", new CreatePostalCodeDto("WD25", "Watfort")),
                "0475080808", "HarryPotter@Hogwarts.uk", new CreateLicensePlateDto("1515", "UK"), null);
        MemberDto expectedMemberDto = memberMapper.ToDto(memberMapper.ToMember(expectedCreateMemberDto));
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
        Assertions.assertThat(actualMemberDto.getFirstName()).isEqualTo(expectedMemberDto.getFirstName());
        Assertions.assertThat(actualMemberDto.getLastName()).isEqualTo(expectedMemberDto.getLastName());
        Assertions.assertThat(actualMemberDto.getAddress()).isEqualTo(expectedMemberDto.getAddress());
        Assertions.assertThat(actualMemberDto.getPhoneNumber()).isEqualTo(expectedMemberDto.getPhoneNumber());
        Assertions.assertThat(actualMemberDto.getEmailAddress()).isEqualTo(expectedMemberDto.getEmailAddress());
        Assertions.assertThat(actualMemberDto.getLicensePlate()).isEqualTo(expectedMemberDto.getLicensePlate());

    }

    @Test
    void GivenWrongEmailAddressFormat_WhenCreatingNewMember_ThenThrowIllegalArgException() {
        //  GIVEN
        CreateMemberDto expectedCreateMemberDto = new CreateMemberDto("Harry ", "Potter"
                , new CreateAddressDto("Privet drive", "4", new CreatePostalCodeDto("WD25", "Watfort")),
                "0475080808", "HarryPotter@Hogwartsuk", new CreateLicensePlateDto("1515", "UK"), null);
//  WHEN
        RestAssured
                .given()
                .body(expectedCreateMemberDto)
                .accept(JSON)
                .contentType(JSON)
                .when()
                .port(port)
                .post("members")
                .then()
                .assertThat()
                .statusCode(BAD_REQUEST.value());
        //  THEN
    }

    @Nested
    @DisplayName("Membership tests")
    class MembershipTests {
        @Test
        void givenMemberWithoutMembershipLevel_WhenPostMembers_ThenReturnMemberWithMembershipLevelBronze() {
            //  GIVEN
            CreateMemberDto expectedCreateMemberDto = new CreateMemberDto("Harry ", "Potter"
                    , new CreateAddressDto("Privet drive", "4", new CreatePostalCodeDto("WD25", "Watfort")),
                    "0475080808", "HarryPotter@Hogwarts.uk", new CreateLicensePlateDto("1515", "UK"), null);
            MemberDto expectedMemberDto = memberMapper.ToDto(memberMapper.ToMember(expectedCreateMemberDto));
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
            Assertions.assertThat(actualMemberDto.getMembershipLevel()).isEqualTo(MembershipLevel.BRONZE);
        }


        @Test
        void givenMemberWithGoldMembershipLevel_WhenPostMembers_ThenReturnMemberWithMembershipLevelGold() {
            //  GIVEN
            CreateMemberDto expectedCreateMemberDto = new CreateMemberDto("Harry ", "Potter"
                    , new CreateAddressDto("Privet drive", "4", new CreatePostalCodeDto("WD25", "Watfort")),
                    "0475080808", "HarryPotter@Hogwarts.uk", new CreateLicensePlateDto("1515", "UK"), MembershipLevel.GOLD);
            MemberDto expectedMemberDto = memberMapper.ToDto(memberMapper.ToMember(expectedCreateMemberDto));
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
            Assertions.assertThat(actualMemberDto.getMembershipLevel()).isEqualTo(MembershipLevel.GOLD);

        }
    }
}
