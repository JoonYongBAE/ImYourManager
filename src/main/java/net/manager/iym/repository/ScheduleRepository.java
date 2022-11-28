package net.manager.iym.repository;

import net.manager.iym.domain.Schedule;
import net.manager.iym.dto.MemberDTO;
import net.manager.iym.dto.ScheduleDTO;
import net.manager.iym.dto.TeamDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
