package net.manager.iym.service;

import net.manager.iym.dto.ScheduleDTO;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.validation.Errors;

import java.util.List;
import java.util.Map;

public interface ScheduleService {
    JSONArray getJsonArray(Long teamNum);
    void register (ScheduleDTO scheduleDTO);
    JSONObject readOne(Long scheduleNum);
    void modify(ScheduleDTO scheduleDTO);
    void remove(Long ScheduleNum);

}
