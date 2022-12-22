package com.example.MarsRover.Service;

import com.example.MarsRover.Model.MarsRoverResponse;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
public class MarsClient {


    private WebClient webClient;

    public MarsClient (WebClient webClient) {
        this.webClient = webClient;
    }

    private String keyApi = "6kr7Q0gSgBdfcKdlrFNcnEIUmEDwKoVWV2YA8OgL";

    public MarsRoverResponse Datalist(String date, String camera, Integer page) {
        String urlApi = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?earth_date=" + date + "&camera=" + camera + "&page=" + page + "&api_key=" + keyApi;

 //       https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?earth_date=2015-6-3&api_key=DEMO_KEY

        Mono<MarsRoverResponse> bodyResponseData = webClient
                .method(HttpMethod.GET)
                .uri(urlApi)
                .retrieve()
                .bodyToMono(MarsRoverResponse.class);

        return bodyResponseData.block();

   }
}
