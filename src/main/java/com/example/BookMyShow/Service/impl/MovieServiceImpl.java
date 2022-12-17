package com.example.BookMyShow.Service.impl;

import com.example.BookMyShow.Model.MovieEntity;
import com.example.BookMyShow.Repository.MovieRepository;
import com.example.BookMyShow.Service.MovieService;
import com.example.BookMyShow.converter.MovieConverter;
import com.example.BookMyShow.dto.EntryDto.MovieEntryDto;
import com.example.BookMyShow.dto.ResponseDto.MovieNameAndIdObject;
import com.example.BookMyShow.dto.ResponseDto.MovieResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService {


    @Autowired
    MovieRepository movieRepository;

    @Override
    public MovieResponseDto addMovie(MovieEntryDto movieEntryDto)  {


        //Id --> not there
        //name  --> Yes
        //releaseDate --> Yes


        MovieResponseDto movieResponseDto = null;

        //if the movie is already created then we can throw an exception....movie already exists.
        if(movieRepository.existsByName(movieEntryDto.getName())){

            movieResponseDto.setName("This movie is already Existing");
            return movieResponseDto;
        }

        log.info("In the function add movie "+ movieEntryDto);


        //I need a movieEntity Object
        /*
                How can I get it
         */

        //We were createing a MovieEntity Object


        MovieEntity movieEntity = MovieConverter.convertDtoToEntity(movieEntryDto);


        movieEntity = movieRepository.save(movieEntity); //This will auto add the id variable
        //

        movieResponseDto = MovieConverter.convertEntityToDto(movieEntity);

        return movieResponseDto; //It can be a response type of the movie

    }

    @Override
    public MovieResponseDto getMovie(int id) {

        MovieEntity movieEntity = movieRepository.findById(id).get();

        MovieResponseDto movieResponseDto = MovieConverter.convertEntityToDto(movieEntity);
        return movieResponseDto;

    }

    @Override
    public MovieNameAndIdObject getNameAndId(int id){

        //I need information from repo
        MovieEntity movieEntity = movieRepository.findById(id).get(); //Get this movieEntity from the database


        //I have to convert it

        MovieNameAndIdObject obj = MovieConverter.convertEntityToThisObject(movieEntity);


        return obj;
    }

}
