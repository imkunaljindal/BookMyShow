package com.example.BookMyShow.dto.EntryDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TheaterEntryDto {

    String name;
    String address;
    String city;

}
