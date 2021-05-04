
package com.today10sec.diary.model;

import lombok.Getter;
import lombok.Setter;

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

    private int totalDailyCount;

    private boolean isUsed;

    @ManyToOne
    private Customer customer;

    @OneToMany
    private List<Daily> dailyList;

    @Column(name = "CREATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(name = "UPDATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt = new Date();
}

