package com.truenorth.calculator.calculator.mappers;


import com.truenorth.calculator.calculator.dtos.SignUpDto;
import com.truenorth.calculator.calculator.dtos.UserDTO;
import com.truenorth.calculator.calculator.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);

}
