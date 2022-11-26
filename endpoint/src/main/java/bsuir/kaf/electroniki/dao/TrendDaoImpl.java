package bsuir.kaf.electroniki.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import bsuir.kaf.electroniki.model.Trend;
import bsuir.kaf.electroniki.model.User;

public class TrendDaoImpl extends AbstactEntityDao<Trend> implements TrendDao, ResultSetExtractor<Trend>, Serializable {

    /**
     * A logger object for logging events.
     */
    private static final Logger LOGGER = Logger.getLogger(SafIndDaoImpl.class.getName());

    @Override
    protected List<Trend> findAllStatement(Connection connection) throws SQLException, EntityExtractionFailedException {
        return new ArrayList<>();
    }

    @Override
    protected PreparedStatement createEntityStatement(Connection connection, Trend entity) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("insert into trends (date_trend, prd_trend, id_user, id_unit, id_saf_ind, val_mid) " +
            "values (?, ?, ?, ?, ?, ?);");
        statement.setDate(1, Date.valueOf(LocalDate.now()));
        statement.setString(2, entity.getPeriod().toString());
        statement.setLong(3, entity.getUser().getId());
        statement.setLong(4, entity.getUnitId());
        statement.setLong(5, entity.getSafIndId());
        statement.setBigDecimal(6, entity.getValue());
        return statement;
    }

    @Override
    public List<Trend> findAllTrendForUnitAndIndicator(Connection connection, long idUnit, long idSavInd) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM trends " +
            "JOIN users ON trends.id_user = users.id_user " +
            "JOIN users_name ON users.id_name = users_name.id_name " +
            "WHERE id_unit = ? AND id_saf_ind = ?");
        statement.setLong(1, idUnit);
        statement.setLong(2, idSavInd);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return this.extractAll(resultSet);
            }
            return new ArrayList<>();
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
    public static Trend extract(ResultSet resultSet) throws EntityExtractionFailedException {
        try {
            return new Trend(
                resultSet.getLong("id_trend"),
                LocalDate.parse(resultSet.getString("date_trend"), DateTimeFormatter.ISO_LOCAL_DATE),
                Year.parse(resultSet.getString("prd_trend").substring(0, 4)),
                new BigDecimal(resultSet.getLong("val_mid")),
                new User(resultSet.getLong("id_user"),
                    resultSet.getString("surname"),
                    resultSet.getString("name"),
                    resultSet.getString("patronymic")),
                resultSet.getLong("id_unit"),
                resultSet.getLong("id_saf_ind"));
        }
        catch (SQLException e) {
            throw new EntityExtractionFailedException(e);
        }
    }

    @Override
    public List<Trend> extractAll(ResultSet resultSet) throws SQLException, EntityExtractionFailedException {
        List<Trend> entities = new ArrayList<>();
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
    public static TrendDao getInstance() {
        return TrendDaoImpl.Holder.INSTANCE;
    }

    private static class Holder {

        public static final TrendDao INSTANCE = new TrendDaoImpl();
    }
}
