package net.manager.iym.service;

import net.manager.iym.dto.TeamDTO;
import org.springframework.validation.Errors;

import java.util.Map;

public interface TeamService {
    boolean checkTeamName(String teamName);                //중복체크기능
    Map<String, String> validateHandling(Errors errors);   //유효성검사기능
    Long register(TeamDTO teamDTO);                      //팀등록기능
}
