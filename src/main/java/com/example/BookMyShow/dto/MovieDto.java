package com.example.BookMyShow.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDto {

    int id;

    String name;

    LocalDate releaseDate;

    List<ShowDto> movies;
}
