package com.example.udyrprojectv1.entities.dtos;

public class UserDto {

    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private String cpf;

    public UserDto(Integer id, String name, Integer age, String email, String cpf) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.cpf = cpf;
    }
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }
}
