package com.ecomerce.ecomerce.controller;

import com.ecomerce.ecomerce.domain.UserConfig;
import com.ecomerce.ecomerce.handle.ApiRestException;
import com.ecomerce.ecomerce.model.User;
import com.ecomerce.ecomerce.service.ConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/e-comerce/api/config")
public class ConfigController {

    private static final Logger logger = LoggerFactory.getLogger(ConfigController.class);

    @Autowired
    ConfigService configService;

    @GetMapping("/users/all")
    public ArrayList<User> getUsersAll() {
        logger.info("GET Request recibido string");
        //solo para que no este vacio
        User aux = new User (10L,"programer","lucas",1234L);
        this.dataUsers.add(aux);
        return dataUsers;
    }

    private ArrayList<User> dataUsers= new ArrayList<>();

    @PutMapping("/users")
    UserConfig updateConfig(@RequestBody UserConfig userConfig) {
        logger.info("PUT Request recibido");
        configService.updateUserConfig(userConfig.getRol());
        return userConfig;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        logger.info("POST Request recibido");
        return user;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) throws ApiRestException {
        logger.info("DELETE Request recibido por id");
        if (id == 0) {
            throw new ApiRestException("El identificador del mensaje debe ser mayor a 0");
        }
    }

}