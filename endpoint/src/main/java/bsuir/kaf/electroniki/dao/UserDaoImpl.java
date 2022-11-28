package bsuir.kaf.electroniki.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import bsuir.kaf.electroniki.model.User;

public class UserDaoImpl extends AbstactEntityDao<User> implements ResultSetExtractor<User>, Serializable {

    /**
     * A logger object for logging events.
     */
    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class.getName());

    @Override
    protected List<User> findAllStatement(Connection connection) throws SQLException, EntityExtractionFailedException {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM users " +
            "JOIN users_name ON users.id_name = users_name.id_name");
             ResultSet resultSet = statement.executeQuery()) {
            return extractAll(resultSet);
        }
        catch (SQLException e) {
            LOGGER.severe("Error when working with the PreparedStatement.");
            throw e;
        }
    }

    @Override
    protected PreparedStatement createEntityStatement(Connection connection, User entity) throws SQLException {
        return null;
    }

    /**
     * A method for processing data from a database that creates an entity and removes spaces in string variables.
     *
     * @param resultSet response from the database
     * @return employee object from the database
     * @throws EntityExtractionFailedException Error processing an entity when getting it from the database
     */
    public static User extract(ResultSet resultSet) throws EntityExtractionFailedException {
        try {
            return new User(resultSet.getLong("id_user"),
                resultSet.getString("surname"),
                resultSet.getString("name"),
                resultSet.getString("patronymic"));
        }
        catch (SQLException e) {
            throw new EntityExtractionFailedException(e);
        }
    }

    @Override
    public List<User> extractAll(ResultSet resultSet) throws SQLException, EntityExtractionFailedException {
        List<User> entities = new ArrayList<>();
        while (resultSet.next()) {
            entities.add(extract(resultSet));
        }
        return entities;
    }

    /**
     * Getting a single instance of the class.
     *
     * @return the instance
     */
    public static EntityDao<User> getInstance() {
        return UserDaoImpl.Holder.INSTANCE;
    }

    private static class Holder {

        public static final EntityDao<User> INSTANCE = new UserDaoImpl();
    }
}