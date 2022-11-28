package net.manager.iym.repository;

import net.manager.iym.domain.JoinBoard;
import net.manager.iym.domain.NoticeBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeBoardRepository extends JpaRepository<NoticeBoard, Long> {
}
