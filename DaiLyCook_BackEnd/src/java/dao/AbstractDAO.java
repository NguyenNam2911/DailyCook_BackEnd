package dao;

import org.mongodb.morphia.Datastore;

abstract class AbstractDAO {

    protected final Datastore datastore = ConnectionDAO.getDataStore();
}
