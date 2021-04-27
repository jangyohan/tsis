package com.tsis.ticketing.service;

import com.tsis.ticketing.domain.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();

    List<Movie> getMovie(int theater);
}
