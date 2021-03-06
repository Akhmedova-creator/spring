package ru.otus.spring.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.otus.spring.domain.Books;
import ru.otus.spring.domain.Comments;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BooksDaoRepositoriesJPAImpl implements BooksDaoRepositoriesJPA {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Integer count() {
        TypedQuery<Books> query = em.createQuery("select b from books b",
                Books.class);
        return query.getResultList().size();

    }

    @Override
    public Books insert(Books book) {
        if (book.getId() == null) {
            em.persist(book);
            return book;
        } else
            return em.merge(book);
    }

    @Override
    public Optional<Books> findById(Long id) {
        return Optional.ofNullable(em.find(Books.class,
                id));
    }

    @Override
    public void deleteById(long id) {
        em.remove(em.find(Books.class,
                id));
    }

    @Override
    public void updateNameById(long id, String name) {
        Books books = em.find(Books.class,
                id);
        books.setTitle(name);
        insert(books);
    }

}

