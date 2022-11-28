package bsuir.kaf.electroniki.service;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import bsuir.kaf.electroniki.dao.CtitsDaoImpl;
import bsuir.kaf.electroniki.dao.EntityDao;
import bsuir.kaf.electroniki.dao.EntityExtractionFailedException;
import bsuir.kaf.electroniki.dao.connection.ApplicationConnectionDatabase;
import bsuir.kaf.electroniki.dao.connection.ConnectionDatabase;
import bsuir.kaf.electroniki.model.Crits;

public class CritsServiceImpl implements EntityService<Crits>, Serializable {

    private final EntityDao<Crits> dao;

    private final ConnectionDatabase connectionDatabase;

    private static final Logger LOGGER = Logger.getLogger(SafIndServiceImpl.class.getName());

    public CritsServiceImpl(EntityDao<Crits> dao, ConnectionDatabase connectionDatabase) {
        this.dao = dao;
        this.connectionDatabase = connectionDatabase;
    }

    @Override
    public long create(Crits entity) throws ServiceException {
        return 0;
    }

    @Override
    public List<Crits> findAll() throws ServiceException, EntityExtractionFailedException {
        return dao.findAll(connectionDatabase.getConnection());
    }

    /**
     * Getting a single instance of the class.
     *
     * @return the instance
     */
    public static EntityService<Crits> getInstance() {
        return CritsServiceImpl.Holder.INSTANCE;
    }

    private static class Holder {

        public static final EntityService<Crits> INSTANCE =
            new CritsServiceImpl(CtitsDaoImpl.getInstance(), ApplicationConnectionDatabase.getInstance());
    }
}