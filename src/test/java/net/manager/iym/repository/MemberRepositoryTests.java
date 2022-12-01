package net.manager.iym.repository;

import lombok.extern.log4j.Log4j2;
import net.manager.iym.domain.Member;
import net.manager.iym.domain.MemberGrade;
import net.manager.iym.domain.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class MemberRepositoryTests {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void insertMember(){
        IntStream.rangeClosed(1,2).forEach(i->{
            Member member = Member.builder().id("member1").team(null)
                    .pass(passwordEncoder.encode("1111"))
                    .mail("ict"+i+"@naver.com").gender("man").phone("01012345"+i)
                    .name("mingyo").memberLoc("korea")
                    .build();
            member.addGrade(MemberGrade.STANDARD);
            if (i>=10){
                member.addGrade(MemberGrade.TEAMMEMBER);
            }
            memberRepository.save(member);
        });
    }

    @Test
    public void testRead(){
        Optional<Member> result = memberRepository.getWithGrade("member9");
        Member member = result.orElseThrow();
        log.info(member);
        log.info(member.getGradeSet());
        member.getGradeSet().forEach(memberGrade -> log.info(memberGrade.name()));
    }

}
