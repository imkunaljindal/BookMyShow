package com.example.BookMyShow.Service;

import com.example.BookMyShow.dto.EntryDto.TheaterEntryDto;
import com.example.BookMyShow.dto.ResponseDto.TheaterResponseDto;

public interface TheaterService {


    TheaterResponseDto addTheater(TheaterEntryDto theaterEntryDto);

    TheaterResponseDto getTheater(int id);

}
