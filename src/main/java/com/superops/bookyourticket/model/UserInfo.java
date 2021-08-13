package com.superops.bookyourticket.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "USER_INFO", uniqueConstraints = {@UniqueConstraint(columnNames = {"EMAIL_ID"})})
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private long userId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL_ID")
    private String emailId;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "USER_ROLE")
    private String userRole;

    @Column(name = "USER_STATUS")
    private String userStatus;

    @Column(name = "CREATED_AT")
    @CreationTimestamp
    private Date createAt;

    @Column(name = "UPDATED_AT")
    @UpdateTimestamp
    private Date updatedAt;

    @Override
    public String toString() {
        return "{\"UserInfo\":{"
                + "\"userId\":\"" + userId + "\""
                + ", \"firstName\":\"" + firstName + "\""
                + ", \"lastName\":\"" + lastName + "\""
                + ", \"emailId\":\"" + emailId + "\""
                + ", \"phoneNumber\":\"" + phoneNumber + "\""
                + ", \"password\":\"" + password + "\""
                + ", \"userRole\":\"" + userRole + "\""
                + ", \"userStatus\":\"" + userStatus + "\""
                + ", \"createAt\":" + createAt
                + ", \"updatedAt\":" + updatedAt
                + "}}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return userId == userInfo.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
