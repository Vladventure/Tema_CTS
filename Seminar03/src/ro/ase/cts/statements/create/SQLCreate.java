package ro.ase.cts.statements.create;

import ro.ase.cts.statements.IStatement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLCreate implements IStatement<Connection> {

    Statement statement = null;

    @Override
    public void execute(Connection connection) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS employees");
            statement.executeUpdate("CREATE TABLE employees(id INTEGER PRIMARY KEY, name TEXT, address TEXT, salary REAL)");
            statement.close();

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
