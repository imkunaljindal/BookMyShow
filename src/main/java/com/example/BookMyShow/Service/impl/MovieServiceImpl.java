package com.example.BookMyShow.Service.impl;

import com.example.BookMyShow.Model.MovieEntity;
import com.example.BookMyShow.Repository.MovieRepository;
import com.example.BookMyShow.Service.MovieService;
import com.example.BookMyShow.converter.MovieConverter;
import com.example.BookMyShow.dto.MovieDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public MovieDto addMovie(MovieDto movieDto){

        //find how to search by name using JPA

        if(movieDto.getId()<0){
            // erro
        }

        log.info("Reached addMovie function");

        MovieEntity movieEntity = MovieConverter.dtoToEntity(movieDto);
        movieRepository.save(movieEntity);
        return movieDto;
    }

    @Override
    public MovieDto getMovie(int id) {

        MovieEntity movieEntity = movieRepository.findById(id).get();
        MovieDto movieDto = MovieConverter.entityToDto(movieEntity);
        return movieDto;
    }


}
