package com.example.assignment5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBActions {
    public static void insertProduct(Product product) {
        try (Connection connection = Connector.getConnection()) {
            String query = "INSERT INTO products (name, company, price, idproducts) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, product.getName());
                preparedStatement.setString(2, product.getCompany());
                preparedStatement.setDouble(3, product.getPrice());
                preparedStatement.setInt(4, product.getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateProduct(Product product) {
        try (Connection connection = Connector.getConnection()) {
            String query = "UPDATE products SET name=?, company=?, price=? WHERE idproducts=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, product.getName());
                preparedStatement.setString(2, product.getCompany());
                preparedStatement.setDouble(3, product.getPrice());
                preparedStatement.setInt(4, product.getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteProduct(int productId) {
        try (Connection connection = Connector.getConnection()) {
            String query = "DELETE FROM products WHERE idproducts=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, productId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = Connector.getConnection()) {
            String query = "SELECT * FROM products";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Product product = new Product();
                        product.setId(resultSet.getInt("idproducts"));
                        product.setName(resultSet.getString("name"));
                        product.setCompany(resultSet.getString("company"));
                        product.setPrice(resultSet.getDouble("price"));
                        products.add(product);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
