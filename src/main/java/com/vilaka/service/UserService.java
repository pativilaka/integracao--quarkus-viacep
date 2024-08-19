package com.vilaka.service;

import com.vilaka.dto.UserDto;
import com.vilaka.entity.Address;
import com.vilaka.entity.User;
import com.vilaka.repositories.UserRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.stream.Collectors;

@RequestScoped
public class UserService {

    private final UserRepository userRepository;

    @Inject
    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public UserDto cadastraUser(UserDto userDto){

        User userEntity = new User();
        userEntity.setName(userDto.getName());
        userEntity.setAge(userDto.getAge());

        userEntity.setAddressesList(userDto.getEnderecos().stream()
                .map(aDto -> {
                    Address aEntity = new Address();
                    aEntity.setCep(aDto.getCep());
                    aEntity.setLogradouro(aDto.getLogradouro());
                    aEntity.setBairro(aDto.getBairro());
                    aEntity.setLocalidade(aDto.getLocalidade());
                    aEntity.setUf(aDto.getUf());
                    aEntity.setUser(userEntity);
                    return aEntity;
                }).collect(Collectors.toList()));

        userRepository.persist(userEntity);

        return new UserDto(userEntity);
    }
}
