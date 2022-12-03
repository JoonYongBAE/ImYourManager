package net.manager.iym.service;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.manager.iym.dto.JoinBoardDTO;
import net.manager.iym.dto.paging.PageRequestDTO;
import net.manager.iym.dto.paging.PageResponseDTO;
import net.manager.iym.repository.JoinBoardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
public interface JoinBoardService{
    Long register(JoinBoardDTO joinBoardDTO);

    JoinBoardDTO readOne(Long joinBoardNum);

    void modify(JoinBoardDTO joinBoardDto);

    void remove(Long joinBoardNum);

    PageResponseDTO<JoinBoardDTO> list(PageRequestDTO pageRequestDTO);
}
