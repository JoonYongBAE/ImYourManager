package net.manager.iym.controller;

import net.manager.iym.dto.TeamDTO;
import net.manager.iym.service.TeamServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Map;
@Controller
@RequestMapping("/team")
public class TeamController {
    TeamServiceImpl teamService;

    @PostMapping("/createTeamProcess")
    public String createTeamProcess(@Valid TeamDTO teamDTO, Errors errors, Model model){
        if(errors.hasErrors()){

            //중복체크
            teamService.checkTeamName(teamDTO);

            //유효성 검사에 통과해지 못해도 입력 데이터값을 유지
            model.addAttribute("teamDTO",teamDTO);

            //유효성 검사 통과하지 못한 항목과 메세지 출력
            Map<String, String> validResult = teamService.validateHandling(errors);
            for(String key : validResult.keySet()){
                model.addAttribute(key, validResult.get(key));
            }

            //다시 팀등록 페이지로 돌려보내기
            return "/team/createTeam";
        }
        teamService.createTeam(teamDTO);
        return "redirect:/team";   //일단 팀등록후 팀게시판으로 (팀페이지 바로 생성해서 띄운다면 변경해야함.)
    }
}
