package com.tsis.ticketing.controller;

import com.tsis.ticketing.domain.Movie;
import com.tsis.ticketing.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping()
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{theater}")
    public ResponseEntity<List<Movie>> getMovie(@PathVariable("theater") int theater) {
        return new ResponseEntity<>(movieService.getMovie(theater), HttpStatus.OK);
    }
}
