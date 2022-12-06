//package net.manager.iym.repository;
//
//import com.querydsl.core.QueryResults;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import net.manager.iym.domain.JoinBoard;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//
//import java.util.List;
//
//import static net.manager.iym.domain.QJoinBoard.joinBoard;
//import static net.manager.iym.domain.QMember.member;
//
//@Repository
public class JoinBoardQueryRepository {
//
//    private final EntityManager entityManager;
//    private final JPAQueryFactory queryFactory;
//
//
//    public JoinBoardQueryRepository(EntityManager entityManager) {
//        this.entityManager = entityManager;
//        this.queryFactory = new JPAQueryFactory(entityManager);
//    }
//    public Page<JoinBoard> getJoinBoardList(Pageable pageable) {
//        QueryResults<JoinBoard> results = queryFactory
//                .selectFrom(joinBoard).leftJoin(joinBoard.member, member).fetchJoin()
//                .offset(pageable.getOffset())
//                .limit(pageable.getOffset()).orderBy(joinBoard.joinBoardNum.desc())
//                .fetchResults();
//
//        List<JoinBoard> content = results.getResults();
//        Long total = results.getTotal();
//
//        return new PageImpl<>(content, pageable, total);//Page<>형식의 return이다.
//    }
}
