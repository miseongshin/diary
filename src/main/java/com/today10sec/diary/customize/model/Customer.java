package com.today10sec.diary.customize.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer implements Serializable {

    public static final long serialVersionUID = 10002L;

    @Id @GeneratedValue
    private Integer id;
    @Nullable
    @Length(min = 1, max = 100)
    private String nick_name;

    @NotNull
    @Length(max=320)
    @Email
    private String email;

    @NotNull
    @Length(min= 6, max= 12)
    private String password;

    @Nullable
    @OneToMany(mappedBy = "customer")
    private List<Diary> diaryList;

    /**
     * [TODO]
     * EmailVerifiedAt When confirm Email
     * null is not invalidated
     */
    @Column(name = "EMAIL_VERIFIED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    @Nullable
    private Date EmailVerifiedAt;

    @Nullable
    @Column(name = "LAST_LOGIN")
    private Date lastLogin;

    @Column(name = "CREATED_AT")
    @CreatedDate
    private Date createdAt;

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    private Date updatedAt = new Date();

    private Boolean isWithdrawn;

    public Customer(@NotNull @Length(max = 320) @Email String email, @NotNull @Length(min = 6, max = 12) String password) {
        this.email = email;
        this.password = password;
    }

    public Customer(@NotNull @Length(max = 320) @Email String email, @NotNull @Length(min = 6, max = 12) String password, @Nullable List<Diary> diaryList) {
        this.email = email;
        this.password = password;
        this.diaryList = diaryList;
    }
}
