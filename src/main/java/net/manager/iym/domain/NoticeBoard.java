package net.manager.iym.domain;

import lombok.*;
import net.manager.iym.dto.NoticeBoardDTO;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// domain은 DB와 밀접한, 중요한 entity 클래스
// 한번 정의된 객체들의 내용이 그대로 유지되어야 함, 사용자에 의해서 변하면 안됨, 그렇기떄문에 dto를 사용함

// DB의 테이블 역할을 하는 클래스
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@ToString(exclude = "imageSet")
public class NoticeBoard extends CommonEntity{

    @Id // pk 컬럼 지정. 필수
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long noticeboardNum;

    @ManyToOne
    @JoinColumn(name="id")
    private Member member;

    @Column(length = 20, nullable = false) // 크기 20, not null
    private String writer;

    @Column
    private String title;

    @Column(length = 500)
    private String content;

    public void addMember(Member member){ //홈페이지에서 멤버값을 받아 조인게시글 멤버컬럼에 삽입시 사용
        this.member = member;
    }

    public void change(String title, String content){
        this.title = title;
        this.content = content;
    }


//    @OneToMany(mappedBy = "noticeBoard",
//            cascade = {CascadeType.ALL},
//            fetch = FetchType.LAZY,
//            orphanRemoval = true)
//    @Builder.Default
//    @BatchSize(size = 20)
//    private Set<BoardImage> imageSet = new HashSet<>();
//
//    public void addImage(String uuid, String fileName){
//
//        BoardImage boardImage = BoardImage.builder()
//                .uuid(uuid)
//                .fileName(fileName)
//                .noticeBoard(this)
//                .ord(imageSet.size())
//                .build();
//        imageSet.add(boardImage);
//    }

//    public void clearImages() {
//
//        imageSet.forEach(boardImage -> boardImage.changeBoard(null));
//
//        this.imageSet.clear();
//    }

}
