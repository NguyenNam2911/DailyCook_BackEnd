package dao;

import entity.Category;
import java.util.List;

import org.mongodb.morphia.query.Query;

public class CategoryDAO extends AbstractDAO {

    private static final CategoryDAO instance = new CategoryDAO();

    private CategoryDAO() {
        datastore.ensureIndexes();
    }

    public static CategoryDAO getInstance() {
        return instance;
    }

    public void save(Category category) {
        try {
            datastore.save(category);
        } catch (Exception ex) {
//			throw new DAOException(ErrorCodeConstant.DAO_EXCEPTION);
        }
    }

    public List<Category> getCategories(String parentId) {
        try {
            Query<Category> query = null;
            if (parentId != null) {
                query = datastore.createQuery(Category.class).field("parent_id").equal(parentId);
            } else {
                query = datastore.createQuery(Category.class).field("parent_id").doesNotExist();
            }

            return query.asList();
        } catch (Exception ex) {
//			throw new DAOException(ErrorCodeConstant.DAO_EXCEPTION);
        }
        return null;
    }
}
