package com.example.BookMyShow.Service;

import com.example.BookMyShow.dto.MovieDto;

public interface MovieService {

    //add
    MovieDto addMovie(MovieDto moveiDto);

    //get
    MovieDto getMovie(int id);
}
