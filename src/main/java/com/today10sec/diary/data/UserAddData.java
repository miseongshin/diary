package com.today10sec.diary.data;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class UserAddData {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private Date EmailVerifiedAt;
    private Date lastLogin;
    private Date createAt = new Date();
    private Date updateAt = new Date();
    private Boolean isUsed;

    public UserAddData(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public UserAddData(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
