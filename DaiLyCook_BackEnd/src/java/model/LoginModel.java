/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.UserDAO;
import entity.User;

/**
 *
 * @author Nguyen Hoai Nam
 */
public class LoginModel {

    public User CheckLogin(User user) {
        User u = UserDAO.getInstance().getUserInfoByEmail(user.getEmail());
        if (u != null) {
            if (u.getRole().equals("admin") || u.getRole().equals("super_admin")) {
                return u;
            } else {
                u = null;
            }

        }

        return u;
    }

}
