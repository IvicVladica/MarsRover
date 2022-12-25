package com.example.MarsRover.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "mars_photos")
public class MarsRoverResponse {

    @Id
    @Column(name = "date_taken")
    private LocalDate date;

    @Column(name = "photo_1")
    private String photo1url;

    @Column(name = "photo_2")
    private String photo2url;

    @Column(name = "photo_3")
    private String photo3url;

    @Override
    public String toString() {
        return "MarsRoverResponse{" +
                "date=" + date +
                ", photo1url='" + photo1url + '\'' +
                ", photo2url='" + photo2url + '\'' +
                ", photo3url='" + photo3url + '\'' +
                '}';
    }
}
