package com.switchfully.sharkmen.parking_allocation.service;

import com.switchfully.sharkmen.infrastructure.exceptions.NotFoundException;
import com.switchfully.sharkmen.member.domain.Member;
import com.switchfully.sharkmen.member.domain.MemberRepository;
import com.switchfully.sharkmen.member.domain.MembershipLevel;
import com.switchfully.sharkmen.parking_allocation.api.dto.CreateParkingAllocationDto;
import com.switchfully.sharkmen.parking_allocation.api.dto.CreateParkingAllocationResultDto;
import com.switchfully.sharkmen.parking_allocation.domain.ParkingAllocation;
import com.switchfully.sharkmen.parking_allocation.domain.ParkingAllocationRepository;
import com.switchfully.sharkmen.parking_lot.domain.ParkingLotRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;


@Service
@Transactional
public class ParkingAllocationService {

    private final Logger parkingAllocationServiceLogger = LoggerFactory.getLogger(ParkingAllocationService.class);
    private final ParkingAllocationRepository parkingAllocationRepository;
    private final MemberRepository memberRepository;
    private final ParkingLotRepository parkingLotRepository;
    private final ParkingAllocationMapper parkingAllocationMapper;

    public ParkingAllocationService(ParkingAllocationRepository parkingAllocationRepository, MemberRepository memberRepository, ParkingLotRepository parkingLotRepository, ParkingAllocationMapper parkingAllocationMapper) {
        this.parkingAllocationRepository = parkingAllocationRepository;
        this.memberRepository = memberRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingAllocationMapper = parkingAllocationMapper;
    }

    public CreateParkingAllocationResultDto startAllocation(CreateParkingAllocationDto createParkingAllocationDto) {
        parkingAllocationServiceLogger.info("Started creating parking allocation");
        assertMemberIdExists(createParkingAllocationDto.getMemberId());
        assertLicensePlateIsCorrect(createParkingAllocationDto.getLicensePlateNumber(), createParkingAllocationDto.getMemberId());
        assertParkingLotIdExists(createParkingAllocationDto.getParkingLotId());

        ParkingAllocation parkingAllocation = parkingAllocationMapper.toParkingAllocation(createParkingAllocationDto);
        parkingAllocationServiceLogger.info("Saving allocation to database");
        parkingAllocationRepository.save(parkingAllocation);
        parkingAllocationServiceLogger.info("Successfully created parking allocation");
        return parkingAllocationMapper.toDto(parkingAllocation);
    }

    private void assertMemberIdExists(Long memberId) {
        if (!memberRepository.existsById(memberId)) {
            throw new NotFoundException("no member found for id " + memberId);
        }
    }

    private void assertLicensePlateIsCorrect(String licensePlateNumber, Long memberId) {
        if (memberRepository.getById(memberId).getMembershipLevel() == MembershipLevel.GOLD) {
            return;
        }
        List<Member> foundMembers = memberRepository.findByLicensePlateLicensePlateNumber(licensePlateNumber);
        if (foundMembers.stream()
                .map(Member::getMemberId)
                .noneMatch(number -> Objects.equals(number, memberId))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "License plate number is not registered to the member with id " + memberId);
        }
    }

    private void assertParkingLotIdExists(Long parkingLotId) {
        if (!parkingLotRepository.existsById(parkingLotId)) {
            throw new NotFoundException("no parking lot found for id " + parkingLotId);
        }
    }
}
