package net.manager.iym.repository;

import net.manager.iym.domain.JoinBoard;
import net.manager.iym.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
