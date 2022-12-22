package com.example.MarsRover.Controller;

import com.example.MarsRover.Model.MarsRoverResponse;
import com.example.MarsRover.Service.MarsClient;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class MarsController {

    private MarsClient marsClient;


    public MarsController (MarsClient marsClient) {
        this.marsClient = marsClient;
    }

    @GetMapping("/api/")
    public MarsRoverResponse listData(@RequestParam(required=false) String date,
                                      @RequestParam(required = false) String camera,
                                      @RequestParam(required = false) Integer page){
        MarsRoverResponse roverData = marsClient.Datalist(date, camera, page);
        return roverData;
    }

}


