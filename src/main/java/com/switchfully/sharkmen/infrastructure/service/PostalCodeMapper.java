package com.switchfully.sharkmen.infrastructure.service;

import com.switchfully.sharkmen.infrastructure.api.dto.CreatePostalCodeDto;
import com.switchfully.sharkmen.infrastructure.api.dto.PostalCodeDto;
import com.switchfully.sharkmen.infrastructure.domain.PostalCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PostalCodeMapper {

    private final Logger postalCodeMapperLogger = LoggerFactory.getLogger(PostalCodeMapper.class);


    public PostalCode toPostalCode(CreatePostalCodeDto postalCodeDto) {
        postalCodeMapperLogger.info("CreatePostalCodeDto conversion to PostalCode");
        return new PostalCode(postalCodeDto.getZipcode(), postalCodeDto.getCity());
    }

    public PostalCodeDto toDto(PostalCode postalCode) {
        postalCodeMapperLogger.info("PostalCode conversion to PostalCodeDto");
        return new PostalCodeDto(postalCode.getZipcode(), postalCode.getCity());
    }
}
