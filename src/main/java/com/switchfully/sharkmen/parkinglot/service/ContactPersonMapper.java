package com.switchfully.sharkmen.parkinglot.service;

import com.switchfully.sharkmen.infrastructure.Address;
import com.switchfully.sharkmen.infrastructure.service.AddressMapper;
import com.switchfully.sharkmen.parkinglot.ContactPerson;
import com.switchfully.sharkmen.parkinglot.api.dto.ContactPersonDTO;
import com.switchfully.sharkmen.parkinglot.api.dto.CreateContactPersonDTO;
import org.springframework.stereotype.Component;

@Component
public class ContactPersonMapper {

    private final AddressMapper addressMapper;

    public ContactPersonMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public ContactPerson toContactPerson(CreateContactPersonDTO createContactPersonDto, Address contactPersonAddress) {
        return new ContactPerson(
                createContactPersonDto.getFirstName(),
                createContactPersonDto.getLastName(),
                createContactPersonDto.getMobilePhoneNumber(),
                createContactPersonDto.getPhoneNumber(),
                createContactPersonDto.getEmail(),
                contactPersonAddress
        );
    }

    public ContactPersonDTO toDto(ContactPerson contactPerson) {
        return new ContactPersonDTO(
                contactPerson.getId(),
                contactPerson.getFirstName(),
                contactPerson.getLastName(),
                contactPerson.getMobilePhoneNumber(),
                contactPerson.getPhoneNumber(),
                contactPerson.getEmail(),
                addressMapper.toDto(contactPerson.getAddress())
        );
    }
}
