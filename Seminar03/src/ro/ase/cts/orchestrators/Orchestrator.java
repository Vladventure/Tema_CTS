package ro.ase.cts.orchestrators;

import ro.ase.cts.connections.IConnection;

import java.lang.reflect.InvocationTargetException;

public class Orchestrator {

    private IConnection connection = null;

    public Orchestrator(String connectionType) {
        try {
            connection = (IConnection) Class.forName(connectionType).getDeclaredConstructor().newInstance();
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

    public void execute(String host, String database) {
        connection.connect(host, database);
        connection.executeStatements();
        connection.close();
    }
}
