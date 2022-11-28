package bsuir.kaf.electroniki.service;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import bsuir.kaf.electroniki.dao.EntityDao;
import bsuir.kaf.electroniki.dao.EntityExtractionFailedException;
import bsuir.kaf.electroniki.dao.UserDaoImpl;
import bsuir.kaf.electroniki.dao.connection.ApplicationConnectionDatabase;
import bsuir.kaf.electroniki.dao.connection.ConnectionDatabase;
import bsuir.kaf.electroniki.model.User;

public class UserServiceImpl implements EntityService<User>, Serializable {

    private final EntityDao<User> dao;

    private final ConnectionDatabase connectionDatabase;

    private static final Logger LOGGER = Logger.getLogger(SafIndServiceImpl.class.getName());

    public UserServiceImpl(EntityDao<User> dao, ConnectionDatabase connectionDatabase) {
        this.dao = dao;
        this.connectionDatabase = connectionDatabase;
    }

    @Override
    public long create(User entity) throws ServiceException {
        return 0;
    }

    @Override
    public List<User> findAll() throws ServiceException, EntityExtractionFailedException {
        return dao.findAll(connectionDatabase.getConnection());
    }

    /**
     * Getting a single instance of the class.
     *
     * @return the instance
     */
    public static EntityService<User> getInstance() {
        return UserServiceImpl.Holder.INSTANCE;
    }

    private static class Holder {

        public static final EntityService<User> INSTANCE =
            new UserServiceImpl(UserDaoImpl.getInstance(), ApplicationConnectionDatabase.getInstance());
    }
}
