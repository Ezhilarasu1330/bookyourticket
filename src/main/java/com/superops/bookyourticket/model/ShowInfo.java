package com.superops.bookyourticket.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "SHOW_INFO")
public class ShowInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SHOW_ID")
    private long showId;

    @OneToOne
    @JoinColumn(name = "SCREEN_ID", referencedColumnName = "SCREEN_ID")
    private ScreenInfo screenInfo;

    @OneToOne
    @JoinColumn(name = "MOVIE_ID", referencedColumnName = "MOVIE_ID")
    private MovieInfo movieInfo;

    @Column(name = "SHOW_START_TIME")
    private Date showStartTime;

    @Column(name = "SHOW_END_TIME")
    private Date showEndTime;

    @OneToMany(mappedBy = "showInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = BookedSeatInfo.class)
    @Fetch(FetchMode.SUBSELECT)
    @JsonBackReference
    private List<BookedSeatInfo> bookedSeatInfos;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CREATED_AT")
    @CreationTimestamp
    private Date createAt;

    @Column(name = "UPDATED_AT")
    @UpdateTimestamp
    private Date updatedAt;
}
