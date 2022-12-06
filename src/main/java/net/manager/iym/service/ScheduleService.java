package net.manager.iym.service;

import net.manager.iym.dto.ScheduleDTO;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.validation.Errors;

import java.util.Map;

public interface ScheduleService {
    JSONArray register (ScheduleDTO scheduleDTO);
    JSONObject readOne(Long scheduleNum);
    JSONArray modify(ScheduleDTO scheduleDTO);
    void remove(Long ScheduleNum);

}
