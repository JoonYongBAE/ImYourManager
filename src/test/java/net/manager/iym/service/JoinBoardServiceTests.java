package net.manager.iym.service;

import lombok.extern.log4j.Log4j2;
import net.manager.iym.domain.Member;
import net.manager.iym.domain.MemberGrade;
import net.manager.iym.dto.JoinBoardDTO;
import net.manager.iym.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.support.Repositories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Log4j2
public class JoinBoardServiceTests {
@Autowired
    MemberService memberService;
@Autowired
    JoinBoardService joinBoardService;
@Autowired
    MemberRepository memberRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;

@Test
    public void testRegister(){
//    Member member = Member.builder().id("bjy961206").team(null)
//            .pass(passwordEncoder.encode("1111"))
//            .mail("bjy@gamil.com").gender("man").phone("01098293728")
//            .name("bjy").memberLoc("seoul")
//            .build();
//    member.addGrade(MemberGrade.STANDARD);
    Member member = memberRepository.findMemberById("bjy961206");
    log.info("-----------------member----------------");
    log.info(member);
    JoinBoardDTO joinBoardDTO = JoinBoardDTO.builder()
            .joinTitle("서비스테스트4").joinContent("서비스테스트글내용4")
            .id(member.getId()).name(member.getName())
            .joinVisitCount(0l).joinType("서비스테스트타입4")
            .build();
    log.info("---------------joinBoardDTO------------------");
    log.info(joinBoardDTO);
    joinBoardService.register(joinBoardDTO);
}
}
