package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Service

public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie){
        return movieRepository.addMovie(movie);
    }
    public String addDirector(Director director){
        return movieRepository.addDirector(director);
    }
    public String addMovieDirectorPair(String movie,String director){
        return movieRepository.addMovieDirectorPair(movie,director);
    }
    public Movie getMovieByName(String movie){
        return movieRepository.getMovie(movie);
    }
    public Director getDirectorByName(String director){
        return movieRepository.getDirector(director);
    }
    public List<String> getMoviesByDirectorName(String director){
        return movieRepository.getMoviesByDirectorName(director);
    }
    public List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }
    public String deleteDirectorByName(String director){
        return movieRepository.deleteDirectorByName(director);
    }
    public String deleteAllDirectors(){
        return movieRepository.deleteAllDirectors();
    }
}
