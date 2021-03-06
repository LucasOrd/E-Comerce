package com.ecomerce.ecomerce.model;

public class Cliente {

    private Long id;
    private String name;
    private int age;
    private String rol;
    private String email;
    private Long phone;


    public Cliente(Long id, String rol , String email, Long phone) {
        this.id=id;
        this.rol=rol;
        this.email=email;
        this.phone=phone;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}