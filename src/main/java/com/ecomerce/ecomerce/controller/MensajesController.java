package com.ecomerce.ecomerce.controller;

import com.ecomerce.ecomerce.handle.ApiRestException;
import com.ecomerce.ecomerce.model.Mensaje;
import com.ecomerce.ecomerce.service.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/coder-house")
public class MensajesController {

    Logger logger = LogManager.getLogger(MensajesController.class);

    @Autowired
    private PersonService personService;

    @GetMapping("/mensajes/example")
    public String getMensajesString() {
        logger.info("GET Request recibido string");
        return "Ejemplo de respuesta puerto 8082";
    }

    @GetMapping("/mensajes/all")
    public List<Mensaje> getMensajesAll() {
        logger.info("GET Request recibido string");
        return dataMensajes();
    }

    @GetMapping("/mensajes")
    public List<Mensaje> getMensajesByDescription(@RequestParam String description) {
        logger.info("GET obtener mensajes que sean iguales a la descripción");
        var msjFiltered = dataMensajes().stream()
                .filter(mensajes -> mensajes.getDescription().equalsIgnoreCase(description));
        return msjFiltered.collect(Collectors.toList());
    }

    @GetMapping("/mensajes/{id}")
    public Mensaje getMensajeById(@PathVariable Long id) throws ApiRestException {
        logger.info("GET obtener mensaje por el id");

        if(id == 0) {
            throw new ApiRestException("El identificador del mensaje debe ser mayor a 0");
        }
        var msjFiltered = dataMensajes().stream()
                .filter(mensajes -> Objects.equals(mensajes.getId(), id));
        return msjFiltered.findFirst().orElse(new Mensaje(0L, "No existe el mensaje"));
    }


    @PostMapping("/mensajes")
    public Mensaje createMensaje(@RequestBody Mensaje mensaje) {
        logger.info("POST Request recibido");
        return mensaje;
    }

    @PutMapping("/mensajes/{id}")
    public Mensaje updateMensaje(@PathVariable Long id, @RequestBody Mensaje mensaje) throws ApiRestException {
        logger.info("PUT Request recibido por id");
        if (id == 0) {
            throw new ApiRestException("El identificador del mensaje debe ser mayor a 0");
        }
        return mensaje;
    }

    @DeleteMapping("/mensajes/{id}")
    public void deleteMensaje(@PathVariable Long id) throws ApiRestException {
        logger.info("DELETE Request recibido por id");
        if (id == 0) {
            throw new ApiRestException("El identificador del mensaje debe ser mayor a 0");
        }
    }


    private List<Mensaje> dataMensajes() {
        List<Mensaje> aux = new List<Mensaje>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Mensaje> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Mensaje mensaje) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Mensaje> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Mensaje> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Mensaje get(int index) {
                return null;
            }

            @Override
            public Mensaje set(int index, Mensaje element) {
                return null;
            }

            @Override
            public void add(int index, Mensaje element) {

            }

            @Override
            public Mensaje remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Mensaje> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Mensaje> listIterator(int index) {
                return null;
            }

            @Override
            public List<Mensaje> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        aux.add(new Mensaje(1L, "Prueba-1"));
        aux.add(new Mensaje(2L, "Prueba-2"));
        return aux;


    }
}