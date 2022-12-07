package net.manager.iym.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.manager.iym.dto.TeamBoardDTO;
import net.manager.iym.dto.paging.PageRequestDTO;
import net.manager.iym.dto.paging.PageResponseDTO;
import net.manager.iym.service.TeamBoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/teamboard")
@Log4j2
@RequiredArgsConstructor
public class TeamBoardController {

    private final TeamBoardService teamBoardService;

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){

        //PageResponseDTO<BoardDTO> responseDTO = boardService.list(pageRequestDTO);

        PageResponseDTO<TeamBoardDTO> responseDTO =
                teamBoardService.list(pageRequestDTO);

        log.info(responseDTO);

        model.addAttribute("responseDTO", responseDTO);
    }

    @GetMapping("/register")
    public void registerGet(){}

    @PostMapping("/register")
    public String registerPost(@Valid TeamBoardDTO teamBoardDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        log.info("Teamboard POST register.......");

        if(bindingResult.hasErrors()) {
            log.info("has errors.......");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors() );
            return "redirect:/teamboard/register";
        }

        log.info(teamBoardDTO);

        Long teamBoardNum  = teamBoardService.register(teamBoardDTO);

        redirectAttributes.addFlashAttribute("result", teamBoardNum);

        return "redirect:/teamboard/list";
    }

    @GetMapping("/read, /modify")//게시글 확인, 수정 컨트롤러 GET
    public void read(Long teamBoardNum, PageRequestDTO pageRequestDTO, Model model){
        TeamBoardDTO teamBoardDTO = teamBoardService.readOne(teamBoardNum);
        log.info("teamBoardDTO의 값 확인 : "+teamBoardDTO);
        model.addAttribute("teamBoardDTO", teamBoardDTO);
    }

    @PostMapping("/modify")//조인게시글 수정 컨트롤러 POST
    public String modify(@Valid TeamBoardDTO teamBoardDTO, PageRequestDTO pageRequestDTO,
                         BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            log.info("/modify에 결과값이 안넘어옴");//결과값이 바인딩안되면 실행됨
            return "redirect:/";
        }
        teamBoardService.modify(teamBoardDTO);
        return "redirect:/teamboard/list";
    }
    @PostMapping("/remove")//조인 게시글 삭제 컨트롤러 POST
    public String remove(TeamBoardDTO teamBoardDTO, RedirectAttributes redirectAttributes){
        Long teamBoardNum = teamBoardDTO.getTeamBoardNum();
        teamBoardService.remove(teamBoardNum);
        return "redirect:/teamboard/list";
    }
}
