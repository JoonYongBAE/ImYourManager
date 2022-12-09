package net.manager.iym.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teamNum")
    private Long teamNum;

    @Column(nullable = false)
    private String id;

    @Column(length = 20, nullable = false)
    private String teamName;

    @Column(length = 20, nullable = false)
    private String teamAge;

    @Column(length = 30, nullable = false)
    private String teamType;

    @Column(length = 50, nullable = false)
    private String teamLocal;

    @Column(length = 20, nullable = false)
    private String teamLevel;

    @Column(length = 200)
    private String teamInfo;



}
