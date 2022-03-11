package ro.ase.cts;

import ro.ase.cts.orchestrators.Orchestrator;

public class Main {
    public static void main(String[] args) {
        Orchestrator orchestrator;

        orchestrator = new Orchestrator("ro.ase.cts.connections.SQLConnection");
        orchestrator.execute("org.sqlite.JDBC", "jdbc:sqlite:database.db");
    }
}
