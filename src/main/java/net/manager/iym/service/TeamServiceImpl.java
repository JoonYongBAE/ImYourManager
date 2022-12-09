package net.manager.iym.service;

import lombok.RequiredArgsConstructor;
import net.manager.iym.domain.JoinBoard;
import net.manager.iym.domain.Member;
import net.manager.iym.domain.MemberGrade;
import net.manager.iym.domain.Team;
import net.manager.iym.dto.JoinBoardDTO;
import net.manager.iym.dto.TeamDTO;
import net.manager.iym.dto.paging.PageRequestDTO;
import net.manager.iym.dto.paging.PageResponseDTO;
import net.manager.iym.repository.MemberRepository;
import net.manager.iym.repository.TeamRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final ModelMapper modelMapper;

    private final TeamRepository teamRepository;

    private final MemberRepository memberRepository;

    @Override
    public Long register(TeamDTO teamDTO) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String id = ((UserDetails) principal).getUsername();//위에 있는 행과 함께 로그인한 사람의 id를 뽑아옴
        teamDTO.setId(id);//팀DTO에 null값인 id에 로그인한 사람의 아이디를 넣어준다.
        Team team = modelMapper.map(teamDTO, Team.class);//받은 팀 정보를 domain으로 매핑한다.
        teamRepository.save(team);//매핑한 팀을 등록해준다.
        Member member = memberRepository.findMemberById(id);//뽑아온 아이디로 멤버값 뽑음
        member.changeTeam(team);//팀 체인지 메소드를 통해서 로그인한 멤버의 null값이었던 팀값을 방금 생성한 팀의 teamNum으로 변경시킴
        member.addGrade(MemberGrade.TEAMLEADER);//팀을 생성했기에 로그인한 사람의 등급을 리더로 지명
        memberRepository.save(member);//멤버를 업데이트하여 데이터 베이스에 저장해줌
        return member.getTeam().getTeamNum();//팀 넘버를 리턴해서 팀넘버 알려줌
    }

    @Override
    public TeamDTO readOne(Long teamNum) {
        Team team = teamRepository.findTeamByTeamNum(teamNum);
        TeamDTO teamDTO = modelMapper.map(team, TeamDTO.class);
        return teamDTO;
    }

    @Override
    public void modify(TeamDTO teamDTO) {

    }

    @Override
    public void remove(Long teamNum) {

    }

    @Override
    public PageResponseDTO<TeamDTO> list(PageRequestDTO pageRequestDTO) {
        String[] types = pageRequestDTO.getTypes();
        String keyword = pageRequestDTO.getKeyword();
        Pageable pageable = pageRequestDTO.getPageable("teamNum");

        Page<Team> result = teamRepository.searchAll(types, keyword, pageable);

        List<TeamDTO> dtoList = result.getContent().stream()
                .map(team -> modelMapper.map(team,TeamDTO.class)).collect(Collectors.toList());

        return PageResponseDTO.<TeamDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total((int)result.getTotalElements())
                .build();
    }

}