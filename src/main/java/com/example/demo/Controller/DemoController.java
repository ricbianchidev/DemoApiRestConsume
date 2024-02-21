package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Joke;
import com.example.demo.Services.JokeService;

@RestController
public class DemoController {

    @Autowired
    private JokeService jokeService;
    
    @GetMapping("/getJoke")
    public ResponseEntity<List<Joke>> getJoke() {
        return jokeService.getJoke();
    }

}
