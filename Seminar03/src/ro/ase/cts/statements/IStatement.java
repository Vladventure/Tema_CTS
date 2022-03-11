package ro.ase.cts.statements;

public interface IStatement<T> {

    void execute(T connection);
}
