package net.manager.iym.schedule;


import lombok.extern.log4j.Log4j2;

import net.manager.iym.dto.ScheduleDTO;
import net.manager.iym.repository.ScheduleRepository;
import net.manager.iym.service.ScheduleService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Log4j2
@SpringBootTest

public class scheduleRegister {
   @Autowired
    public ScheduleRepository scheduleRepository;
   @Autowired
   public ScheduleService scheduleService;

    @Test
    public void register(ScheduleDTO scheduleDTO){
             scheduleDTO.builder()
                .scheduleDate("2022-12-25")
                .scheduleStartTime("11:00")
                     .scheduleEndTime("12:00")
                     .ground("https://www.naver.com")
                     .playType("자체전")
                     .build();
             scheduleService.register(scheduleDTO);
             log.info(scheduleDTO);
    }
}
