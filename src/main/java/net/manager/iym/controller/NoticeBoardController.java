package net.manager.iym.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.manager.iym.dto.NoticeBoardDTO;
import net.manager.iym.dto.paging.PageRequestDTO;
import net.manager.iym.dto.paging.PageResponseDTO;
import net.manager.iym.service.NoticeBoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/main/notice")
@Log4j2
@RequiredArgsConstructor
public class NoticeBoardController {

    private final NoticeBoardService noticeBoardService;

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){

        PageResponseDTO<NoticeBoardDTO> responseDTO =
                noticeBoardService.list(pageRequestDTO);

        log.info(responseDTO);

        model.addAttribute("responseDTO", responseDTO);
    }

    @GetMapping("/register")
    public void registerGET(){

    }

    @PostMapping("/register")
    public String registerPost(@Valid NoticeBoardDTO noticeBoardDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        log.info("board POST register.......");

        if(bindingResult.hasErrors()) {
            log.info("has errors.......");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors() );
            return "redirect:/main/notice/register";
        }

        log.info(noticeBoardDTO);

        Long noticeBoardNum  = noticeBoardService.register(noticeBoardDTO);

        redirectAttributes.addFlashAttribute("result", noticeBoardNum);

        return "redirect:/main/notice/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(Long noticeBoardNum, PageRequestDTO pageRequestDTO, Model model){

        NoticeBoardDTO noticeBoardDTO = noticeBoardService.readOne(noticeBoardNum);

        log.info(noticeBoardDTO);

        model.addAttribute("noticeBoardNum", noticeBoardDTO);

    }


}
