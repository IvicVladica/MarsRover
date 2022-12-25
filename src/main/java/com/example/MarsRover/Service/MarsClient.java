package com.example.MarsRover.Service;

import com.example.MarsRover.Model.MarsPhoto;
import com.example.MarsRover.Model.MarsPhotoList;
import com.example.MarsRover.Model.MarsRoverResponse;
import com.example.MarsRover.Repository.MarsRoverResponseDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class MarsClient {


    private WebClient webClient;
    private MarsRoverResponseDB marsRoverResponseDB;

    @Autowired
    public MarsClient (WebClient webClient, MarsRoverResponseDB marsRoverResponseDB) {
        this.webClient = webClient;
        this.marsRoverResponseDB = marsRoverResponseDB;
    }

    public List<MarsRoverResponse> getPhotoListResponse(LocalDate today) {
        List<MarsRoverResponse> responseList = new ArrayList<>();
        for (int i=1; i<=10; i++) {
            LocalDate date = today.minusDays(i);
            String keyApi = "6kr7Q0gSgBdfcKdlrFNcnEIUmEDwKoVWV2YA8OgL";
            String urlApi = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?earth_date=" + date + "&api_key=" + keyApi;

            Mono<MarsPhotoList> bodyResponseData = webClient
                    .method(HttpMethod.GET)
                    .uri(urlApi)
                    .retrieve()
                    .bodyToMono(MarsPhotoList.class);

            saveMarsRoverResponse(bodyResponseData.block(), date);
            responseList.add(readMarsRoverResponse(date));
        }
        return responseList;
    }


        public MarsRoverResponse mapToMarsRoverResponse(MarsPhotoList marsPhotoList) {
                MarsRoverResponse marsRoverResponse = new MarsRoverResponse();
                MarsPhoto photo1 = Objects.requireNonNull(marsPhotoList.getPhotos().get(1));
                MarsPhoto photo2 = Objects.requireNonNull(marsPhotoList.getPhotos().get(2));
                MarsPhoto photo3 = Objects.requireNonNull(marsPhotoList.getPhotos().get(3));
                marsRoverResponse.setPhoto1url(photo1.getImgSrc());
                marsRoverResponse.setPhoto2url(photo2.getImgSrc());
                marsRoverResponse.setPhoto3url(photo3.getImgSrc());
                marsRoverResponse.setDate(photo1.getEarth_date());

            return marsRoverResponse;
        }

        public void saveMarsRoverResponse (MarsPhotoList marsPhotoList, LocalDate date) {
                MarsRoverResponse marsRoverResponse = new MarsRoverResponse();
                MarsRoverResponse existingDateResponse = marsRoverResponseDB.findByDate(date);
                if (marsPhotoList.photos.isEmpty()) {
                    if (existingDateResponse == null) {
                        marsRoverResponse = new MarsRoverResponse(date, null, null, null);
                        marsRoverResponseDB.save(marsRoverResponse);
                        System.out.println("Nema podataka");
                    } else {
                        existingDateResponse.setPhoto1url(null);
                        existingDateResponse.setPhoto2url(null);
                        existingDateResponse.setPhoto3url(null);
                        marsRoverResponseDB.save(existingDateResponse);
                        System.out.println("Vec postoji prazan dan");
                    }
                }
                else {
                    if (!(existingDateResponse == null)) {
                        existingDateResponse = mapToMarsRoverResponse(Objects.requireNonNull(marsPhotoList));
                        marsRoverResponseDB.save(existingDateResponse);
                        System.out.println("Postoje podaci za taj dan");
                    }
                    else {
                        marsRoverResponse = mapToMarsRoverResponse(Objects.requireNonNull(marsPhotoList));
                        marsRoverResponseDB.save(marsRoverResponse);
                        System.out.println("Uspesno snimanje novih podataka");}
                }
        }

        public MarsRoverResponse readMarsRoverResponse (LocalDate date) {
            return marsRoverResponseDB.findByDate(date);
        }
}
