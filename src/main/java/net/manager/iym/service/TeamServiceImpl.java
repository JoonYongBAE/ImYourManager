package net.manager.iym.service;

import lombok.RequiredArgsConstructor;
import net.manager.iym.domain.QMember;
import net.manager.iym.domain.Team;
import net.manager.iym.dto.MemberDTO;
import net.manager.iym.dto.TeamDTO;
import net.manager.iym.repository.MemberRepository;
import net.manager.iym.repository.TeamRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

import static net.manager.iym.domain.QMember.member;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService{
    private final ModelMapper modelMapper;
    private final TeamRepository teamRepository;


public boolean checkTeamName(String teamName){   //중복 체크

    return teamRepository.existsByTeamName(teamName);
}

public Map<String, String> validateHandling(Errors errors){     // 유효성 검사 핸들러
    Map<String, String> validResult = new HashMap<>();
        //유효성검사에 통과하지 못한 항목을 가져옴.
    for (FieldError error: errors.getFieldErrors()){
            String validKey = String.format("%s", error.getField());  // %s = 유효성검사 통과하지 못한 dto의 필드명
            validResult.put(validKey, error.getDefaultMessage());     // dto에 작성된 default 메세지
    }
    return validResult;
}

public Long register(TeamDTO teamDTO){

    Team team = modelMapper.map(teamDTO, Team.class);
    Long teamNum = teamRepository.save(team).getTeamNum();
   /*팀생성한 사람의 등급을 팀리더로 변경.*/

    return teamNum;
}
}
