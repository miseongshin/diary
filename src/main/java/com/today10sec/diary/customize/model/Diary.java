
package com.today10sec.diary.customize.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
public class Diary {

    @Id @GeneratedValue
    private Integer id;

    private String title;

    private String locale;

    private int year;

    private boolean isUsed;

    @ManyToOne @NonNull
    private Customer customer;

    @OneToMany(mappedBy = "diary")
    private List<Daily> dailyList;

    @Column(name = "CREATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createAt;

    @Column(name = "UPDATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updateAt;

    public Diary(String title) {
        this.title = title;
    }
}

