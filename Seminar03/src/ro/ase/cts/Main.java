package ro.ase.cts;

import ro.ase.cts.orchestrators.Orchestrator;

public class Main {
    public static void main(String[] args) {

        Orchestrator orchestrator;

        // SQL

        orchestrator = new Orchestrator("ro.ase.cts.connections.SQLConnection");
        orchestrator.execute("org.sqlite.JDBC", "jdbc:sqlite:database.db");

        // NoSQL

        orchestrator = new Orchestrator("ro.ase.cts.connections.NoSQLConnection");
        orchestrator.execute("mongodb://localhost:27017", "database");
    }
}
