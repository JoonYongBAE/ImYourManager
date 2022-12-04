package net.manager.iym.service;

import lombok.RequiredArgsConstructor;
import net.manager.iym.domain.Member;
import net.manager.iym.domain.MemberGrade;
import net.manager.iym.dto.MemberDTO;
import net.manager.iym.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final ModelMapper modelMapper;
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override//
    public String register(MemberDTO memberDTO) {
        memberDTO.setPass(bCryptPasswordEncoder.encode(memberDTO.getPass()));
        Member member = modelMapper.map(memberDTO, Member.class);
        member.addGrade(MemberGrade.STANDARD);
//        Member member = Member.builder()
//                .id(memberDTO.getId()).pass(memberDTO.getPass())
//                .name(memberDTO.getName()).gender(memberDTO.getGender())
//                .mail(memberDTO.getMail()).phone(memberDTO.getPhone())
//                .team(null).memberLoc(memberDTO.getMemberLoc()).build();
//        member.addGrade(MemberGrade.STANDARD);
        String id = memberRepository.save(member).getId();
        return id;
    }

    @Override
    public MemberDTO readMember(String id) {
        return null;
    }

    @Override
    public void modify(MemberDTO memberDTO) {

    }

    @Override
    public void delete(String id) {

    }
}
