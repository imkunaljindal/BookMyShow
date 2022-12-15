package com.example.BookMyShow.converter;

import com.example.BookMyShow.Model.TheaterEntity;
import com.example.BookMyShow.dto.TheaterDto;
import lombok.experimental.UtilityClass;
import org.hibernate.annotations.ValueGenerationType;

@UtilityClass
public class TheaterConverter {

    public static TheaterEntity dtoToEntity(TheaterDto theaterDto){
        return TheaterEntity.builder().id(theaterDto.getId()).address(theaterDto.getAddress())
                .city(theaterDto.getCity()).name(theaterDto.getName()).build();
    }

    public static TheaterDto entityToDto(TheaterEntity theaterEntity){

        return TheaterDto.builder().id(theaterEntity.getId()).name(theaterEntity.getName())
                .city(theaterEntity.getCity()).address(theaterEntity.getAddress()).build();
    }
}
