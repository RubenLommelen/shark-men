package com.switchfully.sharkmen.member.licenseplate;

import com.switchfully.sharkmen.infrastructure.api.dto.CreateAddressDto;
import com.switchfully.sharkmen.infrastructure.api.dto.CreatePostalCodeDto;
import com.switchfully.sharkmen.member.api.dto.CreateMemberDto;
import com.switchfully.sharkmen.member.license_plate.api.dto.CreateLicensePlateDto;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;

import static io.restassured.http.ContentType.JSON;
import static org.springframework.http.HttpStatus.BAD_REQUEST;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureTestDatabase
public class LicensePlateTest {

    @LocalServerPort
    private int port;



    @Test
    void GivenWrongLicensePlate_WhenCreatingNewMember_ThenThrowBadRequest() {
        //  GIVEN
        CreateMemberDto expectedCreateMemberDto = new CreateMemberDto("Harry ", "Potter"
                , new CreateAddressDto("Privet drive", "4", new CreatePostalCodeDto("WD25", "Watfort")),
                "0475080808", "HarryPotter@Hogwarts.uk", new CreateLicensePlateDto(null, "UK"), null);
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
}
