/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.*;
import java.util.List;
import model.User;
/**
 * HoTen: LeDucTien
 * MSV: 2050531200309
 * LHP: 221LTJNC01
 */
public class UserDao {
    private final Connection connection = SQLServerJTDSConnection.getSQLServerConnection();

    public UserDao() {
    }
    
    public void closeConnection() throws SQLException {
        connection.close();
    }
    
    public boolean isUserNameExists(String userName) throws SQLException {
        String sql = "SELECT * FROM tblUser WHERE userName = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, userName);
        ResultSet rs = preparedStatement.executeQuery();
        return rs.next();
    }
    
    public boolean signIn(String userName, String password) throws SQLException {
        String sql = "SELECT * FROM tblUser WHERE userName = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, password);
        ResultSet rs = preparedStatement.executeQuery();
        return rs.next();
    }
    
    public boolean signUp(String userName, String password) throws SQLException {
        String sql = "INSERT INTO tblUser VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, password);
        int rs = preparedStatement.executeUpdate();
        return rs != 0;
    }
}
