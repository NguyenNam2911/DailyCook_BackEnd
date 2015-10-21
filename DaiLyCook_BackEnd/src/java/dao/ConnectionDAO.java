package dao;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

class ConnectionDAO {
	
	private static final String DBNAME = "dailycook";
	private static Morphia morphia;
	private static Datastore datastore;
	
	private static void config() {
		morphia = new Morphia();
		
		// tell Morphia where to find your classes
		// can be called multiple times with different packages or classes
		morphia.mapPackage("Entity");
		
		MongoClient mongoClient = new MongoClient("localhost");
		
		// create the Datastore connecting to the default port on the local host
		datastore = morphia.createDatastore(mongoClient, DBNAME);
	}
	
	public static Datastore getDataStore() {
		if (datastore == null) {
			config();
		}
		
		return datastore;
	}
}
