package com.bezkoder.spring.datajpa.controller;

import com.bezkoder.spring.datajpa.dto.UserDto;
import com.bezkoder.spring.datajpa.model.Tutorial;
import com.bezkoder.spring.datajpa.model.User;
import com.bezkoder.spring.datajpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")

public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/userData")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDto userDto) {
        try {
            User user1 = new User();
            user1.setContactno(userDto.getContactNo());
            user1.setEmailid(userDto.getEmailId());
            user1.setFirstname(userDto.getFirstName());
            user1.setLastname(userDto.getLastName());
            user1.setPassword(userDto.getPassword());

            List<User> userList = userRepository.findByEmailid(userDto.getEmailId());

            if (!userList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);

            }

            User _user = userRepository.save(user1);

            // User _user =userRepository.findByfirstnameContaining("vishal").get(0);
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/login")
    public ResponseEntity<List<User>> findbyemailIdorpassword(@RequestParam String emailId, @RequestParam String password) {
        User user = new User();

        try {
            List<User> users = new ArrayList<User>();


            if (emailId == null)
                userRepository.findAll().forEach(users::add);
            else
                users = userRepository.findByEmailidAndPassword(emailId, password);

            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @GetMapping("/login1")
    public ResponseEntity<List<User>> findbyfirstName(@RequestParam String firstName) {
        User user = new User();

        try {
            List<User> user1 = new ArrayList<User>();


            if (firstName == null)
                userRepository.findAll().forEach(user1::add);
            else
                user1 = userRepository.findByfirstnameContaining(firstName);

            if (user1.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(user1, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

