package com.switchfully.sharkmen.parking_allocation.api.dto;

public class CreateParkingAllocationResultDto {
    private Long id;

    public CreateParkingAllocationResultDto() {
    }

    public CreateParkingAllocationResultDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
