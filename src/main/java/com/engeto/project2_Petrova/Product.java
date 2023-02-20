package com.engeto.project2_Petrova;

import java.math.BigDecimal;

public class Product {
    private String partNumber;
    private String name;
    private Integer id;
    private String description;
    private boolean isForSale;
    private BigDecimal price;
    //private int id;


    public Product(){

    }

    public Product(String partNumber, String name, String description, boolean isForSale, BigDecimal price){
        this.partNumber = partNumber;
        this.name = name;
        this.description = description;
        this.isForSale = isForSale;
        this.price = price;
        //            id =0;
     //   this.id = id;
    }
    public Product(String partNumber, String name, String description, boolean isForSale, BigDecimal price, Integer id){
        this.partNumber = partNumber;
        this.name = name;
        this.description = description;
        this.isForSale = isForSale;
        this.price = price;
        //            id =0;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getPartnumber(){
        return partNumber;
    }

    public void setPartnumber(){
        this.partNumber = partNumber;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(){
        this.description = description;
    }

    public boolean getIsForSale(){
        return isForSale;
    }

    public void setIsForSale(){
        this.isForSale = isForSale;
    }

    public BigDecimal getPrice(){
        return price;
    }

    public void setPrice(){
        this.price = price;
    }

   public void updatePrice(BigDecimal price){
        this.price = price;
    }

}