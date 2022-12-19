package com.example.BookMyShow.Service.impl;

import com.example.BookMyShow.Model.TheaterEntity;
import com.example.BookMyShow.Model.TheaterSeatsEntity;
import com.example.BookMyShow.Repository.TheaterRepository;
import com.example.BookMyShow.Repository.TheaterSeatsRepository;
import com.example.BookMyShow.Service.TheaterService;
import com.example.BookMyShow.converter.TheaterConverter;
import com.example.BookMyShow.dto.EntryDto.TheaterEntryDto;
import com.example.BookMyShow.dto.ResponseDto.TheaterResponseDto;
import com.example.BookMyShow.enums.SeatType;
import com.example.BookMyShow.enums.TheaterType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TheaterServiceImpl implements TheaterService {

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    TheaterSeatsRepository theaterSeatsRepository;

    @Override
    public TheaterResponseDto addTheater(TheaterEntryDto theaterEntryDto) {

        TheaterEntity theaterEntity = TheaterConverter.convertDtoToEntity(theaterEntryDto);


        //create the Seats
        List<TheaterSeatsEntity> seats = createTheaterSeats();


        theaterEntity.setSeats(seats);
        //I need to set the theaterId for all these seats

        theaterEntity.setShows(null);

        for(TheaterSeatsEntity theaterSeatsEntity:seats){
            theaterSeatsEntity.setTheater(theaterEntity);
        }

        theaterEntity.setType(TheaterType.SINGLE);

        log.info("The theater entity is "+ theaterEntity);

        theaterEntity = theaterRepository.save(theaterEntity);
        theaterSeatsRepository.saveAll(seats);

        TheaterResponseDto theaterResponseDto = TheaterConverter.convertEntityToDto(theaterEntity);


        return theaterResponseDto;

    }

    List<TheaterSeatsEntity> createTheaterSeats(){


        List<TheaterSeatsEntity> seats = new ArrayList<>();

        seats.add(getTheaterSeat("1A",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1B",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1C",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1D",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1E",100,SeatType.CLASSIC));

        seats.add(getTheaterSeat("2A",100,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2B",100,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2C",100,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2D",100,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2E",100,SeatType.PREMIUM));

        return seats;
        //Add in this TheaterSeatEntity type

    }

    TheaterSeatsEntity getTheaterSeat(String seatName, int rate, SeatType seatType){

        return TheaterSeatsEntity.builder().seatNumber(seatName).rate(rate).seatType(seatType).build();
    }

    //Seperate function will be create...


    @Override
    public TheaterResponseDto getTheater(int id) {

        TheaterEntity theaterEntity = theaterRepository.findById(id).get();

        TheaterResponseDto theaterResponseDto = TheaterConverter.convertEntityToDto(theaterEntity);

        return theaterResponseDto;
    }
}
