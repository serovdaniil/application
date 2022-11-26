package bsuir.kaf.electroniki.service;

import java.util.List;

import bsuir.kaf.electroniki.model.Trend;

public interface TrendService extends EntityService<Trend> {

    List<Trend> findAllValueForUnitAndIndicator(long idUnit, long idSavInd);
}
