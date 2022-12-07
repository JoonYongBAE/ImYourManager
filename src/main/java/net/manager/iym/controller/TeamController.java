package net.manager.iym.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.manager.iym.dto.TeamDTO;
import net.manager.iym.service.TeamServiceImpl;
import net.manager.iym.service.Validate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Map;
@Controller
@RequestMapping("/team")
@RequiredArgsConstructor
@Log4j2
public class TeamController {

    private final TeamServiceImpl teamService;
    private final Validate validate;

    @GetMapping("/newTeamForm")    ///팀생성하기 버튼 눌렀을 때
    public String createForm() {
        return "/newTeamForm";
    }
    @GetMapping("/checkTeamName")  // 팀이름 중복확인만을 위한 값으로 매핑
    @ResponseBody  // 값 변환을 위해 필요함.
    public boolean check(String teamName) throws Exception {
        System.out.println(teamName);

        //중복체크
        boolean result=  teamService.checkTeamName(teamName);
        return result;
    }

    @PostMapping("/saveTeam")
    public String saveTeam(@Valid TeamDTO teamDTO, Errors errors, Model model){

        if(errors.hasErrors()){

            //유효성 검사에 통과해지 못해도 입력 데이터값을 유지
            model.addAttribute("teamDTO",teamDTO);

            //유효성 검사 통과하지 못한 항목과 메세지 출력
            Map<String, String> validResult = validate.validateHandling(errors);
            for(String key : validResult.keySet()){
                model.addAttribute(key, validResult.get(key));
            }
            //다시 팀등록 페이지로 돌려보내기
            return "team/newTeamForm";
        }
        teamService.register(teamDTO);

        return "redirect:/team";   //일단 팀등록후 팀게시판으로 (팀페이지 바로 생성해서 띄운다면 변경해야함.)
    }

    @GetMapping({"/teamList", "/modify"})
    public void read(Long teamNum, Model model){

        TeamDTO teamDTO = teamService.readOne(teamNum);

        log.info(teamDTO);

        model.addAttribute("dto", teamDTO);

    }

    @PostMapping("/modify")
    public String modify( @Valid TeamDTO teamDTO,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes){

        log.info("team modify post......." + teamDTO);

        if(bindingResult.hasErrors()) {
            log.info("has errors.......");

            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors() );

            redirectAttributes.addAttribute("bno", teamDTO.getTeamNum());

            return "redirect:/team/modify";
        }

        teamService.modify(teamDTO);

        redirectAttributes.addFlashAttribute("result", "modified");

        redirectAttributes.addAttribute("teamNum", teamDTO.getTeamNum());

        return "redirect:/team/teamList";
    }

}

