package net.manager.iym.service;


import lombok.extern.log4j.Log4j2;
import net.manager.iym.domain.Member;
import net.manager.iym.domain.MemberGrade;
import net.manager.iym.dto.MemberDTO;
import net.manager.iym.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.Set;


@SpringBootTest
@Log4j2
public class MemberServiceTests {
    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;
    @Test
    public void testRegister(){
        log.info("---------------------------------------------");
        log.info(memberService.getClass().getName());
        MemberDTO memberDTO = MemberDTO.builder()
                .memberLoc("seoul").id("member123").pass("1234").name("bjy").gender("man").phone("01031322412").mail("test@test.com") //.team(null)
                .build();
        String id = memberService.register(memberDTO);

        log.info("id    :  " + id);
    }

    @Test
    public void testGrade(){
        Optional<Member> member1 = memberRepository.getWithGrade("test1");
        Member member2 = member1.orElseThrow();
        Set<MemberGrade> memberGradeSet =member2.getGradeSet();
        log.info("결과보기 : "+memberGradeSet);
    }
}
