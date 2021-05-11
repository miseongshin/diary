package com.today10sec.diary.customize.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer implements Serializable, UserDetails {

    public static final long serialVersionUID = 10002L;

    @Id @GeneratedValue
    private Integer id;
    @Nullable
    @Length(min = 1, max = 100)
    private String nick_name;

    @NotNull
    @Length(max=320)
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    private String password;

    @Nullable
    @OneToMany(mappedBy = "customer")
    private List<Diary> diaryList;

    private String auth;

    @Nullable
    @Column(name = "LAST_LOGIN")
    private Date lastLogin;

    @Column(name = "ACCOUNT_NON_EXPIRED")
    @Nullable
    private Boolean accountNonExpired;

    @Column(name = "ACCOUNT_NON_LOCKED")
    @Nullable
    private Boolean accountNonLocked;
    /**
     * 패스워드 만료여부
     */
    @Column(name = "CREDENTIALS_NON_EXPIRED")
    @Nullable
    private Boolean credentialsNonExpired;

    @Nullable
    private Boolean enabled;

    @Column(name = "CREATED_AT")
    @CreatedDate
    private Date createdAt;

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    private Date updatedAt = new Date();

    @Builder
    public Customer(String email, String password, String auth, List<Diary> diaryList) {
        this.email = email;
        this.password = password;
        this.auth = auth;
        this.diaryList = diaryList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> roles = new HashSet<>();
        for (String role : this.auth.split(",")){
            roles.add(new SimpleGrantedAuthority(role));
        }
        return roles;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }


}
