package dao;

import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;

import com.mongodb.BasicDBObject;
import entity.Following;



/**
 * 
 * @author duyetpt
 * recipe is favorited by
 */
public class FollowingDAO extends AbstractDAO{
	
	private static final FollowingDAO instance = new FollowingDAO();
	private FollowingDAO() {
		
	}
	
	public static FollowingDAO getInstance() {
		return instance;
	}
	
	public void push(String ownerId, String starId) {
		
	}
	
	public void pull(String ownerId, String starId) {
		
	}
	
	public boolean isFollowing(String ownerId, String starId) {
		try {
			Query<Following> query = datastore.createQuery(Following.class).field("_id").equal(new ObjectId(ownerId));
			query.field("following").hasThisElement(new BasicDBObject("$eq", starId));
			
			Following foll = query.retrievedFields(true, "_id").get();
			if (foll != null ) {
				return foll.getOwner() != null;
			}
		} catch (Exception ex) {
			
		}
		
		return false;
	}
}
