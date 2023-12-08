package com.example.assignment5;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.List;
import javafx.scene.control.cell.PropertyValueFactory;



public class Controller {
    @FXML
    private TextField productIdField;

    @FXML
    private TextField productNameField;

    @FXML
    private TextField productCompanyField;

    @FXML
    private TextField productPriceField;

    @FXML
    private TableView<Product> productTableView;

    @FXML
    private TableColumn<Product, Integer> idColumn;

    @FXML
    private TableColumn<Product, String> nameColumn;

    @FXML
    private TableColumn<Product, String> companyColumn;

    @FXML
    private TableColumn<Product, Double> priceColumn;

    // Implement methods for insertProduct, updateProduct, deleteProduct, and displayProducts

    @FXML
    private void insertProduct() {
        Product newProduct = new Product();
        newProduct.setId(Integer.parseInt(productIdField.getText()));
        newProduct.setName(productNameField.getText());
        newProduct.setCompany(productCompanyField.getText());
        newProduct.setPrice(Double.parseDouble(productPriceField.getText()));
        DBActions.insertProduct(newProduct);
    }

    @FXML
    private void updateProduct() {
        Product newProduct = new Product();
        newProduct.setId(Integer.parseInt(productIdField.getText()));
        newProduct.setName(productNameField.getText());
        newProduct.setCompany(productCompanyField.getText());
        newProduct.setPrice(Double.parseDouble(productPriceField.getText()));
        DBActions.updateProduct(newProduct);
    }

    @FXML
    private void deleteProduct() {
        DBActions.deleteProduct(Integer.parseInt(productIdField.getText()));
    }

    @FXML
    private void displayProducts() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        companyColumn.setCellValueFactory(new PropertyValueFactory<>("company"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        productTableView.getItems().clear();
        List<Product> products = DBActions.getAllProducts();
        for(Product product : products) {
            System.out.println(product);
            productTableView.getItems().add(product);
        }
    }
}