package com.ecomerce.ecomerce.repository;

import com.ecomerce.ecomerce.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {

}
