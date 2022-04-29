package com.switchfully.sharkmen.parkinglot.api.dto;

public class CreateParkingLotResultDto {

    private Long id;

    public CreateParkingLotResultDto(Long id) {
        this.id = id;
    }

    public CreateParkingLotResultDto() {
    }

    public Long getId() {
        return id;
    }
}
