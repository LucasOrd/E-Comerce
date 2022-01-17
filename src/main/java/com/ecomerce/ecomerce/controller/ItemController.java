package com.ecomerce.ecomerce.controller;


import com.ecomerce.ecomerce.model.Item;
import com.ecomerce.ecomerce.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/e-comerce")
public class ItemController {

    @Autowired
    ItemService service;

    @PostMapping("/item")
    public Item createItem(@RequestBody Item item) {
        return service.createItem(item);
    }


    @PutMapping("/item/{id}")
    public Item updateItemById(@PathVariable Long id, @RequestBody  Item user) {
        return service.updateItemById(user, id);
    }

    @GetMapping ("item")
    public List<Item> findItems() {
        return service.findAll();
    }

    @GetMapping("item/{id}")
    public Item getItemById (@PathVariable Long id){
        return service.getItemById(id);
    }

    @DeleteMapping("item/{id}")
    public void deleteItem (@PathVariable Long id, @RequestBody  Item item){
        service.deleteItem(item,id);
    }
}