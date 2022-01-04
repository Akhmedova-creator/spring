package ru.otus.spring.spring_data.domain;

import liquibase.pro.packaged.B;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Repository
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "comments")
@Data
@Table(name = "comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment_name")
    private String commentName;

    @Column(name = "comment_data")
    private LocalDate commentData;

    @ManyToOne(targetEntity = Books.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "bookid")
    private Books books;

    public Comments(String commentName, LocalDate commentData) {
        this.commentName = commentName;
        this.commentData = commentData;
    }
}

