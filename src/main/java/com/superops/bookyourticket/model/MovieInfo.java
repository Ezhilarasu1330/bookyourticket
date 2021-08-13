package com.superops.bookyourticket.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "MOVIE_INFO")
public class MovieInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID")
    private long movieId;

    @Column(name = "MOVIE_NAME")
    private String movieName;

    @Column(name = "LANGUAGE")
    private String language;

    @Column(name = "RELEASED_DATE")
    private Date releasedDate;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CREATED_AT")
    @CreationTimestamp
    private Date createAt;

    @Column(name = "UPDATED_AT")
    @UpdateTimestamp
    private Date updatedAt;
}
