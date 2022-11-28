package net.manager.iym.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    @JoinColumn(name="id")
    private Member member;

    @Column(nullable = false)
    private Long teamNum;

    @Column(length = 50, nullable = false)
    private String ground;

    @Column(length = 20, nullable = false)
    private String playType;

    @Column(length = 30, nullable = false)  // Date 체크필요
    private Date scheduleTime;
}
