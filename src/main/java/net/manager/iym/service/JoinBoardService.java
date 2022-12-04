package net.manager.iym.service;

import net.manager.iym.domain.JoinBoard;
import net.manager.iym.domain.Member;
import net.manager.iym.dto.JoinBoardDTO;
import net.manager.iym.dto.paging.PageRequestDTO;
import net.manager.iym.dto.paging.PageResponseDTO;

public interface JoinBoardService {

    Long register(JoinBoardDTO joinBoardDTO);//조인보드게시글 등록 메소드 오버라이드

    JoinBoardDTO readOne(Long joinBoardNum);//조인보드게시글 확인 메소드 오버라이드

    void modify(JoinBoardDTO joinBoardDto);//조인보드게시글 수정 메소드 오버라이드

    void remove(Long joinBoardNum);//조인보드게시글 삭제 메소드 오버라이드

    PageResponseDTO<JoinBoardDTO> list(PageRequestDTO pageRequestDTO);// 조인보드게시글리스트 출력 메소드 오버라이드

    default JoinBoard dtoToEntity(JoinBoardDTO joinBoardDTO){//defalut를 써서 implement한 클래스도 사용가능
        //dto를 Entity로 매핑해주는 작업을 함

        JoinBoard joinBoard = JoinBoard.builder().joinBoardNum(joinBoardDTO.getJoinBoardNum())
                .joinTitle(joinBoardDTO.getJoinTitle()).joinContent(joinBoardDTO.getJoinContent())
                .joinFile(joinBoardDTO.getJoinFile()).joinVisitCount(joinBoardDTO.getJoinVisitCount())
                .joinType(joinBoardDTO.getJoinType()).build();
        return  joinBoard;
        //dto에서 id값을 가져와서 찾은다음에 memeber에 넣어주기
    }
    default JoinBoardDTO EntityToDto(JoinBoard joinBoard){
        JoinBoardDTO joinBoardDTO = JoinBoardDTO.builder().joinBoardNum(joinBoard.getJoinBoardNum())
                .joinTitle(joinBoard.getJoinTitle()).joinContent(joinBoard.getJoinContent())
                .joinFile(joinBoard.getJoinFile()).joinVisitCount(joinBoard.getJoinVisitCount())
                .joinType(joinBoard.getJoinType()).build();//이름
        return joinBoardDTO;
        //멤버에서 아이디 값과 이름을 뽑아서 출력해주기
    }
}
