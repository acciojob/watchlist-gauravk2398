package com.driver;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController

public class MovieController {
    @Autowired
    MovieService movieService;

@PostMapping ("/add-movie")
public ResponseEntity addMovie(@RequestBody Movie movie){
    String str= movieService.addMovie(movie);
    return new ResponseEntity<>(str,HttpStatus.CREATED);
}
@PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){
    return new ResponseEntity(movieService.addDirector(director),HttpStatus.CREATED);
}
@PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("director") String director,@RequestParam("movie") String movie){
        return new ResponseEntity(movieService.addMovieDirectorPair(movie,director),HttpStatus.CREATED);
}
@GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String movie){
        return new ResponseEntity(movieService.getMovieByName(movie),HttpStatus.FOUND);

}
@GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable("name") String director){
    return new ResponseEntity(movieService.getDirectorByName(director),HttpStatus.FOUND);
}
@GetMapping("/get-movie-by-director-name/{director}")
    public ResponseEntity getMovieByDirectorName(@PathVariable("director") String director){
    return new ResponseEntity(movieService.getMoviesByDirectorName(director),HttpStatus.FOUND);
}
@GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies(){
    return new ResponseEntity(movieService.findAllMovies(),HttpStatus.FOUND);
}
@DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("dirName") String director){
    return new ResponseEntity(movieService.deleteDirectorByName(director),HttpStatus.OK);
}
@DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
    return new ResponseEntity(movieService.deleteAllDirectors(),HttpStatus.OK);
}


}
