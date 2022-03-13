/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Product;
import net.sourceforge.jtds.jdbcx.proxy.PreparedStatementProxy;
/**
 * HoTen: LeDucTien
 * MSV: 2050531200309
 * LHP: 221LTJNC01
 */
public class ProductDao {
    Connection connection = SQLServerJTDSConnection.getSQLServerConnection();
    
    public Product createProductData(ResultSet rs) throws SQLException {
        Product p = new Product();
        p.setProductId(rs.getString("productId"));
        p.setCategoryId(rs.getString("categoryId"));
        p.setCategoryName(rs.getString("categoryName"));
        p.setBrand(rs.getString("Brand"));
        p.setProductName(rs.getString("productName"));
        p.setColor(rs.getString("color"));
        p.setSize(rs.getString("size"));
        p.setQuantityAvailable(rs.getInt("quantityAvailable"));
        p.setUnitPrice(rs.getInt("unitPrice"));
        return p;
    }
    
    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM tblCategory, tblProduct WHERE tblCategory.categoryId = tblProduct.categoryId";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()) {
            products.add(createProductData(rs));
        }
        return products;
    } 
    
    public Product getProductById(String productId) throws SQLException {
        String sql = "SELECT * FROM tblCategory, tblProduct WHERE tblCategory.categoryId = tblProduct.categoryId AND productId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, productId);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) 
            return createProductData(rs);
        return null;
    }
    
    public List<Category> getAllCategory() throws SQLException {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM tblCategory";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()) {
            Category c = new Category();
            c.setCategoryId(rs.getString("categoryId"));
            c.setCategoryName(rs.getString("categoryName"));
            categories.add(c);
        }
        return categories;
    }
    
    public List<Product> getProductsByCategory(String category) throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM tblCategory, tblProduct WHERE tblCategory.categoryId = tblProduct.categoryId and tblcategory.categoryName = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, category);
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next()) {
            products.add(createProductData(rs));
        }
        return products;
    }
    
    public String getCategoryIdByCategoryName(String categoryName) throws SQLException {
        String sql = "SELECT * FROM tblCategory WHERE categoryName = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, categoryName);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) 
            return rs.getString("categoryId");
        return null;
    }
    
    public void addProduct(Product product) throws SQLException {
        String sql = "INSERT INTO tblProduct VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, product.getProductId());
        preparedStatement.setString(2, product.getCategoryId());
        preparedStatement.setString(3, product.getBrand());
        preparedStatement.setString(4, product.getProductName());
        preparedStatement.setString(5, product.getColor());
        preparedStatement.setString(6, product.getSize());
        preparedStatement.setInt(7, product.getQuantityAvailable());
        preparedStatement.setLong(8, product.getUnitPrice());
        preparedStatement.executeUpdate();
    }
    
    public void deleteProduct(String productId) throws SQLException {
        String sql = "DELETE tblProduct WHERE productId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, productId);
        preparedStatement.executeUpdate();
    }
    
    public void updateProduct(Product product) throws SQLException {
        String sql = "UPDATE tblProduct SET categoryId = ?, brand = ?, productName = ?, color = ?, size = ?, quantityAvailable = ?, unitPrice = ? WHERE productId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, product.getCategoryId());
        preparedStatement.setString(2, product.getBrand());
        preparedStatement.setString(3, product.getProductName());
        preparedStatement.setString(4, product.getColor());
        preparedStatement.setString(5, product.getSize());
        preparedStatement.setInt(6, product.getQuantityAvailable());
        preparedStatement.setLong(7, product.getUnitPrice());
        preparedStatement.setString(8, product.getProductId());
        preparedStatement.executeUpdate();
    }
}
