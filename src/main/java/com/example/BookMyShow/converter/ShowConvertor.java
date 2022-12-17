package com.example.BookMyShow.converter;

import com.example.BookMyShow.Model.ShowEntity;
import com.example.BookMyShow.dto.EntryDto.ShowEntryDto;
import com.example.BookMyShow.dto.ResponseDto.ShowResponseDto;

public class ShowConvertor {


    public static ShowEntity convertDtoToEntity(ShowEntryDto showDto){

        return ShowEntity.builder().showDate(showDto.getShowDate()).showTime(showDto.getShowTime())
                .build();
    }

    public static ShowResponseDto convertEntityToDto(ShowEntity showEntity, ShowEntryDto showEntryDto){

        return ShowResponseDto.builder()
                .id(showEntity.getId())
                .showTime(showEntity.getShowTime())
                .showDate(showEntity.getShowDate())
                .movieResponseDto(showEntryDto.getMovieResponseDto())
                .theaterDto(showEntryDto.getTheaterResponseDto())
                .build();
    }
}
