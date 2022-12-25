package com.example.MarsRover.Controller;

import com.example.MarsRover.Model.MarsPhotoList;
import com.example.MarsRover.Service.MarsClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class MarsController {

    private MarsClient marsClient;


    public MarsController (MarsClient marsClient) {
        this.marsClient = marsClient;
    }

    @GetMapping("/api/")
    public void listData(){
        LocalDate date = LocalDate.now().minusDays(1);
        marsClient.getPhotoListResponse(date);
    }
}


