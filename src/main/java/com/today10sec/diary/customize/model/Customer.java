package com.today10sec.diary.customize.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Customer {
    @Id @GeneratedValue
    private Integer id;
    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "customer")
    private List<Diary> diaryList;

    /**
     * EmailVerifiedAt When confirm Email
     *
     * null is not invalidated
     */
    @Column(name = "EMAIL_VERIFIED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    @Nullable
    private Date EmailVerifiedAt;

    @Column(name = "LAST_LOGIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;

    @Column(name = "CREATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(name = "UPDATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt = new Date();

    private Boolean isUsed;

    public Customer() {
    }

    public Customer(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
}
