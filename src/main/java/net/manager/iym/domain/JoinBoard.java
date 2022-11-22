package net.manager.iym.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JoinBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long joinBoardNum;

    @Column(length = 20, nullable = false)
    private String id;

    @Column(length = 100, nullable = false)
    private String joinTitle;

    @Column(length = 3000, nullable = false)
    private String joinContent;

    @Column(length = 30, nullable = false)
    private String grade;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String joinType;

    @Column(length = 3000)
    private String joinFile;

    @Column(columnDefinition = "long default 0", nullable = false)
    private Long joinVisitCount;

    @ManyToOne
    @JoinColumn(name="id")
    private Member member;


}