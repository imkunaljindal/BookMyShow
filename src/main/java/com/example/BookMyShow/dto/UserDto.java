package com.example.BookMyShow.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private int id;

    @NonNull
    private String name;

    @NonNull
    private String mobile;
}
