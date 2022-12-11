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

    @Autowired
    private TeamRepository teamRepository;
    @Test
    public void insertMember(){ //멤버 인서트 + 팀 강제 주입 테스트 성공
        Optional<Team> result = teamRepository.findById(1l);
        Team team = (Team)result.orElseThrow();
        IntStream.rangeClosed(1,1).forEach(i->{
            Member member = Member.builder().id("member1").team(team)
                    .pass(passwordEncoder.encode("1111"))
                    .mail("ict"+i+"@naver.com").gender("man").phone("01012345"+i)
                    .name("tester").memberLoc("seoul")
                    .build();
            member.addGrade(MemberGrade.STANDARD);
            if (i>=0){
                member.addGrade(MemberGrade.TEAMLEADER);
            }
            memberRepository.save(member);
        });
    }

    @Test
    public void testRead(){
        Optional<Member> result = memberRepository.getWithGrade("member12");
        log.info("--------");
        log.info(result);
        Member member = result.orElseThrow();
        log.info("--------");
        log.info(member);
        log.info("--------");
        log.info(member.getGradeSet());
        log.info("--------");
        member.getGradeSet().forEach(memberGrade -> log.info(memberGrade.name()));
    }

}
