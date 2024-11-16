package com.polstat.inventarisasi.service;

import com.polstat.inventarisasi.dto.UserDto;
import com.polstat.inventarisasi.entity.User;
import com.polstat.inventarisasi.mapper.UserMapper;
import com.polstat.inventarisasi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User user = userRepository.save(UserMapper.mapToUser(userDto));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public UserDto getUserByEmail (String email) {
        User user = userRepository.findByEmail(email);
        return UserMapper.mapToUserDto(user);
    }
}
