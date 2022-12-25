package com.example.MarsRover.Controller;

import com.example.MarsRover.Model.MarsRoverResponse;
import com.example.MarsRover.Service.MarsClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class MarsController {

    private MarsClient marsClient;


    public MarsController (MarsClient marsClient) {
        this.marsClient = marsClient;
    }

    @GetMapping("/api/")
    public List<MarsRoverResponse> listData(){
        LocalDate date = LocalDate.now().minusDays(1);
        return marsClient.getPhotoListResponse(date);
    }
}


