package com.switchfully.sharkmen.member.service;

import com.switchfully.sharkmen.infrastructure.domain.Address;
import com.switchfully.sharkmen.infrastructure.domain.PostalCode;
import com.switchfully.sharkmen.member.domain.Member;
import com.switchfully.sharkmen.member.domain.MemberRepository;
import com.switchfully.sharkmen.member.domain.MembershipLevel;
import com.switchfully.sharkmen.member.license_plate.domain.LicensePlate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {
    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @Test
    void checkMemberConnection() {
        Member expectedMember = new Member("Harry ", "Potter"
                , new Address("Privet drive", "4", new PostalCode("WD25", "Watfort")),
                "0475080808", "HarryPotter@Hogwartsuk", new LicensePlate("1515", "UK"), MembershipLevel.BRONZE);
        memberRepository.save(expectedMember);
        Mockito.verify(memberRepository).save(expectedMember);
    }


}