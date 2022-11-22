package bsuir.kaf.electroniki.service;

import java.sql.Connection;
import java.util.List;

import bsuir.kaf.electroniki.model.SafVal;

public interface SafValService extends EntityService<SafVal>{

    List<SafVal> findAllValueForUnitAndIndicator(long idUnit, long idSavInd);
}
