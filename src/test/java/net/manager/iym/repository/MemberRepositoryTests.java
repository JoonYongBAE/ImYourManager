package net.manager.iym.repository;

import lombok.extern.log4j.Log4j2;
import net.manager.iym.domain.Member;
import net.manager.iym.domain.MemberGrade;
import net.manager.iym.domain.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
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
        Optional<Team> result = teamRepository.findById(6l);
        Team team = (Team)result.orElseThrow();//팀 null값 익셉션 해준 테스트
        IntStream.rangeClosed(1,3).forEach(i->{
            Member member = Member.builder().id("member"+i).team(team)
                    .pass(passwordEncoder.encode("1111"))
                    .mail("ict"+i+"@naver.com").gender("man").phone("010123456"+i)
                    .name("min"+i).memberLoc("korea")
                    .build();
            member.addGrade(MemberGrade.STANDARD);
            member.addGrade(MemberGrade.TEAMMEMBER);
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
    @Test
    public void testMemberInfo(){
        Member bjy7883 =memberRepository.findMemberById("bjy7883");
        Member mn1206 = memberRepository.findMemberById("mn1206");
        log.info("bjy7883의 담긴 값 확인 : "+bjy7883);
        log.info("mn1206의 담긴 값 확인 : "+mn1206);
    }
    @Test
    public void testMemberTeamUpdate(){
        Team team = teamRepository.findTeamByTeamNum(3l);
        log.info("team :" + team);
        memberRepository.updateDeleteTeam(team);

    }
}
