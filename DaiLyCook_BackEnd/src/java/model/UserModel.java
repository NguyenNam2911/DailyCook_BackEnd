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
public class UserModel {

    public List<User> getUsersNomrmal() {
        List<User> users = new ArrayList<>();
        List<User> users_normal = new ArrayList<>();
        users = UserDAO.getInstance().getAllUser();
        for (User user : users) {
            if (user.getRole().equals("normal_user")) {
                users_normal.add(user);
            }
        }
        return users_normal;
    }
//  getUsersNomrmal  namnh

    public User getUserByID(String id) {
        return UserDAO.getInstance().getUser(id);
    }

    public boolean increaseReportOfUser(String userId) {
        return UserDAO.getInstance().increateReportNumber(userId);
    }

    public boolean banUser(String userId, int flag) {
        return UserDAO.getInstance().banUser(userId, flag);
    }

    public boolean unBanUser(String userId, int flag) {
        return UserDAO.getInstance().unBanUser(userId);
    }

    public String getUserName(String id) {
        User u = UserDAO.getInstance().getUser(id);
        if (u != null) {
            String name = u.getDisplayName();
            return name;
        }
        return "Not available";
    }
}
