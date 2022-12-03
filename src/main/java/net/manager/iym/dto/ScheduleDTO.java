package net.manager.iym.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@ToString
@Data
@Builder
@NoArgsConstructor
@Getter
public class ScheduleDTO{

    private String s_num; //일정번호

    @NotEmpty
    private String id; //아이디

    @NotEmpty
    private String t_num; //팀번호

    @NotEmpty(message = "경기 날짜를 입력해주세요.")
    private String s_date; //일정날짜

    @NotEmpty(message = "경기 장소를 입력해주세요.")
    private String ground; //일정지역

    @NotEmpty(message = "경기 유형을 입력해주세요.")
    private String p_type; //일정경기유형

    private String vote; //일정참가여부

    private String name; //이름
}