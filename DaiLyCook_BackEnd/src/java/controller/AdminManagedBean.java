/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.AdminModel;

/**
 *
 * @author Nguyen Hoai Nam
 */
@ManagedBean
@RequestScoped
public class AdminManagedBean {

    /**
     * Creates a new instance of AdminManagedBean
     */
    
    AdminModel adminModel = new AdminModel();
    List<User>  users = new ArrayList<>();
    String search;
    
    
    public AdminManagedBean() {
        
        users = adminModel.getUsersAdmin();
        
    }
    public void SearchUser() {
        List<User> search_user = new ArrayList<>();
        if (search != null) {
            for (User user : users) {
                if (user.getDisplayName().contains(search)) {
                    search_user.add(user);
                }

            }
            users = search_user;
        }
        search = "";
    }
    
    public String getSearch() {
        return search;
    }

    //get and set
    public void setSearch(String search) {
        this.search = search;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    
}
