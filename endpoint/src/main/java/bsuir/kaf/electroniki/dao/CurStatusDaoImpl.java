package bsuir.kaf.electroniki.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import bsuir.kaf.electroniki.model.CurStatus;
import bsuir.kaf.electroniki.model.Mark;
import bsuir.kaf.electroniki.model.SysEquip;
import bsuir.kaf.electroniki.model.User;

public class CurStatusDaoImpl extends AbstactEntityDao<CurStatus> implements CurStatusDao, ResultSetExtractor<CurStatus>, Serializable {

    /**
     * A logger object for logging events.
     */
    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class.getName());

    @Override
    public void addNewCurStatus(Connection connection, CurStatus entity) {
        LOGGER.info("DAO: Entity creation started.");
        String loggerMsgUnsuccessful = "DAO: Entity creation completed unsuccessfully.";
        try {
            PreparedStatement statement = connection.prepareStatement("insert into cur_status (date_cur, id_user, id_sys, id_mark, id_doc) " +
                "values (?, ?, ?, ?, 1);");
            statement.setDate(1, Date.valueOf(LocalDate.now()));
            statement.setLong(2, entity.getUser().getId());
            statement.setLong(3, entity.getIdSys());
            statement.setLong(4, entity.getIdMark());
            statement.executeUpdate();

            statement = connection.prepareStatement("Select LAST_INSERT_ID() as newId;");
            ResultSet resultSet1 = statement.executeQuery();

            long newId = 0;

            if (resultSet1.next()) {
                newId = resultSet1.getLong("newId");
            }

            statement = connection.prepareStatement(String.format("select calc_distan(%s) as result", entity.getIdSys()));

            ResultSet resultSet = statement.executeQuery();

            BigDecimal distan = BigDecimal.ZERO;
            if (resultSet.next()) {
                distan = resultSet.getBigDecimal("result");
            }

            statement = connection.prepareStatement(String.format("UPDATE cur_status SET distan = %s WHERE id_cur = %s;", distan, newId));
            statement.executeUpdate();
            String loggerMsgSuccessful = "DAO: Entity creation completed successfully.";
        }
        catch (SQLSyntaxErrorException e) {
            LOGGER.severe(e.getMessage());
            LOGGER.info(loggerMsgUnsuccessful);
            throw new DaoException(e);
        }
        catch (SQLException e) {
            LOGGER.severe("DAO: sql exception occurred");
            LOGGER.info(loggerMsgUnsuccessful);
            throw new DaoException(e);
        }
    }

    @Override
    public List<CurStatus> findCurStatusBySystem(Connection connection, long idSystem) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM cur_status " +
            "JOIN users ON cur_status.id_user = users.id_user " +
            "JOIN users_name ON users.id_name = users_name.id_name " +
            "JOIN marks ON cur_status.id_mark = marks.id_mark WHERE id_sys = ?");
        statement.setLong(1, idSystem);
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
    protected List<CurStatus> findAllStatement(Connection connection) throws SQLException, EntityExtractionFailedException {
        return new ArrayList<>();
    }

    @Override
    protected PreparedStatement createEntityStatement(Connection connection, CurStatus entity) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(String.format("select calc_distan(%s) as result", entity.getIdSys()));

        ResultSet resultSet = preparedStatement.executeQuery();

        BigDecimal distan = BigDecimal.ZERO;
        if (resultSet.next()) {
            distan = resultSet.getBigDecimal("result");
        }

        PreparedStatement statement = connection.prepareStatement("insert into cur_status (date_cur, id_user, id_sys, id_mark, distan, id_doc) " +
            "values (?, ?, ?, ?, ?, 1);");
        statement.setDate(1, Date.valueOf(LocalDate.now()));
        statement.setLong(2, entity.getUser().getId());
        statement.setLong(3, entity.getIdSys());
        statement.setLong(4, entity.getIdMark());
        statement.setBigDecimal(5, distan);
        return statement;
    }

    /**
     * A method for processing data from a database that creates an entity and removes spaces in string variables.
     *
     * @param resultSet response from the database
     * @return employee object from the database
     * @throws EntityExtractionFailedException Error processing an entity when getting it from the database
     */
    public static CurStatus extract(ResultSet resultSet) throws EntityExtractionFailedException {
        try {
            return new CurStatus(
                resultSet.getLong("id_cur"),
                LocalDate.parse(resultSet.getString("date_cur")),
                new User(resultSet.getLong("id_user"),
                    resultSet.getString("surname"),
                    resultSet.getString("name"),
                    resultSet.getString("patronymic")),
                resultSet.getLong("id_sys"),
                new Mark(resultSet.getLong("id_mark"),
                    resultSet.getString("discr_mark")),
                resultSet.getBigDecimal("distan"));
        }
        catch (SQLException e) {
            throw new EntityExtractionFailedException(e);
        }
    }

    @Override
    public List<CurStatus> extractAll(ResultSet resultSet) throws SQLException, EntityExtractionFailedException {
        List<CurStatus> entities = new ArrayList<>();
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
    public static CurStatusDao getInstance() {
        return CurStatusDaoImpl.Holder.INSTANCE;
    }

    private static class Holder {

        public static final CurStatusDao INSTANCE = new CurStatusDaoImpl();
    }
}