package ro.ase.cts.executors;

import java.sql.Connection;
import ro.ase.cts.statements.IStatement;

import java.lang.reflect.InvocationTargetException;

public class SQLExecutor implements IExecutable<Connection> {

    @Override
    public void execute(Connection connection, String statementClass) {
        try {
            IStatement<Connection> statement = (IStatement<Connection>) Class.forName(statementClass).getDeclaredConstructor().newInstance();
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
