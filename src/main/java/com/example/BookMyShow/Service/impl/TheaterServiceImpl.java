package com.example.BookMyShow.Service.impl;

import com.example.BookMyShow.Model.TheaterEntity;
import com.example.BookMyShow.Model.TheaterSeatsEntity;
import com.example.BookMyShow.Repository.TheaterRepository;
import com.example.BookMyShow.Repository.TheaterSeatsRepository;
import com.example.BookMyShow.Service.TheaterService;
import com.example.BookMyShow.converter.TheaterConverter;
import com.example.BookMyShow.dto.TheaterDto;
import com.example.BookMyShow.enums.SeatType;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterServiceImpl implements TheaterService {

    @Autowired
    TheaterSeatsRepository theaterSeatsRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Override
    public void addTheater(TheaterDto theaterDto) {

        TheaterEntity theaterEntity = TheaterConverter.dtoToEntity(theaterDto);

        List<TheaterSeatsEntity> seats = createTheaterSeats();
        for(TheaterSeatsEntity theaterSeat: seats)
            theaterSeat.setTheater(theaterEntity);

        theaterRepository.save(theaterEntity);
    }

    public List<TheaterSeatsEntity> createTheaterSeats(){

        List<TheaterSeatsEntity> seats = new ArrayList<>();

        seats.add(getTheaterSeat("1A",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1B",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1C",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1D",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1E",100,SeatType.CLASSIC));

        seats.add(getTheaterSeat("2A",200,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2B",200,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2C",200,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2D",200,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2E",200,SeatType.PREMIUM));

        theaterSeatsRepository.saveAll(seats);
        return seats;
    }

    public TheaterSeatsEntity getTheaterSeat(String seatNo, int rate, SeatType seatType){
        return TheaterSeatsEntity.builder().seatNumber(seatNo).rate(rate).seatType(seatType).build();
    }


    @Override
    public TheaterDto getTheater(int id) {
        TheaterEntity theaterEntity = theaterRepository.findById(id).get();

        TheaterDto theaterDto = TheaterConverter.entityToDto(theaterEntity);

        return theaterDto;
    }
}
