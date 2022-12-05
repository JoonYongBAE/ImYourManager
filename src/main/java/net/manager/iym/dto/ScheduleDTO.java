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
    private String scheduleNum; //일정번호

    @NotEmpty
    private String teamNum; //팀번호   스케줄 등록을 진행하는 회원의 정보에서 가져와서 동기화

    @NotEmpty(message = "경기 날짜를 입력해주세요.")
    private String scheduleDate; //일정날짜

    @NotEmpty(message = "시간을 입력해주세요.")
    private String scheduleTime;   //경기 시간

    @NotEmpty(message = "경기 장소를 입력해주세요.")
    private String ground; //일정지역

    @NotEmpty(message = "경기 유형을 입력해주세요.")
    private String playType; //일정경기유형

    private String vote; //일정참가여부

    private String name; //이름

}