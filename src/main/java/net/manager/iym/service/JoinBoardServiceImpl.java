package net.manager.iym.service;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.manager.iym.domain.JoinBoard;
import net.manager.iym.domain.Member;
import net.manager.iym.dto.JoinBoardDTO;
import net.manager.iym.dto.paging.PageRequestDTO;
import net.manager.iym.dto.paging.PageResponseDTO;
import net.manager.iym.repository.JoinBoardRepository;
import net.manager.iym.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service //자동으로 빈을 만들어주고 service 클래스라는것을 표현한다.
@Log4j2 //콘솔창에 설정한 정보들을 출력해준다
@RequiredArgsConstructor//final을 사용한 객체들을 이 클래스에 자동으로 의존주입을 해준다.
@Transactional //이 클래스를 실행하는 중에 오류가 생기면 처음으로 되돌려준다.
public class JoinBoardServiceImpl implements JoinBoardService {
    //@RequiredArgsConstructor에 의해서 자동으로 생성자가 주입된다.
    private final ModelMapper modelMapper;
    private final JoinBoardRepository joinBoardRepository;

    private final MemberRepository memberRepository;
    @Override
    public Long register(JoinBoardDTO joinBoardDTO) {
        Member member = memberRepository.findMemberById(joinBoardDTO.getId());
        JoinBoard joinBoard = dtoToEntity(joinBoardDTO);
        joinBoard.setMember(member);
        Long joinBoardNum = joinBoardRepository.save(joinBoard).getJoinBoardNum();//JPA를 사용하여 테이블에 값을 넣어주고 번호를 붙여준다.
        return joinBoardNum;
    }

    @Override
    public JoinBoardDTO readOne(Long joinBoardNum) {


        return null;
    }

    @Override
    public void modify(JoinBoardDTO joinBoardDTO) {

    }

    @Override
    public void remove(Long joinBoardNum) {


    }


    public PageResponseDTO<JoinBoardDTO> list(PageRequestDTO pageRequestDTO) {
        return null;
    }


}
//    public List<JoinBoardDTO> getList(){
//        List<JoinBoardDTO> allList = joinBoardRepository.findAll().stream()
//                .map(vo ->modelMapper.map(vo, JoinBoardDTO.class))
//                .collect(Collectors.toList());
//        return allList;
//        //매퍼를 통해서 findAll()을 통해서 나온 정보들은 각각 다른 TodoVO들이기 때문에
//        //이 각각의 정보들을 vo를 DTO로 변환시켜 묶어준다.
//        //List<TodoVO>를 List<TodoDTO>로 변환하는 작업을 stream을 이용하여 각 TodoVO는
//        //map()을 통해서 TodoDTO로 바꾸고 collect()을 이용하여 List<TodoDTO>로 묶어준다.
//    }

