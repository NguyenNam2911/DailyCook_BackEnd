/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.User;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import model.AdminModel;
import org.apache.commons.lang3.RandomStringUtils;
/**
 *
 * @author Nguyen Hoai Nam
 */

@ManagedBean
@ViewScoped
public class AdminManagedBean extends Object{

    /**
     * Creates a new instance of AdminManagedBean
     */
    AdminModel adminModel = new AdminModel();
    List<User> users = new ArrayList<>();
    String search;
    User userAdmin;
    boolean addView;
    Date date;

    //method
    public void save(ActionEvent event){
        userAdmin.setRole("admin");
        userAdmin.setPassword(RandomStringUtils.randomAlphanumeric(8));
        userAdmin.setRegisteredTime(date.getTime());
        adminModel  = new AdminModel();
        adminModel.insertAdmin(userAdmin);
        users = adminModel.getUsersAdmin();
        userAdmin  = new User();
        addView = true;
    }
    public void cancel( ActionEvent event){
        userAdmin = new User();
        addView = true;
    }

    public void preAdd(ActionEvent event){
        userAdmin = new User( );
        addView = false;
    }
    public AdminManagedBean() {
        addView = true; 
        userAdmin = new User();
        users = adminModel.getUsersAdmin();
        date = new Date();
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

    

    //get and set
    public String getSearch() {
        return search;
    }
    
    public User getUserAdmin() {
        return userAdmin;
    }

    public void setUserAdmin(User userAdmin) {
        this.userAdmin = userAdmin;
    }

    public boolean isAddView() {
        return addView;
    }
    public void setAddView(boolean addView) {    
        this.addView = addView;
    }

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
