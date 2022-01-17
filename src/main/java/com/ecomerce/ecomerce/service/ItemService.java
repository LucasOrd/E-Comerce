package com.ecomerce.ecomerce.service;

import com.ecomerce.ecomerce.model.Item;

import java.util.List;


public interface ItemService {

    Item createItem(Item item);
    Item getItemById(Long id);
    Item updateItemById(Item item, Long id);
    void deleteItem(Item item, Long id);

    List<Item> findAll();
}
