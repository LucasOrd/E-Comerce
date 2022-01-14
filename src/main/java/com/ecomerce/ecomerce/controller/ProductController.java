package com.ecomerce.ecomerce.controller;

import com.ecomerce.ecomerce.handle.ApiRestException;
import com.ecomerce.ecomerce.model.Product;
import com.ecomerce.ecomerce.service.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/e-comerce")
public class ProductController {


    Logger logger = LogManager.getLogger(ProductController.class);

    @Autowired
    private PersonService personService;

    @GetMapping("/api/prueba")
    public String getProductosString() {
        logger.info("GET Request recibido string");
        return "Ejemplo de respuesta";
    }

    @GetMapping("/api/productos")
    public List<Product> getProductsAll() throws ApiRestException {
        if (data.size() == 0){
            throw new ApiRestException("No hay productos cargados");
        }
        logger.info("GET Request recibido string");
        return dataProductos();
    }

    @GetMapping("/api")
    public List<Product> getProductsByDescription(@RequestParam String description) {
        logger.info("GET obtener mensajes que sean iguales a la descripción");
        var msjFiltered = dataProductos().stream()
                .filter(products -> products.getDescription().equalsIgnoreCase(description));
        return msjFiltered.collect(Collectors.toList());
    }

    @GetMapping("/api/productos/{id}")
    public Product getMensajeById(@PathVariable Long id) throws ApiRestException {
        logger.info("GET obtener mensaje por el id");

        if(id == 0) {
            throw new ApiRestException("El identificador del mensaje debe ser mayor a 0");
        }
        boolean aux=false;
        for (int i=0; i<this.data.size();i++){
            if (id == data.get(i).getId()) {
                aux=true;
            }
        }
        if (aux == false){
            throw new ApiRestException("Producto no encontrado");
        }
        var msjFiltered = dataProductos().stream()
                .filter(products -> Objects.equals(products.getId(), id));
        return msjFiltered.findFirst().orElse(new Product(0L, "No existe el producto",0L));
    }

    @PostMapping("/api/productos")
    public Product createProduct(@RequestBody Product product) {
        logger.info("POST Request recibido");
        Product aux = new Product(contador+1,product.getDescription(),product.getPrice());
        data.add(aux);
        contador++;
        return aux;
    }

    private ArrayList<Product> data = new ArrayList<>();

    private long contador=0;

    private List<Product> dataProductos() {
        return this.data;
    }
}
