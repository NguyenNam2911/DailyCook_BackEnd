/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.RecipeDAO;
import entity.Recipe;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Nguyen Hoai Nam
 */
public class RecipeModel {
    
    //get all recipe namnh
   public List<Recipe> getAllRecipe(){
       List<Recipe> list = new ArrayList<>();
       list = RecipeDAO.getInstance().getAllRecipe();
       return list;
   }
   
   public Recipe getRecipeByID(String id){
        return RecipeDAO.getInstance().getRecipe(id);
    }
}
