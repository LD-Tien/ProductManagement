/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserDao;
import java.sql.SQLException;

/**
 * HoTen: LeDucTien
 * MSV: 2050531200309
 * LHP: 221LTJNC01
 */
public class UserServices {
    UserDao userDao;

    public UserServices() {
        userDao = new UserDao();
    }
    
    public boolean isUserNameExists(String userName) throws SQLException {
        return userDao.isUserNameExists(userName);
    }
    
    public boolean signIn(String userName, String password) throws SQLException {
        return userDao.signIn(userName, password);
    }
    
    public boolean signUp(String userName, String password) throws SQLException {
        return userDao.signUp(userName, password);
    }
    
    
    
    public void closeConnection() throws SQLException {
        userDao.closeConnection();
    }
}
