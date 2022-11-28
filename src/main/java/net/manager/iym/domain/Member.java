package net.manager.iym.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private String id;

    @Column(length = 20, nullable = false)
    private String pass;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String mail;

    @Column(length = 30, nullable = false)
    private String phone;

    @Column(length = 10, nullable = false)
    private String gender;

    @Column(length = 50, nullable = false)
    private String memberLoc;

    @Column(length = 30, nullable = false)
    private String grade;

    @ManyToOne
    @JoinColumn(name = "team_Num")
    private Team team;

}
