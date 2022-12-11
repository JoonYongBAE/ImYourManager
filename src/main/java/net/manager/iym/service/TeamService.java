package net.manager.iym.service;

import net.manager.iym.dto.TeamDTO;
import net.manager.iym.dto.paging.PageRequestDTO;
import net.manager.iym.dto.paging.PageResponseDTO;

public interface TeamService {

    Long register(TeamDTO teamDTO);
    TeamDTO readOne(Long teamNum);
    void modify(TeamDTO teamDTO);
    void remove(Long teamNum);
    PageResponseDTO<TeamDTO> list(PageRequestDTO pageRequestDTO);

}
