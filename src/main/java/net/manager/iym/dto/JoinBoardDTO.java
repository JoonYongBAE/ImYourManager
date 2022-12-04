package net.manager.iym.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JoinBoardDTO {//Entity에서 필요한 필드값들을 받아와 get,set을 통해 출력을 해주거나 받은 DTO 값들을 Entity로 보내준다.

    @NotEmpty
    private Long joinBoardNum;
    //@NotEmpty
    @Size(min = 1, max = 100)
    private String joinTitle;
    //@NotEmpty
    private String joinContent;
    //@NotEmpty
    private String name;
    //@NotEmpty
    private String id;
    //@NotEmpty
    private String joinType;
    //@NotEmpty
    private Long joinVisitCount;

    private String joinFile;
    //@NotEmpty
    private LocalDateTime regDate;

}

