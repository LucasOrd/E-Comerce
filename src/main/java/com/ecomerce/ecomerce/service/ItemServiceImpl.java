package com.ecomerce.ecomerce.service;


import com.ecomerce.ecomerce.model.Item;
import com.ecomerce.ecomerce.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository repository;

    @Override
    public Item createItem(Item item) {
        return repository.save(item);
    }

    @Override
    public Item getItemById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Item updateItemById(Item item, Long id) {
        item.setId(id);
        return repository.save(item);
    }

    @Override
    public void deleteItem(Item item, Long id) {
        item.setId(id);
        repository.delete(item);
    }

    @Override
    public List<Item> findAll() {
        return (List<Item>) repository.findAll();
    }

}


