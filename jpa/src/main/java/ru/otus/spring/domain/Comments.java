package ru.otus.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
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


    public Comments(String commentName, LocalDate commentData) {
        this.commentName = commentName;
        this.commentData = commentData;
    }
}

