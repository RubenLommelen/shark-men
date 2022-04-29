package com.switchfully.sharkmen.member.domain;

import com.switchfully.sharkmen.infrastructure.Address;
import com.switchfully.sharkmen.infrastructure.PostalCode;
import com.switchfully.sharkmen.member.license_plate.domain.LicensePlate;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Arrays;
import org.hibernate.type.OffsetDateTimeType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

@DataJpaTest
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    //@Test
    //void checkIfMemberIsInRepo() {
    //    List<Member> memberList = memberRepository.findAll();
    //    Assertions.assertThat(memberList).contains(new Member("Ron", "Weasley", new Address("The Burrow", "1", new PostalCode("DH16", "devon")), "123456789", "RonWeasley@hogwarts.com", new LicensePlate("JA21HJH", "UK")));
    //}



}