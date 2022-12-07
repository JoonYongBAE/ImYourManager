package net.manager.iym.repository.search;

import net.manager.iym.domain.NoticeBoard;
import net.manager.iym.dto.BoardListAllDTO;
import net.manager.iym.dto.BoardListReplyCountDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardSearch {
    Page<NoticeBoard> search1(Pageable pageable);

    Page<NoticeBoard> searchAll(String[] types, String keyword, Pageable pageable);

    Page<BoardListReplyCountDTO> searchWithReplyCount(String[] types,
                                                      String keyword,
                                                      Pageable pageable);

    Page<BoardListAllDTO> searchWithAll(String[] types,
                                        String keyword,
                                        Pageable pageable);
}
