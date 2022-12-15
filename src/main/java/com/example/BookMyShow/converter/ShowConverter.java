package com.example.BookMyShow.converter;

import com.example.BookMyShow.Model.ShowEntity;
import com.example.BookMyShow.dto.ShowDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ShowConverter {

    public static ShowEntity dtoToEntity(ShowDto showDto){
        return ShowEntity.builder().id(showDto.getId()).showTime(showDto.getShowTime()).showDate(showDto.getShowDate())
                .build();
    }
}
