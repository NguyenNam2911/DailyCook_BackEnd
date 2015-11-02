/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Recipe;
import entity.User;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.UserModel;
import util.JSFutil;

/**
 *
 * @author Nguyen Hoai Nam
 */
@ManagedBean
@SessionScoped
public class RecipeDetailManagedBean {

    /**
     * Creates a new instance of RecipeDetailManagedBean
     */
    
    Recipe recipe;
    UserModel userModel;
    User user;
    
    
     //method
    public User getOwner(String id){
        userModel = new UserModel();
        return userModel.getUserByID(id);
    }
    
    public String getOwnerName(String id){
        userModel = new UserModel();
        String name = userModel.getUserName(id);
        return name;
    }
    public RecipeDetailManagedBean() {
        recipe = new Recipe();
    }
    
    public void recipeDetail(Recipe r){
        recipe = r;
        JSFutil.navigate("recipe_detail?faces-redirect=true");
        
    }
   
    public String convertTime(long time) {
        return util.TimeUtils.convertTime(time);
        
    }

    //get and set

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
    
    
}
