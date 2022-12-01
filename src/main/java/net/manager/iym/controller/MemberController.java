package net.manager.iym.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.manager.iym.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@Log4j2
@RequiredArgsConstructor
public class MemberController {

    @GetMapping("/login")
    public void loginGET(String error, String logout){
        log.info("Login get....");
        log.info("logout : " +logout);
        if(logout != null){
            log.info("user Logout");
        }
    }

    @GetMapping("/join")
    public void joinGET () {
        log.info("join get....");
    }

    @PostMapping("/join")
    public String joinPOST(MemberDTO memberDTO){
        log.info("join post....");
        log.info(memberDTO);
        return "redirect:/board/list";
    }

}
