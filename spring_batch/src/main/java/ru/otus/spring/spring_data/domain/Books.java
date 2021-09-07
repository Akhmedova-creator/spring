package ru.otus.spring.spring_data.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "books")
@Table(name = "books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @ManyToOne(targetEntity = Genre.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "genreid")
    private Genre genre;

    @ManyToOne(targetEntity = Authors.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "authorsid")
    private Authors authors;

    public Books(String title, Genre genre, Authors authors) {
        this.title = title;
        this.genre = genre;
        this.authors = authors;
    }
}


