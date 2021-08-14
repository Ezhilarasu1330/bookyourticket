package com.superops.bookyourticket.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "BOOKED_SEATS_INFO")
public class BookedSeatInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOKED_SEATS_ID")
    private long bookedSeatId;

    @OneToOne(mappedBy = "showInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ShowInfo.class)
    @JoinColumn(name = "SHOW_ID", referencedColumnName = "SHOW_ID")
    private ShowInfo showInfo;

//    @OneToMany
//    @JoinColumn(name = "SCREEN_ID", referencedColumnName = "SCREEN_ID")
//    private ScreenInfo screenInfo;

    /*
    @OneToMany
    @JoinColumn(name = "SCREEN_SEAT_ID", referencedColumnName = "SCREEN_SEAT_ID")
    private ScreenSeatInfo screenSeatInfo;
    */

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CREATED_AT")
    @CreationTimestamp
    private Date createAt;

    @Column(name = "UPDATED_AT")
    @UpdateTimestamp
    private Date updatedAt;
}
