package com.example.BookMyShow.Service;

import com.example.BookMyShow.dto.EntryDto.MovieEntryDto;
import com.example.BookMyShow.dto.ResponseDto.MovieNameAndIdObject;
import com.example.BookMyShow.dto.ResponseDto.MovieResponseDto;

public interface MovieService {

    //Add movie
    MovieResponseDto addMovie(MovieEntryDto movieEntryDto);


    //get movie
    MovieResponseDto getMovie(int id);

    MovieNameAndIdObject getNameAndId(int id);


}
