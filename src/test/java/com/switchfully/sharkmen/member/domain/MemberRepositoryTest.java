package com.switchfully.sharkmen.member.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

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