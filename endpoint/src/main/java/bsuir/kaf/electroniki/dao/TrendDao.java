package bsuir.kaf.electroniki.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import bsuir.kaf.electroniki.model.SafVal;
import bsuir.kaf.electroniki.model.Trend;

public interface TrendDao extends EntityDao<Trend> {

    List<Trend> findAllTrendForUnitAndIndicator(Connection connection, long idUnit, long idSavInd) throws SQLException;

}
