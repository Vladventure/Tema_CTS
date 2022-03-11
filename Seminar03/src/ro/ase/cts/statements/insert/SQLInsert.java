package ro.ase.cts.statements.insert;

import ro.ase.cts.statements.IStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLInsert implements IStatement<Connection> {

    @Override
    public void execute(Connection connection) {
        try {
            Statement statement = null;
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO employees VALUES(1, 'Popescu Ion', 'Bucharest', 4000)");
            statement.close();

            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement("INSERT INTO employees VALUES (?,?,?,?)");
            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "Ionescu Vasile");
            preparedStatement.setString(3, "Brasov");
            preparedStatement.setDouble(4, 4500);
            preparedStatement.executeUpdate();
            preparedStatement.close();

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
