package com.ecomerce.ecomerce.utils;


import com.ecomerce.ecomerce.handle.ApiRestException;

public interface ConfigObserver {
    void updateConfig(Object event) throws ApiRestException;
    void deleteConfig(Object event);
}