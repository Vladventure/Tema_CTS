package ro.ase.cts.statements.create;

import ro.ase.cts.statements.IStatement;

import com.mongodb.client.MongoDatabase;

public class NoSQLCreate implements IStatement<MongoDatabase> {

    @Override
    public void execute(MongoDatabase connection) {
        connection.getCollection("employees");
        connection.getCollection("employees").drop();
        connection.createCollection("employees");
    }
}
