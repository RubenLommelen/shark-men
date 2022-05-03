package com.switchfully.sharkmen.division.service;

import com.switchfully.sharkmen.division.api.dto.CreateDivisionDto;
import com.switchfully.sharkmen.division.api.dto.DivisionDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;

import static io.restassured.http.ContentType.JSON;
import static org.springframework.http.HttpStatus.CREATED;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureTestDatabase
class DivisionControllerTest {

    @LocalServerPort
    private int port;

    @Test
    void givenNameOriginalNameAndDirectorName_WhenCreateDivision_ThenReturnDivision() {
        //  GIVEN
        CreateDivisionDto expectedCreateDivisionDto = new CreateDivisionDto("Hogwarts","The four wizards school", "Hagrid");
        //  WHEN
        DivisionDto actualDivisionDto = RestAssured
                .given()
                .baseUri("http://localhost")
                .port(port)
                .when()
                .body(expectedCreateDivisionDto)
                .contentType(JSON)
                .accept(JSON)
                .post("/divisions")
                .then()
                .assertThat()
                .statusCode(CREATED.value())
                .extract()
                .as(DivisionDto.class);
        //  THEN
        Assertions.assertThat(actualDivisionDto.getName()).isEqualTo(expectedCreateDivisionDto.getName());
        Assertions.assertThat(actualDivisionDto.getOriginalName()).isEqualTo(expectedCreateDivisionDto.getOriginalName());
        Assertions.assertThat(actualDivisionDto.getDirector()).isEqualTo(expectedCreateDivisionDto.getDirector());
    }
}