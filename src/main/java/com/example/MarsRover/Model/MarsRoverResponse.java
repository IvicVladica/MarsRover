package com.example.MarsRover.Model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class MarsRoverResponse {

    @JsonProperty("img_src")
    public List<String> imgSrc = new ArrayList<>();

    @Override
    public String toString() {return "MarsRoverPhotos [photos=" + imgSrc + "]"; }

    public List<String> getImgSrc() {return imgSrc;}

}
