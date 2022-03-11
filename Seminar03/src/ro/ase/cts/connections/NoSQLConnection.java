package ro.ase.cts.connections;

import ro.ase.cts.executors.NoSQLExecutor;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class NoSQLConnection implements IConnection {

    private MongoClient client = null;
    private MongoDatabase connection = null;

    @Override
    public void connect(String host, String database) {
        try {
            client = MongoClients.create(host);
            connection = client.getDatabase(database);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void executeStatements() {
        NoSQLExecutor executor = new NoSQLExecutor();

        executor.execute(connection, "ro.ase.cts.statements.create.NoSQLCreate");
        executor.execute(connection, "ro.ase.cts.statements.insert.NoSQLInsert");
        executor.execute(connection, "ro.ase.cts.statements.select.NoSQLSelect");
    }

    @Override
    public void close() {
        try {
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
