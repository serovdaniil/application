package bsuir.kaf.electroniki.repository.connection;

import java.sql.Connection;

/**
 * Interface for getting a connection to the database.
 */
public interface ConnectionDatabase {

    /**
     * The method returns a connection.
     *
     * @return connection
     */
    Connection getConnection();
}
