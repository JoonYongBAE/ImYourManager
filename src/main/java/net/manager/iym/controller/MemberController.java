package net.manager.iym.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.manager.iym.dto.MemberDTO;

import net.manager.iym.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/member")
@Log4j2
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public void loginGET(String error, String logout){
        log.info("Login get....");
        log.info("logout : " +logout);
        if(logout != null){
            log.info("user Logout");
        }
    }
    @GetMapping("/logout")
    public String logout(String error, String logout){
        log.info("logout : " +logout);
        if(logout != null){
            log.info("user Logout");
        }
        return "redirect:/index1";
    }

    @GetMapping("/register")
    public void signUp() {
        log.info("memberRegister....");
    }

    @PostMapping("/register")
    public String signUp(@Valid MemberDTO memberDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        log.info("memberRegister post.......");
        if(bindingResult.hasErrors()){
            log.info("memberRegister post error");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/member/register";
        }
        log.info(memberDTO);
        memberService.register(memberDTO);
        return "redirect:/member/register";
    }

}
