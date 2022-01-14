package com.ecomerce.ecomerce.controller;

import com.ecomerce.ecomerce.domain.UserConfig;
import com.ecomerce.ecomerce.service.ConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/e-comerce/api/config")
public class ConfigController {

    private static final Logger logger = LoggerFactory.getLogger(ConfigController.class);

    @Autowired
    ConfigService configService;

    @PutMapping("/users")
    UserConfig updateConfig(@RequestBody UserConfig userConfig) {
        logger.info("PUT Request recibido");
        configService.updateUserConfig(userConfig.getRol());
        return userConfig;
    }

}