package net.manager.iym.service;

import net.manager.iym.dto.TeamBoardDTO;
import net.manager.iym.dto.paging.PageRequestDTO;
import net.manager.iym.dto.paging.PageResponseDTO;

public interface TeamBoardService {

    Long register(TeamBoardDTO teamBoardDTO);

    TeamBoardDTO readOne(Long joinBoardNum);

    void modify(TeamBoardDTO teamBoardDTO);

    void remove(Long teamBoardNum);

    PageResponseDTO<TeamBoardDTO> list(PageRequestDTO pageRequestDTO);
}
