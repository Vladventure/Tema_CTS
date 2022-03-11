package ro.ase.cts.executors;

import com.mongodb.client.MongoDatabase;
import ro.ase.cts.statements.IStatement;

import java.lang.reflect.InvocationTargetException;

public class NoSQLExecutor implements IExecutable<MongoDatabase> {

    @Override
    public void execute(MongoDatabase connection, String statementClass) {
        try {
            IStatement<MongoDatabase> statement = (IStatement<MongoDatabase>) Class.forName(statementClass).getDeclaredConstructor().newInstance();
            statement.execute(connection);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
