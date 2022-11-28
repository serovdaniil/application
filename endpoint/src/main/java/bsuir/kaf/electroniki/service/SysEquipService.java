package bsuir.kaf.electroniki.service;

import java.sql.SQLException;
import java.util.List;

import bsuir.kaf.electroniki.model.SysEquip;

public interface SysEquipService extends EntityService<SysEquip> {

    List<SysEquip> findSysEquipForIdUnit(long idUnit);
}