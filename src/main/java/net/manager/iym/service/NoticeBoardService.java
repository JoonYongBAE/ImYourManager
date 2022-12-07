package net.manager.iym.service;

import net.manager.iym.domain.NoticeBoard;
import net.manager.iym.dto.BoardListAllDTO;
import net.manager.iym.dto.BoardListReplyCountDTO;
import net.manager.iym.dto.NoticeBoardDTO;
import net.manager.iym.dto.paging.PageRequestDTO;
import net.manager.iym.dto.paging.PageResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public interface NoticeBoardService {
    Long register(NoticeBoardDTO noticeBoardDTO);

    NoticeBoardDTO readOne(Long noticeboardNum);

    void modify(NoticeBoardDTO noticeBoardDTO);

    void remove(Long noticeboardNum);

    PageResponseDTO<NoticeBoardDTO> list(PageRequestDTO pageRequestDTO);

    default NoticeBoard dtoToEntity(NoticeBoardDTO noticeBoardDTO){

        NoticeBoard noticeBoard = NoticeBoard.builder()
                .noticeboardNum(noticeBoardDTO.getNoticeboardNum())
                .title(noticeBoardDTO.getTitle())
                .content(noticeBoardDTO.getContent())

                .build();

//        if(noticeBoardDTO.getFileNames() != null){
//            noticeBoardDTO.getFileNames().forEach(fileName -> {
//                String[] arr = fileName.split("_");
//                noticeBoard.addImage(arr[0], arr[1]);
//            });
//        }

        return noticeBoard;
    }

    default NoticeBoardDTO entityToDTO(NoticeBoard noticeBoard) {

        NoticeBoardDTO noticeBoardDTO = NoticeBoardDTO.builder()
                .noticeboardNum(noticeBoard.getNoticeboardNum())
                .title(noticeBoard.getTitle())
                .content(noticeBoard.getContent())
                .id(noticeBoard.getMember().getId())
                .regDate(noticeBoard.getRegDate())
                .modDate(noticeBoard.getModDate())
                .build();

//        List<String> fileNames =
//                noticeBoard.getImageSet().stream().sorted().map(boardImage ->
//                        boardImage.getUuid()+"_"+boardImage.getFileName()).collect(Collectors.toList());
//
//        noticeBoardDTO.setFileNames(fileNames);

        return noticeBoardDTO;
    }

}