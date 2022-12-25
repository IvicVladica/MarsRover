package com.example.MarsRover.Model;
import java.util.ArrayList;

public class MarsPhotoList {

    public ArrayList<MarsPhoto> photos = new ArrayList<>();

    @Override
    public String toString() {return "MarsRoverPhotos [photos=" + photos + "]"; }

    public ArrayList<MarsPhoto> getPhotos() {
        return photos;
    }
}
