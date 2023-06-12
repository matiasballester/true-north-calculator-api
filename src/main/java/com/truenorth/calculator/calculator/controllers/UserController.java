package com.truenorth.calculator.calculator.controllers;

import com.truenorth.calculator.calculator.dtos.RecordDTO;
import com.truenorth.calculator.calculator.dtos.UserDTO;
import com.truenorth.calculator.calculator.mappers.RecordMapper;
import com.truenorth.calculator.calculator.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RecordMapper recordMapper;

    @GetMapping("/")
    public List<UserDTO> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable(name = "id") Long id) {
        return userService.findById(id);
    }

    @GetMapping("/{id}/records")
    public List<RecordDTO> getUserRecords(@PathVariable(name = "id") Long id) {
        UserDTO userDTO = userService.findById(id);
        return userDTO.getRecords();
    }

}
