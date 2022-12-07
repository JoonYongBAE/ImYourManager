package net.manager.iym.repository;

import net.manager.iym.domain.NoticeBoard;
import net.manager.iym.repository.search.BoardSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

// JpaRepository<Entity클래스,PK타입>을 상속받으면 기본 CRUD 메소드가 자동 생성
public interface NoticeBoardRepository extends JpaRepository<NoticeBoard, Long>, BoardSearch {

    @EntityGraph(attributePaths = {"imageSet"})
    @Query("select b from NoticeBoard b where b.noticeboardNum =:noticeboardNum")
    Optional<NoticeBoard> findById(Long noticeboardNum);

}
