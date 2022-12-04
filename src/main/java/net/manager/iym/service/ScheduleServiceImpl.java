package net.manager.iym.service;

import lombok.RequiredArgsConstructor;
import net.manager.iym.domain.Schedule;
import net.manager.iym.dto.ScheduleDTO;
import net.manager.iym.repository.ScheduleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService{
    private final ModelMapper modelMapper;
    private final ScheduleRepository scheduleRepository;
    @Override
    public Long register(ScheduleDTO scheduleDTO) {
        Schedule schedule = modelMapper.map(scheduleDTO, Schedule.class);
        Optional<Schedule> schedule1 = scheduleRepository.findById(schedule.getTeamNum());

        return null;
    }
}
