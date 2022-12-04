package net.manager.iym.controller;


import net.manager.iym.domain.MemberGrade;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/schedule")
@Controller
public class ScheduleController {

    @PreAuthorize("hasRole('TEAMLEADER')")
    @GetMapping("/add-schedule")
    public String newSchedule(){
        return "schedule/addScheduleForm";
    }
}
