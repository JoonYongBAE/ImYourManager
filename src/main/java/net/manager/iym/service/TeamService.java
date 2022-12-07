package net.manager.iym.service;

import net.manager.iym.dto.TeamDTO;
import org.springframework.validation.Errors;

import java.util.Map;

public interface TeamService {
    boolean checkTeamName(String teamName);                //중복체크기능
    Long register(TeamDTO teamDTO);                      //팀등록기능

    TeamDTO readOne(Long TeamNum);

    void modify(TeamDTO teamDTO);
}
