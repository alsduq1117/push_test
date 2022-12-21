package com.example.push_test.Controller;


import com.example.push_test.DTO.TestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TestController {
    @Operation(summary = "get_test" , description = "get test 샘플 예제")
    @ApiResponses({
            @ApiResponse(responseCode = "200" , description = "OK!"),
            @ApiResponse(responseCode = "400" , description = "Bad Request"),
            @ApiResponse(responseCode = "404" , description = "NOT FOUND"),
            @ApiResponse(responseCode = "500" , description = "INTERNAL SERVER ERROR!!")
    })
    @GetMapping("/api/get/test")
    public ResponseEntity<String> hello(
            @Parameter(description = "이름", required = true, example = "김민엽") @RequestParam String name,
            @Parameter(description = "나이", example = "25") @RequestParam int age
    ) {
        return ResponseEntity.ok("안녕하세요. "+age+"살 "+name+"님");
    }

    @Operation(summary = "post_test" , description = "post test 샘플 예제")
    @ApiResponses({
            @ApiResponse(responseCode = "200" , description = "OK!"),
            @ApiResponse(responseCode = "400" , description = "Bad Request"),
            @ApiResponse(responseCode = "404" , description = "NOT FOUND"),
            @ApiResponse(responseCode = "500" , description = "INTERNAL SERVER ERROR!!")
    })
    @PostMapping("/api/post/test")
    public ResponseEntity testMessage(@RequestBody TestDTO testDTO){
        return ResponseEntity.ok().build();
    }


}
