package bsuir.kaf.electroniki.service;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import bsuir.kaf.electroniki.model.SafInd;
import bsuir.kaf.electroniki.repository.connection.ApplicationConnectionDatabase;
import bsuir.kaf.electroniki.repository.connection.ConnectionDatabase;
import bsuir.kaf.electroniki.repository.EntityDao;
import bsuir.kaf.electroniki.repository.EntityExtractionFailedException;
import bsuir.kaf.electroniki.repository.SafIndDaoImpl;

public class SafIndServiceImpl  implements EntityService<SafInd>, Serializable {

    /**
     * A reference to an object on daoEmployee.
     */
    private final EntityDao<SafInd> employeeDao;

    /**
     * The DataSource object.
     */
    private final ConnectionDatabase connectionDatabase;

    /**
     * A logger object for logging events.
     */
    private static final Logger LOGGER = Logger.getLogger(SafIndServiceImpl.class.getName());

    public SafIndServiceImpl(EntityDao<SafInd> employeeDao, ConnectionDatabase connectionDatabase) {
        this.employeeDao = employeeDao;
        this.connectionDatabase = connectionDatabase;
    }

    @Override
    public long create(SafInd entity) throws ServiceException {
        return 0;
    }

    @Override
    public List<SafInd> findAll() throws ServiceException, EntityExtractionFailedException {
        return employeeDao.findAll(connectionDatabase.getConnection());
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
