package net.manager.iym.service;

import net.manager.iym.dto.JoinBoardDTO;
import net.manager.iym.dto.paging.PageRequestDTO;
import net.manager.iym.dto.paging.PageResponseDTO;

public interface JoinBoardService {

    Long register(JoinBoardDTO joinBoardDTO);

    JoinBoardDTO readOne(Long joinBoardNum);

    void modify(JoinBoardDTO joinBoardDto);

    void remove(Long joinBoardNum);

    PageResponseDTO<JoinBoardDTO> list(PageRequestDTO pageRequestDTO);
}
