package net.manager.iym.service;


import lombok.extern.log4j.Log4j2;
import net.manager.iym.dto.MemberDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
@Log4j2
public class MemberServiceTests {
    @Autowired
    private MemberService memberService;

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
}
