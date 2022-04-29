package com.switchfully.sharkmen.infrastructure.service;

import com.switchfully.sharkmen.infrastructure.domain.Address;
import com.switchfully.sharkmen.infrastructure.domain.PostalCode;
import com.switchfully.sharkmen.infrastructure.api.dto.AddressDto;
import com.switchfully.sharkmen.infrastructure.api.dto.CreateAddressDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    private final Logger addressMapperLogger = LoggerFactory.getLogger(AddressMapper.class);

    private final PostalCodeMapper postalCodeMapper;

    public AddressMapper(PostalCodeMapper postalCodeMapper) {
        this.postalCodeMapper = postalCodeMapper;
    }

    public Address toAddress(AddressDto addressDto) {
        addressMapperLogger.info("AddressDto conversion to Address");
        return new Address(
                addressDto.getStreetName(),
                addressDto.getStreetNumber(),
                postalCodeMapper.toPostalCode(addressDto.getPostalCodeDto())
        );
    }

    public Address toAddress(CreateAddressDto createAddressDto, PostalCode postalCode) {
        addressMapperLogger.info("AddressDto conversion to Address");
        return new Address(
                createAddressDto.getStreetName(),
                createAddressDto.getStreetNumber(),
                postalCode
        );
    }

    public AddressDto toDto(Address address) {
        addressMapperLogger.info("Address conversion to AddressDto");
        return new AddressDto(
                address.getStreetName(),
                address.getStreetNumber(),
                postalCodeMapper.toDto(address.getPostalCode())
        );
    }
}
