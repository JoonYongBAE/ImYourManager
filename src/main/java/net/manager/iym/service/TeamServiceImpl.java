package net.manager.iym.service;

import lombok.RequiredArgsConstructor;
import net.manager.iym.dto.TeamDTO;
import net.manager.iym.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService{

    private final TeamRepository teamRepository;

    // 유효성 검사 실패한 항목을 찾아서 메세지 담아서 보내줌.
    public Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validResult = new HashMap<>();
        //유효성검사에 통과하지 못한 항목을 가져옴.
        for (FieldError error: errors.getFieldErrors()){
            String validKey = String.format("%s", error.getField());
            validResult.put(validKey, error.getDefaultMessage());
        }
        return validResult;
    }
    //중복체크
    public void checkTeamName(TeamDTO teamDTO){
        boolean teamNameDuplicate = teamRepository.existsByTeamName(teamDTO.getTeamName());
        if(teamNameDuplicate){
            throw new IllegalStateException("같은 팀이름이 이미 존재합니다.");
        }
    }

    public void createTeam(TeamDTO teamDTO) {

    }
}
