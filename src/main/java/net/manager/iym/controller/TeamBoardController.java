package net.manager.iym.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.manager.iym.dto.TeamBoardDTO;
import net.manager.iym.service.TeamBoardService;
import org.springframework.stereotype.Controller;
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

    @GetMapping
    public void registerGet(){}

    @PostMapping
    public String registerPost(@Valid TeamBoardDTO teamBoardDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        log.info("Teamboard POST register.......");

        if(bindingResult.hasErrors()) {
            log.info("has errors.......");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors() );
            return "redirect:/board/register";
        }

        log.info(teamBoardDTO);

        Long teamBoardNum  = teamBoardService.register(teamBoardDTO);

        redirectAttributes.addFlashAttribute("result", teamBoardNum);

        return "redirect:/teamboard/list";
    }
}
