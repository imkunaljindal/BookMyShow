package com.example.BookMyShow.Service.impl;

import com.example.BookMyShow.Model.*;
import com.example.BookMyShow.Repository.*;
import com.example.BookMyShow.Service.ShowService;
import com.example.BookMyShow.converter.ShowConverter;
import com.example.BookMyShow.dto.ShowDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ShowServiceImpl implements ShowService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    ShowSeatsRepository showSeatsRepository;

    @Autowired
    ShowRepository showRepository;

    @Override
    public ShowDto addShow(ShowDto showDto) {
        ShowEntity showEntity = ShowConverter.dtoToEntity(showDto);

        MovieEntity movieEntity = movieRepository.findById(showDto.getMovieDto().getId()).get();
        showEntity.setMovie(movieEntity);

        TheaterEntity theaterEntity = theaterRepository.findById(showDto.getTheaterDto().getId()).get();
        showEntity.setTheater(theaterEntity);

        List<ShowSeatsEntity> seats = createShowSeatsEntity(theaterEntity.getSeats(),showEntity);
        showEntity.setSeats(seats);

        showRepository.save(showEntity);

        return showDto;
    }

    public List<ShowSeatsEntity> createShowSeatsEntity(List<TheaterSeatsEntity> theaterSeats,ShowEntity show){

        List<ShowSeatsEntity> showSeats = new ArrayList<>();
        for(TheaterSeatsEntity seat: theaterSeats){
            ShowSeatsEntity showSeat = ShowSeatsEntity.builder().id(seat.getId()).seatNumber(seat.getSeatNumber()).
                    seatType(seat.getSeatType()).
                    show(show).
                    build();
            showSeats.add(showSeat);
        }

        showSeatsRepository.saveAll(showSeats);
        return showSeats;
    }
}
