/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.User;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Nguyen Hoai Nam
 */
@ManagedBean
@SessionScoped
public class UserDetailManagedBean {

    /**
     * Creates a new instance of UserDetailManagedBean
     */
    //method
    User userSelected = new User();
    
    public UserDetailManagedBean() {
    }
    
    public String convertTime(long time) {
        return util.TimeUtils.convertTime(time);
        
    }
    public String UserDetail(User u){
        userSelected = u;
        return "user_detail?faces-redirect=true";
        
    }
    //get and set

    public User getUserSelected() {
        return userSelected;
    }

    public void setUserSelected(User userSelected) {
        this.userSelected = userSelected;
    }
    
}
