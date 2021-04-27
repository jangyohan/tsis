package com.tsis.ticketing.repository;

import com.tsis.ticketing.domain.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository {
    List<Movie> readAllMovie();

    List<Movie> getMovie(int theater);
}