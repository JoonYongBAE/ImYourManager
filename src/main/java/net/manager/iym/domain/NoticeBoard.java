package net.manager.iym.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NoticeBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long noticeBoardNum;

    @Column(length = 20, nullable = false)
    private String id;

    @Column(length = 100, nullable = false)
    private String noticeTitle;

    @Column(length = 3000, nullable = false)
    private String noticeContent;

    @Column(length = 30, nullable = false)
    private String grade;

    @Column(columnDefinition = "long default 0", nullable = false)
    private Long noticeVisitCount;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 3000)
    private String noticeFile;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;



}
