package com.example.eventmoa.domain.dong.presentation;

import com.example.eventmoa.domain.dong.presentation.dto.request.DongCreateRequest;
import com.example.eventmoa.domain.dong.presentation.dto.response.DongQueryAllResponse;
import com.example.eventmoa.domain.dong.service.DongCreateService;
import com.example.eventmoa.domain.dong.service.DongDeleteService;
import com.example.eventmoa.domain.dong.service.DongQueryAllService;
import com.example.eventmoa.domain.dong.service.DongUpdateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dong")
@Tag(name = "dong controller", description = "dong 관련 api")
public class DongController {
    private final DongCreateService dongCreateService;
    private final DongQueryAllService dongQueryAllService;
    private final DongUpdateService dongUpdateService;
    private final DongDeleteService dongDeleteService;

    @GetMapping("/queryAll")
    public List<DongQueryAllResponse> queryAll() {
        return dongQueryAllService.queryAll();
    }

    @PostMapping("/post")
    @Operation(description = "swagger에서 동 enum을 넣을때 string으로 넣으라고 나오는데 string으로 넣어도 되고 보내드린 jpg참고해서 enum number로 보내도 됩니다.")
    public void post(@Valid @RequestBody DongCreateRequest request) {
        dongCreateService.create(request);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        dongDeleteService.delete(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id,@Valid @RequestBody DongCreateRequest request){
        dongUpdateService.update(id, request);
    }
}
