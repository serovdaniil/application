package bsuir.kaf.electroniki.service;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import bsuir.kaf.electroniki.dao.DaoException;
import bsuir.kaf.electroniki.dao.EntityExtractionFailedException;
import bsuir.kaf.electroniki.dao.MarkDao;
import bsuir.kaf.electroniki.dao.MarkDaoImpl;
import bsuir.kaf.electroniki.dao.connection.ApplicationConnectionDatabase;
import bsuir.kaf.electroniki.dao.connection.ConnectionDatabase;
import bsuir.kaf.electroniki.model.Mark;
import bsuir.kaf.electroniki.model.SafVal;

public class MarkServiceImpl implements MarkService {

    private final MarkDao dao;

    private final ConnectionDatabase connectionDatabase;

    private static final Logger LOGGER = Logger.getLogger(SafValServiceImpl.class.getName());

    public MarkServiceImpl(MarkDao dao, ConnectionDatabase connectionDatabase) {
        this.dao = dao;
        this.connectionDatabase = connectionDatabase;
    }

    @Override
    public long create(Mark entity) throws ServiceException {
        return dao.create(connectionDatabase.getConnection(), entity);
    }

    @Override
    public List<Mark> findAll() throws ServiceException, EntityExtractionFailedException {
        return null;
    }


    @Override
    public List<Mark> findMarksByCrit(long idCrit) {
        try {
            return dao.findMarksByCrit(connectionDatabase.getConnection(), idCrit);
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
    public static MarkService getInstance() {
        return MarkServiceImpl.Holder.INSTANCE;
    }

    private static class Holder {

        public static final MarkService INSTANCE =
            new MarkServiceImpl(MarkDaoImpl.getInstance(), ApplicationConnectionDatabase.getInstance());
    }
}