package com.example.BookMyShow.Service;

import com.example.BookMyShow.dto.EntryDto.ShowEntryDto;
import com.example.BookMyShow.dto.ResponseDto.ShowResponseDto;

public interface ShowService {

    ShowResponseDto addShow(ShowEntryDto showEntryDto);

    //Get show
    //Complete
}
