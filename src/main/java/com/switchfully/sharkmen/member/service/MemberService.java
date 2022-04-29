package com.switchfully.sharkmen.member.service;

import com.switchfully.sharkmen.infrastructure.exceptions.IllegalFormatForEmailException;
import com.switchfully.sharkmen.member.api.dto.CreateMemberDto;
import com.switchfully.sharkmen.member.api.dto.MemberDto;
import com.switchfully.sharkmen.member.domain.Member;
import com.switchfully.sharkmen.member.domain.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class MemberService {

    private final Logger memberServiceLogger = LoggerFactory.getLogger(MemberService.class);
    private final MemberRepository memberRepository;

    private final MemberMapper memberMapper;

    public MemberService(MemberRepository memberRepository, MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
    }

    public MemberDto registerMember(CreateMemberDto createMemberDto) {
        Member memberToRegister = memberMapper.ToMember(createMemberDto);
        if (!isEmailFormValid(memberToRegister.getEmailAddress())) {
            memberServiceLogger.info("Wrong e-mail address format" + memberToRegister.getEmailAddress());
            throw new IllegalFormatForEmailException();
        }
        memberRepository.save(memberToRegister);
        memberServiceLogger.info("Registering a member" + memberToRegister.getFirstName());
        return memberMapper.ToDto(memberToRegister);
    }

    private boolean isEmailFormValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        return pat.matcher(email).matches();
    }

}
