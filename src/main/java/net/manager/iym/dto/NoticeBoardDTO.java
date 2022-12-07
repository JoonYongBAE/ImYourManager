package net.manager.iym.dto;

import lombok.*;
import net.manager.iym.domain.NoticeBoard;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자
public class NoticeBoardDTO {
    private Long noticeboardNum;
    @Size(min = 3, max = 100)
    private String title;
    private String content;

    private String id;

    private LocalDateTime regDate;

    private LocalDateTime modDate;

    //첨부파일의 이름들
    private List<String> fileNames;

}