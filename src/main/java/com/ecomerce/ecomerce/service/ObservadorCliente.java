package com.ecomerce.ecomerce.service;

import com.ecomerce.ecomerce.utils.ConfigObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class ObservadorCliente {

    private static final Logger logger = LoggerFactory.getLogger(ObservadorCliente.class);

    private final Set<ConfigObserver> observers;

    public ObservadorCliente() {
        observers = Collections.synchronizedSet(new HashSet<>());
    }

    public void addObserver(ConfigObserver observer) {
        logger.info("Se agrega un observador");
        observers.add(observer);
    }

    public void removeObserver(ConfigObserver observer) {
        logger.info("Se elimina un observador");
        observers.remove(observer);
    }

    public void notifyObservers(Object event) {
        synchronized (observers) {
            logger.info("Se notifica a los observadores");
            observers.forEach(observer -> {
                try {
                    observer.updateConfig(event);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}