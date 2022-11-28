package bsuir.kaf.electroniki.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import bsuir.kaf.electroniki.model.SysEquip;

public class SysEquipDaoImpl extends AbstactEntityDao<SysEquip> implements SysEquipDao, ResultSetExtractor<SysEquip>, Serializable {

    /**
     * A logger object for logging events.
     */
    private static final Logger LOGGER = Logger.getLogger(SysEquipDaoImpl.class.getName());

    @Override
    protected List<SysEquip> findAllStatement(Connection connection) throws SQLException, EntityExtractionFailedException {
        return null;
    }

    @Override
    protected PreparedStatement createEntityStatement(Connection connection, SysEquip entity) throws SQLException {
        return null;
    }

    @Override
    public List<SysEquip> findSysEquipForIdUnit(Connection connection, long idUnit) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM sys_equip WHERE id_unit = ?");
        statement.setLong(1, idUnit);
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
    public static SysEquip extract(ResultSet resultSet) throws EntityExtractionFailedException {
        try {
            return new SysEquip(
                resultSet.getLong("id_sys"),
                resultSet.getString("name_sys"),
                resultSet.getString("kks"),
                resultSet.getLong("id_unit"),
                resultSet.getLong("id_mark"));
        }
        catch (SQLException e) {
            throw new EntityExtractionFailedException(e);
        }
    }

    @Override
    public List<SysEquip> extractAll(ResultSet resultSet) throws SQLException, EntityExtractionFailedException {
        List<SysEquip> entities = new ArrayList<>();
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
    public static SysEquipDao getInstance() {
        return SysEquipDaoImpl.Holder.INSTANCE;
    }

    private static class Holder {

        public static final SysEquipDao INSTANCE = new SysEquipDaoImpl();
    }
}
