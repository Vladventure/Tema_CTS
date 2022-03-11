package ro.ase.cts.connections;

import ro.ase.cts.executors.SQLExecutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection implements IConnection {
    private Connection connection = null;

    @Override
    public void connect(String host, String database) {
        try {
            Class.forName(host);
            connection = DriverManager.getConnection(database);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void executeStatements() {
        SQLExecutor executor = new SQLExecutor();

        executor.execute(connection, "ro.ase.cts.statements.create.SQLCreate");
        executor.execute(connection, "ro.ase.cts.statements.insert.SQLInsert");
        executor.execute(connection, "ro.ase.cts.statements.select.SQLSelect");
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
