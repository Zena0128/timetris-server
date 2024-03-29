package com.trendithon.timetris.domain.mainpage.controller;

import com.trendithon.timetris.domain.mainpage.domain.Category;
import com.trendithon.timetris.domain.mainpage.dto.CategoryCreateDTO;
import com.trendithon.timetris.domain.mainpage.dto.CategoryRequestDTO;
import com.trendithon.timetris.domain.mainpage.dto.CategoryViewDTO;
import com.trendithon.timetris.domain.mainpage.service.CategoryService;
import com.trendithon.timetris.global.auth.jwt.TokenProvider;
import com.trendithon.timetris.global.exception.ApiResponse;
import com.trendithon.timetris.global.exception.CustomException;
import com.trendithon.timetris.global.exception.enums.ErrorStatus;
import com.trendithon.timetris.global.exception.enums.SuccessStatus;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;
    private final TokenProvider tokenProvider;


    @GetMapping("")
    public ApiResponse<List<CategoryViewDTO>> readCategoryAll(HttpServletRequest request) {
        Long userId = tokenProvider.getUserId(request);

        List<CategoryViewDTO> categoryList = categoryService.readCategoryAll(userId);
        return ApiResponse.success(SuccessStatus.OK, categoryList);
    }

    @PostMapping("")
    public ApiResponse<CategoryRequestDTO> createCategory(HttpServletRequest request,
                                                          @RequestBody CategoryRequestDTO categoryRequestDTO) {
        Long userId = tokenProvider.getUserId(request);

        Category category = categoryService.createCategory(userId, categoryRequestDTO);
        if (category == null) {
            throw new CustomException(ErrorStatus.INVALID_FORMAT_ERROR);
        }
        return ApiResponse.success(SuccessStatus.OK, categoryRequestDTO);
    }

    @PutMapping("/{categoryId}")
    public ApiResponse<CategoryRequestDTO> updateCategory(HttpServletRequest request,
                                                          @PathVariable long categoryId,
                                                          @RequestBody CategoryRequestDTO categoryRequestDTO) {
        Long userId = tokenProvider.getUserId(request);

        categoryService.updateCategory(userId, categoryId, categoryRequestDTO);
        return ApiResponse.success(SuccessStatus.OK, categoryRequestDTO);
    }

    @DeleteMapping("/{categoryId}")
    public ApiResponse deleteCategory(HttpServletRequest request,
                                      @PathVariable long categoryId) {
        Long userId = tokenProvider.getUserId(request);

        categoryService.deleteCategory(userId, categoryId);
        return ApiResponse.success(SuccessStatus.OK);
    }

}
