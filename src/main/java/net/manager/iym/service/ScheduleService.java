package net.manager.iym.service;

import net.manager.iym.dto.ScheduleDTO;
import org.springframework.validation.Errors;

import java.util.Map;

public interface ScheduleService {
    Long register (ScheduleDTO scheduleDTO);


}
