package com.example.MarsRover.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MarsRover {

    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("landing_date")
    private Date landingDate;

}
