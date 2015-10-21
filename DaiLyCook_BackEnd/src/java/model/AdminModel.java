/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.UserDAO;
import entity.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyen Hoai Nam
 */
public class AdminModel {
    //get list admin
    public List<User> getUsersAdmin(){
        List<User> users = new ArrayList<>();
        List<User> users_admin = new ArrayList<>();
        users = UserDAO.getInstance().getAllUser();
        for (User user : users) {
            if(user.getRole().equals("admin")){
                users_admin.add(user);
            }
            
            
        }
        return users_admin;
    }
    //add new admin
    public  void insertAdmin(User user){
        UserDAO.getInstance().save(user);
    }
    
}
