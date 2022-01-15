package com.ecomerce.ecomerce.controller;

import com.ecomerce.ecomerce.domain.ClienteConfig;
import com.ecomerce.ecomerce.handle.ApiRestException;
import com.ecomerce.ecomerce.model.Cliente;
import com.ecomerce.ecomerce.service.ServicioCliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/e-comerce/api/config")
public class ControlladorCliente {

    private static final Logger logger = LoggerFactory.getLogger(ControlladorCliente.class);

    @Autowired
    ServicioCliente servicioCliente;

    @GetMapping("/users/all")
    public ArrayList<Cliente> getUsersAll() {
        logger.info("GET Request recibido string");
        //solo para que no este vacio
        Cliente aux = new Cliente(10L,"programer","lucas",1234L);
        this.dataClientes.add(aux);
        return dataClientes;
    }

    private ArrayList<Cliente> dataClientes = new ArrayList<>();

    @PutMapping("/users")
    ClienteConfig updateConfig(@RequestBody ClienteConfig clienteConfig) {
        logger.info("PUT Request recibido");
        servicioCliente.updateUserConfig(clienteConfig.getRol());
        return clienteConfig;
    }

    @PostMapping("/users")
    public Cliente createUser(@RequestBody Cliente cliente) {
        logger.info("POST Request recibido");
        return cliente;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) throws ApiRestException {
        logger.info("DELETE Request recibido por id");
        if (id == 0) {
            throw new ApiRestException("El identificador del mensaje debe ser mayor a 0");
        }
    }

}