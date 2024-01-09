package com.engeto.project2_Petrova;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@RestController
public class Project2Controller{

    ProductService productService;

    public Project2Controller() throws SQLException {
        productService = new ProductService();
    }

    //vrati vo forme vypisu tohto jedneho produktu vo svorkovej zatvorke
    /*@GetMapping("/getProduct/1")
    public Product getItem(){
        Product product = new Product("123","srobka R20","obycajna srobka",true,BigDecimal.valueOf(1),1);
        return product;
    }
*/
   /* @GetMapping("/addProduct")
    public Product addProduct(){
        Product product = new Product("123","srobka R20","obycajna srobka",true,BigDecimal.valueOf(15),2);
        product.setId(2);
        products.put(2,product);
        return product;
    }
    */
    //Map<Integer, Product> products = new HashMap<Integer, Product>();

    //int seq = 0;

    @GetMapping("/getAllItems")
    public Collection<Product> getAllItems() throws SQLException {
        return productService.getAllProducts();
    }
    /*@GetMapping("/getProduct/{id}")
    public Product getItemById(@PathVariable ("id") int id){
       // Product product = new Product("4","matica R20","obycajna matka",true,BigDecimal.valueOf(40),3);
        return products.get(id);
    }
*/
    @PostMapping("/postProduct")
    public Product postProduct(@RequestBody Product product) throws SQLException {

       // System.out.println("We are inserting new item..");
        Integer generatedId = productService.insertNewProduct(product);
        product.setId(generatedId);
        return product;
    }

    @PutMapping("/putProduct/{id}")
    public Product putProduct(@PathVariable Integer id, @RequestBody Product product) throws SQLException {
        //product.setId(id);
        //products.put(id, product);
        productService.updateProduct(product,id);
        return product;
    }

    @DeleteMapping("/deleteProduct/{id}")
     public void deleteProduct(@PathVariable Integer id) throws SQLException {
        //products.remove(id);
        productService.deleteOldProduct(id);
        //product.setId(generatedId);
        //return product;
    }


}