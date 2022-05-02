package com.switchfully.sharkmen.member.domain;

import com.switchfully.sharkmen.infrastructure.domain.Address;
import com.switchfully.sharkmen.infrastructure.domain.PostalCode;
import com.switchfully.sharkmen.member.license_plate.domain.LicensePlate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DataJpaTest
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void checkIfMemberIsInRepo() {
        List<Member> expectedMemberList = new ArrayList<>(List.of(
                new Member("Ron",
                        "Weasley",
                        new Address("The Burrow",
                                "1",
                                new PostalCode("DH16", "devon")),
                        "123456789",
                        "RonWeasley@hogwarts.com",
                        new LicensePlate("JA21HJH",
                                "UK"),
                        MembershipLevel.BRONZE)));

        List<Member> actualMemberList = memberRepository.findAll();

        Assertions.assertThat(actualMemberList).hasSameSizeAs(expectedMemberList);
        Assertions.assertThat(actualMemberList).hasSameElementsAs(expectedMemberList);
    }

}