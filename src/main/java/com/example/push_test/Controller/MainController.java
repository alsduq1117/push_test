package com.example.push_test.Controller;

import com.example.push_test.DTO.RequestDTO;
import com.example.push_test.Service.FirebaseCloudMessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequiredArgsConstructor
public class MainController {

    private final FirebaseCloudMessageService firebaseCloudMessageService;


    @Operation(summary = "push_test" , description = "push test 샘플 예제")
    @ApiResponses({
            @ApiResponse(responseCode = "200" , description = "OK!"),
            @ApiResponse(responseCode = "400" , description = "Bad Request"),
            @ApiResponse(responseCode = "404" , description = "NOT FOUND"),
            @ApiResponse(responseCode = "500" , description = "INTERNAL SERVER ERROR!!")
    })
    @PostMapping("/api/fcm")
    public ResponseEntity pushMessage(@RequestBody RequestDTO requestDTO) throws IOException {
        System.out.println(requestDTO.getTargetToken() + " "
                +requestDTO.getTitle() + " " + requestDTO.getBody());

        firebaseCloudMessageService.sendMessageTo(
                requestDTO.getTargetToken(),
                requestDTO.getTitle(),
                requestDTO.getBody());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/fcm_topic")
    public ResponseEntity pushMessages(@RequestBody RequestDTO requestDTO) throws IOException {
        System.out.println(requestDTO.getTargetToken() + " "
                +requestDTO.getTitle() + " " + requestDTO.getBody());

        firebaseCloudMessageService.sendMessagesTo(
                requestDTO.getTargetToken(),
                requestDTO.getTitle(),
                requestDTO.getBody());

        return ResponseEntity.ok().build();
    }
}


