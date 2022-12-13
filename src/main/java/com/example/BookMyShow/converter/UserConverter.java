package com.example.BookMyShow.converter;

import com.example.BookMyShow.Model.UserEntity;
import com.example.BookMyShow.dto.UserDto;
import lombok.experimental.UtilityClass;

import java.util.Optional;

@UtilityClass
public class UserConverter {

    public static UserEntity dtoToEntity(UserDto userDto){

        return UserEntity.builder().name(userDto.getName()).mobile(userDto.getMobile()).build();
    }

    public static UserDto entityToDto(UserEntity userEntity){

        return UserDto.builder().name(userEntity.getName()).mobile(userEntity.getMobile()).build();

    }

}
