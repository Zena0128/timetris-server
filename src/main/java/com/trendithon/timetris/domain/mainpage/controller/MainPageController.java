package com.trendithon.timetris.domain.mainpage.controller;

import com.trendithon.timetris.domain.mainpage.dto.MainPageDTO;
import com.trendithon.timetris.domain.mainpage.service.MainPageService;
import com.trendithon.timetris.domain.member.dto.MyPageResponse;
import com.trendithon.timetris.global.auth.jwt.TokenProvider;
import com.trendithon.timetris.global.exception.ApiResponse;
import com.trendithon.timetris.global.exception.enums.SuccessStatus;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/main")
@Slf4j
public class MainPageController {

    private final MainPageService mainPageService;
    private final TokenProvider tokenProvider;

//    @GetMapping
    public ApiResponse<MyPageResponse.getMyPageDTO> getMainPage(HttpServletRequest request) {

        Long userId = tokenProvider.getUserId(request);

        MyPageResponse.getMyPageDTO mainPageDTO = mainPageService.getUserInfo(userId);

        return ApiResponse.success(SuccessStatus.OK, mainPageDTO);
    }

    @GetMapping("")
    public ApiResponse<MainPageDTO> getMainPage2(HttpServletRequest request) {

        Long userId = tokenProvider.getUserId(request);

        MainPageDTO mainPageDTO = mainPageService.getMainPage(userId);
        return ApiResponse.success(SuccessStatus.OK, mainPageDTO);
    }

}
