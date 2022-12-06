package net.manager.iym.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JoinBoardListAllDTO {


        private Long joinBoardNum;
        private String joinType;
        private String joinTitle;
        private String id;
        private LocalDateTime regDate;
}
