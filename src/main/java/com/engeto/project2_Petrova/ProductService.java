package com.engeto.project2_Petrova;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    static Connection connection;

    public ProductService() throws SQLException {
      //  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoitem",user: "project2_host")
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","project2_user","Engeto123");
    }

    public List<Product> getAllProducts() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeQuery("SELECT * FROM product");

        ResultSet resultSet = statement.getResultSet();

        List <Product> resultList = new ArrayList<>();

        while (resultSet.next()){
            resultList.add(new Product(
                    resultSet.getString("partnumber"),
                    resultSet.getString("name"),
                    resultSet.getString("description"),
                    resultSet.getBoolean("isForSale"),
                    resultSet.getBigDecimal("price"),
                    resultSet.getInt("id")
            ));
        }
        return resultList;
    }

    public Integer insertNewProduct(Product newProduct) throws SQLException {
        //System.out.println("We are inserting new item..");
        Statement statement = connection.createStatement();
        statement.executeUpdate(
                "INSERT INTO product(name, description, isForSale, price,partnumber) VALUES('"
                        //+ newProduct.getPartnumber() + "', '"
                        + newProduct.getName() + "', '"
                        + newProduct.getDescription() + "', "
                        + newProduct.getIsForSale() + ", "
                        + newProduct.getPrice() + ",'"
                        + newProduct.getPartnumber() + "')",1);


        return statement.getGeneratedKeys().getInt(1);
    }

    public void deleteOldProduct(Integer myId) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(
                "DELETE FROM product WHERE id = " + myId  );
    }

    public void updateProduct(Product product,Integer myId) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(
                "UPDATE product SET "
                        + "name = " + product.getName()
                        + "description = " + product.getDescription()
                        + "isForSale = " + product.getIsForSale()
                        + "price = " + product.getPrice()
                        + "partnumber " + product.getPartnumber()
                        + " WHERE id = " + myId);
    }
}
