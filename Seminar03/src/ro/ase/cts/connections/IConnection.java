package ro.ase.cts.connections;

public interface IConnection {

    void connect(String host, String database);

    void executeStatements();

    void close();
}
