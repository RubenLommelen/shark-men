package com.switchfully.sharkmen.parking_allocation.api;

import com.switchfully.sharkmen.infrastructure.exceptions.MemberNotFoundException;
import com.switchfully.sharkmen.parking_allocation.api.dto.CreateParkingAllocationDto;
import com.switchfully.sharkmen.parking_allocation.api.dto.CreateParkingAllocationResultDto;
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
class ParkingAllocationControllerTest {

    @LocalServerPort
    private int port;

    @Test
    void startAllocation_AllocationIsCreatedSuccessfully() {
        CreateParkingAllocationDto createParkingAllocationDto = new CreateParkingAllocationDto(
                1L,
                "JA21HJH",
                1L
        );

        CreateParkingAllocationResultDto result = given()
                .baseUri("http://localhost")
                .port(port)
                .when()
                .body(createParkingAllocationDto)
                .contentType(JSON)
                .post("/allocations")
                .then()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .extract()
                .as(CreateParkingAllocationResultDto.class);

        Assertions.assertThat(result.getId()).isNotNull();
    }

    @Test
    void startAllocation_whenNonExistingMemberId_getBadRequest() {
        CreateParkingAllocationDto createParkingAllocationDto = new CreateParkingAllocationDto(
                0L,
                "JA21HJH",
                1L
        );

        given()
                .baseUri("http://localhost")
                .port(port)
                .when()
                .body(createParkingAllocationDto)
                .contentType(JSON)
                .post("/allocations")
                .then()
                .assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void startAllocation_whenIncorrectLicensePlate_getBadRequest() {
        CreateParkingAllocationDto createParkingAllocationDto = new CreateParkingAllocationDto(
                1L,
                "YABBADABBADOO",
                1L
        );

        given()
                .baseUri("http://localhost")
                .port(port)
                .when()
                .body(createParkingAllocationDto)
                .contentType(JSON)
                .post("/allocations")
                .then()
                .assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }
}