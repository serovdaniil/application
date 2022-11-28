package bsuir.kaf.electroniki.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import bsuir.kaf.electroniki.model.Crits;

public class CtitsDaoImpl extends AbstactEntityDao<Crits> implements ResultSetExtractor<Crits>, Serializable {

    /**
     * A logger object for logging events.
     */
    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class.getName());

    @Override
    protected List<Crits> findAllStatement(Connection connection) throws SQLException, EntityExtractionFailedException {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM crits");
             ResultSet resultSet = statement.executeQuery()) {
            return extractAll(resultSet);
        }
        catch (SQLException e) {
            LOGGER.severe("Error when working with the PreparedStatement.");
            throw e;
        }
    }

    @Override
    protected PreparedStatement createEntityStatement(Connection connection, Crits entity) throws SQLException {
        return null;
    }

    /**
     * A method for processing data from a database that creates an entity and removes spaces in string variables.
     *
     * @param resultSet response from the database
     * @return employee object from the database
     * @throws EntityExtractionFailedException Error processing an entity when getting it from the database
     */
    public static Crits extract(ResultSet resultSet) throws EntityExtractionFailedException {
        try {
            return new Crits(resultSet.getLong("id_crit"),
                resultSet.getString("name_crit"));
        }
        catch (SQLException e) {
            throw new EntityExtractionFailedException(e);
        }
    }

    @Override
    public List<Crits> extractAll(ResultSet resultSet) throws SQLException, EntityExtractionFailedException {
        List<Crits> entities = new ArrayList<>();
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
    public static EntityDao<Crits> getInstance() {
        return CtitsDaoImpl.Holder.INSTANCE;
    }

    private static class Holder {

        public static final EntityDao<Crits> INSTANCE = new CtitsDaoImpl();
    }
}