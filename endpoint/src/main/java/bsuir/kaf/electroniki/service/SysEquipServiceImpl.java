package bsuir.kaf.electroniki.service;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import bsuir.kaf.electroniki.dao.EntityExtractionFailedException;
import bsuir.kaf.electroniki.dao.SysEquipDao;
import bsuir.kaf.electroniki.dao.SysEquipDaoImpl;
import bsuir.kaf.electroniki.dao.connection.ApplicationConnectionDatabase;
import bsuir.kaf.electroniki.dao.connection.ConnectionDatabase;
import bsuir.kaf.electroniki.model.SysEquip;

public class SysEquipServiceImpl implements SysEquipService {

    private final SysEquipDao dao;

    private final ConnectionDatabase connectionDatabase;

    private static final Logger LOGGER = Logger.getLogger(TrendServiceImpl.class.getName());

    public SysEquipServiceImpl(SysEquipDao dao, ConnectionDatabase connectionDatabase) {
        this.dao = dao;
        this.connectionDatabase = connectionDatabase;
    }

    @Override
    public long create(SysEquip entity) throws ServiceException {
        return 0;
    }

    @Override
    public List<SysEquip> findAll() throws ServiceException, EntityExtractionFailedException {
        return null;
    }

    @Override
    public List<SysEquip> findSysEquipForIdUnit(long idUnit) {
        try {
            return dao.findSysEquipForIdUnit(connectionDatabase.getConnection(), idUnit);
        }
        catch (SQLException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Getting a single instance of the class.
     *
     * @return the instance
     */
    public static SysEquipService getInstance() {
        return SysEquipServiceImpl.Holder.INSTANCE;
    }

    private static class Holder {

        public static final SysEquipService INSTANCE =
            new SysEquipServiceImpl(
                SysEquipDaoImpl.getInstance(), ApplicationConnectionDatabase.getInstance()
            );
    }
}