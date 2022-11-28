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
    private Long scheduleNum;

    @Column(nullable = false)
    private Long teamNum;

    @Column(length = 30, nullable = false)
    private String grade;

    @Column(length = 50, nullable = false)
    private String ground;

    @Column(length = 20, nullable = false)
    private String playType;

    @Column(length = 30, nullable = false)  // Date 체크필요
    private Date scheduleTime;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String id;



    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;
}
