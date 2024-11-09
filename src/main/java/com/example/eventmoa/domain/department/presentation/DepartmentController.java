package com.example.eventmoa.domain.department.presentation;

import com.example.eventmoa.domain.department.persistence.Department;
import com.example.eventmoa.domain.department.presentation.dto.request.DepartmentCreateRequest;
import com.example.eventmoa.domain.department.presentation.dto.response.DepartmentQueryAllResponse;
import com.example.eventmoa.domain.department.service.DepartmentCreateService;
import com.example.eventmoa.domain.department.service.DepartmentQueryAllService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@Tag(name = "department controller", description = "department 관련 api")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentCreateService departmentCreateService;
    private final DepartmentQueryAllService departmentQueryAllService;

    @Operation(summary = "과행사 생성 요청", description = "과행사가 삭제됩니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PostMapping("/create")
    public void create(@Valid @RequestBody DepartmentCreateRequest request) {
        departmentCreateService.create(request);
    }

    @Operation(summary = "과행사 전체 조회")
    @GetMapping("/queryAll")
    public List<DepartmentQueryAllResponse> queryAll() {
        return departmentQueryAllService.queryAll();
    }

}
