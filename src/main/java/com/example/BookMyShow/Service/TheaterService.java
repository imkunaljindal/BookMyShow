package com.example.BookMyShow.Service;

import com.example.BookMyShow.dto.TheaterDto;

public interface TheaterService {

    void addTheater(TheaterDto theaterDto);

    TheaterDto getTheater(int id);
}
