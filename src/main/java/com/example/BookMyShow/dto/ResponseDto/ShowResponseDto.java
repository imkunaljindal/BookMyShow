package com.example.BookMyShow.dto.ResponseDto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class ShowResponseDto {


    int id;

    LocalDate showDate;

    LocalTime showTime;

    MovieResponseDto movieResponseDto;

    TheaterResponseDto theaterDto;

}
