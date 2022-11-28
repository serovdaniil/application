package bsuir.kaf.electroniki.service;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import bsuir.kaf.electroniki.dao.CurStatusDao;
import bsuir.kaf.electroniki.dao.CurStatusDaoImpl;
import bsuir.kaf.electroniki.dao.EntityExtractionFailedException;
import bsuir.kaf.electroniki.dao.connection.ApplicationConnectionDatabase;
import bsuir.kaf.electroniki.dao.connection.ConnectionDatabase;
import bsuir.kaf.electroniki.model.CurStatus;

public class CurSysServiceImpl implements CurSysService, Serializable {

    private final CurStatusDao dao;

    private final ConnectionDatabase connectionDatabase;

    private static final Logger LOGGER = Logger.getLogger(CurSysServiceImpl.class.getName());

    public CurSysServiceImpl(CurStatusDao dao, ConnectionDatabase connectionDatabase) {
        this.dao = dao;
        this.connectionDatabase = connectionDatabase;
    }

    @Override
    public List<CurStatus> findCurStatusBySystem(long idSystem) {
        try {
            return dao.findCurStatusBySystem(connectionDatabase.getConnection(), idSystem);
        }
        catch (SQLException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public long create(CurStatus entity) throws ServiceException {
        dao.addNewCurStatus(connectionDatabase.getConnection(), entity);
        return 1L;
    }

    @Override
    public List<CurStatus> findAll() throws ServiceException, EntityExtractionFailedException {
        return dao.findAll(connectionDatabase.getConnection());
    }

    /**
     * Getting a single instance of the class.
     *
     * @return the instance
     */
    public static CurSysService getInstance() {
        return CurSysServiceImpl.Holder.INSTANCE;
    }

    private static class Holder {

        public static final CurSysService INSTANCE =
            new CurSysServiceImpl(CurStatusDaoImpl.getInstance(), ApplicationConnectionDatabase.getInstance());
    }
}