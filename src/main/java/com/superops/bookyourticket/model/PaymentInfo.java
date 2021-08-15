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
@Table(name = "PAYMENT_INFO")
public class PaymentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAYMENT_ID")
    private long paymentId;

    @Column(name = "PAYMENT_METHOD")
    private String paymentMethod;

    @Column(name = "TRANSACTION_ID")
    private String transactionID;

    @Column(name = "PAYMENT_STATUS")
    private String paymentStatus;

    @Column(name = "DISCOUNT_COUPON_ID")
    private String discountCouponId;

    @OneToOne
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
