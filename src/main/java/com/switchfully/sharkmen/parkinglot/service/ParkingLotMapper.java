package com.switchfully.sharkmen.parkinglot.service;

import com.switchfully.sharkmen.infrastructure.domain.Address;
import com.switchfully.sharkmen.infrastructure.service.AddressMapper;
import com.switchfully.sharkmen.infrastructure.service.PostalCodeMapper;
import com.switchfully.sharkmen.parkinglot.ContactPerson;
import com.switchfully.sharkmen.parkinglot.api.dto.CreateParkingLotDto;
import com.switchfully.sharkmen.parkinglot.api.dto.CreateParkingLotResultDto;
import com.switchfully.sharkmen.parkinglot.api.dto.ParkingLotResultDto;
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

    public ParkingLot toParkingLot(CreateParkingLotDto parkingLotDTO, ContactPerson contactPerson, Address parkingLotAddress) {
        return new ParkingLot(
                parkingLotDTO.getName(),
                parkingLotDTO.getCategory(),
                parkingLotDTO.getCapacity(),
                contactPerson,
                parkingLotAddress
        );
    }

    public ParkingLot toParkingLot(CreateParkingLotDto parkingLotDTO) {
        return new ParkingLot(
                parkingLotDTO.getName(),
                parkingLotDTO.getCategory(),
                parkingLotDTO.getCapacity(),
                contactPersonMapper.toContactPerson(parkingLotDTO.getCreateContactPersonDto()),
                addressMapper.toAddress(parkingLotDTO.getCreateAddressDto())
        );
    }

    public CreateParkingLotResultDto toCreateParkingLotResultDto(ParkingLot parkingLot) {
        return new CreateParkingLotResultDto(
                parkingLot.getId()
        );
    }

    public ParkingLotResultDto toDto(ParkingLot parkingLot) {
        return new ParkingLotResultDto(
                parkingLot.getId(),
                parkingLot.getName(),
                parkingLot.getCategory(),
                parkingLot.getCapacity(),
                contactPersonMapper.toDto(parkingLot.getContactPerson()),
                addressMapper.toDto(parkingLot.getAddress())
        );
    }
}
