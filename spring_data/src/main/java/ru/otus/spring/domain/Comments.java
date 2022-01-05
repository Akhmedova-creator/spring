package ru.otus.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "comments")
@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment_name")
    private String commentName;

    @Column(name = "comment_data")
    private LocalDate commentData;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "bookid")
    private Books books;

    public Comments(String commentName, LocalDate commentData, Books books) {
        this.commentName = commentName;
        this.commentData = commentData;
        this.books = books;
    }

}

