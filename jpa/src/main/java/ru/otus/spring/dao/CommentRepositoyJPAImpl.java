package ru.otus.spring.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.otus.spring.domain.Books;
import ru.otus.spring.domain.Comments;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CommentRepositoyJPAImpl implements CommentRepositoryJPA {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Comments> findAllCommentsByBook(String booksName) {
        Session session = em.unwrap(Session.class);
        CriteriaBuilder builder =em.getEntityManagerFactory().getCriteriaBuilder();
        CriteriaQuery<Comments> queryComments = builder.createQuery(Comments.class);

        Root<Comments> rootComments = queryComments.from(Comments.class);
        Join<Comments, Books> commentByBook =rootComments.join("books");

        queryComments.select(rootComments);

        queryComments.where(builder.equal(commentByBook.get("title"),booksName));

        Query<Comments> q=session.createQuery(queryComments);
        return q.getResultList();
    }
}
