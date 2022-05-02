package com.switchfully.sharkmen.parkinglot.service;

import com.switchfully.sharkmen.contact_person.service.ContactPersonMapper;
import com.switchfully.sharkmen.infrastructure.service.AddressMapper;
import com.switchfully.sharkmen.parkinglot.api.dto.CreateParkingLotDto;
import com.switchfully.sharkmen.parkinglot.api.dto.CreateParkingLotResultDto;
import com.switchfully.sharkmen.parkinglot.domain.ParkingLot;
import com.switchfully.sharkmen.parkinglot.domain.ParkingLotRepository;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotMapper {

    private final ContactPersonMapper contactPersonMapper;
    private final AddressMapper addressMapper;
    private final ParkingLotRepository parkingLotRepository;

    public ParkingLotMapper(ContactPersonMapper contactPersonMapper, AddressMapper addressMapper, ParkingLotRepository parkingLotRepository) {
        this.contactPersonMapper = contactPersonMapper;
        this.addressMapper = addressMapper;
        this.parkingLotRepository = parkingLotRepository;
    }

    public ParkingLot toParkingLot(CreateParkingLotDto parkingLotDTO) {
        return new ParkingLot(
                parkingLotDTO.getName(),
                parkingLotDTO.getCategory(),
                parkingLotDTO.getCapacity(),
                contactPersonMapper.toContactPerson(parkingLotDTO.getContactPerson()),
                addressMapper.toAddress(parkingLotDTO.getAddress())
        );
    }

    public ParkingLot toParkingLot(Long parkingLotId) {
        return parkingLotRepository.getById(parkingLotId);
    }


    public CreateParkingLotResultDto toCreateParkingLotResultDto(ParkingLot parkingLot) {
        return new CreateParkingLotResultDto(
                parkingLot.getId()
        );
    }
}
