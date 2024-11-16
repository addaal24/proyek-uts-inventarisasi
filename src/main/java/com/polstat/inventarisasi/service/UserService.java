package com.polstat.inventarisasi.service;

import com.polstat.inventarisasi.dto.UserDto;

public interface UserService {
    public UserDto createUser(UserDto user);
    public UserDto getUserByEmail(String email);
}
