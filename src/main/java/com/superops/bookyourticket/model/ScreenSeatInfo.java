package com.superops.bookyourticket.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "SCREEN_SEAT_INFO")
public class ScreenSeatInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SCREEN_SEAT_ID")
    private long screenSeatId;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "SCREEN_ID", referencedColumnName = "SCREEN_ID")
    private ScreenInfo screenInfo;

    @Column(name = "SEAT_NUMBER")
    private String seatNumber;

    @OneToMany(mappedBy = "screenSeatInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = BookedSeatInfo.class)
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
