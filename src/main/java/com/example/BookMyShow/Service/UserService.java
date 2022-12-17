package com.example.BookMyShow.Service;

import com.example.BookMyShow.dto.EntryDto.UserEntryDto;
import com.example.BookMyShow.dto.ResponseDto.UserResponseDto;

public interface UserService { //Designing part

    void addUser(UserEntryDto userEntryDto);

    UserResponseDto getUser(int id);


}
