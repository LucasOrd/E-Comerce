package com.ecomerce.ecomerce.service;

import com.ecomerce.ecomerce.utils.ConfigType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioCliente {

    @Autowired
    ObservadorCliente observadorCliente;

    private String userRol;

    public void updateUserConfig(String userRolParam) {

        userRol = userRolParam;
        observadorCliente.notifyObservers(ConfigType.USER);
    }

    public String getUserRol() {
        return userRol;
    }

    public void setUserRol(String userRol) {

        this.userRol = userRol;
    }

}