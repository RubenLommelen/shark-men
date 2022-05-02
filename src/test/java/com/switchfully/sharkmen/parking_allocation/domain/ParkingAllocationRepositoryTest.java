package com.switchfully.sharkmen.parking_allocation.domain;


import com.switchfully.sharkmen.member.domain.Member;
import com.switchfully.sharkmen.member.domain.MemberRepository;
import com.switchfully.sharkmen.parkinglot.domain.ParkingLotRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ParkingAllocationRepositoryTest {

    @Autowired
    ParkingAllocationRepository parkingAllocationRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    ParkingLotRepository parkingLotRepository;

    @Test
    void checkIfParkingAllocationIsInRepo() {
        List<ParkingAllocation> expectedParkingAllocationList = new ArrayList<>(List.of(new ParkingAllocation(memberRepository.getById(1L),"JA21HJH",parkingLotRepository.getById(1L))));

        List<ParkingAllocation> actualParkingAllocationList = parkingAllocationRepository.findAll();

        Assertions.assertThat(actualParkingAllocationList).hasSameSizeAs(expectedParkingAllocationList);
        Assertions.assertThat(actualParkingAllocationList).hasSameElementsAs(expectedParkingAllocationList);

    }


}