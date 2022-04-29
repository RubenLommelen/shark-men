package com.switchfully.sharkmen.parkinglot.service;

import com.switchfully.sharkmen.infrastructure.Address;
import com.switchfully.sharkmen.infrastructure.service.AddressMapper;
import com.switchfully.sharkmen.infrastructure.service.PostalCodeMapper;
import com.switchfully.sharkmen.parkinglot.ContactPerson;
import com.switchfully.sharkmen.parkinglot.api.dto.CreateParkingLotDTO;
import com.switchfully.sharkmen.parkinglot.api.dto.CreateParkingLotResultDTO;
import com.switchfully.sharkmen.parkinglot.api.dto.ParkingLotResultDTO;
import com.switchfully.sharkmen.parkinglot.domain.ParkingLot;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotMapper {

    private final ContactPersonMapper contactPersonMapper;
    private final AddressMapper addressMapper;
    private final PostalCodeMapper postalCodeMapper;

    public ParkingLotMapper(ContactPersonMapper contactPersonMapper, AddressMapper addressMapper, PostalCodeMapper postalCodeMapper) {
        this.contactPersonMapper = contactPersonMapper;
        this.addressMapper = addressMapper;
        this.postalCodeMapper = postalCodeMapper;
    }

    public ParkingLot toParkingLot(CreateParkingLotDTO parkingLotDTO, ContactPerson contactPerson, Address parkingLotAddress) {
        return new ParkingLot(
                parkingLotDTO.getName(),
                parkingLotDTO.getCategory(),
                parkingLotDTO.getCapacity(),
                contactPerson,
                parkingLotAddress
        );
    }

    public CreateParkingLotResultDTO toCreateParkingLotResultDto(ParkingLot parkingLot) {
        return new CreateParkingLotResultDTO(
                parkingLot.getId()
        );
    }

    public ParkingLotResultDTO toDto(ParkingLot parkingLot) {
        return new ParkingLotResultDTO(
                parkingLot.getId(),
                parkingLot.getName(),
                parkingLot.getCategory(),
                parkingLot.getCapacity(),
                contactPersonMapper.toDto(parkingLot.getContactPerson()),
                addressMapper.toDto(parkingLot.getAddress())
        );
    }
}
