package com.example.MarsRover.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MarsCamera {

    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("rover_id")
    private Long roverId;

    @JsonProperty("full_name")
    private String fullName;

}
