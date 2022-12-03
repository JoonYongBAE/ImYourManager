package net.manager.iym.dto;

import lombok.*;
import net.manager.iym.domain.Team;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TeamDTO {

    private Long teamNum;

    @NotBlank(message = "팀이름은 필수 입력사항 입니다.")
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-zA-Z0-9]+$", message = "팀이름은 한글과 영문자, 숫자만 사용가능합니다.(공백미포함)")
    @Length(min = 1, max= 10, message = "팀이름은 1글자 이상, 10글자이하 이어야 합니다.")
    private String teamName;

    @NotEmpty(message = "연령대를 선택해주세요.")
    private String teamAge;

    @NotEmpty(message = "팀의 타입을 선택해주세요.")
    private String teamType;

    @NotEmpty(message = "팀의 주 활동 지역을 선택해주세요.")
    private String teamLocal;

    @NotEmpty(message = "팀의 실력을 선택해주세요")
    private String teamLevel;

    private String teamInfo;
    private String teamLogo;


    // repository를 통해 조회한 Team Entity를 dto로 변환하는 용도.
    public TeamDTO(Team team){
    }
}
