package bsuir.kaf.electroniki.dao;

import java.io.Serializable;
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

import bsuir.kaf.electroniki.model.SafVal;
import bsuir.kaf.electroniki.model.User;

public class SafValDaoImpl extends AbstactEntityDao<SafVal> implements SafValDao, ResultSetExtractor<SafVal>, Serializable {

    /**
     * A logger object for logging events.
     */
    private static final Logger LOGGER = Logger.getLogger(SafValDaoImpl.class.getName());

    @Override
    protected List<SafVal> findAllStatement(Connection connection) throws SQLException, EntityExtractionFailedException {
        return null;
    }

    @Override
    protected PreparedStatement createEntityStatement(Connection connection, SafVal entity) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("insert into saf_val (date_saf_val, prd_saf_val, id_user, id_unit, id_saf_ind, val_cur) values (?, ?, ?, ?, ?, ?);");
        statement.setDate(1, Date.valueOf(LocalDate.now()));
        statement.setString(2, entity.getPeriod().toString());
        statement.setLong(3, entity.getUser().getId());
        statement.setLong(4, entity.getUnitId());
        statement.setLong(5, entity.getSafIndId());
        statement.setBigDecimal(6, entity.getValue());
        return statement;
    }

    @Override
    public List<SafVal> findAllValueForUnitAndIndicator(Connection connection, long idUnit, long idSavInd) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM saf_val " +
            "JOIN users ON saf_val.id_user = users.id_user " +
            "JOIN users_name ON users.id_name = users_name.id_name " +
            "WHERE id_unit = ? AND id_saf_ind = ?");
        statement.setLong(1, idUnit);
        statement.setLong(2, idSavInd);

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

    @Override
    public List<SafVal> findAllValueForUnitAndIndicatorAndPeriod(Connection connection, Year period, long idUnit, long idSavInd) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM saf_val " +
            "JOIN users ON saf_val.id_user = users.id_user " +
            "JOIN users_name ON users.id_name = users_name.id_name " +
            "WHERE id_unit = ? AND id_saf_ind = ? AND prd_saf_val <= ?");
        statement.setLong(1, idUnit);
        statement.setLong(2, idSavInd);
        statement.setInt(3, period.getValue());
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

    public SafVal extract(ResultSet resultSet) throws EntityExtractionFailedException {
        try {
            return new SafVal(
                resultSet.getLong("id_saf_val"),
                LocalDate.parse(resultSet.getString("date_saf_val"), DateTimeFormatter.ISO_LOCAL_DATE),
                Year.parse(resultSet.getString("prd_saf_val").substring(0, 4)),
                resultSet.getBigDecimal("val_cur"),
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
    public List<SafVal> extractAll(ResultSet resultSet) throws SQLException, EntityExtractionFailedException {
        List<SafVal> entities = new ArrayList<>();

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
    public static SafValDao getInstance() {
        return SafValDaoImpl.Holder.INSTANCE;
    }

    private static class Holder {

        public static final SafValDao INSTANCE = new SafValDaoImpl();
    }
}
