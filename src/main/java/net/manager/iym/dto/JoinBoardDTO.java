package net.manager.iym.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JoinBoardDTO{

    @NotEmpty
    private Long joinBoardNum;
    @NotEmpty
    @Size(min = 1, max = 100)
    private String joinTitle;
    @NotEmpty
    private String joinContent;
    @NotEmpty
    private String id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String joinType;
    @NotEmpty
    private int grade;

    private int joinCount;
    private LocalDate joinDate;
    private String joinFile;

}

