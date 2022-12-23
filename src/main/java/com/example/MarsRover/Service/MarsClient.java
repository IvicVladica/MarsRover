package com.example.MarsRover.Service;

import com.example.MarsRover.Model.MarsRoverResponse;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
public class MarsClient {


    private WebClient webClient;

    public MarsClient (WebClient webClient) {
        this.webClient = webClient;
    }

    public MarsRoverResponse Datalist(String date, String camera, Integer page) {
        String keyApi = "6kr7Q0gSgBdfcKdlrFNcnEIUmEDwKoVWV2YA8OgL";
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
