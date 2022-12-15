package com.example.BookMyShow.Service.impl;

import com.example.BookMyShow.Model.UserEntity;
import com.example.BookMyShow.Repository.UserRepository;
import com.example.BookMyShow.Service.UserService;
import com.example.BookMyShow.converter.UserConverter;
import com.example.BookMyShow.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(UserDto userDto){

        UserEntity userEntity = UserConverter.dtoToEntity(userDto);
        userRepository.save(userEntity);
    }

    @Override
    public UserDto getUser(int id){

        UserEntity userEntity = userRepository.findById(id).get();
        UserDto userDto = UserConverter.entityToDto(userEntity);
        return userDto;
    }
}
