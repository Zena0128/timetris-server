package com.trendithon.timetris.domain.mainpage.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor @NoArgsConstructor
public class Plan {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean status = false;
    @ManyToOne(fetch = FetchType.LAZY)
    private Category categoryId;
    @ManyToOne(fetch = FetchType.LAZY)
    private Date dateId;

}