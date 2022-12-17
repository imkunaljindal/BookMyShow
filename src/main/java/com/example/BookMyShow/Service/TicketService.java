package com.example.BookMyShow.Service;

import com.example.BookMyShow.dto.BookTicketRequestDto;
import com.example.BookMyShow.dto.ResponseDto.TicketResponseDto;
import com.example.BookMyShow.dto.TicketDto;

public interface TicketService {


    TicketResponseDto getTicket(int id); //H.W (Hint is same as you do in GetMovie)

    TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto);

}
