package com.truenorth.calculator.calculator.services;

import com.truenorth.calculator.calculator.dtos.CredentialsDto;
import com.truenorth.calculator.calculator.dtos.RecordDTO;
import com.truenorth.calculator.calculator.dtos.SignUpDto;
import com.truenorth.calculator.calculator.dtos.UserDTO;
import com.truenorth.calculator.calculator.exceptions.AppException;
import com.truenorth.calculator.calculator.mappers.UserMapper;
import com.truenorth.calculator.calculator.entities.User;
import com.truenorth.calculator.calculator.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RecordService recordService;

    public UserDTO login(CredentialsDto credentialsDto) {
        User user = userRepository.findByName(credentialsDto.name())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.password()), user.getPassword())) {
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public UserDTO register(SignUpDto userDto) {
        Optional<User> optionalUser = userRepository.findByName(userDto.name());

        if (optionalUser.isPresent()) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        User user = userMapper.signUpToUser(userDto);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.password())));

        User savedUser = userRepository.save(user);

        return userMapper.toUserDto(savedUser);
    }

    public UserDTO findByName(String login) {
        User user = userRepository.findByName(login)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }

    public UserDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }

    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(user -> userMapper.toUserDto(user))
                .collect(Collectors.toList());
    }

    public List<RecordDTO> findRecords(Long userId) {
        return recordService.getRecordsByUserId(userId);
    }



}
