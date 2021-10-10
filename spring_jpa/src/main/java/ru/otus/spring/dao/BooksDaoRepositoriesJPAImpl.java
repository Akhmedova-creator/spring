package ru.otus.spring.dao;

import org.springframework.stereotype.Repository;
import ru.otus.spring.domain.Books;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

/**
 * Репозиторий, в котором есть методы для работв с БД
 */
@Repository
public class BooksDaoRepositoriesJPAImpl implements BooksDaoRepositoriesJPA {

    @PersistenceContext
    private EntityManager em;

    /**
     * Возвращение количества книг
     * @return количество книг
     */
    @Override
    public Integer count() {
        TypedQuery<Books> query = em.createQuery("select b from Books b",
                Books.class);
        return query.getResultList().size();

    }

    /**
     * вставка в бд
     * @param book книгу,которую надо вставить
     * @return вставленную книгу
     */
    @Override
    public Books insert(Books book) {
        if (book.getId() == null) {
            em.persist(book);
            return book;
        } else
            return em.merge(book);
    }

    /**
     * поиск книги по ид
     * @param id принимает id, по которому осуществляется поиск
     * @return найденную в таблице книгу
     */
    @Override
    public Optional<Books> findById(Long id) {
        return Optional.ofNullable(em.find(Books.class,
                id));
    }

    /**
     * удаление по ид
     * @param id ид,по которому находит книгу и удаляет
     */
    @Override
    public void deleteById(long id) {
        em.remove(em.find(Books.class,
                id));
    }

    /**
     * получение списка книг
     * @return список всех книг
     */
    @Override
    public List<Books> getAll() {
        TypedQuery<Books> query = em.createQuery("select b from Books b join fetch b.authors ",
                Books.class);
        return query.getResultList();
    }

    /**
     * обновление книги
     * @param id ид книги,которую надо обновить
     * @param name наименование книги,на которую надо изменить
     */
    @Override
    public void updateNameById(long id, String name) {
        Books books = em.find(Books.class,
                id);
        books.setTitle(name);
        insert(books);
    }


}

