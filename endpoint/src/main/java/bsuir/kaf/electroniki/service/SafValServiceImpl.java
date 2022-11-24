package bsuir.kaf.electroniki.service;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import bsuir.kaf.electroniki.dao.DaoException;
import bsuir.kaf.electroniki.dao.EntityExtractionFailedException;
import bsuir.kaf.electroniki.dao.SafValDaoImpl;
import bsuir.kaf.electroniki.dao.SafValDao;
import bsuir.kaf.electroniki.dao.connection.ApplicationConnectionDatabase;
import bsuir.kaf.electroniki.dao.connection.ConnectionDatabase;
import bsuir.kaf.electroniki.model.SafVal;

public class SafValServiceImpl implements SafValService{

    private final SafValDao dao;

    private final ConnectionDatabase connectionDatabase;

    private static final Logger LOGGER = Logger.getLogger(SafValServiceImpl.class.getName());

    public SafValServiceImpl(SafValDao dao, ConnectionDatabase connectionDatabase) {
        this.dao = dao;
        this.connectionDatabase = connectionDatabase;
    }

    @Override
    public long create(SafVal entity) throws ServiceException {
      return dao.create(connectionDatabase.getConnection(), entity);
    }

    @Override
    public List<SafVal> findAll() throws ServiceException, EntityExtractionFailedException {
        return null;
    }

    @Override
    public List<SafVal> findAllValueForUnitAndIndicator(long idUnit, long idSavInd) {
        try {
            return dao.findAllValueForUnitAndIndicator(connectionDatabase.getConnection(), idUnit, idSavInd);
        }
        catch (SQLException | DaoException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Getting a single instance of the class.
     *
     * @return the instance
     */
    public static SafValService getInstance() {
        return SafValServiceImpl.Holder.INSTANCE;
    }

    private static class Holder {

        public static final SafValService INSTANCE =
            new SafValServiceImpl(SafValDaoImpl.getInstance(), ApplicationConnectionDatabase.getInstance());
    }
}
