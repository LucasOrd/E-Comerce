package com.ecomerce.ecomerce.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document("producto")
public class Product {

    @Id
    private Long id;
    private String title;
    private Long price;

    public Product(Long id, String title, Long price) {
        this.id = id;
        this.title = title;
        this.price=price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getPrice() {
        return price;
    }

    public void setDescription(String title) {
        this.title = title;
    }

    public String getDescription() {
        return title;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
