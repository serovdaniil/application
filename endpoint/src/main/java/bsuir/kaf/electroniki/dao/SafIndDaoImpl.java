package bsuir.kaf.electroniki.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import bsuir.kaf.electroniki.model.SafInd;

public class SafIndDaoImpl extends AbstactEntityDao<SafInd> implements ResultSetExtractor<SafInd>, Serializable {

    /**
     * A logger object for logging events.
     */
    private static final Logger LOGGER = Logger.getLogger(SafIndDaoImpl.class.getName());

    @Override
    protected List<SafInd> findAllStatement(Connection connection) throws SQLException, EntityExtractionFailedException {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM saf_ind;");
             ResultSet resultSet = statement.executeQuery()) {
            return extractAll(resultSet);
        }
        catch (SQLException e) {
            LOGGER.severe("Error when working with the PreparedStatement.");
            throw e;
        }
    }

    @Override
    protected PreparedStatement createEntityStatement(Connection connection, SafInd entity) throws SQLException {
        return null;
    }

    /**
     * A method for processing data from a database that creates an entity and removes spaces in string variables.
     *
     * @param resultSet response from the database
     * @return employee object from the database
     * @throws EntityExtractionFailedException Error processing an entity when getting it from the database
     */
    public static SafInd extract(ResultSet resultSet) throws EntityExtractionFailedException {
        try {
            return new SafInd(
                resultSet.getLong("id_saf_ind"),
                resultSet.getString("name_saf_ind").trim(),
                resultSet.getString("meas").trim());
        }
        catch (SQLException e) {
            throw new EntityExtractionFailedException(e);
        }
    }

    @Override
    public List<SafInd> extractAll(ResultSet resultSet) throws SQLException, EntityExtractionFailedException {
        List<SafInd> entities = new ArrayList<>();
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
    public static EntityDao<SafInd> getInstance() {
        return SafIndDaoImpl.Holder.INSTANCE;
    }

    private static class Holder {

        public static final EntityDao<SafInd> INSTANCE = new SafIndDaoImpl();
    }
}
