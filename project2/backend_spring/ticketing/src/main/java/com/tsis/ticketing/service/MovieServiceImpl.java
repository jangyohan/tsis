package com.tsis.ticketing.service;

import com.tsis.ticketing.domain.Movie;
import com.tsis.ticketing.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.readAllMovie();
    }

    @Override
    public List<Movie> getMovie(int theater) {
        return movieRepository.getMovie(theater);
    }
}
