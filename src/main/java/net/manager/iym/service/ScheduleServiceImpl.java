package net.manager.iym.service;

import lombok.RequiredArgsConstructor;
import net.manager.iym.domain.Schedule;
import net.manager.iym.dto.ScheduleDTO;
import net.manager.iym.repository.ScheduleRepository;
import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.time.LocalTime;

import java.util.HashMap;

import java.util.Optional;



@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService{
//    private final ModelMapper modelMapper;

    private final ScheduleRepository scheduleRepository;
    @Override
    public JSONArray register(ScheduleDTO scheduleDTO) {

        Schedule schedule = Schedule.builder()
                .scheduleDate(LocalDateTime.parse(scheduleDTO.getScheduleDate()))
                .scheduleTime(LocalTime.parse(scheduleDTO.getScheduleStartTime().concat(scheduleDTO.getScheduleEndTime())))
                .ground(scheduleDTO.getGround())
                .playType(scheduleDTO.getPlayType())
                .build();    //스케줄 등록 폼에서 입력받은 값을  schedule 객체에 담기.
        scheduleRepository.save(schedule);    // entity 에 저장.

        HashMap<String, String> info = new HashMap<>(); // Map 타입의 info 객체
        JSONObject daily = new JSONObject(info);    // JSONObject 타입의 daily 객체
        JSONArray list = new JSONArray();  //JSONObject를 배열로 저장할 JSONArray 타입의 list 객체
        info.put("id", schedule.getScheduleNum().toString());
        info.put("date",scheduleDTO.getScheduleDate());
        info.put("startTime", scheduleDTO.getScheduleStartTime());
        info.put("endTime", scheduleDTO.getScheduleEndTime());
        info.put("url",scheduleDTO.getGround());
        info.put("type",scheduleDTO.getPlayType());

        list.put(daily);
        return list;
    }

    @Override
    public JSONObject readOne(Long scheduleNum) {

        return null;
    }

    @Override
    public JSONArray modify(ScheduleDTO scheduleDTO) {
        Schedule schedule = Schedule.builder()
                .scheduleDate(LocalDateTime.parse(scheduleDTO.getScheduleDate()))
                .scheduleTime(LocalTime.parse(scheduleDTO.getScheduleStartTime().concat(scheduleDTO.getScheduleEndTime())))
                .ground(scheduleDTO.getGround())
                .playType(scheduleDTO.getPlayType())
                .build();
        scheduleRepository.save(schedule);
        HashMap<String, String> info = new HashMap<>();
        JSONObject daily = new JSONObject(info);
        JSONArray list = new JSONArray();
        info.put("id", schedule.getScheduleNum().toString());
        info.put("date",scheduleDTO.getScheduleDate());
        info.put("startTime", scheduleDTO.getScheduleStartTime());
        info.put("endTime", scheduleDTO.getScheduleEndTime());
        info.put("url",scheduleDTO.getGround());
        info.put("type",scheduleDTO.getPlayType());
        list.put(daily);
        return list;
    }

    @Override
    public void remove(Long scheduleNum) {
       Optional<Schedule> schedule1 = scheduleRepository.findById(scheduleNum);
       scheduleRepository.delete(schedule1);

    }


}
