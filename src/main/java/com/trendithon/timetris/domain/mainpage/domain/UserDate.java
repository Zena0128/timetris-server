package com.trendithon.timetris.domain.mainpage.domain;

import com.trendithon.timetris.domain.member.domain.User;
import com.trendithon.timetris.domain.mainpage.dto.UserDateCreateDTO;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDate {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dateId")
    private Date date;

    @OneToMany(mappedBy = "userDate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Do> doList = new ArrayList<>();

    @OneToMany(mappedBy = "userDate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Plan> planList = new ArrayList<>();

    @OneToMany(mappedBy = "userDate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<See> seeList = new ArrayList<>();

    public UserDate(UserDateCreateDTO userDateCreateDTO){
        this.user = userDateCreateDTO.getUser();
        this.date = userDateCreateDTO.getDate();
    }

}
