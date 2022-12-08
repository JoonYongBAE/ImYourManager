package net.manager.iym.repository;

import net.manager.iym.domain.NoticeBoard;
import net.manager.iym.repository.search.NoticeBoardSearch;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface NoticeBoardRepository extends JpaRepository<NoticeBoard, Long>, NoticeBoardSearch {
    @EntityGraph(attributePaths = {"imageSet"})
    @Query("select b from NoticeBoard b where b.noticeBoardNum =:noticeBoardNum")
    Optional<NoticeBoard> findById(Long noticeBoardNum);

}
