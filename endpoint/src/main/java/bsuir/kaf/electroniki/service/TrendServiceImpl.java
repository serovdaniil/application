package bsuir.kaf.electroniki.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import bsuir.kaf.electroniki.dao.DaoException;
import bsuir.kaf.electroniki.dao.EntityExtractionFailedException;
import bsuir.kaf.electroniki.dao.SafValDao;
import bsuir.kaf.electroniki.dao.SafValDaoImpl;
import bsuir.kaf.electroniki.dao.TrendDao;
import bsuir.kaf.electroniki.dao.TrendDaoImpl;
import bsuir.kaf.electroniki.dao.connection.ApplicationConnectionDatabase;
import bsuir.kaf.electroniki.dao.connection.ConnectionDatabase;
import bsuir.kaf.electroniki.model.SafVal;
import bsuir.kaf.electroniki.model.Trend;

public class TrendServiceImpl implements TrendService {

    private final TrendDao dao;

    private final SafValDao safValDao;

    private final ConnectionDatabase connectionDatabase;

    private static final Logger LOGGER = Logger.getLogger(TrendServiceImpl.class.getName());

    public TrendServiceImpl(TrendDao dao, SafValDao safValDao, ConnectionDatabase connectionDatabase) {
        this.dao = dao;
        this.safValDao = safValDao;
        this.connectionDatabase = connectionDatabase;
    }

    @Override
    public long create(Trend entity) throws ServiceException {
        List<SafVal> values;

        try {
            values = safValDao.findAllValueForUnitAndIndicatorAndPeriod(
                connectionDatabase.getConnection(), entity.getPeriod().plusYears(1), entity.getUnitId(), entity.getSafIndId()
            );
        }
        catch (SQLException | DaoException e) {
            throw new ServiceException(e);
        }

        BigDecimal total = values.stream()
            .map(SafVal::getValue)
            .map(it-> {
                System.out.println(it);
                return it;
            })
            .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(values.size());
        entity.setValue(total.divide(BigDecimal.valueOf(values.size()), 5, RoundingMode.HALF_UP));

        return dao.create(connectionDatabase.getConnection(), entity);
    }

    @Override
    public List<Trend> findAll() throws ServiceException, EntityExtractionFailedException {
        return null;
    }

    @Override
    public List<Trend> findAllValueForUnitAndIndicator(long idUnit, long idSavInd) {
        try {
            return dao.findAllTrendForUnitAndIndicator(connectionDatabase.getConnection(), idUnit, idSavInd);
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
    public static TrendService getInstance() {
        return TrendServiceImpl.Holder.INSTANCE;
    }

    private static class Holder {

        public static final TrendService INSTANCE =
            new TrendServiceImpl(
                TrendDaoImpl.getInstance(), SafValDaoImpl.getInstance(), ApplicationConnectionDatabase.getInstance()
            );
    }
}
