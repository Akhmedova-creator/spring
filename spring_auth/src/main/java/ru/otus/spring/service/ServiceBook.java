package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.security.acls.model.MutableAcl;
import org.springframework.security.acls.model.MutableAclService;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.acls.model.Sid;
import org.springframework.stereotype.Service;
import ru.otus.spring.domain.Book;
import ru.otus.spring.repository.BookRepository;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

@Service
public class ServiceBook {

    @Autowired
    protected MutableAclService mutableAclService;

    @Autowired
    private BookRepository bookRepository;

    public Book add(Book book) {

        BigInteger id = new BigInteger(Long.toString(bookRepository.count() + 1));
        ObjectIdentity oid = new ObjectIdentityImpl(Book.class,
                (id));
        final Sid admin = new PrincipalSid("admin");

        MutableAcl acl = mutableAclService.createAcl(oid);
        acl.insertAce(acl.getEntries().size(),
                BasePermission.READ,
                admin,
                true);
        mutableAclService.updateAcl(acl);

        return bookRepository.save(book);
    }

    @Transactional
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    @Transactional
    public Book findBookById(Long id) {
        return bookRepository.getById(id);
    }
}