package com.switchfully.sharkmen.contact_person.service;

import com.switchfully.sharkmen.contact_person.api.dto.CreateContactPersonDto;
import com.switchfully.sharkmen.contact_person.domain.ContactPerson;
import com.switchfully.sharkmen.infrastructure.service.AddressMapper;
import org.springframework.stereotype.Component;

@Component
public class ContactPersonMapper {

    private final AddressMapper addressMapper;

    public ContactPersonMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public ContactPerson toContactPerson(CreateContactPersonDto createContactPersonDto) {
        return new ContactPerson(
                createContactPersonDto.getFirstName(),
                createContactPersonDto.getLastName(),
                createContactPersonDto.getMobilePhoneNumber(),
                createContactPersonDto.getPhoneNumber(),
                createContactPersonDto.getEmail(),
                addressMapper.toAddress(createContactPersonDto.getAddress())
        );
    }
}
