package com.ecomerce.ecomerce.utils;


public interface ConfigObserver {
    void updateConfig(Object event) ;
    void deleteConfig(Object event);
}