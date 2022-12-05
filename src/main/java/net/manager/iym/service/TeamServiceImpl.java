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


public Long register(TeamDTO teamDTO){

    Team team = modelMapper.map(teamDTO, Team.class);
    Long teamNum = teamRepository.save(team).getTeamNum();
   /*팀생성한 사람의 등급을 팀리더로 변경.*/

    return teamNum;
}
}
