package ro.ase.cts.executors;

public interface IExecutable<T> {

    void execute(T connection, String statementClass) throws ClassNotFoundException;
}
