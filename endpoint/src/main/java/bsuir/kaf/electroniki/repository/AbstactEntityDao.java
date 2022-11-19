package bsuir.kaf.electroniki.repository;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import bsuir.kaf.electroniki.model.Entity;

/**
 * This class contains methods that are necessary for the dao layer to work.
 *
 * @author Daniil Serov
 * @version 20220504-1
 * @since 20220504-1
 * @param <T> entity
 */
public abstract class AbstactEntityDao<T extends Entity> implements EntityDao<T>, Serializable {

    /**
     * A logger object for logging events.
     */
    private static final Logger LOGGER = Logger.getLogger(AbstactEntityDao.class.getName());

    /**
     * Constructor for creating an object.
     */
    public AbstactEntityDao() {
    }

    @Override
    public long create(Connection connection, T entity) throws DaoException {
        LOGGER.info("DAO: Entity creation started.");
        String loggerMsgUnsuccessful = "DAO: Entity creation completed unsuccessfully.";
        try (PreparedStatement statement = createEntityStatement(connection, entity)) {
            boolean result = statement.executeUpdate() == 1;
            String loggerMsgSuccessful = "DAO: Entity creation completed successfully.";
            return checkOperationResult(connection, result, loggerMsgSuccessful, loggerMsgUnsuccessful);
        }
        catch (SQLException e) {
            LOGGER.severe("DAO: sql exception occurred");
            LOGGER.info(loggerMsgUnsuccessful);
            throw new DaoException(e);
        }
    }

    @Override
    public List<T> findAll(Connection connection) throws DaoException {
        try {
            return findAllStatement(connection);
        }
        catch (EntityExtractionFailedException e) {
            LOGGER.warning("DAO: could not extract entity" + e);
            throw e;
        }
        catch (SQLException e) {
            LOGGER.severe("DAO: sql exception occurred" + e);
            throw new DaoException(e);
        }
    }

    /**
     * Setting parameters to search for all entities in the database.
     *
     * @param connection connection database
     * @return all entity in database
     * @throws SQLException DB-related error
     * @throws EntityExtractionFailedException Error processing an entity when getting it from the database
     */
    protected abstract List<T> findAllStatement(Connection connection) throws
        SQLException, EntityExtractionFailedException;

    /**
     * Setting parameters for creating an entity in the database.
     *
     * @param connection connection database
     * @param entity entity
     * @return object PreparedStatement
     * @throws SQLException DB-related error
     */
    protected abstract PreparedStatement createEntityStatement(Connection connection, T entity) throws SQLException;

    /**
     * The method of checking the result of the create operation.
     *
     * @param connection connection db
     * @param resultOperation result operation
     * @param loggerMsgSuccessful message for logger by successful operation
     * @param loggerMsgUnsuccessful message for logger by unsuccessful operation
     * @return id new entity
     * @throws DaoException  DB-related error
     */
    public long checkOperationResult(Connection connection, boolean resultOperation, String loggerMsgSuccessful,
        String loggerMsgUnsuccessful) throws DaoException {
        if (resultOperation) {
            LOGGER.info(loggerMsgSuccessful);
            return callIdentity(connection);
        }
        else {
            LOGGER.info(loggerMsgUnsuccessful);
            throw new DaoException(loggerMsgUnsuccessful);
        }
    }

    /**
     * The method works with the "Caller Identity()" function and returns the last added record to the database.
     *
     * @param connection connection with db
     * @return id of the last record added to the database in this CONNECTION
     * @throws DaoException  DB-related error
     */
    public long callIdentity(Connection connection) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement("CALL IDENTITY()");
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getLong(1);
            }
            else {
                throw new DaoException("DAO: exception function CALL IDENTITY.");
            }
        }
        catch (SQLException e) {
            LOGGER.warning("DAO: sql exception occurred" + e);
            throw new DaoException(e);
        }
    }
}
