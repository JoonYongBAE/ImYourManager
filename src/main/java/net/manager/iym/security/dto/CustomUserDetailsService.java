package net.manager.iym.security.dto;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.manager.iym.domain.Member;
import net.manager.iym.repository.MemberRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService { //인터페이스 연결해주고 한개의 메소드를 오버라이딩해준다.

    private final MemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {  //id로 회원 정보를 조회후 회원이 맞는지 인증과정을 처리하기 위한 메소드
        log.info("loadUserByUserName" + id);
        Optional<Member> result = memberRepository.getWithGrade(id);
        if(result.isEmpty()){
            throw new UsernameNotFoundException("User Not Found!!!");
        }
        Member member = result.get();
        MemberSecurityDTO memberSecurityDTO = new MemberSecurityDTO(
                member.getId(),
                member.getPass(),
                member.getMail(),
                member.getPhone(),
                member.getGender(),
                member.getMemberLoc(),
                member.getName(),
                member.getTeam(),
                member.getGradeSet().stream().map(memberGrade -> new SimpleGrantedAuthority("GRADE_"+memberGrade.name())).collect(Collectors.toList())
        );
        log.info("memberSecurityDTO");
        log.info(memberSecurityDTO);
    return memberSecurityDTO; //컨트롤러에게 던져준다.
    }
}
