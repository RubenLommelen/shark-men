package com.switchfully.sharkmen.division.service;

import com.switchfully.sharkmen.division.api.dto.CreateDivisionDto;
import com.switchfully.sharkmen.division.api.dto.DivisionDto;
import com.switchfully.sharkmen.division.domain.DivisionRepository;
import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;
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
class DivisionControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private DivisionRepository divisionRepository;

    @Test
    void givenNameOriginalNameAndDirectorName_WhenCreateDivision_ThenReturnDivision() {
        //  GIVEN
        CreateDivisionDto expectedCreateDivisionDto = new CreateDivisionDto("Hogwarts", "The four wizards school", "Hagrid");
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

        Assertions.assertThat(divisionRepository.existsById(actualDivisionDto.getId())).isTrue();
    }

    @Test
    void givenBlankName_WhenCreateDivision_ThenBadRequest() {
        //  GIVEN
        CreateDivisionDto expectedCreateDivisionDto = new CreateDivisionDto("   ", "The four wizards school", "Hagrid");
        //  WHEN
        RestAssured
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
                .statusCode(BAD_REQUEST.value());

    }

    @Test
    void givenDirectorNull_WhenCreateDivision_ThenBadRequest() {
        //  GIVEN
        CreateDivisionDto expectedCreateDivisionDto = new CreateDivisionDto("Hogwarts", "The four wizards school", null);
        //  WHEN
        RestAssured
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
                .statusCode(BAD_REQUEST.value());

    }

    @Test
    void givenOriginalNameIsEmpty_WhenCreateDivision_ThenBadRequest() {
        //  GIVEN
        CreateDivisionDto expectedCreateDivisionDto = new CreateDivisionDto("Hogwarts", "", "Hagrid");
        //  WHEN
        RestAssured
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
                .statusCode(BAD_REQUEST.value());

    }
}