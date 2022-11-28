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
    private Long teamBoardNum;

    @Column(length = 20, nullable = false)
    private String id;

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

    @ManyToOne
    @JoinColumn(name="team_Num")
    private Member member;


}
