/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Recipe;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.RecipeModel;

/**
 *
 * @author Nguyen Hoai Nam
 */
@ManagedBean
@ViewScoped
public class RecipeManagedBean {

    /**
     * Creates a new instance of RecipeManagedBean
     */
    private Recipe recipe;
    private RecipeModel recipeModel;
    List<Recipe> recipes = new ArrayList<>();
    String search;
    String filter;

    //method
    public String convertTime(long time) {
        Date date = new Date(time);
        Format format = new SimpleDateFormat("dd-MM-yyyy");
        return format.format(date);
    }

    public void Filter() {
        List<Recipe> filter_Recipe = new ArrayList<>();
        recipes = recipeModel.getAllRecipe();
        if (!"Filter".equals(filter)) {
            switch (filter) {
                case "Approve":
                    for (Recipe r : recipes) {
                        if (r.getStatusFlag() == 1) {
                            filter_Recipe.add(r);
                        }
                    }
                    break;
                case "Report":
                    for (Recipe r : recipes) {
                        if (r.getStatusFlag() == 0) {
                            filter_Recipe.add(r);
                        }
                    }
                    break;
                case "Removed":
                    for (Recipe r : recipes) {
                        if (r.getStatusFlag() == -1) {
                            filter_Recipe.add(r);
                        }
                    }
                    break;
                

            }
            recipes = filter_Recipe;
            filter = "Filter";
        }

    }

    public void SearchRecipe() {
        List<Recipe> search_recipe = new ArrayList<>();
        recipes = recipeModel.getAllRecipe();
        if (search != null) {
            for (Recipe r : recipes) {
                if (r.getTitle().contains(search)) {
                    search_recipe.add(r);
                }

            }
            recipes = search_recipe;
        }
        search = "";
    }

    public RecipeManagedBean() {
        recipeModel = new RecipeModel();
        recipes = recipeModel.getAllRecipe();
        recipe = new Recipe();

    }
    //get and set

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

}
