package com.switchfully.sharkmen.division.service;

import com.switchfully.sharkmen.division.api.dto.CreateDivisionDto;
import com.switchfully.sharkmen.division.api.dto.DivisionDto;
import com.switchfully.sharkmen.division.domain.Division;
import com.switchfully.sharkmen.division.domain.DivisionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DivisionService {

    private final Logger logger = LoggerFactory.getLogger(DivisionService.class);

    private final DivisionMapper divisionMapper;
    private final DivisionRepository divisionRepository;

    public DivisionService(DivisionMapper divisionMapper, DivisionRepository divisionRepository) {
        this.divisionMapper = divisionMapper;
        this.divisionRepository = divisionRepository;
    }

    public DivisionDto createDivision(CreateDivisionDto createDivisionDto) {
        logger.info("Started creating a division");
        Division divisionToSave = divisionMapper.toDivision(createDivisionDto);
        logger.info("Saving division to database");
        divisionRepository.save(divisionToSave);
        logger.info("Division with id: " + divisionToSave.getId() + " has been saved");
        return divisionMapper.toDto(divisionToSave);
    }
}
