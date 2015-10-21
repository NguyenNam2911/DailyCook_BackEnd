/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.User;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import model.LoginModel;
import util.JSFutil;

/**
 *
 * @author Nguyen Hoai Nam
 */
@ManagedBean
@SessionScoped
public class LoginManagedBean {

    /**
     * Creates a new instance of LoginManagedBean
     */
    User user = new User();
    LoginModel loginModel = new LoginModel();
    boolean pass;
    boolean email;

    public void checkLogin() {
        User user_check = loginModel.CheckLogin(user);
        if (user_check != null) {
            if (user_check.getPassword().equals(user.getPassword())) {
                user = user_check;
                JSFutil.navigate("index");
            } else {
                pass = true;
                email = false;
            }
        } else {
            email = true;
            pass = false;
        }
    }

    public void logOut() {
        JSFutil.navigate("login");
    }

    // contructer
    public LoginManagedBean() {
        pass = false;
        email = false;
    }

    //get and set
    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public boolean isEmail() {
        return email;
    }

    public void setEmail(boolean email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
