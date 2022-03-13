/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ProductDao;
import java.sql.SQLException;
import java.util.List;
import model.Category;
import model.Product;

/**
 * HoTen: LeDucTien
 * MSV: 2050531200309
 * LHP: 221LTJNC01
 */
public class ProductServices {
    ProductDao productDao;
    
    public ProductServices() {
        productDao = new ProductDao();
    }
    
    public List<Product> getAllProducts() throws SQLException {
        return productDao.getAllProducts();
    }
    
    public List<Category> getAllCategory() throws SQLException {
        return productDao.getAllCategory();
    }
    
    public List<Product> getProductsByCategory(String category) throws SQLException {
        return productDao.getProductsByCategory(category);
    }
    
    public Product getProductById(String productId) throws SQLException {
        return productDao.getProductById(productId);
    }
    
    public String getCategoryIdByCategoryName(String categoryName) throws SQLException {
        return productDao.getCategoryIdByCategoryName(categoryName);
    }
    
    public void addProduct(Product product) throws SQLException {
        productDao.addProduct(product);
    }
    
    public void updateProduct(Product product) throws SQLException {
        productDao.updateProduct(product);
    }
    
    public void deleteProduct(String productId) throws SQLException {
        productDao.deleteProduct(productId);
    }
}
