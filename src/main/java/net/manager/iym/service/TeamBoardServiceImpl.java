package net.manager.iym.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.manager.iym.dto.TeamBoardDTO;
import net.manager.iym.dto.paging.PageRequestDTO;
import net.manager.iym.dto.paging.PageResponseDTO;
import net.manager.iym.repository.TeamBoardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class TeamBoardServiceImpl implements TeamBoardService {

    private final ModelMapper modelMapper;

    private final TeamBoardRepository teamBoardRepository;

    @Override
    public Long register(TeamBoardDTO teamBoardDTO) {
        return null;
    }

    @Override
    public TeamBoardDTO readOne(Long teamBoardNum) {
        return null;
    }

    @Override
    public void modify(TeamBoardDTO teamBoardDTO) {

    }

    @Override
    public void remove(Long teamBoardNum) {

    }

    @Override
    public PageResponseDTO<TeamBoardDTO> list(PageRequestDTO pageRequestDTO) {
        return null;
    }
}
