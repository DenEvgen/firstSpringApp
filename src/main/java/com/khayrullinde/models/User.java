package com.khayrullinde.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {

    private int id;

    @Min(value = 0, message = "STOP")
    private int age;

    @NotEmpty(message = "Name can't be null")
    @Size(min = 2, max = 30, message = "2-30 CHARACTERS")
    private String name;

    @NotEmpty(message = "Email can't be null")
    @Email(message = "Enter valid email")
    private String email;

    public User(){

    }

    public User(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
