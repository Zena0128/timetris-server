package com.trendithon.timetris.domain.mainpage.dto;

import com.trendithon.timetris.domain.mainpage.domain.Category;
import com.trendithon.timetris.domain.mainpage.domain.Date;
import com.trendithon.timetris.domain.mainpage.domain.Do;
import com.trendithon.timetris.domain.mainpage.domain.UserDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Getter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class DoViewDTO {

    private long id;
    private String title;
    private LocalTime startTime;
    private LocalTime endTime;
    private CategoryViewDTO category;

    public static DoViewDTO of(Do does){
        return DoViewDTO.builder()
                .id(does.getId())
                .title(does.getTitle())
                .startTime(does.getStartTime())
                .endTime(does.getEndTime())
                .category(CategoryViewDTO.of(does.getCategory()))
                .build();
    }

}
