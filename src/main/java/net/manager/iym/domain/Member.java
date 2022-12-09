package net.manager.iym.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Member extends CommonEntity{//

    @Id
    private String id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "teamNum")
    private Team team;

    @Column(nullable = false)
    private String pass;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String mail;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String memberLoc;

    @ElementCollection(fetch = FetchType.EAGER)//
    @Builder.Default
    private Set<MemberGrade> gradeSet = new HashSet<>();

    public void changeTeam(Team team) {
        this.team = team;
    }

    public void addGrade(MemberGrade memberGrade){
        this.gradeSet.add(memberGrade);
    }

    public void change(String pass, String mail, String phone, String memberLoc){
        this.pass = pass;
        this.mail = mail;
        this.phone = phone;
        this.memberLoc = memberLoc;
    }

}

