package com.switchfully.sharkmen.parkinglot;

import com.switchfully.sharkmen.infrastructure.api.dto.CreateAddressDto;
import com.switchfully.sharkmen.infrastructure.api.dto.CreatePostalCodeDto;
import com.switchfully.sharkmen.parkinglot.api.dto.CreateContactPersonDto;
import com.switchfully.sharkmen.parkinglot.api.dto.CreateParkingLotDto;
import com.switchfully.sharkmen.parkinglot.api.dto.CreateParkingLotResultDto;
import com.switchfully.sharkmen.parkinglot.domain.ParkingLotRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureTestDatabase
public class ParkingLotIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Test
    void createParkingLot_whenCreateParkingLot_thenCreatedSuccessfully() {
        CreateParkingLotDto parkingLotDto = new CreateParkingLotDto(
                "Shark",
                Category.UNDERGROUND_BUILDING,
                20,
                new CreateContactPersonDto(
                        "FirstName",
                        "LastName",
                        "11",
                        "22",
                        "a@bob.com",
                        new CreateAddressDto("streetName",
                                "1",
                                new CreatePostalCodeDto(
                                        "3000",
                                        "Leuven"
                                )
                        )
                ),
                new CreateAddressDto("streetName",
                        "1",
                        new CreatePostalCodeDto(
                                "3000",
                                "Leuven"
                        )
                )
        );

        CreateParkingLotResultDto result = given()
                .baseUri("http://localhost")
                .port(port)
                .when()
                .body(parkingLotDto)
                .contentType(JSON)
                .post("/parking-lots")
                .then()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .extract()
                .as(CreateParkingLotResultDto.class);

        Assertions.assertThat(result.getId()).isNotNull();
        Assertions.assertThat(parkingLotRepository.findById(result.getId())).isNotNull();
    }

    @Test
    void createParkingLot_whenWrongName_thenBadRequest() {
        CreateParkingLotDto parkingLotDto = new CreateParkingLotDto(
                "",
                Category.UNDERGROUND_BUILDING,
                20,
                new CreateContactPersonDto(
                        "FirstName",
                        "ddd",
                        "11",
                        "22",
                        "a@bob.com",
                        new CreateAddressDto("streetName",
                                "1",
                                new CreatePostalCodeDto(
                                        "3000",
                                        "Leuven"
                                )
                        )
                ),
                new CreateAddressDto("streetName",
                        "1",
                        new CreatePostalCodeDto(
                                "3000",
                                "Leuven"
                        )
                )
        );

        given()
                .baseUri("http://localhost")
                .port(port)
                .when()
                .body(parkingLotDto)
                .contentType(JSON)
                .post("/parking-lots")
                .then()
                .assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void createParkingLot_whenWrongLastName_thenBadRequest() {
        CreateParkingLotDto parkingLotDto = new CreateParkingLotDto(
                "Bob",
                Category.UNDERGROUND_BUILDING,
                20,
                new CreateContactPersonDto(
                        "FirstName",
                        "",
                        "11",
                        "22",
                        "a@bob.com",
                        new CreateAddressDto("streetName",
                                "1",
                                new CreatePostalCodeDto(
                                        "3000",
                                        "Leuven"
                                )
                        )
                ),
                new CreateAddressDto("streetName",
                        "1",
                        new CreatePostalCodeDto(
                                "3000",
                                "Leuven"
                        )
                )
        );

        given()
                .baseUri("http://localhost")
                .port(port)
                .when()
                .body(parkingLotDto)
                .contentType(JSON)
                .post("/parking-lots")
                .then()
                .assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void createParkingLot_whenEmailWrong_thenBadRequest() {
        CreateParkingLotDto parkingLotDto = new CreateParkingLotDto(
                "Bob",
                Category.UNDERGROUND_BUILDING,
                20,
                new CreateContactPersonDto(
                        "FirstName",
                        "lastName",
                        "11",
                        "22",
                        "a@.com",
                        new CreateAddressDto("streetName",
                                "1",
                                new CreatePostalCodeDto(
                                        "3000",
                                        "Leuven"
                                )
                        )
                ),
                new CreateAddressDto("streetName",
                        "1",
                        new CreatePostalCodeDto(
                                "3000",
                                "Leuven"
                        )
                )
        );

        given()
                .baseUri("http://localhost")
                .port(port)
                .when()
                .body(parkingLotDto)
                .contentType(JSON)
                .post("/parking-lots")
                .then()
                .assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void createParkingLot_whenPostalCodeNull_thenBadRequest() {
        CreateParkingLotDto parkingLotDto = new CreateParkingLotDto(
                "Bob",
                Category.UNDERGROUND_BUILDING,
                20,
                new CreateContactPersonDto(
                        "FirstName",
                        "lastName",
                        "11",
                        "22",
                        "a@bob.com",
                        new CreateAddressDto("streetName",
                                "1",
                                null
                        )
                ),
                new CreateAddressDto("streetName",
                        "1",
                        new CreatePostalCodeDto(
                                "3000",
                                "Leuven"
                        )
                )
        );

        given()
                .baseUri("http://localhost")
                .port(port)
                .when()
                .body(parkingLotDto)
                .contentType(JSON)
                .post("/parking-lots")
                .then()
                .assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void createParkingLot_whenContactPersonNull_thenBadRequest() {
        CreateParkingLotDto parkingLotDto = new CreateParkingLotDto(
                "Bob",
                Category.UNDERGROUND_BUILDING,
                20,
                null,
                new CreateAddressDto("streetName",
                        "1",
                        new CreatePostalCodeDto(
                                "3000",
                                "Leuven"
                        )
                )
        );

        given()
                .baseUri("http://localhost")
                .port(port)
                .when()
                .body(parkingLotDto)
                .contentType(JSON)
                .post("/parking-lots")
                .then()
                .assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void createParkingLot_whenNegativeCapacity_thenBadRequest() {
        CreateParkingLotDto parkingLotDto = new CreateParkingLotDto(
                "Bob",
                Category.UNDERGROUND_BUILDING,
                -20,
                new CreateContactPersonDto(
                        "FirstName",
                        "lastName",
                        "11",
                        "22",
                        "a@bob.com",
                        new CreateAddressDto("streetName",
                                "1",
                                new CreatePostalCodeDto(
                                        "3000",
                                        "Leuven"
                                )
                        )
                ),
                new CreateAddressDto("streetName",
                        "1",
                        new CreatePostalCodeDto(
                                "3000",
                                "Leuven"
                        )
                )
        );

        given()
                .baseUri("http://localhost")
                .port(port)
                .when()
                .body(parkingLotDto)
                .contentType(JSON)
                .post("/parking-lots")
                .then()
                .assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }


}
