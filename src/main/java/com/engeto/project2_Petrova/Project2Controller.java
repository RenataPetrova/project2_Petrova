package com.engeto.project2_Petrova;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@RestController
public class Project2Controller{

    //vrati vo forme vypisu tohto jedneho produktu vo svorkovej zatvorke
    @GetMapping("/getProduct/1")
    public Product getItem(){
        Product product = new Product("123","srobka R20","obycajna srobka",true,BigDecimal.valueOf(1));
        return product;
    }

    @GetMapping("/addProduct")
    public Product addProduct(){
        Product product = new Product("123","srobka R20","obycajna srobka",true,BigDecimal.valueOf(1));
        product.setId(1);
        products.put(1,product);
        return product;
    }
    Map<Integer,Product> products = new HashMap<>();

    @GetMapping("/getAllItems")
    public Collection<Product> getAllItems(){
        return products.values();
    }
    @GetMapping("/getProduct/{id}")
    public Product getItemById(@PathVariable ("id") int id){
        return products.get(id);
    }
}