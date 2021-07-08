package ru.otus.spring.dao;

import org.springframework.stereotype.Repository;
import ru.otus.spring.domain.Books;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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

    @Override
    public List<Books> findAll() {
        return em.createQuery("select distinct b from books b left join fetch b.comments ",
                Books.class)
                .getResultList();

    }
}

