package com.example.MarsRover.Model;
import java.util.ArrayList;
import java.util.List;

public class MarsRoverResponse {

    public List<MarsPhoto> photos = new ArrayList<>();

    @Override
    public String toString() {return "MarsRoverPhotos [photos=" + photos + "]"; }

    public List<MarsPhoto> getPhotos() {return photos;}

}
