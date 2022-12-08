package net.manager.iym.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamDTO {

    private Long teamNum;
    private String id;
    private String teamName;
    private String teamAge;
    private String teamType;
    private String teamLocal;
    private String teamLevel;
    private String teamInfo;

}
