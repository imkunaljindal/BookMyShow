package com.example.BookMyShow.Service;

import com.example.BookMyShow.dto.UserDto;

public interface UserService {

    //add
    public void addUser(UserDto userDto);

    //get
    public UserDto getUser(int id);
}
