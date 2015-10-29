package dao;

import entity.Recipe;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;

public class RecipeDAO extends AbstractDAO {

    private static final RecipeDAO instance = new RecipeDAO();

    private RecipeDAO() {
        datastore.ensureIndexes();
    }

    public static RecipeDAO getInstance() {
        return instance;
    }

    public void save(Recipe recipe) {
        try {
            datastore.save(recipe);
        } catch (Exception ex) {

        }
    }

    public Recipe getRecipe(String recipeId) {
        try {
            Query<Recipe> query = datastore.createQuery(Recipe.class).field("_id").equal(new ObjectId(recipeId));
            return query.get();
        } catch (Exception ex) {

        }

        return null;
    }
    
    public List<Recipe> getAllRecipe() {
        try {
            Query<Recipe> query = datastore.createQuery(Recipe.class);
            return query.asList();
        } catch (Exception ex) {

        }

        return null;
    }
}
