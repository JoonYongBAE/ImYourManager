package net.manager.iym.service;

import lombok.RequiredArgsConstructor;
import net.manager.iym.domain.Member;
import net.manager.iym.domain.MemberGrade;
import net.manager.iym.domain.Team;
import net.manager.iym.dto.TeamDTO;
import net.manager.iym.repository.MemberRepository;
import net.manager.iym.repository.TeamRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService{

    private final ModelMapper modelMapper;

    private final TeamRepository teamRepository;

    private final MemberRepository memberRepository;
    @Override
    public Long register(TeamDTO teamDTO) {
        Team team = modelMapper.map(teamDTO,Team.class);
        Long teamNum = teamRepository.save(team).getTeamNum();
        Optional<Team> result = teamRepository.findById(teamNum);
        team = (Team)result.orElseThrow(); //Team team1 = (Team)result.orElseThrow();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails)principal;
        String username = ((UserDetails) principal).getUsername();
        //이걸로 member레파지토리.아이디로 정보찾기해서 나온 값을 담는다.
        //담은 값을 save를 사용해서 재설정
        //여기에 로그인이 되어있는 사람의 정보를 가져와서 그 사람의 팀값을 변경해준다.
        return teamNum;
    }
}
