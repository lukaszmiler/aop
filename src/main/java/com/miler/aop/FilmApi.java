package com.miler.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FilmApi {

    List<Film> list;

    public FilmApi() {
        list = new ArrayList<>();
        list.add(new Film("Armageddon", "1998"));
        list.add(new Film("The Rock", "1996"));
    }

    @GetMapping("/films")
    public ResponseEntity<List<Film>> getFilms(){
        System.out.println(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @SendMail
    @PostMapping("/films")
    public ResponseEntity<List<Film>> addFilm(@RequestBody Film newFilm){
        list.add(newFilm);
        return new ResponseEntity<>(list, HttpStatus.CREATED);
    }


}
