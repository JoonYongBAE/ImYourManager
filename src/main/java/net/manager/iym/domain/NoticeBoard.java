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
    @Column(name = "noticeBoardNum")
    private Long noticeBoardNum;

    @ManyToOne
    @JoinColumn(name="id")
    private Member member;

    @Column(length = 100, nullable = false)
    private String noticeTitle;

    @Column(length = 3000, nullable = false)
    private String noticeContent;

    @Column(length = 30, nullable = false)
    private String grade;

    @Column(columnDefinition = "long default 0", nullable = false)
    private Long noticeVisitCount;

    @Column(length = 3000)
    private String noticeFile;

}
