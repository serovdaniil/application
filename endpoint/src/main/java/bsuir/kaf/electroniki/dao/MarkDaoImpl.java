package bsuir.kaf.electroniki.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import bsuir.kaf.electroniki.model.Mark;

public class MarkDaoImpl extends AbstactEntityDao<Mark> implements MarkDao, ResultSetExtractor<Mark>, Serializable {

    /**
     * A logger object for logging events.
     */
    private static final Logger LOGGER = Logger.getLogger(SafIndDaoImpl.class.getName());

    @Override
    protected List<Mark> findAllStatement(Connection connection) throws SQLException, EntityExtractionFailedException {
        return new ArrayList<>();
    }

    @Override
    protected PreparedStatement createEntityStatement(Connection connection, Mark entity) throws SQLException {
          return null;
    }

    @Override
    public List<Mark> findMarksByCrit(Connection connection, long idCrit) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM marks WHERE id_crit = ?");
        statement.setLong(1, idCrit);
        try (ResultSet resultSet = statement.executeQuery()) {
            return this.extractAll(resultSet);
        }
        catch (SQLException e) {
            LOGGER.severe("Error when working with the PreparedStatement.");
            throw e;
        }
        finally {
            statement.close();
        }
    }

    /**
     * A method for processing data from a database that creates an entity and removes spaces in string variables.
     *
     * @param resultSet response from the database
     * @return employee object from the database
     * @throws EntityExtractionFailedException Error processing an entity when getting it from the database
     */
    public static Mark extract(ResultSet resultSet) throws EntityExtractionFailedException {
        try {
            return new Mark(
                resultSet.getLong("id_mark"),
                resultSet.getString("discr_mark"),
                resultSet.getInt("mark"));
        }
        catch (SQLException e) {
            throw new EntityExtractionFailedException(e);
        }
    }

    @Override
    public List<Mark> extractAll(ResultSet resultSet) throws SQLException, EntityExtractionFailedException {
        List<Mark> entities = new ArrayList<>();
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
    public static MarkDao getInstance() {
        return MarkDaoImpl.Holder.INSTANCE;
    }

    private static class Holder {

        public static final MarkDao INSTANCE = new MarkDaoImpl();
    }
}
