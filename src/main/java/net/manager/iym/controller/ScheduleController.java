package net.manager.iym.controller;


import lombok.RequiredArgsConstructor;
import net.manager.iym.domain.MemberGrade;
import net.manager.iym.dto.ScheduleDTO;
import net.manager.iym.service.ScheduleService;
import net.manager.iym.service.TeamService;
import net.manager.iym.service.Validate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RequestMapping("/schedule")
@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final Validate validate;

    @PreAuthorize("hasRole('TEAMLEADER')")
    @GetMapping("/addSchedule")
    public String newSchedule(@Valid ScheduleDTO scheduleDTO, Errors errors, Model model) {


        if (errors.hasErrors()) {

            //유효성 검사에 통과해지 못해도 입력 데이터값을 유지
            model.addAttribute("scheduleDTO", scheduleDTO);

            //유효성 검사 통과하지 못한 항목과 메세지 출력
            Map<String, String> validResult = validate.validateHandling(errors);
            for (String key : validResult.keySet()) {
                model.addAttribute(key, validResult.get(key));
            }
            return "schedule/addScheduleForm";
        }
        return "redirect:schedule/schedule_main";
    }
}
