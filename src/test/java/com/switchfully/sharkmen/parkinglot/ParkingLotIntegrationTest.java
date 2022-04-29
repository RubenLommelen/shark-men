package com.switchfully.sharkmen.parkinglot;

import com.switchfully.sharkmen.infrastructure.Address;
import com.switchfully.sharkmen.infrastructure.PostalCode;
import com.switchfully.sharkmen.infrastructure.api.dto.AddressDto;
import com.switchfully.sharkmen.infrastructure.api.dto.CreateAddressDto;
import com.switchfully.sharkmen.infrastructure.api.dto.CreatePostalCodeDto;
import com.switchfully.sharkmen.infrastructure.api.dto.PostalCodeDto;
import com.switchfully.sharkmen.parkinglot.api.dto.CreateParkingLotDTO;
import com.switchfully.sharkmen.parkinglot.api.dto.ParkingLotResultDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
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

    @Test
    void createParkingLot_whenCreateParkingLot_thenCreatedSuccessfully() {
        CreateParkingLotDTO parkingLotDTO = new CreateParkingLotDTO(
                "Shark",
                Category.UNDERGROUND_BUILDING,
                20,
                1,
                new CreateAddressDto("streetName",
                        "streetNumber",
                        new CreatePostalCodeDto(
                                "3000",
                                "Leuven"
                        )
                )
        );

        ParkingLotResultDTO result = given()
                .baseUri("http://localhost")
                .port(port)
                .when()
                .body(parkingLotDTO)
                .contentType(JSON)
                .post("/parking-lots")
                .then()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .extract()
                .as(ParkingLotResultDTO.class);

        Assertions.assertThat(result).isNotNull();
    }
}
