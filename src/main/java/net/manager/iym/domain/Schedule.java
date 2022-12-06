package net.manager.iym.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "scheduleNum")
    private Long scheduleNum;
    @ManyToOne
    @JoinColumn(name="teamNum", nullable = false)
    private Team team;


    @Column(length = 200, nullable = false)
    private String ground;

    @Column(length = 20, nullable = false)
    private String playType;

    @Column(length = 30, nullable = false)
    private LocalDateTime scheduleDate;
    @Column(length = 30, nullable = false)  // Date 체크필요
    private LocalTime scheduleTime;
}
