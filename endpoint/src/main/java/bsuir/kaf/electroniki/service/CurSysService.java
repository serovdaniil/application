package bsuir.kaf.electroniki.service;

import java.util.List;

import bsuir.kaf.electroniki.model.CurStatus;

public interface CurSysService extends EntityService<CurStatus>{

    List<CurStatus> findCurStatusBySystem(long idSystem);

    void callReportCurSystem(long idUnit);
}
