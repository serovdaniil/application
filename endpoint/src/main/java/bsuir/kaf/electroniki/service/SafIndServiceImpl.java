package bsuir.kaf.electroniki.service;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import bsuir.kaf.electroniki.model.SafInd;
import bsuir.kaf.electroniki.dao.connection.ApplicationConnectionDatabase;
import bsuir.kaf.electroniki.dao.connection.ConnectionDatabase;
import bsuir.kaf.electroniki.dao.EntityDao;
import bsuir.kaf.electroniki.dao.EntityExtractionFailedException;
import bsuir.kaf.electroniki.dao.SafIndDaoImpl;

public class SafIndServiceImpl implements EntityService<SafInd>, Serializable {

    private final EntityDao<SafInd> dao;

    private final ConnectionDatabase connectionDatabase;

    private static final Logger LOGGER = Logger.getLogger(SafIndServiceImpl.class.getName());

    public SafIndServiceImpl(EntityDao<SafInd> dao, ConnectionDatabase connectionDatabase) {
        this.dao = dao;
        this.connectionDatabase = connectionDatabase;
    }

    @Override
    public long create(SafInd entity) throws ServiceException {
        return 0;
    }

    @Override
    public List<SafInd> findAll() throws ServiceException, EntityExtractionFailedException {
        return dao.findAll(connectionDatabase.getConnection());
    }

    /**
     * Getting a single instance of the class.
     *
     * @return the instance
     */
    public static EntityService<SafInd> getInstance() {
        return SafIndServiceImpl.Holder.INSTANCE;
    }

    private static class Holder {

        public static final EntityService<SafInd> INSTANCE =
            new SafIndServiceImpl(SafIndDaoImpl.getInstance(), ApplicationConnectionDatabase.getInstance());
    }
}
