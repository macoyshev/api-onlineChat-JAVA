package com.macoyshev.restAPI.api.convertors;

import com.macoyshev.restAPI.api.dto.UserDto;
import com.macoyshev.restAPI.store.entities.UserEntity;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Component
public class UserDtoConvertor {

  public UserDto makeUserDto(UserEntity entity) {
        return UserDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public List<UserDto> makeUserDto(List<UserEntity> entities) {
        return entities.stream()
                .map(this::makeUserDto)
                .collect(Collectors.toList());
    }
}
