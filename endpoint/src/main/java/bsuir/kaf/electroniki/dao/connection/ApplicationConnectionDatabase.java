package bsuir.kaf.electroniki.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

import bsuir.kaf.electroniki.dao.AbstactEntityDao;
import bsuir.kaf.electroniki.dao.DaoException;

/**
 * Connection to the database server.
 */
public class ApplicationConnectionDatabase implements ConnectionDatabase {

    /**
     * A logger object for logging events.
     */
    private static final Logger LOGGER = Logger.getLogger(AbstactEntityDao.class.getName());

    /**
     * Link to the database.
     */
    public static final String DB_URL = "jdbc:mysql://localhost:3306/db2 ?serverTimezone=Europe/Minsk";

    /**
     * Db name.
     */
    public static final String DB_NAME = "root";

    /**
     * Db password.
     */
    public static final String DB_PASSWORD = "serov231969";

    public static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";

    /**
     * Constructor for creating an object.
     */
    public ApplicationConnectionDatabase() {
    }

    @Override
    public Connection getConnection() {
        try {
            Class.forName(DATABASE_DRIVER);
            return DriverManager.getConnection(DB_URL, DB_NAME, DB_PASSWORD);
        }
        catch (SQLException | ClassNotFoundException e) {
            LOGGER.severe("Connection receiving error." + e.getMessage());
            throw new DaoException("Connection receiving error.");
        }
    }

    /**
     * Getting a single instance of the class.
     *
     * @return the instance
     */
    public static ConnectionDatabase getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        public static final ConnectionDatabase INSTANCE = new ApplicationConnectionDatabase();
    }
}
