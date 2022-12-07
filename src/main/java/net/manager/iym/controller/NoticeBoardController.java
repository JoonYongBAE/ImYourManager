package net.manager.iym.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.manager.iym.dto.BoardListAllDTO;
import net.manager.iym.dto.NoticeBoardDTO;
import net.manager.iym.dto.paging.PageRequestDTO;
import net.manager.iym.dto.paging.PageResponseDTO;
import net.manager.iym.service.NoticeBoardService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.File;
import java.nio.file.Files;
import java.util.List;

@Controller
@RequestMapping("/notice")
@Log4j2
@RequiredArgsConstructor
public class NoticeBoardController {

//    @Value("${net.manager.upload.path}")// import 시에 springframework으로 시작하는 Value
//    private String uploadPath;

    private final NoticeBoardService noticeBoardService;

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){

        PageResponseDTO<NoticeBoardDTO> responseDTO =
                noticeBoardService.list(pageRequestDTO);

        log.info(responseDTO);

        model.addAttribute("responseDTO", responseDTO);
    }


//    @PreAuthorize("hasRole('USER')")
    @GetMapping("/register")
    public void registerGET(){

    }

    @PostMapping("/register")
    public String registerPost(@Valid NoticeBoardDTO noticeBoardDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        log.info("board POST register.......");

        if(bindingResult.hasErrors()) {
            log.info("has errors.......");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors() );
            return "redirect:/notice/register";
        }

        log.info(noticeBoardDTO);

        Long noticeboardNum  = noticeBoardService.register(noticeBoardDTO);

        redirectAttributes.addFlashAttribute("result", noticeboardNum);

        return "redirect:/notice/list";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping({"/read", "/modify"})
    public void read(Long bno, PageRequestDTO pageRequestDTO, Model model){

        NoticeBoardDTO noticeBoardDTO = noticeBoardService.readOne(bno);

        log.info(noticeBoardDTO);

        model.addAttribute("dto", noticeBoardDTO);

    }

    @PreAuthorize("principal.username == #boardDTO.writer")
    @PostMapping("/modify")
    public String modify( @Valid NoticeBoardDTO noticeBoardDTO,
                          BindingResult bindingResult,
                          PageRequestDTO pageRequestDTO,
                          RedirectAttributes redirectAttributes){


        log.info("board modify post......." + noticeBoardDTO);

        if(bindingResult.hasErrors()) {
            log.info("has errors.......");

            String link = pageRequestDTO.getLink();

            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors() );

            redirectAttributes.addAttribute("noticeboardNum", noticeBoardDTO.getNoticeboardNum());

            return "redirect:/notice/modify?"+link;
        }

        noticeBoardService.modify(noticeBoardDTO);

        redirectAttributes.addFlashAttribute("result", "modified");

        redirectAttributes.addAttribute("noticeboardNum", noticeBoardDTO.getNoticeboardNum());

        return "redirect:/notice/read";
    }

    @PreAuthorize("principal.username == #boardDTO.writer")
    @PostMapping("/remove")
    public String remove(NoticeBoardDTO noticeBoardDTO, RedirectAttributes redirectAttributes) {


        Long bno  = noticeBoardDTO.getNoticeboardNum();
        log.info("remove post.. " + bno);

        noticeBoardService.remove(bno);

//        //게시물이 삭제되었다면 첨부 파일 삭제
//        log.info(noticeBoardDTO.getFileNames());
//        List<String> fileNames = noticeBoardDTO.getFileNames();
//        if(fileNames != null && fileNames.size() > 0){
//            removeFiles(fileNames);
//        }

        redirectAttributes.addFlashAttribute("result", "removed");

        return "redirect:/notice/list";

    }


//    public void removeFiles(List<String> files){
//
//        for (String fileName:files) {
//
//            Resource resource = new FileSystemResource(uploadPath + File.separator + fileName);
//            String resourceName = resource.getFilename();
//
//
//            try {
//                String contentType = Files.probeContentType(resource.getFile().toPath());
//                resource.getFile().delete();
//
//                //섬네일이 존재한다면
//                if (contentType.startsWith("image")) {
//                    File thumbnailFile = new File(uploadPath + File.separator + "s_" + fileName);
//                    thumbnailFile.delete();
//                }
//
//            } catch (Exception e) {
//                log.error(e.getMessage());
//            }
//
//        }//end for
//    }
}