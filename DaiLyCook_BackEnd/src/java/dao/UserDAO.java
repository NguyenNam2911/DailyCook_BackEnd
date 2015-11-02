package dao;

import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import entity.User;
import java.util.List;
import org.mongodb.morphia.query.Criteria;
import org.mongodb.morphia.query.CriteriaContainerImpl;
import org.mongodb.morphia.query.CriteriaJoin;

public class UserDAO extends AbstractDAO {

    private static final UserDAO instance = new UserDAO();

    private UserDAO() {
        datastore.ensureIndexes();
    }

    public static final UserDAO getInstance() {
        return instance;
    }

    public void save(User user) {
        try {
            synchronized (user) {
                datastore.save(user);
            }
        } catch (Exception ex) {
        }

    }

    public User getUserInfoByEmail(String email) {
        try {
            Query<User> query = datastore.createQuery(User.class).field("email").equal(email);
            User user = query.get();

            return user;
        } catch (Exception ex) {
        }
        return null;
    }

    public User getUser(String userId) {
        try {
            Query<User> query = datastore.createQuery(User.class).field("_id").equal(new ObjectId(userId));
            User user = query.get();

            return user;
        } catch (Exception ex) {
        }
        return null;
    }

    public boolean increateRecipeNumber(String userId) {
        return updateRecipeNumber(userId, 1);
    }

    public boolean decreaseRecipeNumber(String userId) {
        return updateRecipeNumber(userId, -1);
    }

    private boolean updateRecipeNumber(String userId, int number) {
        try {
            Query<User> query = datastore.createQuery(User.class).field("_id").equal(new ObjectId(userId));
            UpdateOperations<User> updateO = datastore.createUpdateOperations(User.class).inc("n_recipes", number);
            UpdateResults result = datastore.update(query, updateO);
            return result.getUpdatedCount() == 1;
        } catch (Exception ex) {
        }
        return false;
    }
    
    public boolean increateReportNumber(String userId) {
        return updateReportNumber(userId, 1);
    }

    public boolean decreaseReportNumber(String userId) {
        return updateReportNumber(userId, -1);
    }
    
    private boolean updateReportNumber(String userId, int number) {
        try {
            Query<User> query = datastore.createQuery(User.class).field("_id").equal(new ObjectId(userId));
            UpdateOperations<User> updateO = datastore.createUpdateOperations(User.class).inc("n_reports", number);
            UpdateResults result = datastore.update(query, updateO);
            return result.getUpdatedCount() == 1;
        } catch (Exception ex) {
        }
        return false;
    }
    
    public boolean banUser(String userId, int flag) {
        try {
            Query<User> query = datastore.createQuery(User.class).field("_id").equal(new ObjectId(userId));
            UpdateOperations<User> updateO = datastore.createUpdateOperations(User.class).set("active_flag", flag);
            UpdateResults result = datastore.update(query, updateO);
            return result.getUpdatedCount() == 1;
        } catch (Exception ex) {
        }
        return false;
    }
    
    public boolean unBanUser(String userId) {
        try {
            Query<User> query = datastore.createQuery(User.class).field("_id").equal(new ObjectId(userId));
            UpdateOperations<User> updateO = datastore.createUpdateOperations(User.class).set("active_flag", User.ACTIVE_FLAG);
            UpdateResults result = datastore.update(query, updateO);
            return result.getUpdatedCount() == 1;
        } catch (Exception ex) {
        }
        return false;
    }

    public List<User> getAllUser() {
        try {
            Query<User> query = datastore.createQuery(User.class);
            return query.asList();
        } catch (Exception ex) {
        }
        return null;
    }
    
   
}
