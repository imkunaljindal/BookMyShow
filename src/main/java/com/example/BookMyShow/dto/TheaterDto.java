package com.example.BookMyShow.dto;

import com.example.BookMyShow.enums.TheaterType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheaterDto {

    int id;

    String name;

    String address;

    String city;

    //Seats ---> Think should we put or not

    //Show Entity
    ShowDto showDto;
}
