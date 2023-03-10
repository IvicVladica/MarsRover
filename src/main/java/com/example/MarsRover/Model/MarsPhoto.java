package com.example.MarsRover.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MarsPhoto {

//    private Long id;
//    private Integer sol;
//    private MarsCamera camera;

    @JsonProperty("img_src")
    private String imgSrc;

    @JsonProperty("earth_date")
    private LocalDate earth_date;

    @Override
    public String toString() {
        return "MarsPhoto{" +
                "imgSrc='" + imgSrc + '\'' +
                ", earth_date='" + earth_date + '\'' +
                '}';
    }

    //    private MarsRover rover;
}
