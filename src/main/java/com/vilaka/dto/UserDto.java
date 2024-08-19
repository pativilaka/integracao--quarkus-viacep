package com.vilaka.dto;

import com.vilaka.entity.Address;
import com.vilaka.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDto {

    private long id;
    private String name;
    private int age;
    private List<EnderecoDto> enderecos = new ArrayList<>();

    public UserDto() {
    }

    public UserDto(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public UserDto(User entity) {
        id = entity.getId();
        name = entity.getName();
        age = entity.getAge();
        for(Address a : entity.getAddressesList()){
            enderecos.add(new EnderecoDto(a));
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<EnderecoDto> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoDto> enderecos) {
        this.enderecos = enderecos;
    }
}
