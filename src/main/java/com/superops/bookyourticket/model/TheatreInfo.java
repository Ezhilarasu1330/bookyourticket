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
@Table(name = "THEATRE_INFO")
public class TheatreInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "THEATRE_ID")
    private long theatreId;

    @Column(name = "THEATRE_NAME")
    private String theatreName;

    @Column(name = "LOCATION")
    private String theatreLoc;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CREATED_AT")
    @CreationTimestamp
    private Date createAt;

    @Column(name = "UPDATED_AT")
    @UpdateTimestamp
    private Date updatedAt;
}
