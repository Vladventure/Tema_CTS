package ro.ase.cts.statements.select;

import ro.ase.cts.statements.IStatement;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class NoSQLSelect implements IStatement<MongoDatabase> {
    @Override
    public void execute(MongoDatabase connection) {
        MongoCollection<Document> collection = connection.getCollection("employees");

        FindIterable<Document> result = collection.find();
        for (Document doc : result) {
            System.out.println(doc);
        }
    }
}
