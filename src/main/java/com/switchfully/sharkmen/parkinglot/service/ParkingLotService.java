package com.switchfully.sharkmen.parkinglot.service;

import com.switchfully.sharkmen.infrastructure.PostalCode;
import com.switchfully.sharkmen.infrastructure.domain.AddressRepository;
import com.switchfully.sharkmen.infrastructure.domain.PostalCodeRepository;
import com.switchfully.sharkmen.infrastructure.service.AddressMapper;
import com.switchfully.sharkmen.infrastructure.service.PostalCodeMapper;
import com.switchfully.sharkmen.parkinglot.api.dto.CreateParkingLotDTO;
import com.switchfully.sharkmen.parkinglot.api.dto.ParkingLotResultDTO;
import com.switchfully.sharkmen.parkinglot.domain.ParkingLotRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ParkingLotService {

    private AddressMapper addressMapper;
    private PostalCodeMapper postalCodeMapper;
    private ParkingLotMapper parkingLotMapper;
    private ContactPersonMapper contactPersonMapper;
    private AddressRepository addressRepository;
    private PostalCodeRepository postalCodeRepository;
    private ParkingLotRepository parkingLotRepository;
    private ContactPersonRepository contactPersonRepository;

    public ParkingLotService(AddressMapper addressMapper, PostalCodeMapper postalCodeMapper, ParkingLotMapper parkingLotMapper, ContactPersonMapper contactPersonMapper, AddressRepository addressRepository, PostalCodeRepository postalCodeRepository, ParkingLotRepository parkingLotRepository, ContactPersonRepository contactPersonRepository) {
        this.addressMapper = addressMapper;
        this.postalCodeMapper = postalCodeMapper;
        this.parkingLotMapper = parkingLotMapper;
        this.contactPersonMapper = contactPersonMapper;
        this.addressRepository = addressRepository;
        this.postalCodeRepository = postalCodeRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.contactPersonRepository = contactPersonRepository;
    }

    public ParkingLotResultDTO createParkingLot(CreateParkingLotDTO parkingLotDTO) {
//        PostalCode postalCode = postalCodeMapper.toPostalCode(parkingLotDTO.get);
        return null;
    }
}
