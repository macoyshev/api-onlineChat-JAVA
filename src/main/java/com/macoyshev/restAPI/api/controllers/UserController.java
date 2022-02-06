package com.macoyshev.restAPI.api.controllers;


import com.macoyshev.restAPI.api.convertors.UserDtoConvertor;
import com.macoyshev.restAPI.api.dto.UserDto;
import com.macoyshev.restAPI.api.exceptions.BadRequestException;
import com.macoyshev.restAPI.store.entities.UserEntity;
import com.macoyshev.restAPI.store.repositories.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RestController
public class UserController {

    UserRepository repository;
    UserDtoConvertor convertor;

    public static final String FETCH = "/api/users";
    public static final String CREATE = "/api/users";
    public static final String DELETE = "/api/users/{id}";
    public static final String GET = "/api/users/{id}";

    @GetMapping(FETCH)
    public List<UserDto> fetch() {
        List<UserEntity> entities = repository.findAll();
        
        return convertor.makeUserDto(entities);
    }

    @PostMapping(CREATE)
    public UserDto create(@RequestParam String name) {
      repository
        .findByName(name)
        .ifPresent(user -> {
          throw new BadRequestException(String.format("Project %s already exists", name));
        });

      UserEntity user = repository.saveAndFlush(
        UserEntity.builder()
          .name(name)
          .build()
      );

      return convertor.makeUserDto(user);
    }

    @DeleteMapping(DELETE)
    public void delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }

    @GetMapping(GET)
    public UserDto getOne(@PathVariable("id") Long id) {
      UserEntity user = repository.findById(id)
        .orElseThrow(() -> {
          throw new BadRequestException("User not found, id: " + id);
        });

      return convertor.makeUserDto(user);
    }
}
