package com.switchfully.sharkmen.parkinglot.api.dto;

public class CreateParkingLotResultDTO {

    private Long id;

    public CreateParkingLotResultDTO(Long id) {
        this.id = id;
    }

    public CreateParkingLotResultDTO() {
    }

    public Long getId() {
        return id;
    }
}
