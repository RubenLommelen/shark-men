package com.switchfully.sharkmen.parking_allocation.service;

import com.switchfully.sharkmen.infrastructure.exceptions.MemberNotFoundException;
import com.switchfully.sharkmen.member.domain.Member;
import com.switchfully.sharkmen.member.domain.MemberRepository;
import com.switchfully.sharkmen.parking_allocation.api.dto.CreateParkingAllocationDto;
import com.switchfully.sharkmen.parking_allocation.api.dto.CreateParkingAllocationResultDto;
import com.switchfully.sharkmen.parking_allocation.domain.ParkingAllocation;
import com.switchfully.sharkmen.parking_allocation.domain.ParkingAllocationRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.sql.SQLException;

@Service
@Transactional
public class ParkingAllocationService {

    private final ParkingAllocationRepository parkingAllocationRepository;
    private final MemberRepository memberRepository;
    private final ParkingAllocationMapper parkingAllocationMapper;

    public ParkingAllocationService(ParkingAllocationRepository parkingAllocationRepository, MemberRepository memberRepository, ParkingAllocationMapper parkingAllocationMapper) {
        this.parkingAllocationRepository = parkingAllocationRepository;
        this.memberRepository = memberRepository;
        this.parkingAllocationMapper = parkingAllocationMapper;
    }

    public CreateParkingAllocationResultDto startAllocation(CreateParkingAllocationDto createParkingAllocationDto) {
        assertMemberIdExists(createParkingAllocationDto.getMemberId());
        ParkingAllocation parkingAllocation = parkingAllocationMapper.toParkingAllocation(createParkingAllocationDto);
        parkingAllocationRepository.save(parkingAllocation);
        return parkingAllocationMapper.toDto(parkingAllocation);
    }

    private void assertMemberIdExists(Long memberId) {
        if (!memberRepository.existsById(memberId)) {
            throw new MemberNotFoundException("no member found for id " + memberId);
        }
    }
}
