package net.manager.iym.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TeamBoard {////

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teamBoardNum")
    private Long teamBoardNum;

    @ManyToOne
    @JoinColumn(name="id")
    private Member member;

    @Column(length = 100, nullable = false)
    private String teamBoardTitle;

    @Column(length = 3000, nullable = false)
    private String teamBoardContent;

    @Column(length = 30, nullable = false)
    private String grade;

    @Column(columnDefinition = "long default 0", nullable = false)
    private Long teamBoardVisitCount;

    @Column(length = 3000)
    private String teamBoardFile;
}
