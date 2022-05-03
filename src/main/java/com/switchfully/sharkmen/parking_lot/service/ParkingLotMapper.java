package com.switchfully.sharkmen.parking_lot.service;

import com.switchfully.sharkmen.contact_person.service.ContactPersonMapper;
import com.switchfully.sharkmen.infrastructure.service.AddressMapper;
import com.switchfully.sharkmen.parking_lot.api.dto.CreateParkingLotDto;
import com.switchfully.sharkmen.parking_lot.api.dto.CreateParkingLotResultDto;
import com.switchfully.sharkmen.parking_lot.api.dto.ParkingLotOverviewDto;
import com.switchfully.sharkmen.parking_lot.domain.ParkingLot;
import com.switchfully.sharkmen.parking_lot.domain.ParkingLotRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParkingLotMapper {

    private final Logger parkingLotMapperLogger = LoggerFactory.getLogger(ParkingLotMapper.class);

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

    public ParkingLotOverviewDto toParkingLotOverviewDto(ParkingLot parkingLot) {
        String phoneNumber = SelectPhoneNumber(parkingLot);
        return new ParkingLotOverviewDto(
                parkingLot.getId(),
                parkingLot.getName(),
                parkingLot.getCapacity(),
                phoneNumber,
                parkingLot.getContactPerson().getEmail()
        );
    }

    public List<ParkingLotOverviewDto> toParkingLotOverviewDto(List<ParkingLot> parkingLotList) {
        return parkingLotList.stream()
                .map(parkingLot -> toParkingLotOverviewDto(parkingLot))
                .toList();
    }

    private String SelectPhoneNumber(ParkingLot parkingLot) {
        String phoneNumber;
        if (parkingLot.getContactPerson().getMobilePhoneNumber() != null && !parkingLot.getContactPerson().getMobilePhoneNumber().isBlank()) {
            phoneNumber = parkingLot.getContactPerson().getMobilePhoneNumber();
            parkingLotMapperLogger.info("Selected mobile phone number");
        } else {
            phoneNumber = parkingLot.getContactPerson().getPhoneNumber();
            parkingLotMapperLogger.info("Selected home phone number");
        }
        return phoneNumber;
    }
}
