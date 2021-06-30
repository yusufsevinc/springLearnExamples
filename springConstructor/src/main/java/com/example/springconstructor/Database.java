package com.example.springconstructor;

public class Database {

    private String databaseName;
    private DBConnection dbConnection;

    public Database() {
    }

    public Database(String databaseName) {
        this.databaseName = databaseName;
    }

    public Database(String databaseName, DBConnection dbConnection) {
        this.databaseName = databaseName;
        this.dbConnection = dbConnection;
    }

    public DBConnection getDbConnection() {
        return dbConnection;
    }

    public void setDbConnection(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    @Override
    public String toString() {
        return "Database{" +
                "databaseName='" + databaseName + '\'' +
                ", dbConnection=" + dbConnection +
                '}';
    }
}
