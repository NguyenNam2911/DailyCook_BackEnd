package dao;

import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;

import com.mongodb.BasicDBObject;
import entity.Favorited;



/**
 * 
 * @author duyetpt
 * recipe is favorited by
 */
public class FavoriteDAO extends AbstractDAO{
	
	private static final FavoriteDAO instance = new FavoriteDAO();
	private FavoriteDAO() {
		
	}
	
	public static FavoriteDAO getInstance() {
		return instance;
	}
	
	public void push(String userId, String recipeId) {
		
	}
	
	public void pull(String userId, String recipeId) {
		
	}
	
	public boolean isFavorited(String userId, String recipeId) {
		try {
			Query<Favorited> query = datastore.createQuery(Favorited.class).field("_id").equal(new ObjectId(userId));
			query.field("user_ids").hasThisElement(new BasicDBObject("$eq", recipeId));
			
			Favorited fav = query.retrievedFields(false, "user_ids").get();
			if (fav != null ) {
				return fav.getId() != null;
			}
		} catch (Exception ex) {
			//
		}
		
		return false;
	}
}
