package ro.ase.cts.statements.select;

import ro.ase.cts.statements.IStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLSelect implements IStatement<Connection> {

    @Override
    public void execute(Connection connection) {
        try {
            Statement statement = null;
            statement = connection.createStatement();

            ResultSet resultSet = null;
            resultSet = statement.executeQuery("SELECT * FROM employees");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString(2);
                String address = resultSet.getString("address");
                double salary = resultSet.getDouble("salary");
                System.out.println("id: " + id + "\nname: " + name + "\naddress: " + address + "\nsalary: " + salary + "\n");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
