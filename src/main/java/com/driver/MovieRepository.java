package com.driver;

import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    HashMap<String, Movie> movieMap=new HashMap<>();
    HashMap<String, Director> directorMap=new HashMap<>();
    HashMap<String,List<String>> directorMovieMapping=new HashMap<>();
    public String addMovie(Movie movie){
        movieMap.put(movie.getName(),movie);
        return "Movie added successfully";
    }
    public String addDirector(Director director){
       directorMap.put(director.getName(),director);
        return "Director added successfully";
    }
    public String addMovieDirectorPair(String movie,String director){
        if(movieMap.containsKey(movie)&& directorMap.containsKey(director)){
            List<String> currentList=new ArrayList<>();
            if(directorMovieMapping.containsKey(director))
                currentList=directorMovieMapping.get(director);
            currentList.add(movie);
            directorMovieMapping.put(director,currentList);
        }
        return "Movie and Director added successfully";
    }
    public Movie getMovie(String movie) {
            return movieMap.get(movie);
    }
    public Director getDirector(String director){
        return directorMap.get(director);
    }
    public List<String> getMoviesByDirectorName(String director){
        List<String> dirMovies=new ArrayList<>();
        dirMovies=directorMovieMapping.get(director);
        return dirMovies;
    }
    public List<String> findAllMovies(){
        List<String> list=new ArrayList();
        for(String name:movieMap.keySet()){
            list.add(name);
        }
        return list;
    }
    public String deleteDirectorByName(String director){
         List<String> movies =new ArrayList<>();
        if(directorMovieMapping.containsKey(director)){
            movies = directorMovieMapping.get(director);
            for(String movie: movies){
                if(movieMap.containsKey(movie)){
                    movieMap.remove(movie);
                }
            }

            directorMovieMapping.remove(director);
        }

        if(directorMap.containsKey(director)){
            directorMap.remove(director);
        }
        return "All Directors Removed SuccessFully";

    }
    public String deleteAllDirectors(){
        List<String> moviesSet=new ArrayList<>();
        for(String director: directorMovieMapping.keySet()){
            for(String movie: directorMovieMapping.get(director)){
                moviesSet.add(movie);
            }
        }

        for(String movie: moviesSet){
            if(movieMap.containsKey(movie)){
                movieMap.remove(movie);
            }
        }
        return "All Directors Removed SuccessFully";
    }


}
