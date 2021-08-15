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
@Table(name = "BOOKING_INFO")
public class BookingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOKING_ID")
    private long bookingId;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private UserInfo userInfo;

    @OneToOne
    @JoinColumn(name = "SHOW_ID", referencedColumnName = "SHOW_ID")
    private ShowInfo showInfo;

    @OneToMany(mappedBy = "bookingInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = BookedSeatInfo.class)
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
