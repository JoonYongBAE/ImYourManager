package net.manager.iym.controller;


import lombok.RequiredArgsConstructor;

import net.manager.iym.domain.Schedule;
import net.manager.iym.domain.Team;
import net.manager.iym.dto.ScheduleDTO;
import net.manager.iym.repository.ScheduleRepository;
import net.manager.iym.service.ScheduleService;
import net.manager.iym.service.Validate;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final Validate validate;
    private final ScheduleRepository scheduleRepository;
    private final Team team;

    @GetMapping(value = "/schedule_main")   //팀페이지에서 경기일정 눌렀을 때
    @ResponseBody
    public JSONArray scheduleMain(){
         JSONArray list = scheduleService.getJsonArray(team.getTeamNum());
         return list;  // json array로 내보내기.
    }
    @PreAuthorize("hasRole('TEAMLEADER')")    @PostMapping("/addSchedule")
    public String newSchedule(@RequestBody @Valid ScheduleDTO scheduleDTO, Errors errors, Model model) {

        if (errors.hasErrors()) {
            //유효성 검사에 통과해지 못해도 입력 데이터값을 유지
            model.addAttribute("scheduleDTO", scheduleDTO);

            //유효성 검사 통과하지 못한 항목과 메세지 출력
            Map<String, String> validResult = validate.validateHandling(errors);
            for (String key : validResult.keySet()) {
                model.addAttribute(key, validResult.get(key));
            }

            return "schedule/addScheduleForm";   // 통과하지 못하면 다시 폼으로
        }
        scheduleService.register(scheduleDTO);

        return "redirect:schedule/schedule_main"; // 등록성공하면 메인페이지로 이동.
    }
//    @GetMapping("/readOne/{teamNum}/{scheduleNum}")
//    public ResponseEntity<ScheduleDTO> selectOne(@RequestBody Long scheduleNum){
//Optional<Schedule> selectSchedule= scheduleRepository.findById(scheduleNum);
//
//    }


}
