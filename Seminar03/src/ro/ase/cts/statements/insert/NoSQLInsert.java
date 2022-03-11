package ro.ase.cts.statements.insert;

import ro.ase.cts.statements.IStatement;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class NoSQLInsert implements IStatement<MongoDatabase> {

    @Override
    public void execute(MongoDatabase connection) {
        MongoCollection<Document> collection = connection.getCollection("employees");

        Document employee1 = new Document().append("name", "Popescu Ion").
                append("address", "Bucharest").append("salary", 4000);
        collection.insertOne(employee1);

        Document employee2 = new Document().append("name", "Ionescu Vasile").
                append("salary", 4500);
        collection.insertOne(employee2);
    }
}
