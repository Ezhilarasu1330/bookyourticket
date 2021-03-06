package com.superops.bookyourticket.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "SHOW_ID", referencedColumnName = "SHOW_ID")
    private ShowInfo showInfo;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "SCREEN_SEAT_ID", referencedColumnName = "SCREEN_SEAT_ID")
    private ScreenSeatInfo screenSeatInfo;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "BOOKING_ID", referencedColumnName = "BOOKING_ID")
    private BookingInfo bookingInfo;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CREATED_AT")
    @CreationTimestamp
    private Date createAt;

    @Column(name = "UPDATED_AT")
    @UpdateTimestamp
    private Date updatedAt;
}
