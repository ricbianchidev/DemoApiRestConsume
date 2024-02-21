package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Models.Joke;

@Service
public class JokeService {

    @Autowired
    private RestTemplate restTemplate;

    final String URL_EXTERNAL_SERVICE = "https://api.chucknorris.io/jokes/random";
    final int TOTAL_OBJECTS = 25;
    
    public ResponseEntity<List<Joke>> getJoke() {
        List<Joke> jokes = new ArrayList<>();
        for (int i = 0; i < TOTAL_OBJECTS; i++) {
            Joke joke = restTemplate.getForObject(URL_EXTERNAL_SERVICE, Joke.class);
            jokes.add(joke);
        }
        return ResponseEntity.ok(jokes);
    }
}
