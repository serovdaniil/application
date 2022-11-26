package bsuir.kaf.electroniki.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.Year;
import java.util.List;

import bsuir.kaf.electroniki.model.SafVal;

public interface SafValDao extends EntityDao<SafVal> {

    List<SafVal> findAllValueForUnitAndIndicator(Connection connection, long idUnit, long idSavInd) throws SQLException;

    List<SafVal> findAllValueForUnitAndIndicatorAndPeriod(Connection connection, Year period, long idUnit, long idSavInd) throws SQLException;

}
