package net.manager.iym.service;

import lombok.RequiredArgsConstructor;
import net.manager.iym.domain.Member;
import net.manager.iym.dto.MemberDTO;
import net.manager.iym.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final ModelMapper modelMapper;
    private final MemberRepository memberRepository;
    @Override
    public String register(MemberDTO memberDTO) {
        Member member = modelMapper.map(memberDTO, Member.class);
        memberRepository.save(member);
        return null;
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
